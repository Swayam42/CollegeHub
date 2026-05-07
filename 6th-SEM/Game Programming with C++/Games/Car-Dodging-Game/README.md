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

## Build and Run (Ubuntu)
From this folder:

```bash
g++ main.cpp Car.cpp PlayerCar.cpp EnemyCar.cpp -o main -lsfml-graphics -lsfml-window -lsfml-system && ./main
```

## Assets
- Font: game tries `assets/font/KOMIKAP_.ttf` first, then `assets/arial.ttf`.

If font assets are missing, gameplay still runs and text is skipped.
