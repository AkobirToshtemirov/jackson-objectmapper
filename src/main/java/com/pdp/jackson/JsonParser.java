package com.pdp.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
    public static String getAmountAndStatus(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        String amount = rootNode.get("amount").asText();
        String status = rootNode.get("status").asText();

        return "Amount: " + amount + ", Status: " + status;
    }
}
