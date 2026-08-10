package com.example.textapi.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil;

    @BeforeEach
    void setUp() {
        textConversionUtil = new TextConversionUtil();
    }

    @Test
    public void convertJsonToYaml_validJson() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN
        String yaml = textConversionUtil.convertJsonToYaml(json);
        // THEN
        assertEquals("""
                name: John
                age: 30
                """, yaml);
    }

    @Test
    public void convertJsonToYaml_invalidJson() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN
        String result = textConversionUtil.convertJsonToYaml(json);
        // THEN
        assertEquals("Error converting JSON to YAML: Unexpected character at position 23", result);
    }

    @Test
    public void convertJsonToXml_validJson() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN
        String xml = textConversionUtil.convertJsonToXml(json);
        // THEN
        assertEquals("""
                <root>
                    <name>John</name>
                    <age>30</age>
                </root>
                """, xml);
    }

    @Test
    public void convertJsonToXml_invalidJson() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN
        String result = textConversionUtil.convertJsonToXml(json);
        // THEN
        assertEquals("Error converting JSON to XML: Unexpected character at position 23", result);
    }
}
