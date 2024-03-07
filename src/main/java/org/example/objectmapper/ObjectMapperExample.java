package org.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapperExample {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
//        toJson();
//        fromJson();
//        toJsonArray();
//        fromJsonArray();
//        withoutProperty();
    }

    private static void withoutProperty() throws JsonProcessingException {
        String jsonArray = """
                    [
                        {
                            "color":"grey",
                            "type":"hetchbek",
                            "model":"Turbo"
                        },
                        {
                            "color":"white",
                            "type":"cabriolet",
                            "model":"Mustang"
                        }
                    ]
                """;
        List<Car> cars = objectMapper.readValue(jsonArray, new TypeReference<>() {
        });
        cars.forEach(System.out::println);
    }

    private static void fromJsonArray() throws JsonProcessingException {
        String jsonArray = """
                    [
                        {
                            "color":"grey",
                            "type":"hetchbek"
                        },
                        {
                            "color":"white",
                            "type":"cabriolet"
                        }
                    ]
                """;
        List<Car> cars = objectMapper.readValue(jsonArray, new TypeReference<List<Car>>() {
        });
        cars.forEach(System.out::println);
    }

    private static void toJsonArray() throws JsonProcessingException {
        List<Car> cars = new ArrayList<>(List.of(
                new Car("grey", "hetchbek"),
                new Car("white", "cabriolet"),
                new Car("yellow", "some type")
        ));
        String jsonArray = objectMapper.writeValueAsString(cars);
        System.out.println(jsonArray);
    }

    private static void fromJson() {
        String carJson = """
                {
                    "color" : "black",
                    "type" : "hybrid"
                }
                """;
        try {
            Car car = objectMapper.readValue(carJson, Car.class);
            System.out.println(car);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void toJson() {
        Car car = new Car("Red", "hybrid");
        try {
            String json = objectMapper.writeValueAsString(car);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
