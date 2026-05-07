#include "Pipe.h"
#include <cmath>

const float Pipe::PIPE_WIDTH    =  52.f;
const float Pipe::WINDOW_HEIGHT = 600.f;
const float Pipe::GROUND_HEIGHT =  20.f;  // ground strip at bottom

Pipe::Pipe(float x, float gapCenterY, float gapHeight, float speed,
           float oscAmp, float oscFreq, float oscPhase)
    : m_X(x), m_GapCenterY(gapCenterY), m_GapHeight(gapHeight),
      m_Speed(speed),
      m_OscAmp(oscAmp), m_OscFreq(oscFreq), m_OscPhase(oscPhase),
      m_Elapsed(0.f), m_Scored(false)
{
    m_TextureLoaded = m_Texture.loadFromFile("assets/pipe.png");

    // Shared style
    sf::Color pipeColor(34, 139, 34);   // forest green fallback
    if (!m_TextureLoaded) {
        m_TopPipe.setFillColor(pipeColor);
        m_BottomPipe.setFillColor(pipeColor);
        m_TopPipe.setOutlineColor(sf::Color(0, 80, 0));
        m_BottomPipe.setOutlineColor(sf::Color(0, 80, 0));
        m_TopPipe.setOutlineThickness(2.f);
        m_BottomPipe.setOutlineThickness(2.f);
    }

    rebuild();
}

void Pipe::rebuild()
{
    float topH    = m_GapCenterY - m_GapHeight / 2.f;
    float bottomY = m_GapCenterY + m_GapHeight / 2.f;
    float bottomH = (WINDOW_HEIGHT - GROUND_HEIGHT) - bottomY;

    if (topH < 0.f)    topH    = 0.f;
    if (bottomH < 0.f) bottomH = 0.f;

    m_TopPipe.setSize(sf::Vector2f(PIPE_WIDTH, topH));
    m_TopPipe.setPosition(m_X, 0.f);

    m_BottomPipe.setSize(sf::Vector2f(PIPE_WIDTH, bottomH));
    m_BottomPipe.setPosition(m_X, bottomY);

    if (m_TextureLoaded) {
        // Tile the texture vertically so it looks natural
        m_TopPipe.setTexture(&m_Texture);
        m_BottomPipe.setTexture(&m_Texture);
    }
}

void Pipe::update(sf::Time dt)
{
    float secs = dt.asSeconds();
    m_Elapsed += secs;
    m_X -= m_Speed * secs;

    // Vertical oscillation (hard mode)
    if (m_OscAmp > 0.f) {
        m_GapCenterY += m_OscAmp * m_OscFreq *
                        std::cos(2.f * 3.14159f * m_OscFreq * m_Elapsed + m_OscPhase) * secs;

        // Clamp gap centre so pipes stay on screen
        float minY = m_GapHeight / 2.f + 20.f;
        float maxY = WINDOW_HEIGHT - GROUND_HEIGHT - m_GapHeight / 2.f - 20.f;
        if (m_GapCenterY < minY) { m_GapCenterY = minY; }
        if (m_GapCenterY > maxY) { m_GapCenterY = maxY; }
    }

    rebuild();
}

void Pipe::draw(sf::RenderWindow& window)
{
    window.draw(m_TopPipe);
    window.draw(m_BottomPipe);
}

sf::FloatRect Pipe::getTopBounds()    const { return m_TopPipe.getGlobalBounds();    }
sf::FloatRect Pipe::getBottomBounds() const { return m_BottomPipe.getGlobalBounds(); }
float         Pipe::getX()            const { return m_X; }
float         Pipe::getRightEdge()    const { return m_X + PIPE_WIDTH; }
bool          Pipe::isScored()        const { return m_Scored; }
void          Pipe::setScored(bool v)       { m_Scored = v; }
bool          Pipe::isOffScreen()     const { return (m_X + PIPE_WIDTH) < 0.f; }
