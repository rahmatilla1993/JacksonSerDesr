package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.domain.Status;
import org.example.domain.Transaction;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WriteAndReadTransactionObjectToYaml {

    private static final File file = new File("data/transaction.yaml");
    private static final YAMLFactory yamlFactory = new YAMLFactory();

    public static void main(String[] args) throws IOException {
//        writeToYamlFile();
        readFromYaml();
    }

    private static void readFromYaml() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
        Transaction transaction = objectMapper.readValue(file, Transaction.class);
        System.out.println(transaction);
    }

    private static void writeToYamlFile() throws IOException {
        Transaction transaction = Transaction.builder()
                .id(1L)
                .amount(BigDecimal.valueOf(12312.1234432))
                .status(Status.SUCCESS)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
        objectMapper.writeValue(file, transaction);
    }
}
