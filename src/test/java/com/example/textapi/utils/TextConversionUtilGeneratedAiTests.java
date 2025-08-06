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
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil util;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        util = new TextConversionUtil();
    }

    @Test
    public void convertJsonToYaml_validJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN
        String yaml = util.convertJsonToYaml(json);
        // THEN
        assertEquals("{\n  \"name\":\"John\",\n  \"age\":30\n}", yaml);
    }

    @Test
    public void convertJsonToXml_validJson_returnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30}";
        // WHEN
        String xml = util.convertJsonToXml(json);
        // THEN
        assertEquals("<root>\n  <name>John</name>\n  <age>30</age>\n</root>", xml);
    }

    @Test
    public void convertJsonToYaml_invalidJson_returnsErrorString() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN
        String error = util.convertJsonToYaml(json);
        // THEN
        assertEquals("Error converting JSON to YAML: org.json.JSONP parse error: Expected name or string, but got null", error);
    }

    @Test
    public void convertJsonToXml_invalidJson_returnsErrorString() {
        // GIVEN
        String json = "{\"name\":\"John\", \"age\":30";
        // WHEN
        String xml = util.convertJsonToXml(json);
        // THEN
        assertEquals("Error converting JSON to XML: org.json.JSONP parse error: Expected name or string, but got null", xml);
    }
}
