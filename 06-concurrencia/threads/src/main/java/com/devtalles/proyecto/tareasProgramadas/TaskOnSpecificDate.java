package com.devtalles.proyecto.tareasProgramadas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskOnSpecificDate {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2025, 5, 14, 10, 21);

        LocalDateTime now = LocalDateTime.now();

        long delay = Duration.between(now, dateTime).toMillis();

        if(delay<0){
            System.out.println("La fecha ya paso...");
            return;
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.schedule( () -> {
            System.out.println("Tarea después de 4 segundos");
            executorService.shutdown();
        }, delay, TimeUnit.MILLISECONDS);
    }
}
