package com.example.coffeeorders.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.persistence.AttributeConverter;

import java.time.LocalDateTime;

public class ConverterData implements AttributeConverter<Object, String> {
    private static final Gson MAPPER = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
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
