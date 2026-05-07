#include "Game.h"

#include <algorithm>
#include <sstream>

Game::Game()
    : m_Window(sf::VideoMode(800, 600), "Car Dodging Game"),
      m_State(GameState::MENU),
      m_Difficulty(Difficulty::MEDIUM),
      m_Road(sf::Vector2f(420.f, 600.f)),
      m_Player(42.f, 80.f, 0.f),
      m_TotalTime(0.f),
      m_SpawnTimer(0.f),
      m_SpeedLevel(1.f),
      m_BaseEnemySpeed(180.f),
      m_Score(0),
      m_DodgedCars(0),
      m_FontLoaded(false)
{
    m_Window.setFramerateLimit(60);

    m_Road.setFillColor(sf::Color(45, 45, 45));
    m_Road.setPosition(190.f, 0.f);

    const float left = m_Road.getPosition().x;
    const float laneWidth = m_Road.getSize().x / 3.f;
    for (int i = 0; i < 3; ++i) {
        m_LaneCenters.push_back(left + laneWidth * (i + 0.5f));
    }

    m_Player.setLane(1, m_LaneCenters, 520.f);

    if (m_Font.loadFromFile("assets/font/KOMIKAP_.ttf") ||
        m_Font.loadFromFile("assets/arial.ttf")) {
        m_FontLoaded = true;
        m_HudText.setFont(m_Font);
        m_HudText.setCharacterSize(20);
        m_HudText.setFillColor(sf::Color::White);
        m_HudText.setPosition(20.f, 16.f);

        m_MessageText.setFont(m_Font);
        m_MessageText.setCharacterSize(28);
        m_MessageText.setFillColor(sf::Color::White);
    }

    if (m_BackgroundMusic.openFromFile("assets/music.ogg")) {
        m_BackgroundMusic.setLoop(true);
        m_BackgroundMusic.setVolume(40.f);
        m_BackgroundMusic.play();
    }

    if (m_CrashBuffer.loadFromFile("assets/crash.wav")) {
        m_CrashSound.setBuffer(m_CrashBuffer);
        m_CrashSound.setVolume(80.f);
    }
}

Game::DifficultyConfig Game::getConfig(Difficulty difficulty) const
{
    switch (difficulty) {
    case Difficulty::EASY:
        return {1.15f, 0.52f, 0.03f, 0.85f, 1.15f};
    case Difficulty::MEDIUM:
        return {0.95f, 0.40f, 0.045f, 0.80f, 1.30f};
    case Difficulty::HARD:
    default:
        return {0.78f, 0.30f, 0.06f, 0.75f, 1.50f};
    }
}

void Game::run()
{
    while (m_Window.isOpen()) {
        const float dt = m_Clock.restart().asSeconds();
        processEvents();
        update(dt);
        render();
    }
}

void Game::processEvents()
{
    sf::Event event;
    while (m_Window.pollEvent(event)) {
        if (event.type == sf::Event::Closed) {
            m_Window.close();
        }

        if (event.type != sf::Event::KeyPressed) {
            continue;
        }

        if (event.key.code == sf::Keyboard::Escape) {
            m_Window.close();
        }

        if (m_State == GameState::MENU) {
            if (event.key.code == sf::Keyboard::Num1) {
                m_Difficulty = Difficulty::EASY;
                resetGame();
                m_State = GameState::PLAYING;
            } else if (event.key.code == sf::Keyboard::Num2) {
                m_Difficulty = Difficulty::MEDIUM;
                resetGame();
                m_State = GameState::PLAYING;
            } else if (event.key.code == sf::Keyboard::Num3) {
                m_Difficulty = Difficulty::HARD;
                resetGame();
                m_State = GameState::PLAYING;
            }
            continue;
        }

        if (event.key.code == sf::Keyboard::P) {
            if (m_State == GameState::PLAYING) {
                m_State = GameState::PAUSED;
            } else if (m_State == GameState::PAUSED) {
                m_State = GameState::PLAYING;
            }
        }

        if (m_State == GameState::PLAYING) {
            if (event.key.code == sf::Keyboard::Left || event.key.code == sf::Keyboard::A) {
                m_Player.moveLeft();
                m_Player.setLane(m_Player.getLaneIndex(), m_LaneCenters, 520.f);
            }
            if (event.key.code == sf::Keyboard::Right || event.key.code == sf::Keyboard::D) {
                m_Player.moveRight(m_LaneCenters.size());
                m_Player.setLane(m_Player.getLaneIndex(), m_LaneCenters, 520.f);
            }
        }

        if (m_State == GameState::GAME_OVER && event.key.code == sf::Keyboard::R) {
            resetGame();
            m_State = GameState::PLAYING;
        }
    }
}

void Game::update(float dt)
{
    if (m_State != GameState::PLAYING) {
        return;
    }

    m_TotalTime += dt;
    m_SpeedLevel += dt * 0.12f;

    const DifficultyConfig cfg = getConfig(m_Difficulty);
    const float spawnInterval = std::max(cfg.minSpawnInterval, cfg.initialSpawnInterval - m_TotalTime * cfg.spawnDecay);

    m_SpawnTimer += dt;
    while (m_SpawnTimer >= spawnInterval) {
        m_SpawnTimer -= spawnInterval;
        spawnEnemy();
    }

    for (EnemyCar& enemy : m_Enemies) {
        enemy.update(dt);
    }

    m_Enemies.erase(
        std::remove_if(m_Enemies.begin(), m_Enemies.end(), [this](const EnemyCar& enemy) {
            if (enemy.getPosition().y - enemy.getBounds().height * 0.5f > 600.f) {
                ++m_DodgedCars;
                return true;
            }
            return false;
        }),
        m_Enemies.end());

    for (const EnemyCar& enemy : m_Enemies) {
        if (m_Player.getBounds().intersects(enemy.getBounds())) {
            m_State = GameState::GAME_OVER;
            if (m_CrashSound.getBuffer()) {
                m_CrashSound.play();
            }
            break;
        }
    }

    m_Score = static_cast<int>(m_TotalTime * 10.f) + (m_DodgedCars * 25);
    updateHud();
}

void Game::spawnEnemy()
{
    const DifficultyConfig cfg = getConfig(m_Difficulty);
    std::uniform_int_distribution<int> laneDist(0, static_cast<int>(m_LaneCenters.size() - 1));
    std::uniform_real_distribution<float> speedDist(cfg.randomSpeedMin, cfg.randomSpeedMax);

    const std::size_t lane = static_cast<std::size_t>(laneDist(m_Rng));
    const float speed = m_BaseEnemySpeed * m_SpeedLevel * speedDist(m_Rng);

    m_Enemies.emplace_back(42.f, 80.f, speed, lane, m_LaneCenters[lane], -40.f);
}

void Game::updateHud()
{
    if (!m_FontLoaded) {
        return;
    }

    std::ostringstream ss;
    ss << "Score: " << m_Score
       << "   Dodged: " << m_DodgedCars
       << "   Level: " << static_cast<int>(m_SpeedLevel)
       << "   Speed: " << static_cast<int>(m_BaseEnemySpeed * m_SpeedLevel);
    m_HudText.setString(ss.str());
}

void Game::resetGame()
{
    m_Clock.restart();
    m_TotalTime = 0.f;
    m_SpawnTimer = 0.f;
    m_SpeedLevel = 1.f;
    m_Score = 0;
    m_DodgedCars = 0;
    m_Enemies.clear();
    m_Player.setLane(1, m_LaneCenters, 520.f);
    updateHud();
}

void Game::render()
{
    m_Window.clear(sf::Color(18, 120, 18));

    m_Window.draw(m_Road);

    const float divider1 = m_Road.getPosition().x + m_Road.getSize().x / 3.f;
    const float divider2 = m_Road.getPosition().x + (m_Road.getSize().x * 2.f / 3.f);

    for (int y = 0; y < 600; y += 42) {
        sf::RectangleShape dash(sf::Vector2f(7.f, 24.f));
        dash.setFillColor(sf::Color(235, 235, 235));
        dash.setPosition(divider1 - 3.5f, static_cast<float>(y));
        m_Window.draw(dash);
        dash.setPosition(divider2 - 3.5f, static_cast<float>(y));
        m_Window.draw(dash);
    }

    for (const EnemyCar& enemy : m_Enemies) {
        enemy.draw(m_Window);
    }
    m_Player.draw(m_Window);

    if (m_FontLoaded) {
        m_Window.draw(m_HudText);

        if (m_State == GameState::MENU) {
            m_MessageText.setCharacterSize(30);
            m_MessageText.setString(
                "Car Dodging Game\n\nPress 1 - Easy\nPress 2 - Medium\nPress 3 - Hard\n\nESC - Quit");
            m_MessageText.setPosition(220.f, 150.f);
            m_Window.draw(m_MessageText);
        } else if (m_State == GameState::PAUSED) {
            m_MessageText.setCharacterSize(38);
            m_MessageText.setString("Paused\nPress P to Resume");
            m_MessageText.setPosition(250.f, 250.f);
            m_Window.draw(m_MessageText);
        } else if (m_State == GameState::GAME_OVER) {
            m_MessageText.setCharacterSize(34);
            m_MessageText.setString("Game Over\nPress R to Restart");
            m_MessageText.setPosition(240.f, 240.f);
            m_Window.draw(m_MessageText);
        }
    }

    m_Window.display();
}
