#ifndef BIRD_H
#define BIRD_H

#include <SFML/Graphics.hpp>
using namespace sf;
class Bird{
private:
    Texture texture;
    Sprite spriteBird;
    float velocity;

public:
    Bird();
    void flap();
    void update();
    void reset();
    void draw(RenderWindow &window);
    FloatRect getBounds();
    float getY();
};

#endif