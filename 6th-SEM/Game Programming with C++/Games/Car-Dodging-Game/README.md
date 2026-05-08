---
# Car Dodging Game

## Overview
This project is a 2D Car Dodging Game developed using C++ and SFML.
The player controls a car moving across lanes while avoiding incoming enemy vehicles.
The objective is to survive as long as possible and achieve the highest score.
---

## Features

- Object-Oriented Programming using:
  - Car base class
  - PlayerCar class
  - EnemyCar class
- Player movement using keyboard controls
- Enemy car spawning in random lanes
- Increasing game speed over time
- Randomized enemy speeds
- Collision detection system
- Score system
- Speed display system
- Pause and Resume functionality
- Restart after Game Over
- Background music
- Crash sound effect
- Road and lane rendering using SFML shapes
- Texture based vehicle graphics

---

## Controls

| Key         | Action         |
| ----------- | -------------- |
| LEFT ARROW  | Move Left      |
| RIGHT ARROW | Move Right     |
| P           | Pause / Resume |
| R           | Restart        |
| ENTER       | Start Game     |

---

## Technologies Used

- C++
- SFML Graphics
- SFML Audio

---

## Folder Structure

```txt
Car-Dodging-Game/
│
├── main.cpp
├── Car.cpp
├── Car.h
├── PlayerCar.cpp
├── PlayerCar.h
├── EnemyCar.cpp
├── EnemyCar.h
│
└── assets/
    ├── audio/
    ├── graphics/
    └── font/
```

## Compilation

```g++ main.cpp Car.cpp PlayerCar.cpp EnemyCar.cpp -o CarGame \
-lsfml-graphics \
-lsfml-window \
-lsfml-system \
-lsfml-audio && ./CarGame
```
