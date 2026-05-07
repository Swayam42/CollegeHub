#include "Car.h"

Car::Car(float width, float height, sf::Color color, float speed)
    : m_Speed(speed)
{
    m_Shape.setSize(sf::Vector2f(width, height));
    m_Shape.setFillColor(color);
    m_Shape.setOrigin(width * 0.5f, height * 0.5f);
}

void Car::update(float dt)
{
    m_Shape.move(0.f, m_Speed * dt);
}

void Car::draw(sf::RenderWindow& window) const
{
    window.draw(m_Shape);
}

void Car::setPosition(float x, float y)
{
    m_Shape.setPosition(x, y);
}

sf::Vector2f Car::getPosition() const
{
    return m_Shape.getPosition();
}

sf::FloatRect Car::getBounds() const
{
    return m_Shape.getGlobalBounds();
}

void Car::setSpeed(float speed)
{
    m_Speed = speed;
}

float Car::getSpeed() const
{
    return m_Speed;
}
