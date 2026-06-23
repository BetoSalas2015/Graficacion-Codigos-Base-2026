# Diálogos y diálogos personalizados (versión 0.0.9)

## Compilar y ejecutar
Desde la carpeta de trabajo:
- Compilar: `javac Ventana.java Dibujo.java DialogoCoordenada.java`
- Ejecutar: `java Ventana`

---
En esta versión se incorpora la interacción con el usuario mediante diálogos Swing, eliminando dependencias de entrada hardcodeada y habilitando captura/selección de datos desde la interfaz.

## ¿Qué se actualiza?
- Se agrega soporte de diálogos estándar con `JOptionPane` para reportar errores y eventos al usuario (por ejemplo, al fallar la carga de archivo).
- Se mejora la carga de puntos desde archivo incorporando `JFileChooser` como selector de archivos, con filtro por extensión `.txt` mediante `FileNameExtensionFilter` y directorio inicial basado en `System.getProperty("user.dir")`.
- Se introduce un diálogo personalizado `DialogoCoordenada` (basado en `JDialog`) para capturar coordenadas `x`/`y` como enteros, con validación y retorno de resultado como `Point`, y se integra a la aplicación vía menú `Graficar → Agregar Punto...`.

## Mejoras logradas
- **Mejor UX en operaciones de E/S**: el usuario selecciona archivos desde una interfaz guiada y recibe retroalimentación inmediata con mensajes modales en caso de error.
- **Extensibilidad de captura de datos**: el diálogo `DialogoCoordenada` centraliza UI, validación y resultado, facilitando agregar nuevos campos y reglas sin reescribir la lógica de integración.
