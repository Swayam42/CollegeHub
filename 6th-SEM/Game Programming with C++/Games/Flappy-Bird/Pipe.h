#pragma once
#include <SFML/Graphics.hpp>

// A single pipe *pair* (top + bottom pipe with a gap between them).
class Pipe {
private:
    sf::RectangleShape m_TopPipe;
    sf::RectangleShape m_BottomPipe;
    sf::Texture        m_Texture;
    bool               m_TextureLoaded;

    float m_X;
    float m_GapCenterY;   // vertical centre of the gap
    float m_GapHeight;    // pixel height of the bird-passage gap
    float m_Speed;        // horizontal speed (px/s)

    // Hard-mode vertical oscillation
    float m_OscAmp;       // amplitude (px), 0 = no oscillation
    float m_OscFreq;      // frequency (Hz)
    float m_OscPhase;     // initial phase offset (radians)
    float m_Elapsed;      // seconds since spawn

    bool m_Scored;        // true once the bird has passed this pipe

    static const float PIPE_WIDTH;
    static const float WINDOW_HEIGHT;
    static const float GROUND_HEIGHT;

    void rebuild();       // recalculate top/bottom shapes from current state

public:
    Pipe(float x, float gapCenterY, float gapHeight, float speed,
         float oscAmp = 0.f, float oscFreq = 0.f, float oscPhase = 0.f);

    void update(sf::Time dt);
    void draw(sf::RenderWindow& window);

    sf::FloatRect getTopBounds()    const;
    sf::FloatRect getBottomBounds() const;

    float getX()         const;
    float getRightEdge() const;
    bool  isScored()     const;
    void  setScored(bool v);
    bool  isOffScreen()  const;
};
