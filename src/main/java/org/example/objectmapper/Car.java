package org.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({"model"})
public class Car {
    private String color;
    private String type;
    private String model;

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }
}
