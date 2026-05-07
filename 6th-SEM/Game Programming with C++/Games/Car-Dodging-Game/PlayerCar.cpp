#include "PlayerCar.h"

PlayerCar::PlayerCar(float width, float height, float speed)
    : Car(width, height, sf::Color::White, speed),
      m_LaneIndex(1)
{
}

void PlayerCar::moveLeft()
{
    if (m_LaneIndex > 0) {
        --m_LaneIndex;
    }
}

void PlayerCar::moveRight(std::size_t laneCount)
{
    if (m_LaneIndex + 1 < laneCount) {
        ++m_LaneIndex;
    }
}

void PlayerCar::setLane(std::size_t laneIndex, const std::vector<float>& laneCenters, float y)
{
    m_LaneIndex = laneIndex;
    setPosition(laneCenters[m_LaneIndex], y);
}

std::size_t PlayerCar::getLaneIndex() const
{
    return m_LaneIndex;
}
