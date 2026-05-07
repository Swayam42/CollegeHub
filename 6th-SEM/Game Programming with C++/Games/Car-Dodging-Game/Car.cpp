#include "Car.h"

void Car::draw(sf::RenderWindow &window)
{
    window.draw(sprite);
}

sf::FloatRect Car::getBounds()
{
    return sprite.getGlobalBounds();
}

sf::Sprite &Car::getSprite()
{
    return sprite;
}