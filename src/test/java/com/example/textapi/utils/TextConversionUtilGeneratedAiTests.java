package com.example.textapi.utils;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain YAML formatted content
        assertThat(yaml).contains("name: \"John\"");
        assertThat(yaml).contains("age: 30");
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
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML formatted content
        assertThat(xml).contains("<name>John</name>");
        assertThat(xml).contains("<age>30</age>");
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
        String emptyJson = "{}";

        // WHEN: Converting empty JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The result should be a valid empty YAML representation
        assertThat(result.trim()).isEmpty();
    }

    @Test
    void testConvertJsonToXml_emptyJson_returnsEmptyXml() {
        // GIVEN: An empty JSON object
        String emptyJson = "{}";

        // WHEN: Converting empty JSON to XML
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The result should be a valid empty XML representation
        assertThat(result.trim()).isEqualTo("<ObjectNode/>");
    }
}