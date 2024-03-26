package com.example.coffeeorders.utils;

import com.example.coffeeorders.model.EventData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.AttributeConverter;

public class ConverterData implements AttributeConverter<Object, String> {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object o) {
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EventData convertToEntityAttribute(String s) {
        try {
            return MAPPER.readValue(s, EventData.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
