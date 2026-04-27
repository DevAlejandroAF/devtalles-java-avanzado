package com.devtalles.proyecto.finalProject.controller;

import com.devtalles.proyecto.finalProject.model.LogSummary;
import com.devtalles.proyecto.finalProject.service.LogProcessorTask;
import com.devtalles.proyecto.finalProject.service.LogService;

import java.util.List;
import java.util.concurrent.*;

public class MainController {

//    private LogService service;
//
//    public MainController(LogService service) {
//        this.service = service;
//    }
//
//    public void run() {
//        System.out.println("Procesando archivos en paralelo...");
//
//        List<String> files = List.of(
//                "logs/sample1.log",
//                "logs/sample2.log",
//                "logs/sample3.log"
//        );
//
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//
//        List<Future<LogSummary>> futures = files.stream()
//                .map(file -> executor.submit(new LogProcessorTask(file)))
//                .toList();
//
//        for (int i = 0; i < futures.size(); i++) {
//            try {
//                LogSummary summary = futures.get(i).get();
//                System.out.println("Archivo " + (i + 1) + ": " + summary);
//            } catch (InterruptedException | ExecutionException e) {
//                System.err.println("Error procesando archivo: " + e.getMessage());
//            }
//        }
//        executor.shutdown();
//    }
}

