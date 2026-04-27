package com.devtalles.proyecto.ejemplos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelismExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ejecutando newSingleThreadExecutor");
        ExecutorService single = Executors.newFixedThreadPool(3);

        long start = System.currentTimeMillis();

        single.submit(()-> task("Tarea A"));
        single.submit(()-> task("Tarea B"));
        single.submit(()-> task("Tarea C"));

        single.shutdown();

        if(!single.awaitTermination(1, TimeUnit.MINUTES)){
            System.out.println("Tareas demoradas, forzando salida");
            single.shutdown();
        }

        long end = System.currentTimeMillis();

        System.out.println("Tiempo total: " + (end - start) + " ms");

    }

    public static void task(String name){
        System.out.println("Iniciando la tarea " + Thread.currentThread().getName());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Tarea completada en hilo " + Thread.currentThread().getName());
    }
}
