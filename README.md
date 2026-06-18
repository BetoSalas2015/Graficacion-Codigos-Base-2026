# Archivos (versión 0.0.7)

## Compilar y ejecutar  
Desde la carpeta de trabajo:  
- Compilar: `javac Ventana.java`  
- Ejecutar: `java Ventana`  

---  
En esta versión se incorpora la carga de puntos desde un archivo de texto, permitiendo graficar coordenadas externas sin capturarlas manualmente desde la interfaz.

## ¿Qué se actualiza?
- En `Ventana.java` se incorporan las clases de `java.io` y `java.util` para leer archivos de texto y procesar cada línea como un par de coordenadas.
- Se agrega el botón `btnCargar`, encargado de ejecutar la carga de puntos desde el archivo `coordenadas.txt`, reemplazando temporalmente el flujo manual de captura con `btnAgregar`.
- Se crea la clase interna `BotonCargar`, que utiliza `BufferedReader`, `FileReader` y `StringTokenizer` para leer cada línea del archivo, separar los valores `x` e `y`, convertirlos a enteros, almacenarlos como objetos `Point` en `vectorPuntos` y actualizar el dibujo.

## Mejoras logradas
- **Carga de datos más eficiente**: los puntos pueden definirse previamente en un archivo de texto, evitando la captura manual repetitiva desde la interfaz.
- **Flujo de dibujo más automatizado**: la aplicación reconstruye el vector de puntos, asigna los datos al componente `Dibujo` y repinta la figura en una sola acción, manteniendo el código más organizado y fácil de extender.
