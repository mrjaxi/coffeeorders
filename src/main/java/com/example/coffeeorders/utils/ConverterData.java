package com.example.coffeeorders.utils;

import com.example.coffeeorders.model.EventData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.persistence.AttributeConverter;

import java.time.LocalDate;

public class ConverterData implements AttributeConverter<Object, String> {
    private static final Gson MAPPER = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();

    @Override
    public String convertToDatabaseColumn(Object o) {
        return MAPPER.toJson(o);
    }

    @Override
    public Object convertToEntityAttribute(String s) {
        return MAPPER.fromJson(s, Object.class);
    }
}
