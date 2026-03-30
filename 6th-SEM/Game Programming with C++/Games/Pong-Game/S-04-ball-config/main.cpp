#include <SFML/Graphics.hpp>
#include"Bat.cpp"
#include"Ball.cpp"
using namespace sf;
int main()
{
    VideoMode vm(960,540);
    RenderWindow window(vm,"Pong Game");
    Bat bat(960/2,540-20);
    Ball ball(960/2,0);
    Clock clock;

    while (window.isOpen())
    {   Time dt = clock.restart();
        Event event;
        while (window.pollEvent(event))
        {
            if (event.type == Event::Closed)
                window.close();
        }

        if (Keyboard::isKeyPressed(Keyboard::Escape)) {
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
        bat.update(dt);

        if(ball.getPosition().left<0 || ball.getPosition().left +ball.getPosition().width>window.getSize().x)
        {
       			 ball.reboundSides();
        }
        if(ball.getPosition().top<0)
        {
       			 ball.reboundBatOrTop();       
        }
        if(ball.getPosition().top>window.getSize().y)
        {
       			 ball.reboundBottom();           
        }
        
        if(ball.getPosition().intersects(bat.getPosition()))
        {
        ball.reboundBatOrTop();
        }         
        
        ball.update(dt);
        window.clear(Color(28, 27, 55));
        window.draw(bat.getShape());
        window.draw(ball.getShape());
        window.display();
    }
    return 0;
}
