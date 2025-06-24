@echo off
REM Check if a file name is provided
IF "%1"=="" (
    echo Usage: compileDemoTestCase.bat [filename.cpp]
    exit /b
)

REM Extract base name without extension
set "SOURCE=%1"
set "RES=%~n1.exe"
set "HEADER=-I ..\..\include -I ..\..\sqlite3_lib\include"
set "LIBRARY_DIRS=-L ..\..\lib -L ..\..\sqlite3_lib\lib"
set "LIBRARIES=-lsqliteWrapper -lsqlite3"
set "STD=-std=c++11"
REM Compile the C++ file
g++ %SOURCE% -o %RES% %HEADER% %LIBRARY_DIRS% %LIBRARIES% %STD%

REM Check if compilation was successful
IF %ERRORLEVEL% NEQ 0 (
    echo Failed to compile %1.cpp
    exit /b %ERRORLEVEL%
)

echo Successfully compiled %SOURCE% to %RES%
