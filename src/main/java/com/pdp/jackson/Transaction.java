package com.pdp.jackson;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"updatedAt", "createdAt", "status", "amount", "id"})
public class Transaction {
    private Long id;
    private BigDecimal amount;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void writeYaml(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.registerModule(new JavaTimeModule());
        mapper.writeValue(new File(filePath), this);
    }

    public static Transaction readYaml(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(new File(filePath), Transaction.class);
    }
}
