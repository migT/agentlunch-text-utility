package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: Reset any modified state before each test
    }

    @Test
    void testConvertJsonToYaml_validJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain YAML formatted content
        assertThat(yamlResult).contains("name: \"John\"");
        assertThat(yamlResult).contains("age: 30");
    }

    @Test
    void testConvertJsonToYaml_invalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John, age:30";

        // WHEN: Attempting to convert invalid JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should contain an error message
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void testConvertJsonToXml_validJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML formatted content
        assertThat(xmlResult).contains("<name>John</name>");
        assertThat(xmlResult).contains("<age>30</age>");
    }

    @Test
    void testConvertJsonToXml_invalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John, age:30";

        // WHEN: Attempting to convert invalid JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should contain an error message
        assertThat(result).startsWith("Error converting JSON to XML:");
    }

    @Test
    void testConvertJsonToYaml_emptyJson_returnsEmptyYaml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should represent an empty YAML structure
        assertThat(yamlResult.trim()).isEqualTo("{}");
    }

    @Test
    void testConvertJsonToXml_emptyJson_returnsEmptyXml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should represent an empty XML structure
        assertThat(xmlResult).contains("<ObjectNode/>");
    }
}
