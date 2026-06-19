# Menús en Swing (versión 0.0.8)

## Compilar y ejecutar
Desde la carpeta de trabajo:
- Compilar: `javac Ventana.java Dibujo.java`
- Ejecutar: `java Ventana`

---
En esta versión se integra una **barra de menús con Swing** y se migra la acción de carga de puntos desde un botón a una opción del menú para mejorar la organización de la interfaz.

## ¿Qué se actualiza?
- Se añade la construcción de la barra de menús con **`JMenuBar`**, **`JMenu`** y **`JMenuItem`** en `Ventana`, incluyendo el menú **Archivo** y sus opciones.
- Se conecta la gestión de eventos de menú mediante `ActionListener`, reutilizando la lógica existente de **carga desde archivo** para la opción *Archivo → Cargar puntos*.
- Se implementa la opción *Archivo → Salir* para terminar la aplicación de forma explícita mediante `System.exit(0)`.

## Mejoras logradas
- **Interfaz más limpia y consistente**: el flujo de “Cargar puntos” se mueve a la barra de menús, reduciendo controles redundantes y alineando la UI con patrones típicos de aplicaciones de escritorio.
- **Mejor reutilización de código**: la lógica ya implementada para cargar coordenadas se reaprovecha desde el menú sin duplicar comportamiento, facilitando mantenimiento y extensiones futuras.
