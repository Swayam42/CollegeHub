#pragma once
#include <SFML/Graphics.hpp>
#include <vector>
#include <memory>
#include "Pipe.h"
#include "Bird.h"

// Manages the full collection of pipe pairs: spawning, movement,
// scoring, and recycling off-screen pairs.
class PipeManager {
private:
    std::vector<std::unique_ptr<Pipe>> m_Pipes;

    // Per-difficulty constants
    float m_PipeSpeed;
    float m_GapHeight;
    float m_OscAmp;
    float m_OscFreq;

    float m_SpawnInterval;  // seconds between pipe pairs
    float m_SpawnTimer;

    static const float WINDOW_WIDTH;
    static const float WINDOW_HEIGHT;
    static const float GROUND_HEIGHT;
    static const float MIN_GAP_CENTRE;  // minimum Y for gap centre
    static const float MAX_GAP_CENTRE;  // maximum Y for gap centre

    void spawnPipe();

public:
    explicit PipeManager(Difficulty difficulty);

    void update(sf::Time dt);
    void draw(sf::RenderWindow& window);

    // Returns the number of pipes the bird has newly passed (0 or 1 per frame).
    int  checkScore(const Bird& bird);

    // Returns true if the bird collides with any pipe.
    bool checkCollision(const Bird& bird) const;

    void reset();
};
