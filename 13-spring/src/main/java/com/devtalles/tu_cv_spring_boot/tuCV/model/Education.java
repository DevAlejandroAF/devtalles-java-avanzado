package com.devtalles.tu_cv_spring_boot.tuCV.model;

import lombok.Data;

@Data
public class Education {
    private String institution;
    private String degree;
    private String period; // Example: "September 2018 - June 2022"
    private String description; // Optional: details of the study
}
