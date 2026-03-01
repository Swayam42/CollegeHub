# Game Programming with C++

> A hands-on course where you build real games from scratch using C++ and SFML.

---

## About This Course

You will build three complete games over the semester:

| #   | Game               | What You Build                                                   |
| --- | ------------------ | ---------------------------------------------------------------- |
| 1   | **TimberMan**      | Sprite layering, HUD, timers, random branch system, bee movement |
| 2   | **Pong**           | OOP classes, ball physics, collision detection, scoring          |
| 3   | **Zombie Shooter** | Views, sprite sheets, bullets, pickups, sound, file I/O          |

Each game is built incrementally — every concept from one game carries forward into the next.

The source files in this repo are split into **step-by-step learning files** so you can follow along at your own pace instead of copy-pasting a finished product.

---

## Environment Setup

Choose your operating system below and follow every step in order.

> **What you are installing:**
>
> - **MinGW / GCC** — the compiler that turns your `.cpp` code into an executable
> - **SFML 2.6** — the library that handles windows, graphics, and audio
> - **VS Code** — the code editor (optional but recommended)

---

## Windows Setup

### Step 1 — Install MinGW (C++ Compiler)

1. Go to **https://github.com/niXman/mingw-builds-binaries/releases**
2. Download the latest file ending in `x86_64-win32-seh.7z` (e.g. `x86_64-14.x.x-release-win32-seh-ucrt.7z`)
3. Extract it using [7-Zip](https://www.7-zip.org/). You'll get a `mingw64` folder. Move it to `C:\` so it becomes `C:\mingw64\`.
4. Add `C:\mingw64\bin` to your Windows PATH:
   - Press `Win + S` → type **"environment variables"** → open it
   - Click **Environment Variables** → under **System variables** → select **Path** → **Edit**
   - Click **New** → type `C:\mingw64\bin` → click OK on all dialogs
5. Open a **new** Command Prompt and check:

```cmd
g++ --version
```

You should see a version number. If you do, the compiler is ready.

---

### Step 2 — Install SFML

1. Go to **https://www.sfml-dev.org/download.php**
2. Download **SFML 2.6.x** → pick **GCC MinGW (SEH) - 64-bit**
3. Extract and rename the folder to `SFML`. Place it at `C:\SFML\` so it looks like:

```
C:\SFML\
    include\
    lib\
    bin\
```

4. Copy the SFML DLL files into your game folder so the game can find them at runtime.
   First, find where your TimberMan folder is:

```cmd
dir /s /b /ad "TimberMan" 2>nul
```

Then copy the DLLs into that path:

```cmd
copy C:\SFML\bin\*.dll "<paste the path from above here>"
```

> Repeat this copy step for each new game folder you create.

---

### Step 3 — Install VS Code

1. Download from **https://code.visualstudio.com** and install with default options.
2. Open VS Code → `Ctrl+Shift+X` → install **C/C++** by Microsoft.

---

### Step 4 — Compile and Run

First find where your TimberMan folder is, then cd into it, compile, and run:

```cmd
dir /s /b /ad "TimberMan" 2>nul
```

Copy the path it prints, then:

```cmd
cd /d "<paste the path printed above>"
g++ Timber.cpp -o Timber.exe -IC:\SFML\include -LC:\SFML\lib -lsfml-graphics -lsfml-window -lsfml-system -lsfml-audio
Timber.exe
```

**Or use VS Code:** open the `.cpp` file → press `Ctrl+Shift+B` → select **"Compile and Run C Program"**.

---

## Linux Setup (Ubuntu / Debian / Mint)

### Step 1 — Install GCC and SFML

Open a terminal and run these two commands:

```bash
sudo apt update
sudo apt install -y build-essential libsfml-dev
```

That's it — both the compiler and SFML are installed in one go. Verify:

```bash
g++ --version
```

---

### Step 2 — Install VS Code

```bash
sudo snap install --classic code
```

Then open VS Code → `Ctrl+Shift+X` → install **C/C++** by Microsoft.

---

### Step 3 — Compile and Run

First find where your TimberMan folder is:

```bash
find ~ -type d -name "TimberMan" 2>/dev/null
```

Copy the path it prints, then cd into it, compile, and run:

```bash
cd "<paste the path printed above>"
g++ Timber.cpp -o Timber -lsfml-graphics -lsfml-window -lsfml-system -lsfml-audio && ./Timber
```

> No need to copy any DLL files or add `-I`/`-L` flags on Linux — SFML is installed system-wide.

---

## Quick Compile Reference

| OS          | Command                                                                                                                 |
| ----------- | ----------------------------------------------------------------------------------------------------------------------- |
| **Windows** | `g++ Timber.cpp -o Timber.exe -IC:\SFML\include -LC:\SFML\lib -lsfml-graphics -lsfml-window -lsfml-system -lsfml-audio` |
| **Linux**   | `g++ Timber.cpp -o Timber -lsfml-graphics -lsfml-window -lsfml-system -lsfml-audio`                                     |

---

