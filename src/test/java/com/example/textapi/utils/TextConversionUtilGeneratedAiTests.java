package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class TextConversionUtil {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getJsonNode(String json) throws JsonProcessingException {
        return objectMapper.readTree(json);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public String convertJsonToYaml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new YAMLMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to YAML: " + e.getMessage();
        }
    }

    public String convertJsonToXml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new XmlMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to XML: " + e.getMessage();
        }
    }
}
