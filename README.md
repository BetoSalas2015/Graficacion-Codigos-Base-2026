# Graficación de puntos con Java2D (versión 0.0.10)

## Compilar y ejecutar
Desde la carpeta de trabajo:
- Compilar: `javac Ventana.java Dibujo.java DialogoCoordenada.java`
- Ejecutar: `java Ventana`

---
En esta versión se actualiza el proceso de graficación para dibujar puntos individuales sobre el plano coordenado usando Java2D y corrigiendo la orientación del eje Y propia de la pantalla.

## ¿Qué se actualiza?
- Se modifica el método de dibujo en `Dibujo` para recorrer la colección de puntos mediante un `for` de colección, ya que ahora cada punto se procesa de forma individual y no como pares consecutivos para trazar líneas.
- Se reemplaza el trazado de líneas entre puntos por el dibujo de pequeños rectángulos con `Rectangle2D.Float`, usando una variable `lado` para controlar el tamaño visual de cada punto.
- Se ajusta la coordenada vertical usando `-y` para compensar que, en la pantalla de una computadora, el eje Y crece hacia abajo, mientras que en el plano cartesiano tradicional crece hacia arriba.

## Mejoras logradas
- **Representación correcta del plano cartesiano**: los puntos respetan la orientación matemática esperada al invertir la coordenada vertical con `-y`.
- **Código de dibujo más claro**: el recorrido con `for-each` elimina el manejo innecesario de índices cuando no se requiere conectar un punto con el siguiente.
