#pragma once
#include <SFML/Graphics.hpp>
#include <string>
#include "Bird.h"
#include "PipeManager.h"

enum class GameState { MENU, PLAYING, PAUSED, GAME_OVER };

class Game {
private:
    sf::RenderWindow m_Window;

    // Game objects (owned via pointer so we can re-create on restart)
    Bird*        m_Bird;
    PipeManager* m_PipeManager;

    GameState  m_State;
    Difficulty m_Difficulty;

    int  m_Score;
    int  m_HighScore;

    sf::Clock m_Clock;

    // UI
    sf::Font m_Font;
    bool     m_FontLoaded;

    sf::Text m_HudText;        // score / high-score line
    sf::Text m_CentreText;     // large centre message (menu, pause, game-over)
    sf::Text m_SubText;        // smaller instruction line below centre message

    // Ground strip
    sf::RectangleShape m_Ground;

    // Background colour
    static const sf::Color BG_COLOR;

    // World constants
    static const float WINDOW_W;
    static const float WINDOW_H;
    static const float GROUND_H;
    static const float BIRD_START_X;
    static const float BIRD_START_Y;

    // Internal helpers
    void processEvents();
    void update(sf::Time dt);
    void render();

    void startGame();
    void restartGame();
    void togglePause();

    void loadHighScore();
    void saveHighScore();

    void setText(sf::Text& t, const std::string& str,
                 float x, float y, unsigned int size,
                 sf::Color colour = sf::Color::White);

public:
    Game();
    ~Game();
    void run();
};
