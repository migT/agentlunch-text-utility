package com.example.textapi.utils;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: Reset any static or shared state if needed (none in this class)
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: the result should contain YAML representation
        assertNotNull(yaml);
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsError() {
        // GIVEN: an invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: the result should indicate an error
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsError() {
        // GIVEN: an empty JSON string
        String emptyJson = "";

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: the result should indicate an error or be empty string
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to YAML:") || result.isEmpty());
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: a valid JSON string
        String json = "{\"name\":\"Alice\",\"city\":\"Wonderland\"}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: the result should contain XML representation
        assertNotNull(xml);
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<city>Wonderland</city>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsError() {
        // GIVEN: an invalid JSON string
        String invalidJson = "{\"name\":\"Alice\",\"city\":Wonderland}";

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: the result should indicate an error
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsError() {
        // GIVEN: an empty JSON string
        String emptyJson = "";

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: the result should indicate an error or be empty string
        assertNotNull(result);
        assertTrue(result.startsWith("Error converting JSON to XML:") || result.isEmpty());
    }

    @Test
    void testConvertJsonToYaml_withJsonArray_returnsYamlArray() {
        // GIVEN: a valid JSON array string
        String jsonArray = "[{\"id\":1,\"val\":\"A\"},{\"id\":2,\"val\":\"B\"}]";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(jsonArray);

        // THEN: the result should contain YAML array representation
        assertNotNull(yaml);
        assertTrue(yaml.contains("- id: 1"));
        assertTrue(yaml.contains("val: \"A\""));
        assertTrue(yaml.contains("- id: 2"));
        assertTrue(yaml.contains("val: \"B\""));
    }

    @Test
    void testConvertJsonToXml_withJsonArray_returnsXmlArray() {
        // GIVEN: a valid JSON array string
        String jsonArray = "[{\"id\":1,\"val\":\"A\"},{\"id\":2,\"val\":\"B\"}