#include "PlayerCar.h"

using namespace sf;

//-----------------------------------
// Shared Texture
//-----------------------------------

namespace
{
    Texture playerTexture;

    bool loaded = false;
}

PlayerCar::PlayerCar()
{
    //-----------------------------------
    // Load once
    //-----------------------------------

    if (!loaded)
    {
        playerTexture.loadFromFile(
            "assets/graphics/WhiteCar.png");

        loaded = true;
    }

    //-----------------------------------

    sprite.setTexture(playerTexture);

    //-----------------------------------
    // Better scaling
    //-----------------------------------

    sprite.setScale(0.4f, 0.4f);

    //-----------------------------------
    // Center origin
    //-----------------------------------

    FloatRect bounds =
        sprite.getLocalBounds();

    sprite.setOrigin(
        bounds.width / 2.f,
        bounds.height / 2.f);

    //-----------------------------------

    sprite.setPosition(400, 580);
}

void PlayerCar::handleInput()
{
    float moveSpeed = 7.f;

    if (Keyboard::isKeyPressed(
            Keyboard::Left))
    {
        if (sprite.getPosition().x > 260)
        {
            sprite.move(-moveSpeed, 0);
        }
    }

    if (Keyboard::isKeyPressed(
            Keyboard::Right))
    {
        if (sprite.getPosition().x < 540)
        {
            sprite.move(moveSpeed, 0);
        }
    }
}

void PlayerCar::update(float speed)
{
    handleInput();
}