package com.devtalles.proyecto.finalProject.service;

import com.devtalles.proyecto.finalProject.model.LogEntry;
import com.devtalles.proyecto.finalProject.util.LogParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LogServiceExplicado {
    // Este es el método que estamos analizando
    public List<LogEntry> readLogsFromFile(String filePath) {
        // Inicia un bloque try-catch para manejar posibles errores durante la lectura del archivo
        try {
            // 1. Files.lines(Path.of(filePath))
            //    - Path.of(filePath): Convierte la ruta del archivo (String) a un objeto Path, que es una representación más moderna de rutas en Java.
            //    - Files.lines(...): Lee el archivo especificado por el Path línea por línea. Devuelve un Stream<String>, donde cada elemento del stream es una línea del archivo.
            return Files.lines(Path.of(filePath)) // Devuelve un Stream<String>

                    // 2. .map(LogParser::parseLine)
                    //    - map(): Es una operación intermedia de Stream que transforma cada elemento del stream.
                    //    - LogParser::parseLine: Es una referencia a método. Significa que para cada String (cada línea) en el stream, se llama al método estático LogParser.parseLine() con esa línea como argumento.
                    //    - LogParser.parseLine() devuelve un Optional<LogEntry>. Así que después de este map(), el stream se convierte en un Stream<Optional<LogEntry>>.
                    .map(LogParser::parseLine) // Devuelve un Stream<Optional<LogEntry>>

                    // 3. .filter(Optional::isPresent)
                    //    - filter(): Es una operación intermedia de Stream que mantiene solo los elementos que cumplen una condición.
                    //    - Optional::isPresent: Es una referencia a método. Significa que solo se mantienen en el stream los elementos (que son Optional<LogEntry>) para los cuales el método isPresent() devuelve true.
                    //    - isPresent() en un Optional devuelve true si el Optional contiene un valor (si el parseo fue exitoso), y false si está vacío (si el parseo falló).
                    //    - Después de este filter(), el stream contiene solo los Optional<LogEntry> que tienen un LogEntry válido dentro.
                    .filter(Optional::isPresent) // Devuelve un Stream<Optional<LogEntry>> (solo los que tienen valor)

                    // 4. .map(Optional::get)
                    //    - map(): De nuevo, transforma cada elemento.
                    //    - Optional::get: Es una referencia a método. Para cada Optional<LogEntry> que queda en el stream (sabemos que tienen un valor gracias al filtro anterior), se llama al método get().
                    //    - get(): En un Optional que tiene un valor, get() devuelve ese valor (el LogEntry).
                    //    - Después de este map(), el stream se convierte en un Stream<LogEntry>.
                    .map(Optional::get) // Devuelve un Stream<LogEntry> (los objetos LogEntry reales)

                    // 5. .collect(Collectors.toList())
                    //    - collect(): Es una operación terminal de Stream que recopila los elementos del stream en una colección u otro resultado.
                    //    - Collectors.toList(): Es un Collector predefinido que recopila todos los elementos del stream en una nueva List<LogEntry>.
                    //    - El resultado de collect() es la List<LogEntry> final.
                    .collect(Collectors.toList()); // Devuelve una List<LogEntry>

            // Inicia el bloque catch para manejar la excepción IOException
        } catch (IOException e) {
            // Si ocurre un error de entrada/salida (ej: el archivo no existe, no tienes permisos para leerlo)
            // Imprime un mensaje de error en la consola de error.
            System.err.println("Error al leer el archivo: " + e.getMessage()); // Salida en español argentino
            // Devuelve una lista vacía. Esto es una forma de manejar el error sin detener el programa,
            // indicando que no se pudieron obtener entradas de log de ese archivo.
            return List.of(); // Devuelve una lista inmutable vacía
        }
    }
}