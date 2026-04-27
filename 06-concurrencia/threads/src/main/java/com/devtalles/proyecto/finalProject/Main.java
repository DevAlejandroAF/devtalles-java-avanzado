package com.devtalles.proyecto.finalProject;

import com.devtalles.proyecto.finalProject.model.LogEntry;
import com.devtalles.proyecto.finalProject.model.LogSummary;
import com.devtalles.proyecto.finalProject.service.LogService;
import com.devtalles.proyecto.finalProject.service.LogProcessorTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Iniciando análisis de logs...");

        File logsFolder = new File("logs");
        File[] logFiles = logsFolder.listFiles((dir, name) -> name.endsWith(".log"));

        if (logFiles == null || logFiles.length == 0) {
            System.out.println("⚠️ No se encontraron archivos .log en la carpeta 'logs'. Asegúrate de crearla y poner archivos dentro.");
            return;
        }

        LogService logService = new LogService();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Future<LogSummary>> futures = new ArrayList<>();

        for (File logFile : logFiles) {
            List<LogEntry> logEntries = logService.readLogsFromFile(logFile.getAbsolutePath());
            LogProcessorTask task = new LogProcessorTask(logEntries);
            futures.add(executor.submit(task));
        }

        for (Future<LogSummary> future : futures) {
            try {
                LogSummary summary = future.get();
                System.out.println(summary);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error al procesar los logs: " + e.getMessage());
            }
        }

        executor.shutdown();
    }
}
