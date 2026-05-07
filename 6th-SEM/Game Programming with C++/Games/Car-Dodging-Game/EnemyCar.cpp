#include "EnemyCar.h"

EnemyCar::EnemyCar(float width, float height, float speed, std::size_t laneIndex, float x, float y)
    : Car(width, height, sf::Color(220, 40, 40), speed),
      m_LaneIndex(laneIndex)
{
    setPosition(x, y);
}

std::size_t EnemyCar::getLaneIndex() const
{
    return m_LaneIndex;
}
