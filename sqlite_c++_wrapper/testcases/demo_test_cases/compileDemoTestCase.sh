#!/bin/bash

# Check if a filename is provided
if [ -z "$1" ]; then
    echo "Usage: ./compileDemoTestCase.sh [filename.cpp]"
    exit 1
fi

# Add .cpp extension if not present
SOURCE="$1"
if [[ "$SOURCE" != *.cpp ]]; then
    SOURCE="${SOURCE}.cpp"
fi

# Extract base name without extension
BASENAME=$(basename "$SOURCE" .cpp)
OUTPUT="${BASENAME}.out"

# Include and library paths
HEADERS="-I ../../include -I ../../sqlite3_lib/include"
LIBRARY_DIRS="-L ../../lib -L ../../sqlite3_lib/lib"
LIBRARIES="-lsqliteWrapper -lsqlite3"
STD="-std=c++11"

echo "Compiling $SOURCE..."

# Compile the C++ source file
g++ "$SOURCE" -o "$OUTPUT" $HEADERS $LIBRARY_DIRS $LIBRARIES $STD

# Check if compilation succeeded
if [ $? -ne 0 ]; then
    echo "❌ Failed to compile $SOURCE"
    exit 1
fi

echo "✅ Successfully compiled $SOURCE to $OUTPUT"

# Optional: Run the executable
# echo "Running $OUTPUT..."
# ./"$OUTPUT"
