# Creando la interfaz de Usuario (versión 0.0.3)

## Compilar y ejecutar
Desde la carpeta de trabajo:
- Compilar: `javac Ventana.java Dibujo.java`
- Ejecutar: `java Ventana`

---
En esta versión se incorpora una interfaz de usuario básica para capturar coordenadas y graficar una línea desde la ventana principal.

## ¿Qué se actualiza?
- Se agregan componentes Swing para capturar los puntos de inicio y fin mediante `JPanel`, `JLabel`, `JTextField` y `JButton`.
- Se organiza la interfaz con `BorderLayout` y `GridLayout`, separando el panel de datos, el área de dibujo y el botón de acción.
- Se implementa el manejo del evento del botón `¡Graficar!` para enviar las coordenadas capturadas al componente `Dibujo`.
- Se añade el método `asignaPuntos()` en `Dibujo.java` para recibir y almacenar las coordenadas que serán graficadas.

## Mejoras logradas
- **Interacción con el usuario**: la aplicación permite capturar coordenadas desde la interfaz gráfica.
- **Flujo de datos más claro**: `Ventana.java` captura la entrada del usuario y `Dibujo.java` conserva la responsabilidad del trazo.
