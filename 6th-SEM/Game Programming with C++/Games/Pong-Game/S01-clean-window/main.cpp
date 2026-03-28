#include <SFML/Graphics.hpp>

using namespace sf;

int main()
{
    VideoMode vm(960, 540);
    RenderWindow window(vm, "Pong Game!!!");
    while (window.isOpen())
    {
        Event event;
        while (window.pollEvent(event))
        {
            
            if (event.type == Event::Closed)
                window.close(); 
        }
        window.clear(Color(28, 27, 55));
        window.display();
    } 
    return 0;
}
