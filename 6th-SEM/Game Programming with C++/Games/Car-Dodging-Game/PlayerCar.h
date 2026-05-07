#pragma once

#include "Car.h"
#include <vector>

class PlayerCar : public Car {
private:
    std::size_t m_LaneIndex;

public:
    PlayerCar(float width, float height, float speed);

    void moveLeft();
    void moveRight(std::size_t laneCount);

    void setLane(std::size_t laneIndex, const std::vector<float>& laneCenters, float y);
    std::size_t getLaneIndex() const;
};
