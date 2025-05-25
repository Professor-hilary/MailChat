#!/bin/bash

echo -e "\033[1;36m[BUILD]\033[0m Starting build process..."

# Step 1: Compile
./gradlew compileJava || { zenity --error --text="Compilation failed!"; exit 1;}

echo "Building jar..."
./gradlew jar || { zenity --error --text="JAR Packaging failed!"; exit 1;}

echo -e "\033[1;36m[BUILD]\033[0m launching application..."
java -jar ./build/libs/typemaster.jar || { zenity --error --text="Run error occured!"; exit 1;}