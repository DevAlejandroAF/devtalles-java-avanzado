package com.devtalles.proyecto.finalProject.util;

import com.devtalles.proyecto.finalProject.model.LogEntry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class LogParser {
//    Es static porque no depende de una instancia de la clase LogParser.
//
//    Como es una sola configuración común para todas las llamadas al
//    método parseLine, no tiene sentido crear uno nuevo cada vez.
//
//    Mejora el rendimiento y reduce el uso de memoria.
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Optional<LogEntry> parseLine(String line) {
        try {
//            En una expresión regular, | significa “alternativa” (por ejemplo, a|b significa “a o b”).
//
//            Pero vos querés dividir por el carácter | literal, no usarlo como OR.
//
//                    Entonces, en regex hay que escaparlo con \|.
//
//            Y como en Java las cadenas usan su propio escape con \, tenés que escribir \\|.

            String[] parts = line.split("\\|");
            if (parts.length != 5) return Optional.empty();

            LocalDateTime timestamp = LocalDateTime.parse(parts[0].trim(), formatter);
            String user = parts[1].trim();
            String action = parts[2].trim();
            int statusCode = Integer.parseInt(parts[3].trim());
            int responseTimeMs = Integer.parseInt(parts[4].trim());

            return Optional.of(new LogEntry(timestamp, user, action, statusCode, responseTimeMs));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

