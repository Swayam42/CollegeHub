#include "Bat.h"

Bat :: Bat(float startX,float startY){
	m_Position.x=startX;
	m_Position.y=startY;
	m_Shape.setSize(sf::Vector2f(70,10));
	m_Shape.setPosition(m_Position);
	m_Shape.setFillColor(Color(150, 210, 196));
}

FloatRect Bat::getPosition(){
	return m_Shape.getGlobalBounds();
}

RectangleShape Bat::getShape(){
	return m_Shape;
}
