#include <SFML/Graphics.hpp>
#include <algorithm>
#include <random>
#include <sstream>
#include <vector>

#include "EnemyCar.h"
#include "PlayerCar.h"

enum class GameState {
    MENU,
    PLAYING,
    PAUSED,
    GAME_OVER
};

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
};

struct DifficultyConfig {
    float initialSpawnInterval;
    float minSpawnInterval;
    float spawnDecay;
    float randomSpeedMin;
    float randomSpeedMax;
};

static DifficultyConfig getConfig(Difficulty difficulty)
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

static void updateHud(sf::Text& hudText, bool fontLoaded, int score, int dodgedCars,
                      float speedLevel, float baseEnemySpeed)
{
    if (!fontLoaded) {
        return;
    }

    std::ostringstream ss;
    ss << "Score: " << score
       << "   Dodged: " << dodgedCars
       << "   Level: " << static_cast<int>(speedLevel)
       << "   Speed: " << static_cast<int>(baseEnemySpeed * speedLevel);
    hudText.setString(ss.str());
}

int main()
{
    const unsigned int windowWidth = 800U;
    const unsigned int windowHeight = 600U;
    const float windowHeightF = static_cast<float>(windowHeight);

    sf::RenderWindow window(sf::VideoMode(windowWidth, windowHeight), "Car Dodging Game");
    window.setFramerateLimit(60);

    sf::Clock clock;
    GameState state = GameState::MENU;
    Difficulty difficulty = Difficulty::MEDIUM;

    sf::RectangleShape road(sf::Vector2f(420.f, windowHeightF));
    road.setFillColor(sf::Color(45, 45, 45));
    road.setPosition(190.f, 0.f);

    std::vector<float> laneCenters;
    laneCenters.reserve(3);
    const float left = road.getPosition().x;
    const float laneWidth = road.getSize().x / 3.f;
    for (int i = 0; i < 3; ++i) {
        laneCenters.push_back(left + laneWidth * (i + 0.5f));
    }

    PlayerCar player(42.f, 80.f, 0.f);
    player.setLane(1, laneCenters, 520.f);

    std::vector<EnemyCar> enemies;
    std::random_device randomDevice;
    std::mt19937 rng(randomDevice());

    float totalTime = 0.f;
    float spawnTimer = 0.f;
    float speedLevel = 1.f;
    const float baseEnemySpeed = 180.f;

    int score = 0;
    int dodgedCars = 0;

    sf::Font font;
    const bool fontLoaded = font.loadFromFile("assets/font/KOMIKAP_.ttf") ||
                            font.loadFromFile("assets/arial.ttf");

    sf::Text hudText;
    sf::Text messageText;
    if (fontLoaded) {
        hudText.setFont(font);
        hudText.setCharacterSize(20);
        hudText.setFillColor(sf::Color::White);
        hudText.setPosition(20.f, 16.f);

        messageText.setFont(font);
        messageText.setCharacterSize(28);
        messageText.setFillColor(sf::Color::White);
    }

    auto resetGame = [&]() {
        clock.restart();
        totalTime = 0.f;
        spawnTimer = 0.f;
        speedLevel = 1.f;
        score = 0;
        dodgedCars = 0;
        enemies.clear();
        player.setLane(1, laneCenters, 520.f);
        updateHud(hudText, fontLoaded, score, dodgedCars, speedLevel, baseEnemySpeed);
    };

    auto spawnEnemy = [&]() {
        const DifficultyConfig cfg = getConfig(difficulty);
        std::uniform_int_distribution<int> laneDist(0, static_cast<int>(laneCenters.size() - 1));
        std::uniform_real_distribution<float> speedDist(cfg.randomSpeedMin, cfg.randomSpeedMax);

        const std::size_t lane = static_cast<std::size_t>(laneDist(rng));
        const float speed = baseEnemySpeed * speedLevel * speedDist(rng);

        enemies.emplace_back(42.f, 80.f, speed, lane, laneCenters[lane], -40.f);
    };

    updateHud(hudText, fontLoaded, score, dodgedCars, speedLevel, baseEnemySpeed);

    while (window.isOpen()) {
        const float dt = clock.restart().asSeconds();

        sf::Event event;
        while (window.pollEvent(event)) {
            if (event.type == sf::Event::Closed) {
                window.close();
            }

            if (event.type != sf::Event::KeyPressed) {
                continue;
            }

            if (event.key.code == sf::Keyboard::Escape) {
                window.close();
            }

            if (state == GameState::MENU) {
                if (event.key.code == sf::Keyboard::Num1) {
                    difficulty = Difficulty::EASY;
                    resetGame();
                    state = GameState::PLAYING;
                } else if (event.key.code == sf::Keyboard::Num2) {
                    difficulty = Difficulty::MEDIUM;
                    resetGame();
                    state = GameState::PLAYING;
                } else if (event.key.code == sf::Keyboard::Num3) {
                    difficulty = Difficulty::HARD;
                    resetGame();
                    state = GameState::PLAYING;
                }
                continue;
            }

            if (event.key.code == sf::Keyboard::P) {
                if (state == GameState::PLAYING) {
                    state = GameState::PAUSED;
                } else if (state == GameState::PAUSED) {
                    state = GameState::PLAYING;
                }
            }

            if (state == GameState::PLAYING) {
                if (event.key.code == sf::Keyboard::Left || event.key.code == sf::Keyboard::A) {
                    player.moveLeft();
                    player.setLane(player.getLaneIndex(), laneCenters, 520.f);
                }
                if (event.key.code == sf::Keyboard::Right || event.key.code == sf::Keyboard::D) {
                    player.moveRight(laneCenters.size());
                    player.setLane(player.getLaneIndex(), laneCenters, 520.f);
                }
            }

            if (state == GameState::GAME_OVER && event.key.code == sf::Keyboard::R) {
                resetGame();
                state = GameState::PLAYING;
            }
        }

        if (state == GameState::PLAYING) {
            totalTime += dt;
            speedLevel += dt * 0.12f;

            const DifficultyConfig cfg = getConfig(difficulty);
            const float spawnInterval = std::max(cfg.minSpawnInterval, cfg.initialSpawnInterval - totalTime * cfg.spawnDecay);

            spawnTimer += dt;
            while (spawnTimer >= spawnInterval) {
                spawnTimer -= spawnInterval;
                spawnEnemy();
            }

            for (EnemyCar& enemy : enemies) {
                enemy.update(dt);
            }

            enemies.erase(
                std::remove_if(enemies.begin(), enemies.end(), [&](const EnemyCar& enemy) {
                    if (enemy.getPosition().y - enemy.getBounds().height * 0.5f > windowHeightF) {
                        ++dodgedCars;
                        return true;
                    }
                    return false;
                }),
                enemies.end());

            for (const EnemyCar& enemy : enemies) {
                if (player.getBounds().intersects(enemy.getBounds())) {
                    state = GameState::GAME_OVER;
                    break;
                }
            }

            score = static_cast<int>(totalTime * 10.f) + (dodgedCars * 25);
            updateHud(hudText, fontLoaded, score, dodgedCars, speedLevel, baseEnemySpeed);
        }

        window.clear(sf::Color(18, 120, 18));
        window.draw(road);

        const float divider1 = road.getPosition().x + road.getSize().x / 3.f;
        const float divider2 = road.getPosition().x + (road.getSize().x * 2.f / 3.f);
        const float dashSpacing = 42.f;
        for (float y = 0.f; y < windowHeightF; y += dashSpacing) {
            sf::RectangleShape dash(sf::Vector2f(7.f, 24.f));
            dash.setFillColor(sf::Color(235, 235, 235));
            dash.setPosition(divider1 - 3.5f, y);
            window.draw(dash);
            dash.setPosition(divider2 - 3.5f, y);
            window.draw(dash);
        }

        for (const EnemyCar& enemy : enemies) {
            enemy.draw(window);
        }
        player.draw(window);

        if (fontLoaded) {
            window.draw(hudText);

            if (state == GameState::MENU) {
                messageText.setCharacterSize(30);
                messageText.setString(
                    "Car Dodging Game\n\nPress 1 - Easy\nPress 2 - Medium\nPress 3 - Hard\n\nESC - Quit");
                messageText.setPosition(220.f, 150.f);
                window.draw(messageText);
            } else if (state == GameState::PAUSED) {
                messageText.setCharacterSize(38);
                messageText.setString("Paused\nPress P to Resume");
                messageText.setPosition(250.f, 250.f);
                window.draw(messageText);
            } else if (state == GameState::GAME_OVER) {
                messageText.setCharacterSize(34);
                messageText.setString("Game Over\nPress R to Restart");
                messageText.setPosition(240.f, 240.f);
                window.draw(messageText);
            }
        }

        window.display();
    }

    return 0;
}
