package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Person;

import java.io.File;
import java.io.IOException;

public class ReadWritePersonToFile {
    private static final File file = new File("data/json.txt");

    public static void main(String[] args) throws IOException {
//        writePersonToFile();
        readPersonFromFile();
    }

    private static void readPersonFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(file, Person.class);
        System.out.println(person);
    }

    private static void writePersonToFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person("John", "Smith", 22);
        objectMapper.writeValue(file, person);
    }
}
