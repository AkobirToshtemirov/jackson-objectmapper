package com.pdp.jackson;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SerializationTasks {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Car car = new Car("Red", "SUV");
        String carJson = car.toJson();
        System.out.println("Car JSON: " + carJson);

        Car newCar = Car.fromJson(carJson);
        System.out.println("From JSON - Color: " + newCar.getColor() + ", Type: " + newCar.getType());

        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setAmount(new BigDecimal("7534675.43"));
        transaction.setStatus(Status.SUCCESS);
        transaction.setCreatedAt(LocalDateTime.parse("2019-03-27T10:15:30"));
        transaction.setUpdatedAt(LocalDateTime.parse("2022-03-14T11:05:20"));

        transaction.writeYaml("transaction.yaml");

        Transaction readTransaction = Transaction.readYaml("transaction.yaml");
        System.out.println("Read Transaction - ID: " + readTransaction.getId() +
                ", Amount: " + readTransaction.getAmount() +
                ", Status: " + readTransaction.getStatus() +
                ", Created At: " + readTransaction.getCreatedAt() +
                ", Updated At: " + readTransaction.getUpdatedAt());

        String json = "{ \"id\" : 1, \"amount\" : 7534675.43, \"status\" : \"SUCCESS\", \"createdAt\" : \"2019-03-27T10:15:30\", \"updatedAt\" : \"2022-03-14T11:05: 20\" }";
        String amountAndStatus = JsonParser.getAmountAndStatus(json);
        System.out.println("Amount and Status from JSON: " + amountAndStatus);

        Person person1 = new Person("John", "Doe", 30);
        Person person2 = new Person("Alice", "Smith", 25);

        Person.writeJson(List.of(person1, person2), "persons.json");

        List<Person> persons = Person.readJson("persons.json");
        for (Person p : persons) {
            System.out.println("Read Person - First Name: " + p.firstName() +
                    ", Last Name: " + p.lastName() +
                    ", Age: " + p.age());
        }
    }
}