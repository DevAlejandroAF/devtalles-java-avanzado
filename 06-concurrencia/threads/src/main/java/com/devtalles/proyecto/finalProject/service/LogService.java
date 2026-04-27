package com.devtalles.proyecto.finalProject.service;



import com.devtalles.proyecto.finalProject.model.LogEntry;
import com.devtalles.proyecto.finalProject.util.LogParser;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LogService {
    public List<LogEntry> readLogsFromFile(String filePath) {
        try {
            return Files.lines(Path.of(filePath))
                    .map(LogParser::parseLine)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return List.of();
        }
    }
}

