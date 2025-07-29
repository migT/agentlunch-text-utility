package com.example.textapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class TextConversionUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertJsonToYaml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new YAMLMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to YAML: " + e.getMessage();
        }
    }

    public static String convertJsonToXml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new XmlMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to XML: " + e.getMessage();
        }
    }

    private static JsonNode getJsonNode(String json) throws JsonProcessingException {
        return objectMapper.readTree(json);
    }
}
