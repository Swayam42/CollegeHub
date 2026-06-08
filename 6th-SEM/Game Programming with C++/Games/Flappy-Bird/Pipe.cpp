#include "Pipe.h"
#include <iostream>

using namespace sf;
namespace{
    Texture pipeTexture;
    bool loaded = false;
}

Pipe::Pipe(float x, float gapY, float gapSize, float spd, float screenH){
    if(!loaded){
        if (!pipeTexture.loadFromFile("assets/graphics/pipe.png")){
            std::cout << "Pipe texture failed\n";
        }

        loaded = true;
    }
    topPipe.setTexture(pipeTexture);
    bottomPipe.setTexture(pipeTexture);

    float screenHeight = screenH;
    float scaleX = 0.8f;

    Vector2u texSize = pipeTexture.getSize();
    float textureHeight = static_cast<float>(texSize.y);
    if (textureHeight < 1.f){
        textureHeight = 1.f;
    }

    float topHeight = gapY;
    float bottomHeight = screenHeight - (gapY + gapSize);

    if (topHeight < 0.f){
        topHeight = 0.f;
    }
    if (bottomHeight < 0.f){
        bottomHeight = 0.f;
    }

    topPipe.setScale(scaleX, -topHeight / textureHeight);
    topPipe.setPosition(x, gapY);
    bottomPipe.setScale(scaleX, bottomHeight / textureHeight);
    bottomPipe.setPosition(x, gapY + gapSize);
    speed = spd;
    passed = false;
}

void Pipe::update(bool oscillate){
    topPipe.move(-speed, 0);
    bottomPipe.move(-speed, 0);
}

void Pipe::draw(RenderWindow &window){
    window.draw(topPipe);
    window.draw(bottomPipe);
}

bool Pipe::offScreen(){
    float width = topPipe.getGlobalBounds().width;
    return (topPipe.getPosition().x + width) < 0;
}

bool Pipe::checkCollision(FloatRect birdBounds){
    return birdBounds.intersects(topPipe.getGlobalBounds()) ||
           birdBounds.intersects(bottomPipe.getGlobalBounds());
}