package com.sms.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class JacksonUtils {

    public static Function<Object, String> marshalToJSON = (obj) -> {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    };

    public static Supplier<ObjectMapper> createObjectMapper = () -> new ObjectMapper();
    public static Function<ObjectMapper, ObjectNode> createJsonObjectNode = (objectMapper) -> objectMapper.createObjectNode();
    public static BiFunction<ObjectMapper, ObjectNode, String> convertNodeToString = (objectMapper, node) -> {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
        } catch (JsonProcessingException e) {
            return null;
        }
    };

}
