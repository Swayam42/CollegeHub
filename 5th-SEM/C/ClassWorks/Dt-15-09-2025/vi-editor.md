# Even/Odd Number Checker

This guide provides step-by-step instructions to create a C program that checks whether a number is even or odd, using the Linux terminal and the vi editor.

## Prerequisites

- Linux environment with gcc installed
- Basic familiarity with terminal commands and vi editor

## Steps

### 1. Create a Directory

Open a terminal and create a directory for the program:

```bash
mkdir EvenOddProgram
cd EvenOddProgram
```

### 2. Create a C File

Create a file named `evenOdd.c`:

```bash
touch evenOdd.c
```

### 3. Write the C Program

Open the file in vi editor:

```bash
vi evenOdd.c
```

Press `i` to enter insert mode, then add the following code:

```c
#include <stdio.h>

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);

    if (num % 2 == 0) {
        printf("%d is even.\n", num);
    } else {
        printf("%d is odd.\n", num);
    }

    return 0;
}
```

**Save and exit vi:**

- Press `Esc` to exit insert mode
- Type `:wq` and press `Enter`

### 4. Compile the Program

Compile the C file using gcc:

```bash
gcc evenOdd.c
```

This generates an executable file named `a.out`.

### 5. Run the Program

Execute the program:

```bash
./a.out
```

Enter a number when prompted, and the program will display whether it is even or odd.

## Example Output

```
Enter a number: 42
42 is even.
```

```
Enter a number: 17
17 is odd.
```

## Troubleshooting

- **If gcc is not found**, install it using:

  ```bash
  sudo apt-get install gcc
  ```

  (For Ubuntu/Debian-based systems)

- Ensure you have write permissions in the directory
- Check for syntax errors in the code if compilation fails

## VI Editor Quick Reference

| Command | Description         |
| ------- | ------------------- |
| `i`     | Enter insert mode   |
| `Esc`   | Exit insert mode    |
| `:w`    | Save file           |
| `:q`    | Quit vi             |
| `:wq`   | Save and quit       |
| `:q!`   | Quit without saving |
