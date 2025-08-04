package com.example.textapi.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
public class TextConversionUtilGeneratedAiTests {

    private ObjectMapper objectMapper;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void convertJsonToYaml_validJson_returnsYamlString() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN the convertJsonToYaml method is called
        String yaml = TextConversionUtil.convertJsonToYaml(json);
        // THEN the returned string is the YAML representation of the JSON
        assertEquals("name: John\nage: 30", yaml);
    }

    @Test
    public void convertJsonToYaml_invalidJson_returnsErrorString() {
        // GIVEN an invalid JSON string
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN the convertJsonToYaml method is called
        String result = TextConversionUtil.convertJsonToYaml(json);
        // THEN the returned string is an error message
        assertEquals("Error converting JSON to YAML: unexpected character at position 21", result);
    }

    @Test
    public void convertJsonToXml_validJson_returnsXmlString() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN the convertJsonToYaml method is called
        String xml = TextConversionUtil.convertJsonToXml(json);
        // THEN the returned string is the XML representation of the JSON
        assertEquals("<?xml version=\"1.0\"?>\n<root>\n    <name>John</name>\n    <age>30</age>\n</root>", xml);
    }

    @Test
    public void convertJsonToXml_invalidJson_returnsErrorString() {
        // GIVEN an invalid JSON string
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN the convertJsonToYaml method is called
        String result = TextConversionUtil.convertJsonToXml(json);
        // THEN the returned string is an error message
        assertEquals("Error converting JSON to XML: unexpected character at position 21", result);
    }
}
