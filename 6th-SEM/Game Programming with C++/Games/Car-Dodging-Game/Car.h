#pragma once

#include <SFML/Graphics.hpp>

class Car {
protected:
    sf::RectangleShape m_Shape;
    float m_Speed;

public:
    Car(float width, float height, sf::Color color, float speed);
    virtual ~Car() = default;

    virtual void update(float dt);
    void draw(sf::RenderWindow& window) const;

    void setPosition(float x, float y);
    sf::Vector2f getPosition() const;
    sf::FloatRect getBounds() const;

    void setSpeed(float speed);
    float getSpeed() const;
};
