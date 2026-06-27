# Descentralizando las tareas de dibujo (versión 0.0.11)

## Compilar y ejecutar
Desde la carpeta de trabajo:
- Compilar: `javac Ventana.java`
- Ejecutar: `java Ventana`

---
En esta versión se separa la lógica de generación de puntos gráficos de la ventana principal para mejorar la organización del proyecto y delegar los algoritmos de dibujo a una clase especializada.

## ¿Qué se actualiza?
- Se crea la nueva clase `DemoGraficos`, encargada de generar colecciones de puntos mediante métodos gráficos independientes.
- Se añade el atributo configurable `incremento`, con sus métodos `setIncremento()` y `getIncremento()`, para controlar la separación entre puntos generados.
- Se implementa el método `lineaUno(int x1, int x2)`, que genera un `Vector<Point>` con los puntos necesarios para graficar una línea.
- Se agrega una nueva opción de menú en `Ventana.java` para ejecutar el algoritmo `Linea Uno`.
- Se modifica `Ventana.java` para que solicite los puntos a `DemoGraficos`, los asigne al objeto `Dibujo` y redibuje la interfaz.
- Se plantea la posibilidad de agregar nuevos métodos gráficos, como `lineaDos()`, reutilizando la misma estructura de generación y visualización.

## Mejoras logradas
- **Separación de responsabilidades**: `Ventana` se concentra en la interfaz de usuario y la gestión de eventos, mientras que `DemoGraficos` encapsula la lógica de generación de puntos.
- **Mejor mantenibilidad**: los algoritmos gráficos pueden modificarse o ampliarse sin alterar directamente la estructura principal de la ventana.
- **Mayor reutilización**: los métodos de `DemoGraficos` pueden ser invocados desde distintas partes del programa sin depender de componentes Swing.
- **Arquitectura más limpia**: el proyecto queda mejor organizado al separar la lógica de UI, dibujo y generación de datos gráficos.
- **Facilidad para agregar nuevos algoritmos**: futuras gráficas o métodos de generación de puntos pueden añadirse como nuevos métodos dentro de `DemoGraficos`.