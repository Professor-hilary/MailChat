@echo off
setlocal enabledelayedexpansion

:: Use colors if Powershell is available
echo [BUILD] Starting build process...

:: Step 1: Compile
echo > Compiling Java files...
call .\gradlew compileJava || goto :error

:: Step 2: build JAR
echo > Building jar...
call .\gradlew jar || goto :error

:: Step 3: Run the app
echo [RUN] Launching application...
call java -jar .\build\libs\typemaster-1.0.0.jar || goto :error

goto :eof

:error
echo [ERROR] Something went wrong.
powershell -Command "Add-Type -AssemblyName PresentationFramework; [System.Windows.MessageBox]::Show('Build or execute failed in executed Java Program.', 'Error', 'OK', 'Error')"
exit /b 1