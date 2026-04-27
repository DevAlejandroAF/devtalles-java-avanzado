package com.devtalles.proyecto.log.model;

import java.util.Map;
import java.util.Set;

public class LogSummary {
    private int totalEntries;
    private int errorCount;
    private Set<String> uniqueUsers;
    private double averageResponseTime;
    private Map<Integer, Long> errorCountsByCode;

    public LogSummary(int totalEntries, int errorCount, Set<String> uniqueUsers, double averageResponseTime, Map<Integer, Long> errorCountsByCode) {
        this.totalEntries = totalEntries;
        this.errorCount = errorCount;
        this.uniqueUsers = uniqueUsers;
        this.averageResponseTime = averageResponseTime;
        this.errorCountsByCode = errorCountsByCode;
    }

    public String toString() {
        return "Total: " + totalEntries +
                ", Errores: " + errorCount +
                ", Usuarios únicos: " + uniqueUsers.size() +
                ", Tiempo promedio: " + averageResponseTime + "ms" +
                ", Errores por código: " + errorCountsByCode;
    }
}
