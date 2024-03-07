package org.example.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Person {

    private final String firstName;
    private final String lastName;
    private final int age;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Person(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("age") int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
