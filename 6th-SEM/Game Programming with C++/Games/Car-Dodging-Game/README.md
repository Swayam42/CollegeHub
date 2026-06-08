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

---

## Annexure: Code Files and Short Explanation

### 1) main.cpp

This file is the entry point and drives the entire game loop.
It sets up the SFML window, fonts, UI text, and audio assets.
The file manages game states (menu, playing, paused, game over) and input flow.
It handles spawning enemy cars, collision checks, scoring, and difficulty scaling.
It also draws the road, lane markers, player, enemies, and status text each frame.

### 2) Car.h

This header defines the abstract base class for all cars in the game.
It stores the common SFML sprite and texture used by derived classes.
The class enforces a virtual `update` method so each car can define its behavior.
It also declares helpers to draw the sprite and return its bounds.
These shared functions keep common rendering and collision logic in one place.

### 3) Car.cpp

This source file implements the common drawing and utility methods for `Car`.
`draw` renders the car sprite to the provided SFML window.
`getBounds` returns the global bounds for collision detection in the main loop.
`getSprite` exposes the sprite reference for positioning and direct access.
Keeping these in one file avoids duplication across player and enemy classes.

### 4) PlayerCar.h

This header declares the `PlayerCar` class that inherits from `Car`.
It exposes a constructor to load the player texture and set initial position.
It declares `handleInput` for keyboard-based lane movement.
The `update` method is overridden to run input handling each frame.
The class keeps player logic isolated from the rest of the game code.

### 5) PlayerCar.cpp

This file loads the player car texture and configures its sprite size and origin.
It places the player car near the bottom of the road at the start of play.
`handleInput` reads arrow keys and moves the car within the road bounds.
The `update` method delegates to input handling, keeping movement responsive.
All player movement rules stay here for easier maintenance.

### 6) EnemyCar.h

This header defines the `EnemyCar` class derived from `Car`.
It stores an `enemySpeed` value so each enemy can move independently.
The constructor accepts a lane position and starting speed for variety.
It declares `update` to move the enemy and `offScreen` to remove old cars.
These declarations keep enemy behavior distinct from the player logic.

### 7) EnemyCar.cpp

This file loads multiple enemy car textures and randomly selects one per spawn.
It sets the enemy scale, origin, and initial off-screen position above the road.
Each enemy moves downward using its own stored speed value.
`offScreen` returns true when the car has moved past the bottom edge.
This logic supports random variety and smooth enemy cleanup during gameplay.
