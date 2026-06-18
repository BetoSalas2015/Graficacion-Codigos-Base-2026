# Trabajando con Puntos (versión 0.0.4)

## Compilar y ejecutar
Desde la carpeta de trabajo:
- Compilar: `javac Ventana.java Dibujo.java Punto.java`
- Ejecutar: `java Ventana`

---
En esta versión se reemplaza el manejo de coordenadas independientes por objetos `Punto` para mejorar la organización de los datos gráficos.

## ¿Qué se actualiza?
- Se agrega la clase `Punto.java` para encapsular las coordenadas `x` e `y` en un objeto dedicado.
- Se modifica `Dibujo.java` para recibir objetos `Punto` en lugar de valores enteros independientes.
- Se actualiza `Ventana.java` para construir los puntos desde los valores capturados en la interfaz antes de enviarlos al componente de dibujo.
- Se incorpora una validación en `Dibujo.java` para evitar intentos de dibujo cuando todavía no existen puntos asignados.

## Mejoras logradas
- **Modelo de datos más limpio**: las coordenadas quedan agrupadas en una clase dedicada y reutilizable.
- **Código más mantenible**: el paso de información entre la interfaz y el componente gráfico es más claro y expresivo.
