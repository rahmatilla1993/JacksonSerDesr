package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Status;
import org.example.domain.Transaction;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class JsonPropertyOrderExample {
    private static final File file = new File("data/order_write.json");
    public static void main(String[] args) throws IOException {
        Transaction transaction = Transaction.builder()
                .id(1L)
                .amount(BigDecimal.valueOf(12312.1234432))
                .status(Status.SUCCESS)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, transaction);
    }
}
