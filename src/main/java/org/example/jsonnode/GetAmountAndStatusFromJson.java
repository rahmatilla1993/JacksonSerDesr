package org.example.jsonnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class GetAmountAndStatusFromJson {
    private static final File file = new File("data/json_data.json");

    public static void main(String[] args) throws IOException {
        getAmountAndStatus();
    }

    private static void getAmountAndStatus() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);
        String status = jsonNode.get("status").asText();
        double amount = jsonNode.get("amount").asDouble();
        System.out.println("Status: " + status + ", amount: " + amount);
    }
}
