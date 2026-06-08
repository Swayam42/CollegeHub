#include "EnemyCar.h"
#include <cstdlib>
#include <iostream>

using namespace sf;
namespace{
    Texture red1;
    Texture red2;
    Texture yellow1;
    Texture yellow2;
    Texture yellow3;

    bool loaded = false;
}

EnemyCar::EnemyCar(float x, float speed){
        red1.loadFromFile("assets/graphics/RedCar1.png");
        red2.loadFromFile("assets/graphics/RedCar2.png");
        yellow1.loadFromFile("assets/graphics/YellowCar1.png");
        yellow2.loadFromFile("assets/graphics/YellowCar2.png");
        yellow3.loadFromFile("assets/graphics/YellowCar3.png");

    int type = rand() % 5;
    switch (type)
    {
    case 0:
        sprite.setTexture(red1);
        break;
    case 1:
        sprite.setTexture(red2);
        break;
    case 2:
        sprite.setTexture(yellow1);
        break;
    case 3:
        sprite.setTexture(yellow2);
        break;
    case 4:
        sprite.setTexture(yellow3);
        break;
    }
    sprite.setScale(0.4f, 0.5f);
    FloatRect bounds = sprite.getLocalBounds();

    sprite.setOrigin(
        bounds.width / 2.f,
        bounds.height / 2.f);
    sprite.setPosition(x, -150);
    enemySpeed = speed;
}

void EnemyCar::update(float speed){
    sprite.move(0, enemySpeed);
}

bool EnemyCar::offScreen(){
    return sprite.getPosition().y > 800;
}