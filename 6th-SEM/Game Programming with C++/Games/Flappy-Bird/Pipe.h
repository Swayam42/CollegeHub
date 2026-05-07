#ifndef PIPE_H
#define PIPE_H
#include <SFML/Graphics.hpp>
using namespace sf;
class Pipe{
private:
    Texture texture;

public:
    Sprite topPipe;
    Sprite bottomPipe;
    bool passed;
    float speed;
    Pipe(float x, float gapY, float gapSize, float spd, float screenH);
    void update(bool oscillate);
    void draw(RenderWindow &window);
    bool offScreen();
    bool checkCollision(FloatRect birdBounds);
};

#endif