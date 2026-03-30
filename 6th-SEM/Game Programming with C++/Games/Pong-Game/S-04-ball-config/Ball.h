#include<SFML/Graphics.hpp>
using namespace sf;
class Ball
{
private:
	 Vector2f m_Position;
	 CircleShape m_Shape;
	 float m_Speed = 1000.0f;
	 float m_DirectionX = 0.2f;
	 float m_DirectionY = 0.2f;	 
public:
	Ball(float startX, float startY) ;
	FloatRect getPosition();
	CircleShape getShape();
	
	void reboundSides();
	void reboundBatOrTop();
	void reboundBottom();
	
	void update(Time dt);
};
