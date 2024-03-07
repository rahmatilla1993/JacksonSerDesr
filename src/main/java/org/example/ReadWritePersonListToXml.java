package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.domain.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWritePersonListToXml {
    private static final File file = new File("data/people.xml");

    public static void main(String[] args) throws IOException {
//        writePersonsToXml();
        readPersonsFromXml();
    }

    private static void readPersonsFromXml() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        List<Person> people = xmlMapper.readValue(file, new TypeReference<>() {
        });
        people.forEach(System.out::println);
    }

    private static void writePersonsToXml() throws IOException {
        List<Person> people = new ArrayList<>(List.of(
                new Person("John", "Smith", 22),
                new Person("Alan", "Turing", 30),
                new Person("Dave", "Alex", 19)
        ));
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(file, people);
    }
}
