# Usando Java2D (versión 0.0.6)

## Compilar y ejecutar  
Desde la carpeta de trabajo:  
- Compilar: `javac Ventana.java`  
- Ejecutar: `java Ventana`  

---  
En esta versión se migra el dibujo de líneas al modelo de **Java2D**, incorporando un plano coordenado y el uso de objetos gráficos más especializados para mejorar la claridad y precisión del renderizado.

## ¿Qué se actualiza?
- En `Dibujo.java` se incorpora el uso de `Graphics2D` mediante conversión desde `Graphics`, permitiendo trabajar con trazos, colores y figuras geométricas de Java2D.
- Se crea el método `planoCoordenado(...)`, encargado de dibujar una cuadrícula y los ejes coordenados, desplazando el origen al centro del área de dibujo mediante `translate(...)`.
- Se reemplazan las llamadas tradicionales a `drawLine(...)` por el uso de `Line2D.Float` y `draw(...)`, además de sustituir la clase `Punto` personalizada por `Point` de Java para representar coordenadas.

## Mejoras logradas
- **Renderizado más preciso**: el uso de `Graphics2D`, `BasicStroke` y `Line2D.Float` permite controlar mejor el grosor, color y comportamiento visual de los trazos.
- **Código más limpio y estándar**: se aprovechan clases nativas de Java como `Point` y `Line2D`, reduciendo código propio innecesario y alineando el proyecto con las prácticas recomendadas de Java2D.
