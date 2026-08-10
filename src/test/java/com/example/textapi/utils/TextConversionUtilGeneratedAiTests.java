package com.example.textapi.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil;

    @BeforeEach
    void setUp() {
        textConversionUtil = new TextConversionUtil();
    }

    @Test
    void testConvertJsonToYaml_ValidJson_ReturnsYamlString() {
        // GIVEN a valid JSON string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToYaml method is called
        String yaml = textConversionUtil.convertJsonToYaml(json);
        // THEN the returned string is the YAML representation of the JSON
        assertEquals("# yaml: --- \nname: John\nage: 30", yaml);
    }

    @Test
    void testConvertJsonToYaml_InvalidJson_ReturnsErrorString() {
        // GIVEN an invalid JSON string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToYaml method is called
        String result = textConversionUtil.convertJsonToYaml(json);
        // THEN the returned string is an error message
        assertEquals("Error converting JSON to YAML: unexpected character at position 0", result);
    }

    @Test
    void testConvertJsonToXml_ValidJson_ReturnsXmlString() {
        // GIVEN a valid JSON string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToXml method is called
        String xml = textConversionUtil.convertJsonToXml(json);
        // THEN the returned string is the XML representation of the JSON
        assertEquals("<?xml version=\"1.0\"?>\n<root><name>John</name><age>30</age></root>", xml);
    }

    @Test
    void testConvertJsonToXml_InvalidJson_ReturnsErrorString() {
        // GIVEN an invalid JSON string
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN the convertJsonToXml method is called
        String result = textConversionUtil.convertJsonToXml(json);
        // THEN the returned string is an error message
        assertEquals("Error converting JSON to XML: unexpected character at position 0", result);
    }
}
