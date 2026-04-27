package com.devtalles.proyecto.ejemplos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutdownComparison {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i<5;i++){
            final int taskId = i;
            executor.submit(()-> {
                System.out.println("Tarea Iniciando con Executor " + taskId
                        + " " + Thread.currentThread().getName());
                try {
                    //Simulación de tiempo de espera API
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println("Tarea " + taskId + " fue interrumpida");
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException error){}
                    return;
                }
                System.out.println("Tarea finalizada");
            });
        }

        Thread.sleep(5000);

        boolean error = true;

        if(error){
            System.out.println("Situación crítica");
            executor.shutdownNow();
        }else {
            System.out.println("Finalización ordenada");
            executor.shutdown();
        }

        if(executor.awaitTermination(1, TimeUnit.SECONDS)){
            System.out.println("Tareas finalizadas correctamente");
        }else{
            System.out.println("Las tareas NO finalizaron correctamente");
        }














    }
}
