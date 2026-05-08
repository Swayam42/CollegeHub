#ifndef CAR_H
#define CAR_H

#include <SFML/Graphics.hpp>
using namespace sf;
class Car{
protected:
    Sprite sprite;
    Texture texture;

public:
    virtual void update(float speed) = 0;
    void draw(RenderWindow &window);
    FloatRect getBounds();
    Sprite &getSprite();
};
#endif