package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Класс для преобразования объекта House в JSON и обратно с использованием библиотеки Jackson
public class HouseJson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String serializeToJson(House house) throws JsonProcessingException {
        return objectMapper.writeValueAsString(house);
    }

    public static House deserializeFromJson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, House.class);
    }
}