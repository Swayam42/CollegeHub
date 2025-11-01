#!/bin/bash

# Check if the user gave a filename
if [ -z "$1" ]; then
    echo "Usage: ./run.sh <filename.c>"
    exit 1
fi

# Get the base name (remove .c)
filename=$(basename "$1" .c)

# Compile the C program
gcc "$1" -o "$filename"

# Check if compilation succeeded
if [ $? -eq 0 ]; then
    echo "✅ Compilation successful! Running the program..."
    echo "---------------------------------------------"
    ./"$filename"
else
    echo "❌ Compilation failed!"
fi
