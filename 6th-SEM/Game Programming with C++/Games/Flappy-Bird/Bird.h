#pragma once
#include <SFML/Graphics.hpp>

// Difficulty settings passed to several classes
enum class Difficulty { EASY, MEDIUM, HARD };

class Bird {
private:
    sf::Vector2f m_Position;

    // Sprite-based rendering (when assets/bird.png is available)
    sf::Texture m_Texture;
    sf::Sprite  m_Sprite;

    // Fallback shape when texture is missing
    sf::RectangleShape m_Shape;

    bool m_TextureLoaded;

    float m_VelocityY;

    static const float GRAVITY;        // px/s²
    static const float FLAP_STRENGTH;  // px/s (negative = upward)
    static const float SCALED_W;       // display width
    static const float SCALED_H;       // display height

public:
    Bird(float startX, float startY);

    void flap();
    void update(sf::Time dt);
    void reset(float startX, float startY);

    sf::FloatRect getBounds() const;
    void draw(sf::RenderWindow& window);
};
