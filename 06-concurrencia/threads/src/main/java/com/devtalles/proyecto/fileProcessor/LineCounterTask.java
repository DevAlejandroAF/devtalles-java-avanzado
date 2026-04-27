package com.devtalles.proyecto.fileProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.Random;

class LineCounterTask implements Callable<Integer> {

    private final String fileName;

    public LineCounterTask(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Tarea: Procesando archivo '" + fileName + "' en hilo " + Thread.currentThread().getName());

        Random random = new Random();
        int delay = random.nextInt(2000) + 500; // Simula un tiempo de procesamiento entre 0.5 y 2.5 segundos
        Thread.sleep(delay);

        if (fileName.contains("error")) {
            System.err.println("Tarea: Simulando error al procesar '" + fileName + "'");
            throw new RuntimeException("Error simulado al leer el archivo: " + fileName);
        }

        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Archivo " + fileName + " procesado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al procesar " + fileName);
        }

        System.out.println("Tarea: Terminado '" + fileName + "'. Líneas: " + lineCount);
        return lineCount;
    }
}
