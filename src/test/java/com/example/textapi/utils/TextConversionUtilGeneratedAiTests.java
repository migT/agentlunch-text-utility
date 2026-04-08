package com.example.textapi.utils;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
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
    void testConvertJsonToYaml_validJson_shouldReturnYamlString() {
        // GIVEN: A valid JSON input
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain YAML representation
        assertThat(yamlResult).contains("name: \"John\"");
        assertThat(yamlResult).contains("age: 30");
    }

    @Test
    void testConvertJsonToYaml_invalidJson_shouldReturnErrorMessage() {
        // GIVEN: An invalid JSON input
        String invalidJson = "{name:John, age:30";

        // WHEN: Attempting to convert invalid JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should contain an error message
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void testConvertJsonToXml_validJson_shouldReturnXmlString() {
        // GIVEN: A valid JSON input
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: Converting JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain XML representation
        assertThat(xmlResult).contains("<name>John</name>");
        assertThat(xmlResult).contains("<age>30</age>");
    }

    @Test
    void testConvertJsonToXml_invalidJson_shouldReturnErrorMessage() {
        // GIVEN: An invalid JSON input
        String invalidJson = "{name:John, age:30";

        // WHEN: Attempting to convert invalid JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should contain an error message
        assertThat(result).startsWith("Error converting JSON to XML:");
    }

    @Test
    void testConvertJsonToYaml_emptyJson_shouldReturnEmptyYamlObject() {
        // GIVEN: An empty JSON input
        String emptyJson = "";

        // WHEN: Attempting to convert empty JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN: The result should either be an error message or a valid empty YAML
        assertThat(result).satisfies(r ->
                assertThat(r.startsWith("Error converting JSON to YAML:") || r.contains("root: {}")).isTrue()
        );
    }

    @Test
    void testConvertJsonToXml_emptyJson_shouldReturnEmptyXmlObject() {
        // GIVEN: An empty JSON input
        String emptyJson = "";

        // WHEN: Attempting to convert empty JSON to XML
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN: The result should either be an error message or a valid empty XML
        assertThat(result).satisfies(r ->
                assertThat(r.startsWith("Error converting JSON to XML:") || r.contains("<root/>")).isTrue()
        );
    }
}