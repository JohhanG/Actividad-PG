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
echo Ejecutando Suite de Pruebas Unitarias...
java PruebasUnitarias
pause
