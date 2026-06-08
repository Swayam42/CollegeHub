# Flappy Bird Game using C++ and SFML

## Overview

This project is a 2D Flappy Bird style game developed using C++ and SFML (Simple and Fast Multimedia Library).  
The player controls a bird that continuously falls due to gravity and must pass through gaps between moving pipes without colliding.

---

## Features

- Object-Oriented Programming using Bird and Pipe classes
- Gravity based bird movement
- Smooth flap mechanics
- Random pipe generation
- Collision detection
- Real-time score system
- High score saving using file handling
- Difficulty modes:
  - Easy
  - Medium
  - Hard
- Pause and Resume functionality
- Restart after Game Over
- Sound effects:
  - Flap sound
  - Hit sound
- Pipe movement and scrolling environment
- SFML based graphics rendering

---

## Controls

| Key   | Action         |
| ----- | -------------- |
| SPACE | Flap           |
| P     | Pause / Resume |
| R     | Restart        |
| 1     | Easy Mode      |
| 2     | Medium Mode    |
| 3     | Hard Mode      |

---

## Technologies Used

- C++
- SFML Graphics
- SFML Audio

---

## Folder Structure

```txt
FlappyBird/
│
├── main.cpp
├── Bird.cpp
├── Bird.h
├── Pipe.cpp
├── Pipe.h
│
└── assets/
    ├── audio/
    ├── graphics/
    └── fonts/
```

## Compilation

````g++ main.cpp Bird.cpp Pipe.cpp -o FlappyBird \
-lsfml-graphics \
-lsfml-window \
-lsfml-system \
-lsfml-audio && ./FlappyBird```

---

## Annexure: Code Files (Serial Order)

1. [main.cpp](main.cpp)
  Handles window creation, game loop, and event input for all states.
  Manages score, high score file I/O, and difficulty settings.
  Spawns and updates pipes, checks collisions, and triggers sounds.
  Renders the bird, pipes, and UI text for menu/pause/game over.

2. [Bird.h](Bird.h)
  Declares the `Bird` class with texture, sprite, and motion state.
  Exposes methods for flap, update, reset, draw, and bounds checks.
  Provides accessors used by the main loop for collision and limits.
  Keeps the bird logic encapsulated from the rest of the game.

3. [Bird.cpp](Bird.cpp)
  Loads bird texture, sets initial scale and position.
  Implements gravity and flap impulse to control vertical motion.
  Rotates the sprite based on velocity for visual feedback.
  Clamps movement at the top and resets state on restart.

4. [Pipe.h](Pipe.h)
  Declares the `Pipe` class with shared texture and sprites.
  Stores speed, pass state, and exposes update/draw helpers.
  Provides collision check and off-screen detection for cleanup.
  Keeps pipe logic modular for easy spawning and management.

5. [Pipe.cpp](Pipe.cpp)
  Loads the pipe texture once and reuses it across all pipes.
  Builds top and bottom pipes by scaling to the gap position.
  Moves pipes left each frame and reports when off screen.
  Detects collisions against the bird's bounding rectangle.


````
