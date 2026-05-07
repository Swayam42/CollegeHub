#pragma once

#include <SFML/Audio.hpp>
#include <SFML/Graphics.hpp>
#include <random>
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

class Game {
private:
    struct DifficultyConfig {
        float initialSpawnInterval;
        float minSpawnInterval;
        float spawnDecay;
        float randomSpeedMin;
        float randomSpeedMax;
    };

    sf::RenderWindow m_Window;
    sf::Clock m_Clock;

    GameState m_State;
    Difficulty m_Difficulty;

    sf::RectangleShape m_Road;
    std::vector<float> m_LaneCenters;

    PlayerCar m_Player;
    std::vector<EnemyCar> m_Enemies;

    std::mt19937 m_Rng;

    float m_TotalTime;
    float m_SpawnTimer;
    float m_SpeedLevel;
    float m_BaseEnemySpeed;

    int m_Score;
    int m_DodgedCars;

    sf::Font m_Font;
    bool m_FontLoaded;
    sf::Text m_HudText;
    sf::Text m_MessageText;

    sf::Music m_BackgroundMusic;
    sf::SoundBuffer m_CrashBuffer;
    sf::Sound m_CrashSound;

    DifficultyConfig getConfig(Difficulty difficulty) const;

    void processEvents();
    void update(float dt);
    void render();

    void resetGame();
    void spawnEnemy();
    void updateHud();

public:
    Game();
    void run();
};
