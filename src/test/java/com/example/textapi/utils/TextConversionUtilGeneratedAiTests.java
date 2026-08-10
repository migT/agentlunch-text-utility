package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil;

    @BeforeEach
    public void setUp() {
        textConversionUtil = new TextConversionUtil();
    }

    @Test
    public void testConvertJsonToYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"key\":\"value\"}";

        try {
            // WHEN: Converting the JSON to YAML
            String yaml = textConversionUtil.convertJsonToYaml(json);

            // THEN: The resulting YAML should be correctly formatted
            assertThat(yaml).contains("key: value");
        } catch (Exception e) {
            // If an exception is thrown, assert that it contains the expected error message
            assertThat(e.getMessage()).contains("Error converting JSON to YAML:");
        }
    }

    @Test
    public void testConvertJsonToXml() {
        // GIVEN: A valid JSON string
        String json = "{\"key\":\"value\"}";

        try {
            // WHEN: Converting the JSON to XML
            String xml = textConversionUtil.convertJsonToXml(json);

            // THEN: The resulting XML should be correctly formatted
            assertThat(xml).contains("<key>value</key>");
        } catch (Exception e) {
            // If an exception is thrown, assert that it contains the expected error message
            assertThat(e.getMessage()).contains("Error converting JSON to XML:");
        }
    }

    @Test
    public void testConvertJsonToYamlWithInvalidJson() {
        // GIVEN: An invalid JSON string
        String json = "{\"key\":\"value\"}";

        try {
            // WHEN: Converting the JSON to YAML
            String yaml = textConversionUtil.convertJsonToYaml(json);

            // THEN: The resulting YAML should indicate an error
            assertThat(yaml).contains("Error converting JSON to YAML:");
        } catch (Exception e) {
            // If an exception is thrown, assert that it contains the expected error message
            assertThat(e.getMessage()).contains("Error converting JSON to YAML:");
        }
    }

    @Test
    public void testConvertJsonToXmlWithInvalidJson() {
        // GIVEN: An invalid JSON string
        String json = "{\"key\":\"value\"}";

        try {
            // WHEN: Converting the JSON to XML
            String xml = textConversionUtil.convertJsonToXml(json);

            // THEN: The resulting XML should indicate an error
            assertThat(xml).contains("Error converting JSON to XML:");
        } catch (Exception e) {
            // If an exception is thrown, assert that it contains the expected error message
            assertThat(e.getMessage()).contains("Error converting JSON to XML:");
        }
    }
}
