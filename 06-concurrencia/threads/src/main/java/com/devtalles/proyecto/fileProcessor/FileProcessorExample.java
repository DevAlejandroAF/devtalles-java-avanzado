package com.devtalles.proyecto.fileProcessor;

import java.util.concurrent.*; // Importamos las clases necesarias (ExecutorService, Callable, Future, etc.)
import java.util.ArrayList;
import java.util.List;

public class FileProcessorExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Aplicación Principal: Iniciando procesamiento de archivos...");

        List<String> fileNames = new ArrayList<>();
        fileNames.add("archivo1.txt");
        fileNames.add("archivo2.txt");
        fileNames.add("archivo_error.txt");

        List<Future<Integer>> futures = new ArrayList<>();

        for (String fileName : fileNames) {

            Callable<Integer> task = new LineCounterTask(fileName);

            Future<Integer> future = executor.submit(task);

            futures.add(future);

            System.out.println("Aplicación Principal: Tarea para '" + fileName + "' enviada.");
        }

        List<Integer> lineCounts = new ArrayList<>();
        int totalLines = 0;

        for (int i = 0; i < futures.size(); i++) {
            Future<Integer> future = futures.get(i);
            String fileName = fileNames.get(i); // Obtenemos el nombre del archivo correspondiente para imprimir

            try {

                Integer count = future.get(); // Espera y obtiene el conteo de líneas

                System.out.println("Aplicación Principal: Resultado de '" + fileName + "': " + count + " líneas.");
                lineCounts.add(count); // Guardamos el conteo individual si fue exitoso
                totalLines += count; // Sumamos al total si fue exitoso

            } catch (InterruptedException e) {

                System.err.println("Aplicación Principal: Espera interrumpida para '" + fileName + "': " + e.getMessage());
                Thread.currentThread().interrupt(); // Es una buena práctica re-interrumpir el hilo
            } catch (ExecutionException e) {

                System.err.println("Aplicación Principal: La tarea para '" + fileName + "' falló: " + e.getCause().getMessage());

            }

        }

        System.out.println("Aplicación Principal: Conteo total de líneas (excluyendo archivos con error): " + totalLines);

        executor.shutdown();
        System.out.println("\nAplicación Principal: ExecutorService iniciado proceso de cierre.");

        // Opcional pero recomendado: esperar un tiempo prudencial a que las tareas terminen después del shutdown().
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.err.println("Aplicación Principal: El ExecutorService no terminó en el tiempo dado.");
            }
        } catch (InterruptedException e) {
            System.err.println("Aplicación Principal: Espera de terminación del ejecutor interrumpida.");
            Thread.currentThread().interrupt();
        }
        System.out.println("Aplicación Principal: Finalizada.");
    }
}


