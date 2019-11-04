package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Manager {
    private int id;
    private int bossId;
    private String name;
    private int salary;
    private int plan;
    private String unit;
}
