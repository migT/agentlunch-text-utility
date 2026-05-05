package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset in TextConversionUtil since methods are stateless
    }

    @Test
    void convertJsonToYaml_withValidJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertTrue(result.contains("name: \"John\""));
        assertTrue(result.contains("age: 30"));
    }

    @Test
    void convertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_withValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"John\",\"age\":30}}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertTrue(result.contains("<person>"));
        assertTrue(result.contains("<name>John</name>"));
        assertTrue(result.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "{\"person\":{\"name\":\"John\",\"age\":30"; // malformed JSON

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }
}
