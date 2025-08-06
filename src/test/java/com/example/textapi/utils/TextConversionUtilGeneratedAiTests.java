package com.example.textapi.utils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

public class TextConversionUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertJsonToYaml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            YAMLMapper yamlMapper = new YAMLMapper();
            yamlMapper.configure(YAMLGenerator.Feature.MINIMIZE_QUOTES, true);
            yamlMapper.configure(YAMLGenerator.Feature.SPLIT_LINES, false);
            yamlMapper.configure(YAMLGenerator.Feature.INDENT_ARRAYS, false);
            yamlMapper.configure(YAMLGenerator.Feature.USE_PLATFORM_LINE_BREAKS, false);
            yamlMapper.configure(YAMLGenerator.Feature.ALWAYS_QUOTE_NUMBERS_AS_STRINGS, false);
            String yaml = yamlMapper.writeValueAsString(jsonNode);
            // Remove quotes only around values, keep keys intact
            // Replace quoted strings like "John" with John without quotes
            yaml = yaml.replaceAll(": \"([^\"]*)\"", ": $1");
            return yaml;
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