#pragma once

#include "Car.h"

class EnemyCar : public Car {
private:
    std::size_t m_LaneIndex;

public:
    EnemyCar(float width, float height, float speed, std::size_t laneIndex, float x, float y);

    std::size_t getLaneIndex() const;
};
