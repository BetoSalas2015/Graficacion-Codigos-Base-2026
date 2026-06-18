# Graficando múltiples Puntos (versión 0.0.5)

## Compilar y ejecutar  
Desde la carpeta de trabajo:  
- Compilar: `javac Ventana.java`  
- Ejecutar: `java Ventana`  

---  
En esta versión se evoluciona la aplicación para dejar de graficar solo una línea entre dos puntos y pasar a **capturar y dibujar múltiples puntos** como una figura compuesta por segmentos consecutivos.

## ¿Qué se actualiza?
- Se **simplifica la interfaz** para capturar un solo punto `(x, y)` y se incorpora un nuevo botón **“Agregar Punto”** para construir incrementalmente la lista de puntos a graficar.
- En `Ventana.java` se crea y administra un `Vector<Punto>` (por ejemplo `vectorPuntos`) que almacena todos los puntos capturados; el botón **Agregar** inserta nuevos elementos en el vector y el botón **Graficar** envía el vector al componente de dibujo.
- En `Dibujo.java` se reemplaza la lógica de dos puntos por una colección: `asignaPuntos(...)` ahora recibe un `Vector<Punto>` y `paintComponent(...)` recorre el vector para **dibujar segmentos entre puntos consecutivos** y **cerrar la figura** uniendo el último punto con el primero (con validación para evitar errores cuando aún no hay suficientes puntos).

## Mejoras logradas
- **Modelo de datos escalable**: se pasa de coordenadas sueltas a una estructura dinámica (`Vector`) que permite graficar cualquier cantidad de puntos sin rediseñar el flujo.
- **Dibujo más robusto y controlado**: se agregan validaciones (nulos y tamaño mínimo) para evitar excepciones al repintar y se estandariza el renderizado como una secuencia de segmentos con cierre de figura.
