package com.example.textapi.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

@Test
public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil;

    void testConvertJsonToYaml_ValidJson_ReturnsYamlString() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN the convertJsonToYaml method is called
        String yaml = textConversionUtil.convertJsonToYaml(json);
        // THEN the returned string is the YAML representation of the JSON
        assertEquals("# YAML representation of the JSON\nname: John\nage: 30", yaml);
    }

    void testConvertJsonToYaml_InvalidJson_ReturnsErrorString() {
        // GIVEN an invalid JSON string
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN the convertJsonToYaml method is called
        String result = textConversionUtil.convertJsonToYaml(json);
        // THEN the returned string is an error message
        assertEquals("Error converting JSON to YAML: Unexpected character at position 20", result);
    }

    void testConvertJsonToXml_ValidJson_ReturnsXmlString() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN the convertJsonToXml method is called
        String xml = textConversionUtil.convertJsonToXml(json);
        // THEN the returned string is the XML representation of the JSON
        assertEquals("<?xml version=\"1.0\"?>\n<root>\n  <name>John</name>\n  <age>30</age>\n</root>", xml);
    }

    void testConvertJsonToXml_InvalidJson_ReturnsErrorString() {
        // GIVEN an invalid JSON string
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN the convertJsonToXml method is called
        String result = textConversionUtil.convertJsonToXml(json);
        // THEN the returned string is an error message
        assertEquals("Error converting JSON to XML: Unexpected character at position 20", result);
    }
}
