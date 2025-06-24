#!/bin/bash
set -e  
echo "[1/4] Compiling SQLite C source..."
gcc -c ../sqlite3_lib/src/sqlite3.c -I ../sqlite3_lib/include -o ../sqlite3_lib/src/sqlite3.o

echo "[2/4] Creating static library [libsqlite3.a]..."
ar rcs ../sqlite3_lib/lib/libsqlite3.a ../sqlite3_lib/src/sqlite3.o

echo "[3/4] Compiling C++ wrapper source..."
g++ -c *.cpp -I ../include -I ../sqlite3_lib/include -std=c++11

echo "[4/4] Creating static library [libsqliteWrapper.a]..."
ar rcs ../lib/libsqliteWrapper.a *.o

echo "✅ Build completed successfully!"
