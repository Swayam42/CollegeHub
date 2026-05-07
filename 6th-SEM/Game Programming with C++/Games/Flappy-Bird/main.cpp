#include <SFML/Graphics.hpp>
#include <SFML/Audio.hpp>
#include <iostream>
#include <vector>
#include <fstream>
#include <ctime>

#include "Bird.h"
#include "Pipe.h"

using namespace sf;
using namespace std;

const int WIDTH = 900;
const int HEIGHT = 600;

enum GameState
{
    MENU,
    PLAYING,
    PAUSED,
    GAMEOVER
};

enum Difficulty
{
    EASY,
    MEDIUM,
    HARD
};

int main()
{
    srand(time(0));
    RenderWindow window(VideoMode(WIDTH, HEIGHT), "Flappy Bird");

    window.setFramerateLimit(60);
    SoundBuffer flapBuffer;
    SoundBuffer hitBuffer;

    flapBuffer.loadFromFile("assets/audio/flap.wav");
    hitBuffer.loadFromFile("assets/audio/hit.wav");

    Sound flapSound;
    Sound hitSound;

    flapSound.setBuffer(flapBuffer);
    hitSound.setBuffer(hitBuffer);

    Font font;
    font.loadFromFile("assets/fonts/KOMIKAP_.ttf");

    Text scoreText;
    Text highScoreText;
    //--------------------------------
    // Current Score (Top Left)
    //--------------------------------

    scoreText.setFont(font);
    scoreText.setCharacterSize(40);
    scoreText.setFillColor(Color::Black);
    scoreText.setPosition(30, 20);

    highScoreText.setFont(font);
    highScoreText.setCharacterSize(40);
    highScoreText.setFillColor(Color::Black);
    highScoreText.setPosition(620, 20);

    Text infoText;

    infoText.setFont(font);
    infoText.setCharacterSize(30);
    infoText.setFillColor(Color::Black);
    infoText.setPosition(250, 180);

    Bird bird;
    vector<Pipe> pipes;

    Clock pipeClock;
    GameState gameState = MENU;

    int score = 0;
    int highScore = 0;

    float gapSize = 180;
    float pipeSpeed = 4;
    float spawnInterval = 1.0f;

    bool oscillation = false;

    ifstream inFile("highscore.txt");

    if (inFile.is_open())
    {
        inFile >> highScore;
    }

    inFile.close();

    while (window.isOpen())
    {
        Event event;

        while (window.pollEvent(event))
        {
            if (event.type == Event::Closed)
            {
                window.close();
            }
            if (event.type == Event::KeyPressed)
            {
                if (gameState == MENU)
                {
                    if (event.key.code == Keyboard::Num1)
                    {
                        gapSize = 250;
                        pipeSpeed = 3;
                        oscillation = false;
                        gameState = PLAYING;
                    }

                    if (event.key.code == Keyboard::Num2)
                    {
                        gapSize = 180;
                        pipeSpeed = 4;
                        oscillation = false;
                        gameState = PLAYING;
                    }

                    if (event.key.code == Keyboard::Num3)
                    {
                        gapSize = 140;
                        pipeSpeed = 5;
                        oscillation = true;
                        gameState = PLAYING;
                    }
                }
                else if (gameState == PLAYING)
                {
                    if (event.key.code == Keyboard::Space)
                    {
                        bird.flap();
                        flapSound.play();
                    }

                    if (event.key.code == Keyboard::P)
                    {
                        gameState = PAUSED;
                    }
                }
                else if (gameState == PAUSED)
                {
                    if (event.key.code == Keyboard::P)
                    {
                        gameState = PLAYING;
                    }
                }
                else if (gameState == GAMEOVER)
                {
                    if (event.key.code == Keyboard::R)
                    {
                        score = 0;
                        pipes.clear();
                        bird.reset();
                        gameState = MENU;
                    }
                }
            }
        }
        if (gameState == PLAYING)
        {
            bird.update();
            if (pipeClock.getElapsedTime().asSeconds() > spawnInterval)
            {
                float margin = 60.f;
                float minGapY = margin;
                float maxGapY = HEIGHT - gapSize - margin;

                if (maxGapY < minGapY)
                {
                    maxGapY = minGapY;
                }
                float gapY = minGapY +
                             (static_cast<float>(rand()) / RAND_MAX) *
                                 (maxGapY - minGapY);

                pipes.push_back(
                    Pipe(WIDTH, gapY, gapSize, pipeSpeed, HEIGHT));

                pipeClock.restart();
            }
            for (int i = 0; i < pipes.size(); i++)
            {
                pipes[i].update(oscillation);
                if (!pipes[i].passed &&
                    pipes[i].topPipe.getPosition().x < 200)
                {
                    score++;

                    pipes[i].passed = true;
                }
                if (pipes[i].checkCollision(bird.getBounds()))
                {
                    gameState = GAMEOVER;

                    hitSound.play();
                }
            }
            while (!pipes.empty() &&
                   pipes.front().offScreen())
            {
                pipes.erase(pipes.begin());
            }
            if (bird.getY() > HEIGHT)
            {
                gameState = GAMEOVER;

                hitSound.play();
            }
            if (score > highScore)
            {
                highScore = score;
                ofstream outFile("highscore.txt");
                outFile << highScore;
                outFile.close();
            }
        }
        window.clear(Color(Color::White));
        for (int i = 0; i < pipes.size(); i++)
        {
            pipes[i].draw(window);
        }
        bird.draw(window);
        scoreText.setString(
            "Score: " + to_string(score));

        highScoreText.setString(
            "High Score: " + to_string(highScore));

        window.draw(scoreText);
        window.draw(highScoreText);
if (gameState == MENU)
{
    infoText.setString(
        "FLAPPY BIRD\n\n"
        "Press 1 : Easy\n"
        "Press 2 : Medium\n"
        "Press 3 : Hard"
    );
    FloatRect textRect =
        infoText.getLocalBounds();
    infoText.setOrigin(
        textRect.left + textRect.width / 2.0f,
        textRect.top + textRect.height / 2.0f
    );

    infoText.setPosition(
        WIDTH / 2.0f,
        HEIGHT / 2.0f
    );

    window.draw(infoText);
}
if (gameState == PAUSED)
{
    infoText.setString(
        "PAUSED\n\n"
        "Press P to Resume"
    );

    FloatRect textRect =
        infoText.getLocalBounds();

    infoText.setOrigin(
        textRect.left + textRect.width / 2.0f,
        textRect.top + textRect.height / 2.0f
    );

    infoText.setPosition(
        WIDTH / 2.0f,
        HEIGHT / 2.0f
    );

    window.draw(infoText);
}
        if (gameState == GAMEOVER)
        {
            infoText.setString(
                "GAME OVER\n\n"
                "Press R to Restart");
            window.draw(infoText);
        }

        window.display();
    }
    return 0;
}