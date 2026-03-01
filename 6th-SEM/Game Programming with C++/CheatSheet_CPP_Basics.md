# C++ Basics Cheat Sheet for Game Programming

> Quick-reference card. Print this out or keep it open on a second monitor.

---

## 1. Variables — Types You'll Use in Games

```cpp
int    lives    = 3;          // whole numbers — scores, counts, indices
float  speed    = 200.5f;     // decimals — positions, speed (add 'f' suffix!)
bool   isActive = false;      // true or false — flags, states
string name     = "Player1";  // text (needs #include <string>)
```

> **Common Mistake:** Forgetting the `f` after float numbers
>
> - WRONG: `float speed = 200.0;` ← compiler warns, it's a double
> - RIGHT: `float speed = 200.0f;` ← proper float

---

## 2. Operators

### Math Operators

```cpp
int a = 10, b = 3;
a + b   // 13  (add)
a - b   // 7   (subtract)
a * b   // 30  (multiply)
a / b   // 3   (integer divide — drops the decimal!)
a % b   // 1   (modulo — remainder after division)
```

> `10 % 3 = 1` because 10 = 3×3 + **1**
> Used in games constantly: `rand() % 5` gives 0,1,2,3, or 4

### Comparison Operators (return true or false)

```cpp
a == b   // equal to?
a != b   // not equal to?
a > b    // greater than?
a < b    // less than?
a >= b   // greater than or equal?
a <= b   // less than or equal?
```

### Shorthand Assignment

```cpp
score += 10;   // same as: score = score + 10;
speed -= 5;    // same as: speed = speed - 5;
count++;       // same as: count = count + 1;
count--;       // same as: count = count - 1;
```

---

## 3. If / Else — Decision Making

```cpp
if (timeRemaining <= 0.0f)
{
    paused = true;
    messageText.setString("Out of Time!");
}
else if (timeRemaining < 1.0f)
{
    // warning — getting close!
}
else
{
    // plenty of time
}
```

---

## 4. Switch — Multiple Choices (Cleaner than many if/else)

```cpp
int r = rand() % 5;   // r can be 0,1,2,3,4

switch (r)
{
case 0:
    branchPositions[0] = Side::LEFT;
    break;             // IMPORTANT: break stops fall-through!
case 1:
    branchPositions[0] = Side::RIGHT;
    break;
default:               // everything else (2, 3, 4)
    branchPositions[0] = Side::NONE;
    break;
}
```

> **What is `default`?** It's the "else" of a switch. Catches all cases not listed above.
> **What happens without `break`?** The code "falls through" to the next case — usually a bug!

---

## 5. Loops

### For Loop — When you know the count

```cpp
// Draw all 6 branches
for (int i = 0; i < NUM_BRANCHES; i++)
{
    window.draw(branches[i]);
    // i goes: 0, 1, 2, 3, 4, 5
    // stops when i reaches 6 (NOT drawn at i=6)
}
```

### While Loop — When you don't know the count

```cpp
while (window.isOpen())
{
    // keeps running until window.close() is called
}
```

---

## 6. Arrays — Multiple Variables with One Name

```cpp
const int NUM_BRANCHES = 6;
Sprite branches[NUM_BRANCHES];     // 6 sprites: branches[0] to branches[5]
Side branchPositions[NUM_BRANCHES]; // 6 enum values

// Access with index (starts at 0!)
branches[0].setTexture(textureBranch);
branchPositions[0] = Side::LEFT;
```

> **Array index starts at 0, NOT 1.**
> An array of size 6 has indices 0, 1, 2, 3, 4, 5.
> Accessing `branchPositions[6]` would be a bug (out of bounds)!

---

## 7. Enum Class — Named Constants

```cpp
// Without enum, you'd write magic numbers like:
// if (side == 0) ...  ← What does 0 mean?!

// With enum, it's readable:
enum class Side { LEFT, RIGHT, NONE };

Side playerSide = Side::LEFT;

if (playerSide == Side::LEFT)
{
    // clear meaning!
}
```

> `enum class` is better than plain `enum` because it won't accidentally collide with other variable names.

---

## 8. Functions — Packaging Reusable Code

```cpp
// DECLARATION (telling C++ the function exists)
void updateBranches(int seed);

// DEFINITION (the actual code)
void updateBranches(int seed)
{
    // shift all branches down by one position
    for (int j = NUM_BRANCHES - 1; j > 0; j--)
        branchPositions[j] = branchPositions[j - 1];

    // pick a random new branch at the top
    int r = rand() % 5;
    switch (r)
    {
    case 0:
        branchPositions[0] = Side::LEFT;
        break;
    case 1:
        branchPositions[0] = Side::RIGHT;
        break;
    default:
        branchPositions[0] = Side::NONE;
        break;
    }
}

// CALLING the function
updateBranches(i);
```

---

## 9. Scope — Where Variables Live

```cpp
int main()
{
    int score = 0;      // lives inside main(), dies when main() ends

    if (true)
    {
        int temp = 5;   // lives only inside this { }
    }
    // temp doesn't exist here!
}
```

> Variables declared BEFORE `main()` (global variables) live forever during the program.
> `Sprite branches[NUM_BRANCHES]` is global so `updateBranches()` can access it.

---

## 10. Random Numbers

```cpp
srand(time(0));     // SEED — call ONCE at the start. Uses current time as seed.
                    // Without this, rand() gives the same sequence every run!

int r = rand();            // random number (very large)
int r = rand() % 5;        // random 0–4
int r = rand() % 200 + 200; // random 200–399
                            //  (rand()%200 gives 0–199, then +200 shifts it)
```

---

## 11. Namespaces — Avoiding Name Clashes

```cpp
using namespace sf;    // so you can write Sprite instead of sf::Sprite
using namespace std;   // so you can write string instead of std::string
```

Without these, every SFML type would need `sf::` prefix:

```cpp
sf::Sprite mySprite;      // without 'using namespace sf'
Sprite mySprite;           // with    'using namespace sf'
```

---

## 12. Stringstream — Building Text with Numbers

```cpp
#include <sstream>

int score = 42;
stringstream ss;

ss << "Score = " << score;   // builds: "Score = 42"
scoreText.setString(ss.str()); // .str() converts stringstream to string

// Reset and rebuild:
ss.str("");          // clear it
ss << "New: " << 99;
```

---

## Quick Reference: Common Mistakes

| Mistake                    | Why it's Wrong                     | Fix                          |
| -------------------------- | ---------------------------------- | ---------------------------- |
| `float x = 5.0;`           | That's a `double`, not `float`     | `float x = 5.0f;`            |
| `if (a = 5)`               | Single `=` assigns, not compares   | `if (a == 5)`                |
| `array[6]` on size-6 array | Out of bounds! Indices are 0–5     | `array[5]`                   |
| No `break` in switch       | Falls through to next case         | Add `break;` after each case |
| `srand()` inside a loop    | Reseeds the random — same number!  | Call `srand()` once at start |
| Forget `{ }` after if/for  | Only next line is inside the block | Always use `{ }`             |
