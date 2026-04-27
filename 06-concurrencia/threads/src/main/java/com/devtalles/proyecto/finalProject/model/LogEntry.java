package com.devtalles.proyecto.finalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogEntry {
    private LocalDateTime timestamp;
    private String user;
    private String action;
    private int statusCode;
    private int responseTimeMs;



    // Constructor, getters y toString() van a agregarse después
}

