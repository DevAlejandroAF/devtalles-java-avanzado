package com.devtalles.proyecto.finalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import java.util.Map;
@Data
@NoArgsConstructor
public class LogSummary {
//    totalEntries: cantidad total de logs procesados.
//
//    errorCount: número de errores detectados.
//
//    uniqueUsers: conjunto de usuarios únicos.
//
//    averageResponseTime: tiempo de respuesta promedio en milisegundos.
//
//    errorCountsByCode: cantidad de errores agrupados por código de estado.
    private int totalEntries;
    private int errorCount;
    private Set<String> uniqueUsers;
    private double averageResponseTime;
    private Map<Integer, Long> errorCountsByCode;

    public LogSummary(int totalEntries, int errorCount,
                      Set<String> uniqueUsers,
                      double averageResponseTime,
                      Map<Integer, Long> errorCountsByCode) {
        this.totalEntries = totalEntries;
        this.errorCount = errorCount;
        this.uniqueUsers = uniqueUsers;
        this.averageResponseTime = averageResponseTime;
        this.errorCountsByCode = errorCountsByCode;
    }

    @Override
    public String toString() {
        return "Total: " + totalEntries +
                ", Errores: " + errorCount +
                ", Usuarios únicos: " + uniqueUsers.size() +
                ", Tiempo promedio: " + averageResponseTime + "ms" +
                ", Errores por código: " + errorCountsByCode;
    }
}


