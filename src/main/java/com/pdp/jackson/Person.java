package com.pdp.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public record Person(String firstName, String lastName, int age) {
    public static void writeJson(List<Person> persons, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(filePath), persons);
    }

    public static List<Person> readJson(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), mapper.getTypeFactory().constructCollectionType(List.class, Person.class));
    }
}
