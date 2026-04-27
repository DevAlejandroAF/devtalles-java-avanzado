package com.devtalles.proyecto.finalProject.repository;

import com.devtalles.proyecto.finalProject.model.LogEntry;

import java.util.ArrayList;
import java.util.List;


public class LogRepository {
    private final List<LogEntry> logEntries;

    public LogRepository() {
        logEntries = new ArrayList<>();
    }

    public List<LogEntry> getLogEntries() {
        return logEntries;
    }
}
