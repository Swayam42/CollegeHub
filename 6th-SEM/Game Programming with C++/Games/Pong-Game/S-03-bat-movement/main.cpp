#include <SFML/Graphics.hpp>
#include "Bat.cpp"

using namespace sf;

int main()
{
    VideoMode vm(960, 540);
    RenderWindow window(vm, "Pong Game!!!");

    Bat bat(960 / 2, 540 - 20);
    Clock clock;

    while (window.isOpen())
    {
        Event event;
        while (window.pollEvent(event))
        {
            if (event.type == Event::Closed)
                window.close();
        }
        if (Keyboard::isKeyPressed(Keyboard::Escape))
        {
            window.close();
        }

        if (Keyboard::isKeyPressed(Keyboard::Left))
        {
            bat.moveLeft();
        }
        else
        {
            bat.stopLeft();
        }

        if (Keyboard::isKeyPressed(Keyboard::Right))
        {
            bat.moveRight();
        }
        else
        {
            bat.stopRight();
        }
        Time dt = clock.restart();
        bat.update(dt);
        window.clear(Color(28, 27, 55));
        window.draw(bat.getShape());
        window.display();
    }

    return 0;
}
