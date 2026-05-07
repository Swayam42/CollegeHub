#ifndef PLAYERCAR_H
#define PLAYERCAR_H

#include "Car.h"

class PlayerCar : public Car
{
public:
    PlayerCar();

    void handleInput();

    void update(float speed) override;
};

#endif