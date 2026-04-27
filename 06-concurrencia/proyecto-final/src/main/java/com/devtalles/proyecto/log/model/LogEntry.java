package com.devtalles.proyecto.log.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogEntry {
    //2025-05-12 09:01:35 | user_e | checkout | 200 | 850
    private LocalDateTime timestamp;
    private String user;
    private String action;
    private int statusCode;
    private int responseTimeMs;
}
