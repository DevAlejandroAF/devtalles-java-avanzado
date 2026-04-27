package com.devtalles.proyecto.finalProject.service;

import com.devtalles.proyecto.finalProject.model.LogEntry;
import com.devtalles.proyecto.finalProject.model.LogSummary;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable; // Importamos Callable
import java.util.stream.Collectors; // Para usar Streams y Collectors
import java.util.Map;


public class LogProcessorTask implements Callable<LogSummary> {

    private final List<LogEntry> logEntries;

    public LogProcessorTask(List<LogEntry> logEntries) {
        this.logEntries = logEntries;
    }

    @Override
    public LogSummary call(){

        System.out.println("Tarea: Procesando " + logEntries.size() + " " +
                "entradas de log en hilo " + Thread.currentThread().getName());

        int total = logEntries.size();

        List<LogEntry> errorLogs = logEntries.stream()
                .filter(e -> e.getStatusCode() >= 400)
                .toList();

        int errorCount = errorLogs.size(); // Conteo de errores

        Set<String> users = logEntries.stream()
                .map(LogEntry::getUser)
                .collect(Collectors.toSet());

        double average = logEntries.stream()
                .mapToInt(LogEntry::getResponseTimeMs)
                .average()
                .orElse(0.0);

        double averageWithMap = logEntries.stream()
                .map(LogEntry::getResponseTimeMs) // Devuelve un Stream<Integer>
                .collect(Collectors.averagingInt(Integer::intValue)); // Devuelve un double (el promedio)


        Map<Integer, Long> errorCountsByCode = errorLogs.stream()
                .collect(Collectors.groupingBy(
                        LogEntry::getStatusCode,
                        Collectors.counting()
                ));



        System.out.println("Tarea: Procesamiento completado en hilo " + Thread.currentThread().getName()); // Salida en español argentino

        return new LogSummary(total, errorCount, users, average, errorCountsByCode);
    }
}




