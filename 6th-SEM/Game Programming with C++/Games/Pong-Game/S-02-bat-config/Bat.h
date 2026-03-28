#include <SFML/Graphics.hpp>

using namespace sf;

class Bat{
private:
	Vector2f m_Position;
	RectangleShape m_Shape;
public:
	Bat(float startX, float startY);
	FloatRect getPosition();
	RectangleShape getShape();
};
