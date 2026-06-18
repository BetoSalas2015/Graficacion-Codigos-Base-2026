# Separando la responsabilidad del dibujo (versión 0.0.2)

## Compilar y ejecutar
Desde la carpeta de trabajo:
- Compilar: `javac Ventana.java Dibujo.java`
- Ejecutar: `java Ventana`

---
En esta versión se separa la lógica de dibujo de la ventana principal para mejorar la organización del proyecto y dejar una estructura más limpia para futuras ampliaciones gráficas.

## ¿Qué se actualiza?
- Se crea la clase `Dibujo.java` como componente independiente para concentrar la responsabilidad del área gráfica.
- Se elimina la lógica de dibujo directa de `Ventana.java`, dejando esta clase enfocada en la creación y configuración de la ventana principal.
- Se integra un objeto `Dibujo` dentro de `Ventana.java` y se agrega al centro de la interfaz mediante `BorderLayout`.

## Mejoras logradas
- **Separación de responsabilidades**: la ventana principal y el dibujo quedan organizados en clases distintas.
- **Código más mantenible**: la estructura facilita modificar el dibujo sin alterar la configuración general de la ventana.
- **Base gráfica más clara**: el proyecto queda preparado para incorporar nuevas funciones de dibujo en versiones posteriores.
