package com.example.textapi.utils;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: Reset any state if necessary (stateless utility class, nothing to reset)
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the expected YAML keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30"; // malformed JSON

        // WHEN: Converting invalid JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should contain an error message
        assertTrue(result.toLowerCase().contains("error"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String emptyJson = "";

        // WHEN: Converting empty JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The result should contain an error message
        assertTrue(result.toLowerCase().contains("error"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML tags for the keys
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30"; // malformed JSON

        // WHEN: Converting invalid JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should contain an error message
        assertTrue(result.toLowerCase().contains("error"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String emptyJson = "";

        // WHEN: Converting empty JSON to XML
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The result should contain an error message
        assertTrue(result.toLowerCase().contains("error"));
    }

    @Test
    void testConvertJsonToYaml_withJsonArray_returnsYamlArray() {
        // GIVEN: A valid JSON array string
        String jsonArray = "[{\"name\":\"Alice\"},{\"name\":\"Bob\"}]";

        // WHEN: Converting JSON array to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(jsonArray);

        // THEN: The result should contain YAML array entries
        assertTrue(yaml.contains("- name: \"Alice\""));
        assertTrue(yaml.contains("- name: \"Bob\""));
    }

    @Test
    void testConvertJsonToXml_withJsonArray_returnsXmlArray() {
        // GIVEN: A valid JSON array string
        String jsonArray = "[{\"name\":\"Alice\"},{\"name\":\"Bob\"}]";

        // WHEN: Converting JSON array to XML
        String xml = TextConversionUtil.convertJsonToXml(jsonArray);

        // THEN: The result should contain XML array entries
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<name>Bob</name>"));
    }
}