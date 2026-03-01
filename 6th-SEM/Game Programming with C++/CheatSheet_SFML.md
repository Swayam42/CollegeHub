# SFML Cheat Sheet for Game Programming

> Everything SFML you need for TimberMan and beyond.

---

## Include & Namespace

```cpp
#include <SFML/Graphics.hpp>    // for window, sprites, text, shapes
#include <SFML/Audio.hpp>       // for sound (later chapters)

using namespace sf;             // so you don't need to write sf:: everywhere
```

---

## 1. Window — Your Game Screen

```cpp
// Create a full-screen sized window
VideoMode vm(1920, 1080);                        // width=1920, height=1080
RenderWindow window(vm, "My Game Title");

// A View = camera. Maps your game world to the window.
View view(FloatRect(0, 0, 1920, 1080));
window.setView(view);
```

### Window Methods You'll Use

```cpp
window.isOpen()         // true until user closes the window
window.close()          // closes the window
window.clear()          // clear screen to black (call before drawing)
window.draw(something)  // draw a Sprite, Text, Shape, etc.
window.display()        // show everything you just drew (MUST call every frame)
```

---

## 2. Events — Keyboard / Mouse / Window Actions

```cpp
Event event;
while (window.pollEvent(event))
{
    // Window X button was clicked
    if (event.type == Event::Closed)
        window.close();

    // A key was pressed
    if (event.type == Event::KeyPressed)
    {
        if (event.key.code == Keyboard::Enter)
        {
            // Enter was pressed!
        }
        if (event.key.code == Keyboard::Space)
        {
            // Space was pressed!
        }
        if (event.key.code == Keyboard::Escape)
        {
            window.close();
        }
    }
}
```

> `pollEvent` checks what happened since last frame and gives you each event one at a time.

---

## 3. Texture + Sprite — Drawing Images

```cpp
// Step 1: Load image into memory
Texture myTexture;
myTexture.loadFromFile("graphics/tree.png");   // path relative to your .exe

// Step 2: Create a drawable Sprite
Sprite mySprite(myTexture);

// Step 3: Position it on screen
mySprite.setPosition(810, 0);     // (x, y) from top-left of window

// Step 4: Draw it
window.draw(mySprite);
```

### Sprite Methods

```cpp
mySprite.setPosition(x, y);       // place at (x,y)
mySprite.setPosition(Vector2f(x, y)); // same, using Vector2f
mySprite.move(dx, dy);            // move relative to current position
mySprite.setRotation(degrees);    // rotate (0=normal, 180=upside-down)
mySprite.setOrigin(x, y);         // pivot point for rotation/position
mySprite.getPosition().x          // get current X
mySprite.getPosition().y          // get current Y
mySprite.setTexture(aTexture);    // change which texture it uses
```

### What is setOrigin?

```cpp
// By default, rotation happens around the TOP-LEFT corner
// setOrigin moves the pivot point to wherever you say

mySprite.setOrigin(220, 20);   // pivot is now at (220,20) inside the sprite
// When you setPosition(610, 100) with this origin,
// the point (220,20) of the sprite will be at (610,100) on screen
```

---

## 4. Font + Text — Drawing Words on Screen

```cpp
// Load a font from file
Font font;
font.loadFromFile("font/KOMIKAP_.ttf");

// Create text
Text myText;
myText.setFont(font);
myText.setCharacterSize(100);              // size in pixels
myText.setFillColor(Color::Red);          // color
myText.setString("Score = 0");            // what it says
myText.setPosition(20, 20);              // where on screen

// Center text exactly on screen
FloatRect textRect = myText.getLocalBounds();  // get the text's bounding box
myText.setOrigin(
    textRect.left + textRect.width / 2.0f,     // horizontal center
    textRect.top  + textRect.height / 2.0f     // vertical center
);
myText.setPosition(960, 540);   // now THIS point is at (960,540)

// Draw it
window.draw(myText);

// Update text contents
myText.setString("Score = 42");
```

### Built-in Colors

```cpp
Color::Red, Color::Green, Color::Blue
Color::White, Color::Black, Color::Yellow
Color(r, g, b)       // custom color, values 0-255
Color(r, g, b, a)    // with alpha (transparency), 0=invisible 255=solid
```

---

## 5. Shapes — Drawing Rectangles, Circles

```cpp
// Rectangle (used for the Timer bar)
RectangleShape myRect;
myRect.setSize(Vector2f(400, 80));      // width=400, height=80
myRect.setFillColor(Color::Red);
myRect.setPosition(760, 980);

window.draw(myRect);

// Resize it (e.g., shrinking timer bar):
myRect.setSize(Vector2f(newWidth, 80));
```

---

## 6. Clock + Time — Measuring Elapsed Time

```cpp
Clock clock;              // starts counting immediately when created

// Get elapsed time AND restart the clock:
Time dt = clock.restart();

// Convert to seconds (most useful):
float seconds = dt.asSeconds();   // usually ~0.016 for 60fps

// Convert to milliseconds:
float ms = dt.asMilliseconds();
```

### Why multiply by dt?

```cpp
// Speed = 200 pixels per second
// If 0.016 seconds passed → move 200 × 0.016 = 3.2 pixels this frame
// If 0.032 seconds passed → move 200 × 0.032 = 6.4 pixels this frame
// Result: same distance covered per real-time second, any frame rate!

spriteBee.move(-beeSpeed * dt.asSeconds(), 0);
```

---

## 7. FloatRect — Rectangles with float coordinates

```cpp
FloatRect rect = mySprite.getGlobalBounds();  // bounding box in world space
rect.left     // X of left edge
rect.top      // Y of top edge
rect.width    // width
rect.height   // height

// Check if two sprites overlap (collision detection):
if (sprite1.getGlobalBounds().intersects(sprite2.getGlobalBounds()))
{
    // they collide!
}
```

---

## 8. Vector2f — 2D Coordinates

```cpp
Vector2f position(100.0f, 200.0f);   // x=100, y=200
position.x   // 100
position.y   // 200

// Most positions in SFML accept Vector2f
mySprite.setPosition(Vector2f(100, 200));
// or just two floats:
mySprite.setPosition(100, 200);
```

---

## 9. Drawing Order — Layers

```cpp
window.clear();              // blank black screen

window.draw(background);    // LAYER 1 — background (furthest back)
window.draw(tree);          // LAYER 2
window.draw(branches[i]);   // LAYER 3
window.draw(bee);           // LAYER 4
window.draw(player);        // LAYER 5
window.draw(axe);           // LAYER 6
window.draw(scoreText);     // LAYER 7
window.draw(timeBar);       // LAYER 8
window.draw(messageText);   // LAYER 9 — on top of everything

window.display();            // show the completed frame
```

> Rule: **Draw backgrounds first, UI/text last.**

---

## 10. Stringstream — Mixing Text and Numbers

```cpp
#include <sstream>
using namespace std;

int score = 0;
stringstream ss;
ss << "Score = " << score;          // builds: "Score = 0"
scoreText.setString(ss.str());      // apply to text object

// When score changes, clear and rebuild:
ss.str("");
ss << "Score = " << score;
scoreText.setString(ss.str());
```

---

## Quick Reference: SFML Compile Command

```bash
g++ Timber.cpp -o Timber.exe -I"C:/SFML/include" -L"C:/SFML/lib" -lsfml-graphics -lsfml-window -lsfml-system
```

### Flags Explained:

| Flag                  | Meaning                                |
| --------------------- | -------------------------------------- |
| `-I"C:/SFML/include"` | Where to find SFML header files (.hpp) |
| `-L"C:/SFML/lib"`     | Where to find SFML library files (.a)  |
| `-lsfml-graphics`     | Link the graphics library              |
| `-lsfml-window`       | Link the window library                |
| `-lsfml-system`       | Link the system library                |

---

## Professor Cross-Questions — SFML Specific

| Question                               | Answer                                                                                                             |
| -------------------------------------- | ------------------------------------------------------------------------------------------------------------------ |
| Difference between Texture and Sprite? | Texture = image data in memory. Sprite = drawable object that uses a Texture. Many Sprites can share one Texture.  |
| Why `loadFromFile` returns bool?       | It can fail if the file path is wrong. You should check: `if (!texture.loadFromFile("path"))`                      |
| What does `window.clear()` do?         | Fills the window with black (or a specified color) to erase the previous frame                                     |
| What does `window.display()` do?       | Swaps the hidden back-buffer to the screen (double buffering)                                                      |
| What is double buffering?              | Drawing happens on a hidden canvas (back buffer). When ready, it flips to the visible screen — prevents flickering |
| What is `getLocalBounds()`?            | The bounding box relative to the Sprite's own origin. Used for centering text.                                     |
| What is `getGlobalBounds()`?           | The bounding box in world/screen coordinates. Used for collision detection.                                        |
