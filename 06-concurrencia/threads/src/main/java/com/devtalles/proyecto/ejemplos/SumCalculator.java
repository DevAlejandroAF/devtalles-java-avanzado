package com.devtalles.proyecto.ejemplos;

import java.util.concurrent.*;

public class SumCalculator implements Callable<Integer> {
    private int number1;
    private int number2;

    public SumCalculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Tarea: Iniciando suma...");

        Thread.sleep(1500);

        int sum = number1 + number2;

        System.out.println("Name: " + Thread.currentThread().getName());

        System.out.println("Tarea: Suma completada");

        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> sumTask = new SumCalculator(5, 60);

        Future<Integer> result = executor.submit(sumTask);

        while (!result.isDone()){
            System.out.println("Procesando...");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Resultado = " + result.get());

        executor.shutdown();
    }
}













