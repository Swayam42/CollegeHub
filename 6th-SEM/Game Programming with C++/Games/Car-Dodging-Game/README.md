# Car Dodging Game (SFML)

A simple lane-based 2D car dodging game.

## Features
- OOP with inheritance: `Car`, `PlayerCar`, `EnemyCar`
- 3-lane movement (`Left/Right` or `A/D`)
- Random enemy spawning and downward movement
- Collision detection using bounding boxes
- Score + speed level display
- Difficulty selection: `1` Easy, `2` Medium, `3` Hard
- Pause/Resume (`P`), Restart after game over (`R`), Quit (`ESC`)
- Optional audio loading (`assets/music.ogg`, `assets/crash.wav`)

## Build and Run (Ubuntu)
From this folder:

```bash
g++ main.cpp Game.cpp Car.cpp PlayerCar.cpp EnemyCar.cpp \
    -o CarDodgingGame \
    -lsfml-graphics -lsfml-window -lsfml-system -lsfml-audio \
    && ./CarDodgingGame
```

## Assets
- Font: game tries `assets/font/KOMIKAP_.ttf` first, then `assets/arial.ttf`.
- Audio (optional):
  - `assets/music.ogg` (background music)
  - `assets/crash.wav` (collision sound)

If optional assets are missing, the game continues silently.
