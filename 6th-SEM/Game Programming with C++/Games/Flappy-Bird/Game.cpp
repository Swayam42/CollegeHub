#include "Game.h"
#include <sstream>
#include <fstream>
#include <algorithm>

// ── Static constants ──────────────────────────────────────────────────────────
const sf::Color Game::BG_COLOR    = sf::Color(135, 206, 235);  // sky blue
const float     Game::WINDOW_W    = 800.f;
const float     Game::WINDOW_H    = 600.f;
const float     Game::GROUND_H    =  20.f;
const float     Game::BIRD_START_X = 150.f;
const float     Game::BIRD_START_Y = 300.f;

// ── Constructor ───────────────────────────────────────────────────────────────
Game::Game()
    : m_Window(sf::VideoMode(static_cast<unsigned>(WINDOW_W),
                             static_cast<unsigned>(WINDOW_H)),
               "Flappy Bird"),
      m_Bird(nullptr), m_PipeManager(nullptr),
      m_State(GameState::MENU), m_Difficulty(Difficulty::MEDIUM),
      m_Score(0), m_HighScore(0), m_FontLoaded(false)
{
    m_Window.setFramerateLimit(60);

    // ── Font ──────────────────────────────────────────────────────────────────
    m_FontLoaded = m_Font.loadFromFile("assets/fonts/Debrosee.ttf");

    // ── Ground strip ─────────────────────────────────────────────────────────
    m_Ground.setSize(sf::Vector2f(WINDOW_W, GROUND_H));
    m_Ground.setPosition(0.f, WINDOW_H - GROUND_H);
    m_Ground.setFillColor(sf::Color(210, 180, 140));  // tan / sandy colour

    // ── HUD text ─────────────────────────────────────────────────────────────
    if (m_FontLoaded) {
        m_HudText.setFont(m_Font);
        m_CentreText.setFont(m_Font);
        m_SubText.setFont(m_Font);
    }

    m_HudText.setCharacterSize(24);
    m_HudText.setFillColor(sf::Color::White);
    m_HudText.setPosition(10.f, 10.f);

    // ── Load persisted high score ─────────────────────────────────────────────
    loadHighScore();

    // ── Show menu ────────────────────────────────────────────────────────────
    m_State = GameState::MENU;
}

Game::~Game()
{
    delete m_Bird;
    delete m_PipeManager;
}

// ── Public: run ───────────────────────────────────────────────────────────────
void Game::run()
{
    while (m_Window.isOpen()) {
        sf::Time dt = m_Clock.restart();
        processEvents();
        if (m_State == GameState::PLAYING) {
            update(dt);
        }
        render();
    }
}

// ── Private helpers ───────────────────────────────────────────────────────────
void Game::setText(sf::Text& t, const std::string& str,
                   float x, float y, unsigned int size, sf::Color colour)
{
    t.setString(str);
    t.setCharacterSize(size);
    t.setFillColor(colour);

    // Centre-align on x
    sf::FloatRect bounds = t.getLocalBounds();
    t.setOrigin(bounds.left + bounds.width / 2.f, bounds.top);
    t.setPosition(x, y);
}

void Game::loadHighScore()
{
    std::ifstream file("scores.txt");
    if (file.is_open()) {
        file >> m_HighScore;
    }
}

void Game::saveHighScore()
{
    std::ofstream file("scores.txt");
    if (file.is_open()) {
        file << m_HighScore;
    }
}

void Game::startGame()
{
    delete m_Bird;
    delete m_PipeManager;

    m_Bird        = new Bird(BIRD_START_X, BIRD_START_Y);
    m_PipeManager = new PipeManager(m_Difficulty);
    m_Score       = 0;
    m_State       = GameState::PLAYING;
}

void Game::restartGame()
{
    startGame();
}

void Game::togglePause()
{
    if (m_State == GameState::PLAYING) {
        m_State = GameState::PAUSED;
    } else if (m_State == GameState::PAUSED) {
        m_State = GameState::PLAYING;
        m_Clock.restart();  // discard paused time
    }
}

// ── processEvents ─────────────────────────────────────────────────────────────
void Game::processEvents()
{
    sf::Event event;
    while (m_Window.pollEvent(event)) {
        if (event.type == sf::Event::Closed) {
            saveHighScore();
            m_Window.close();
        }

        if (event.type == sf::Event::KeyPressed) {
            switch (event.key.code) {

            // ── ESC: quit ────────────────────────────────────────────────────
            case sf::Keyboard::Escape:
                saveHighScore();
                m_Window.close();
                break;

            // ── SPACE: flap / start ──────────────────────────────────────────
            case sf::Keyboard::Space:
                if (m_State == GameState::PLAYING && m_Bird) {
                    m_Bird->flap();
                } else if (m_State == GameState::MENU) {
                    startGame();
                } else if (m_State == GameState::GAME_OVER) {
                    restartGame();
                }
                break;

            // ── R: restart ───────────────────────────────────────────────────
            case sf::Keyboard::R:
                if (m_State == GameState::GAME_OVER ||
                    m_State == GameState::PLAYING   ||
                    m_State == GameState::PAUSED) {
                    restartGame();
                }
                break;

            // ── P: pause / resume ─────────────────────────────────────────────
            case sf::Keyboard::P:
                if (m_State == GameState::PLAYING ||
                    m_State == GameState::PAUSED) {
                    togglePause();
                }
                break;

            // ── 1 / 2 / 3: change difficulty (from menu only) ─────────────────
            case sf::Keyboard::Num1:
                if (m_State == GameState::MENU)
                    m_Difficulty = Difficulty::EASY;
                break;
            case sf::Keyboard::Num2:
                if (m_State == GameState::MENU)
                    m_Difficulty = Difficulty::MEDIUM;
                break;
            case sf::Keyboard::Num3:
                if (m_State == GameState::MENU)
                    m_Difficulty = Difficulty::HARD;
                break;

            default:
                break;
            }
        }
    }
}

// ── update ────────────────────────────────────────────────────────────────────
void Game::update(sf::Time dt)
{
    m_Bird->update(dt);
    m_PipeManager->update(dt);

    // ── Scoring ───────────────────────────────────────────────────────────────
    m_Score += m_PipeManager->checkScore(*m_Bird);
    if (m_Score > m_HighScore) {
        m_HighScore = m_Score;
    }

    // ── Collision: pipes ──────────────────────────────────────────────────────
    if (m_PipeManager->checkCollision(*m_Bird)) {
        m_State = GameState::GAME_OVER;
        saveHighScore();
        return;
    }

    // ── Collision: ground / ceiling ───────────────────────────────────────────
    sf::FloatRect bb = m_Bird->getBounds();
    if (bb.top + bb.height >= WINDOW_H - GROUND_H || bb.top <= 0.f) {
        m_State = GameState::GAME_OVER;
        saveHighScore();
    }
}

// ── render ────────────────────────────────────────────────────────────────────
void Game::render()
{
    m_Window.clear(BG_COLOR);

    // ── Active game objects ───────────────────────────────────────────────────
    if (m_PipeManager) m_PipeManager->draw(m_Window);
    if (m_Bird)        m_Bird->draw(m_Window);

    // ── Ground ────────────────────────────────────────────────────────────────
    m_Window.draw(m_Ground);

    // ── HUD (score) ───────────────────────────────────────────────────────────
    if (m_FontLoaded && m_State != GameState::MENU) {
        std::ostringstream oss;
        oss << "Score: " << m_Score << "   Best: " << m_HighScore;
        m_HudText.setString(oss.str());
        m_Window.draw(m_HudText);
    }

    // ── Overlay messages ──────────────────────────────────────────────────────
    if (m_FontLoaded) {
        switch (m_State) {
        case GameState::MENU: {
            std::string diffStr =
                (m_Difficulty == Difficulty::EASY)   ? "Easy"   :
                (m_Difficulty == Difficulty::MEDIUM) ? "Medium" : "Hard";

            setText(m_CentreText, "FLAPPY BIRD",
                    WINDOW_W / 2.f, 160.f, 54, sf::Color::White);
            m_Window.draw(m_CentreText);

            setText(m_SubText,
                    "Press 1=Easy  2=Medium  3=Hard\n"
                    "Difficulty: " + diffStr + "\n\n"
                    "SPACE or ENTER to start\n"
                    "ESC to quit",
                    WINDOW_W / 2.f, 250.f, 22, sf::Color::White);
            m_Window.draw(m_SubText);
            break;
        }
        case GameState::PAUSED:
            setText(m_CentreText, "PAUSED",
                    WINDOW_W / 2.f, 220.f, 54, sf::Color::Yellow);
            m_Window.draw(m_CentreText);

            setText(m_SubText, "P to resume   R to restart   ESC to quit",
                    WINDOW_W / 2.f, 295.f, 22, sf::Color::White);
            m_Window.draw(m_SubText);
            break;

        case GameState::GAME_OVER: {
            setText(m_CentreText, "GAME OVER",
                    WINDOW_W / 2.f, 200.f, 54, sf::Color::Red);
            m_Window.draw(m_CentreText);

            std::ostringstream oss;
            oss << "Score: " << m_Score << "   Best: " << m_HighScore << "\n\n"
                << "SPACE or R to restart   ESC to quit";
            setText(m_SubText, oss.str(),
                    WINDOW_W / 2.f, 275.f, 22, sf::Color::White);
            m_Window.draw(m_SubText);
            break;
        }
        default:
            break;
        }
    }

    m_Window.display();
}
