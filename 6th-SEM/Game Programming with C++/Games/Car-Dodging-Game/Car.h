#ifndef CAR_H
#define CAR_H

#include <SFML/Graphics.hpp>

class Car
{
protected:
    sf::Sprite sprite;
    sf::Texture texture;

public:
    virtual void update(float speed) = 0;

    void draw(sf::RenderWindow &window);

    sf::FloatRect getBounds();

    sf::Sprite &getSprite();
};

#endif