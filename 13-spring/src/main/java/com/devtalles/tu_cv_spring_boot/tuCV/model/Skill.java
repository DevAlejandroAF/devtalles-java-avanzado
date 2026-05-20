package com.devtalles.tu_cv_spring_boot.tuCV.model;

import lombok.Data;

@Data
public class Skill {
    private String name;
    private String level; // Optional: could be "Basic", "Intermediate", "Advanced" or a percentage
}
