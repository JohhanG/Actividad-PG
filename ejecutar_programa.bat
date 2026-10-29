@echo off
chcp 65001 > nul
echo Compilando clases del proyecto...
javac -encoding UTF-8 *.java
if %errorlevel% neq 0 (
    echo Error en la compilacion.
    pause
    exit /b %errorlevel%
)
echo.
echo Iniciando programa principal (Main)...
java Main
pause
