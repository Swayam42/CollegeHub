#include "PipeManager.h"
#include <cstdlib>
#include <ctime>
#include <cmath>

const float PipeManager::WINDOW_WIDTH   = 800.f;
const float PipeManager::WINDOW_HEIGHT  = 600.f;
const float PipeManager::GROUND_HEIGHT  =  20.f;
const float PipeManager::MIN_GAP_CENTRE = 120.f;
const float PipeManager::MAX_GAP_CENTRE = 430.f;  // 600 - 20(ground) - 150

PipeManager::PipeManager(Difficulty difficulty)
    : m_SpawnTimer(0.f), m_SpawnInterval(2.f)
{
    std::srand(static_cast<unsigned>(std::time(nullptr)));

    switch (difficulty) {
        case Difficulty::EASY:
            m_PipeSpeed = 150.f;
            m_GapHeight = 200.f;
            m_OscAmp    =   0.f;
            m_OscFreq   =   0.f;
            break;
        case Difficulty::MEDIUM:
            m_PipeSpeed = 200.f;
            m_GapHeight = 160.f;
            m_OscAmp    =   0.f;
            m_OscFreq   =   0.f;
            break;
        case Difficulty::HARD:
        default:
            m_PipeSpeed = 250.f;
            m_GapHeight = 120.f;
            m_OscAmp    =  60.f;
            m_OscFreq   =   0.8f;
            break;
    }

    // Spawn the first pipe a little off-screen so the player has time to react
    spawnPipe();
}

void PipeManager::spawnPipe()
{
    float range    = MAX_GAP_CENTRE - MIN_GAP_CENTRE;
    float gapCentreY = MIN_GAP_CENTRE +
                       static_cast<float>(std::rand()) / RAND_MAX * range;

    // Random phase offset for hard-mode oscillation
    float phase = static_cast<float>(std::rand()) / RAND_MAX *
                  2.f * 3.14159f;

    m_Pipes.push_back(std::make_unique<Pipe>(
        WINDOW_WIDTH + 10.f,
        gapCentreY,
        m_GapHeight,
        m_PipeSpeed,
        m_OscAmp, m_OscFreq, phase));
}

void PipeManager::update(sf::Time dt)
{
    m_SpawnTimer += dt.asSeconds();
    if (m_SpawnTimer >= m_SpawnInterval) {
        m_SpawnTimer = 0.f;
        spawnPipe();
    }

    for (auto& pipe : m_Pipes) {
        pipe->update(dt);
    }

    // Remove pipes that have scrolled off the left edge
    m_Pipes.erase(
        std::remove_if(m_Pipes.begin(), m_Pipes.end(),
            [](const std::unique_ptr<Pipe>& p) { return p->isOffScreen(); }),
        m_Pipes.end());
}

void PipeManager::draw(sf::RenderWindow& window)
{
    for (auto& pipe : m_Pipes) {
        pipe->draw(window);
    }
}

int PipeManager::checkScore(const Bird& bird)
{
    sf::FloatRect birdBounds = bird.getBounds();
    float birdCentreX = birdBounds.left + birdBounds.width / 2.f;
    int points = 0;

    for (auto& pipe : m_Pipes) {
        // Award point as soon as the bird's centre crosses the pipe's right edge
        if (!pipe->isScored() && birdCentreX > pipe->getRightEdge()) {
            pipe->setScored(true);
            ++points;
        }
    }
    return points;
}

bool PipeManager::checkCollision(const Bird& bird) const
{
    sf::FloatRect birdBounds = bird.getBounds();
    for (const auto& pipe : m_Pipes) {
        if (birdBounds.intersects(pipe->getTopBounds()))    return true;
        if (birdBounds.intersects(pipe->getBottomBounds())) return true;
    }
    return false;
}

void PipeManager::reset()
{
    m_Pipes.clear();
    m_SpawnTimer = 0.f;
    spawnPipe();
}
