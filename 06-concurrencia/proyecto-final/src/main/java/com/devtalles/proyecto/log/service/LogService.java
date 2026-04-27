package com.devtalles.proyecto.log.service;

import com.devtalles.proyecto.log.model.LogEntry;
import com.devtalles.proyecto.log.util.LogParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class LogService {

    public List<LogEntry> readLogsFromFile(String filePath){
        try{
            return Files.lines(Path.of(filePath))
                    .map(LogParser::parseLine)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();
        }catch (IOException e){
            System.out.println(e.getMessage());
            return List.of();
        }
    }
}
