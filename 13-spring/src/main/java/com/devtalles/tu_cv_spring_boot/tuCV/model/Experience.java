package com.devtalles.tu_cv_spring_boot.tuCV.model;

import lombok.Data;

@Data
public class Experience {
    private String jobTitle;
    private String company;
    private String period; // Example: "March 2020 - Present"
    private String description; // Details of responsibilities and achievements
}
