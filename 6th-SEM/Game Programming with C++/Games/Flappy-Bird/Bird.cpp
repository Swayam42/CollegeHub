#include "Bird.h"

const float Bird::GRAVITY       =  900.f;  // downward acceleration (px/s²)
const float Bird::FLAP_STRENGTH = -400.f;  // upward impulse   (px/s)
const float Bird::SCALED_W      =   40.f;  // display width    (px)
const float Bird::SCALED_H      =   50.f;  // display height   (px)

Bird::Bird(float startX, float startY)
    : m_VelocityY(0.f), m_TextureLoaded(false)
{
    m_TextureLoaded = m_Texture.loadFromFile("assets/bird.png");

    if (m_TextureLoaded) {
        m_Sprite.setTexture(m_Texture);
        // Original image: 141 x 180 px — scale to display size
        m_Sprite.setScale(SCALED_W / 141.f, SCALED_H / 180.f);
        m_Sprite.setOrigin(141.f / 2.f, 180.f / 2.f);
        m_Sprite.setPosition(startX, startY);
    } else {
        m_Shape.setSize(sf::Vector2f(SCALED_W, SCALED_H));
        m_Shape.setFillColor(sf::Color::Yellow);
        m_Shape.setOutlineColor(sf::Color(200, 150, 0));
        m_Shape.setOutlineThickness(2.f);
        m_Shape.setOrigin(SCALED_W / 2.f, SCALED_H / 2.f);
        m_Shape.setPosition(startX, startY);
    }

    m_Position = sf::Vector2f(startX, startY);
}

void Bird::flap()
{
    m_VelocityY = FLAP_STRENGTH;
}

void Bird::update(sf::Time dt)
{
    float secs = dt.asSeconds();
    m_VelocityY += GRAVITY * secs;
    m_Position.y += m_VelocityY * secs;

    // Visual tilt: nose-down when falling, nose-up when rising
    float angle = m_VelocityY * 0.05f;
    if (angle >  45.f) angle =  45.f;
    if (angle < -30.f) angle = -30.f;

    if (m_TextureLoaded) {
        m_Sprite.setPosition(m_Position);
        m_Sprite.setRotation(angle);
    } else {
        m_Shape.setPosition(m_Position);
        m_Shape.setRotation(angle);
    }
}

void Bird::reset(float startX, float startY)
{
    m_VelocityY = 0.f;
    m_Position  = sf::Vector2f(startX, startY);

    if (m_TextureLoaded) {
        m_Sprite.setPosition(m_Position);
        m_Sprite.setRotation(0.f);
    } else {
        m_Shape.setPosition(m_Position);
        m_Shape.setRotation(0.f);
    }
}

sf::FloatRect Bird::getBounds() const
{
    if (m_TextureLoaded) return m_Sprite.getGlobalBounds();
    return m_Shape.getGlobalBounds();
}

void Bird::draw(sf::RenderWindow& window)
{
    if (m_TextureLoaded) window.draw(m_Sprite);
    else                  window.draw(m_Shape);
}
