package com.devtalles.proyecto.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadVsExecutor {
    public static void main(String[] args) {
        System.out.println("Con Thread-----------");
        for (int i = 1; i < 4000; i++){
            new Thread(
                    () -> System.out.println("Tarea A Thread " + Thread.currentThread().getName())
            ).start();
        }

        System.out.println("Con Executor-----------");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 1; i < 8; i++){
            executor.execute(
                    () -> System.out.println("Tarea A Executor " + Thread.currentThread().getName())
            );
        }

        executor.shutdown();
    }
}
