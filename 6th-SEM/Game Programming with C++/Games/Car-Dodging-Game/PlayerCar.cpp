#include "PlayerCar.h"

using namespace sf;
namespace
{
    Texture playerTexture;
    bool loaded = false;
}

PlayerCar::PlayerCar(){
    playerTexture.loadFromFile("assets/graphics/WhiteCar.png");

    sprite.setTexture(playerTexture);
    sprite.setScale(0.4f, 0.5f);
    FloatRect bounds =sprite.getLocalBounds();

    sprite.setOrigin(bounds.width / 2.f,bounds.height / 2.f);
    sprite.setPosition(400, 580);
}

void PlayerCar::handleInput(){
    float moveSpeed = 7.f;
    if (Keyboard::isKeyPressed(Keyboard::Left)){
        if (sprite.getPosition().x > 260){
            sprite.move(-moveSpeed, 0);
        }
    }

    if (Keyboard::isKeyPressed(Keyboard::Right)){
        if (sprite.getPosition().x < 540){
            sprite.move(moveSpeed, 0);
        }
    }
}

void PlayerCar::update(float speed){
    handleInput();
}