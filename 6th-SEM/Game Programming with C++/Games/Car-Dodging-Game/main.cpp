#include <SFML/Graphics.hpp>
#include <SFML/Audio.hpp>
#include <iostream>
#include <vector>
#include <ctime>
#include "PlayerCar.h"
#include "EnemyCar.h"

using namespace sf;
using namespace std;

const int WIDTH = 800, HEIGHT = 700;

enum GameState{MENU,PLAYING,PAUSED,GAMEOVER};

int main(){
    srand(time(0));

    RenderWindow window(VideoMode(WIDTH,HEIGHT),"Car Dodging Game");
    window.setFramerateLimit(60);

    Font font;
    font.loadFromFile("assets/font/KOMIKAP_.ttf");

    Text scoreText,speedText,infoText;

    scoreText.setFont(font);
    scoreText.setCharacterSize(30);
    scoreText.setFillColor(Color::White);
    scoreText.setPosition(40,20);

    speedText.setFont(font);
    speedText.setCharacterSize(30);
    speedText.setFillColor(Color::White);
    speedText.setPosition(550,20);

    infoText.setFont(font);
    infoText.setCharacterSize(40);
    infoText.setFillColor(Color::White);

    Music bgMusic;
    bgMusic.openFromFile("assets/audio/bg_music.ogg");
    bgMusic.setLoop(true);
    bgMusic.play();

    SoundBuffer crashBuffer;
    crashBuffer.loadFromFile("assets/audio/crash.wav");

    Sound crashSound;
    crashSound.setBuffer(crashBuffer);

    PlayerCar player;
    vector<EnemyCar> enemies;
    vector<float> lanes={280,400,520};

    Clock spawnClock;

    GameState gameState=MENU;

    int score=0;

    float gameSpeed=5.f,spawnInterval=1.f;

    while(window.isOpen()){
        Event event;

        while(window.pollEvent(event)){
            if(event.type==Event::Closed) window.close();

            if(event.type==Event::KeyPressed){

                if(gameState==MENU && event.key.code==Keyboard::Enter)
                    gameState=PLAYING;

                else if(gameState==PLAYING && event.key.code==Keyboard::P)
                    gameState=PAUSED;

                else if(gameState==PAUSED && event.key.code==Keyboard::P)
                    gameState=PLAYING;

                else if(gameState==GAMEOVER && event.key.code==Keyboard::R){
                    enemies.clear();
                    score=0;
                    gameSpeed=5.f;
                    spawnInterval=1.f;
                    bgMusic.play();
                    player.getSprite().setPosition(400,580);
                    gameState=MENU;
                }
            }
        }

        if(gameState==PLAYING){

            player.update(gameSpeed);

            if(spawnClock.getElapsedTime().asSeconds()>spawnInterval){
                enemies.push_back(
                    EnemyCar(lanes[rand()%3],gameSpeed+(rand()%3))
                );

                spawnClock.restart();
            }

            for(int i=0;i<enemies.size();i++){
                enemies[i].update(gameSpeed);
                if(player.getBounds().intersects(enemies[i].getBounds())){
                    crashSound.play();
                    bgMusic.stop();
                    gameState=GAMEOVER;
                }
            }

            while(!enemies.empty() && enemies.front().offScreen()){
                enemies.erase(enemies.begin());
                score++;

                if(score%5==0){
                    gameSpeed+=0.5f;

                    if(spawnInterval>0.4f)
                        spawnInterval-=0.05f;
                }
            }
        }

        window.clear(Color(30,30,30));

        RectangleShape road(Vector2f(400,HEIGHT));
        road.setFillColor(Color::Black);
        road.setPosition(200,0);

        window.draw(road);

        for(int y=0;y<HEIGHT;y+=80){
            RectangleShape line(Vector2f(12,50));
            line.setFillColor(Color::White);
            line.setPosition(394,y);
            window.draw(line);
        }

        player.draw(window);

        for(int i=0;i<enemies.size();i++)
            enemies[i].draw(window);

        scoreText.setString("SCORE: "+to_string(score));
        speedText.setString("SPEED: "+to_string((int)gameSpeed));

        window.draw(scoreText);
        window.draw(speedText);

        if(gameState==MENU)
            infoText.setString("CAR DODGING GAME\n\nPress ENTER to Start");

        if(gameState==PAUSED)
            infoText.setString("PAUSED\n\nPress P to Resume");

        if(gameState==GAMEOVER)
            infoText.setString("GAME OVER\n\nPress R to Restart");

        if(gameState!=PLAYING){
            FloatRect bounds=infoText.getLocalBounds();
            infoText.setOrigin(bounds.width/2,bounds.height/2
            );

            infoText.setPosition(WIDTH/2,HEIGHT/2
            );

            window.draw(infoText);
        }

        window.display();
    }

    return 0;
}