package com.example.textapi.utils;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: Reset any state if needed (stateless utility, nothing to reset)
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Calling convertJsonToYaml
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the expected YAML keys
        org.junit.jupiter.api.Assertions.assertTrue(yaml.contains("name"));
        org.junit.jupiter.api.Assertions.assertTrue(yaml.contains("age"));
        org.junit.jupiter.api.Assertions.assertTrue(yaml.contains("John"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: Calling convertJsonToYaml
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should contain an error message
        org.junit.jupiter.api.Assertions.assertTrue(result.toLowerCase().contains("error"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String emptyJson = "";

        // WHEN: Calling convertJsonToYaml
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The result should contain an error message
        org.junit.jupiter.api.Assertions.assertTrue(result.toLowerCase().contains("error"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"city\":\"London\",\"population\":9000000}";

        // WHEN: Calling convertJsonToXml
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain expected XML elements
        org.junit.jupiter.api.Assertions.assertTrue(xml.contains("<city>London</city>"));
        org.junit.jupiter.api.Assertions.assertTrue(xml.contains("<population>9000000</population>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{city:London,population:9000000}";

        // WHEN: Calling convertJsonToXml
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should contain an error message
        org.junit.jupiter.api.Assertions.assertTrue(result.toLowerCase().contains("error"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsErrorMessage() {
        // GIVEN: An empty JSON string
        String emptyJson = "";

        // WHEN: Calling convertJsonToXml
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The result should contain an error message
        org.junit.jupiter.api.Assertions.assertTrue(result.toLowerCase().contains("error"));
    }

    @Test
    void testConvertJsonToYaml_withComplexJson_returnsYaml() {
        // GIVEN: A complex JSON string
        String complexJson = "{\"user\":{\"id\":1,\"roles\":[\"admin\",\"user\"]}}";

        // WHEN: Calling convertJsonToYaml
        String yaml = TextConversionUtil.convertJsonToYaml(complexJson);

        // THEN: The result should contain nested YAML structure
        org.junit.jupiter.api.Assertions.assertTrue(yaml.contains("user:"));
        org.junit.jupiter.api.Assertions.assertTrue(yaml.contains("roles:"));
        org.junit.jupiter.api.Assertions.assertTrue(yaml.toLowerCase().contains("admin"));
        org.junit.jupiter.api.Assertions.assertTrue(yaml.toLowerCase().contains("user"));
    }

    @Test
    void testConvertJsonToXml_withComplexJson_returnsXml() {
        // GIVEN: A complex JSON string
        String complexJson = "{\"user\":{\"id\":1,\"roles\":[\"admin\",\"user\"]}}