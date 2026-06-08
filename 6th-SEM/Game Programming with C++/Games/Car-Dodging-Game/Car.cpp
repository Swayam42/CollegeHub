#include "Car.h"
using namespace sf;
void Car::draw(RenderWindow &window){
    window.draw(sprite);
}

FloatRect Car::getBounds(){
    return sprite.getGlobalBounds();
}

Sprite &Car::getSprite(){
    return sprite;
}