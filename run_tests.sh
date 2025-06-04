#!/bin/bash

# This script runs JUnit tests without using Maven

# Create directories if they don't exist
mkdir -p out/production
mkdir -p out/test

echo "Compiling main source files..."
javac -d out/production src/*.java

if [ $? -ne 0 ]; then
    echo "Error compiling main source files!"
    exit 1
fi

echo "Compiling test files..."
javac -d out/test -cp out/production:lib/* test/*.java

if [ $? -ne 0 ]; then
    echo "Error compiling test files!"
    exit 1
fi

echo "Running tests..."
java -cp out/production:out/test:lib/* org.junit.jupiter.engine.JupiterTestEngine

echo "Tests completed."
