package com.devtalles.proyecto.ejemplos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVsExecutor {
    public static void main(String[] args) {

        System.out.println("_____Con Thread ____");
        for (int i = 1; i<4;i++){
            new Thread(
                    () -> System.out.println("Tarea A con Thread " +
                    " " + Thread.currentThread().getName()) )
                    .start();
        }

        System.out.println("_____Con ExecutorService____");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 1; i<4;i++){
            executor.execute(()-> System.out.println("Tarea desde Executor "
                    + " " + Thread.currentThread().getName() ));
        }

        executor.shutdown();
    }
}
