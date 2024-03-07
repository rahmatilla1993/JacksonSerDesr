package org.example.jsongenerator;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.example.domain.Status;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class JsonGeneratorExample {
    private static final File file = new File("data/json_data.json");

    public static void main(String[] args) {
        generateTransactionJson();
    }

    private static void generateTransactionJson() {
        JsonFactory jsonFactory = new JsonFactory();

        try (JsonGenerator generator = jsonFactory.createGenerator(file, JsonEncoding.UTF8)) {
            generator.writeStartObject();

            generator.writeNumberField("id", 1L);
            generator.writeNumberField("amount", BigDecimal.valueOf(123445.122223455));
            generator.writeStringField("status", Status.SUCCESS.name());
            generator.writeStringField("created_at", LocalDateTime.now().toString());
            generator.writeStringField("updated_at", LocalDateTime.now().toString());

            generator.writeEndObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
