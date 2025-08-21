package com.example.textapi.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.extension.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoJUnitRunner
public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil;

    @BeforeEach
    void setUp() {
        textConversionUtil = new TextConversionUtil();
    }

    void testConvertJsonToYaml_ValidJson_ReturnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN
        String yaml = textConversionUtil.convertJsonToYaml(json);
        // THEN
        assertEquals("# YAML representation of the JSON data\n" +
                "# name: John\n" +
                "# age: 30", yaml);
    }

    void testConvertJsonToYaml_InvalidJson_ReturnsErrorString() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN
        String result = textConversionUtil.convertJsonToYaml(json);
        // THEN
        assertEquals("Error converting JSON to YAML: Unexpected character at position 23", result);
    }

    void testConvertJsonToXml_ValidJson_ReturnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN
        String xml = textConversionUtil.convertJsonToXml(json);
        // THEN
        assertEquals("<?xml version=\"1.0\"?>\n" +
                "<root>\n" +
                "  <name>John</name>\n" +
                "  <age>30</age>\n" +
                "</root>", xml);
    }

    void testConvertJsonToXml_InvalidJson_ReturnsErrorString() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN
        String result = textConversionUtil.convertJsonToXml(json);
        // THEN
        assertEquals("Error converting JSON to XML: Unexpected character at position 23", result);
    }
}
