#ifndef ENEMYCAR_H
#define ENEMYCAR_H

#include "Car.h"

class EnemyCar : public Car{
private:
    float enemySpeed;

public:
    EnemyCar(float x, float speed);
    void update(float speed) override;
    bool offScreen();
};

#endif