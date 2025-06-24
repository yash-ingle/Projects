@echo off
setlocal

echo [1/4] Compiling SQLite C source...
gcc -c "..\sqlite3_lib\src\sqlite3.c" -I "..\sqlite3_lib\include" -o "..\sqlite3_lib\src\sqlite3.o"
if errorlevel 1 (
    echo SQLite C compilation failed!
    exit /b 1
)

echo [2/4] Creating static library [sqlite3.lib]...
ar rcs "..\sqlite3_lib\lib\sqlite3.lib" "..\sqlite3_lib\src\sqlite3.o"
if errorlevel 1 (
    echo Failed to create sqlite3.lib!
    exit /b 1
)

echo [3/4] Compiling C++ wrapper source...
g++ -c *.cpp -I "..\include" -I "..\sqlite3_lib\include" -std=c++11
if errorlevel 1 (
    echo C++ compilation failed!
    exit /b 1
)

echo [4/4] Creating static library [sqliteWrapper.lib]...
ar rcs "..\lib\sqliteWrapper.lib" *.o
if errorlevel 1 (
    echo Failed to create sqliteWrapper.lib!
    exit /b 1
)

echo Build completed successfully!
endlocal
