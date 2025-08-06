package com.example.textapi.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@RunWith(JUnit4.class)
public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil util;

    @BeforeEach
    void setUp() {
        util = new TextConversionUtil();
    }

    @Test
    void testConvertJsonToYaml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";

        // WHEN
        String yaml = util.convertJsonToYaml(json);

        // THEN
        assertEquals("{ \"name\": \"John\", \"age\": 30 }", yaml);
    }

    @Test
    void testConvertJsonToXml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";

        // WHEN
        String xml = util.convertJsonToXml(json);

        // THEN
        assertEquals("<root>{\"name\": \"John\", \"age\": 30}</root>", xml);
    }

    @Test
    void testConvertJsonToYamlError() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";

        // WHEN
        String result = util.convertJsonToYaml(json);

        // THEN
        assertEquals("Error converting JSON to YAML: class com.fasterxml.jackson.databind.JsonMappingException", result);
    }

    @Test
    void testConvertJsonToXmlError() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";

        // WHEN
        String result = util.convertJsonToXml(json);

        // THEN
        assertEquals("Error converting JSON to XML: class com.fasterxml.jackson.databind.JsonMappingException", result);
    }
}
