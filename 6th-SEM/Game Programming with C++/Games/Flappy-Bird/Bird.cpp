#include "Bird.h"
using namespace sf;
Bird::Bird(){
    texture.loadFromFile("assets/graphics/bird.png");
    spriteBird.setTexture(texture);
    spriteBird.setScale(0.2f, 0.2f);
    spriteBird.setPosition(200, 300);
    velocity = 0;
}

void Bird::flap(){
    velocity = -8.5f;
}

void Bird::update(){
    velocity += 0.45f;
    spriteBird.move(0, velocity);
    spriteBird.setRotation(velocity * 3);
    if (spriteBird.getPosition().y < 0){
        spriteBird.setPosition(spriteBird.getPosition().x, 0);
        velocity = 0;
    }
}

void Bird::reset(){
    spriteBird.setPosition(200, 300);
    velocity = 0;
    spriteBird.setRotation(0);
}

void Bird::draw(sf::RenderWindow &window){
    window.draw(spriteBird);
}

sf::FloatRect Bird::getBounds(){
    return spriteBird.getGlobalBounds();
}

float Bird::getY(){
    return spriteBird.getPosition().y;
}