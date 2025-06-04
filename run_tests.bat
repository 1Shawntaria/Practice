@echo off

REM Create output directories
if not exist out\production mkdir out\production
if not exist out\test mkdir out\test

echo Compiling main source files...
javac -d out\production src\*.java

if %ERRORLEVEL% NEQ 0 (
    echo Error compiling main source files!
    exit /b 1
)

echo Compiling test files...
javac -d out\test -cp out\production;lib\* test\*.java

if %ERRORLEVEL% NEQ 0 (
    echo Error compiling test files!
    exit /b 1
)

echo Running tests...
java -cp out\production;out\test;lib\* org.junit.jupiter.engine.JupiterTestEngine

echo Tests completed.
