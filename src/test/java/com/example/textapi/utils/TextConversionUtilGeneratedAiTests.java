package com.example.textapi.utils;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    public void setUp() {
        // GIVEN: Reset any static or shared state if necessary (none in this utility class)
        // No state to reset for TextConversionUtil
    }

    @Test
    public void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30,\"active\":true}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the expected YAML keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
        assertTrue(yaml.contains("active: true"));
    }

    @Test
    public void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30,active:true}";

        // WHEN: convertJsonToYaml is called
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should indicate an error occurred
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    public void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"city\":\"Paris\",\"population\":2148000}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain expected XML tags and values
        assertTrue(xml.contains("<city>Paris</city>"));
        assertTrue(xml.contains("<population>2148000</population>"));
    }

    @Test
    public void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{\"city\":\"Paris\",,\"population\":2148000}";

        // WHEN: convertJsonToXml is called
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should indicate an error occurred
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    public void testConvertJsonToYaml_withEmptyJson_returnsYaml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: convertJsonToYaml is called
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should be a valid empty YAML object
        assertTrue(yaml.trim().isEmpty() || yaml.trim().equals("{}"));
    }

    @Test
    public void testConvertJsonToXml_withEmptyJson_returnsXml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: convertJsonToXml is called
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should be a valid empty XML object
        assertTrue(xml.trim().startsWith("<ObjectNode"));
    }
}