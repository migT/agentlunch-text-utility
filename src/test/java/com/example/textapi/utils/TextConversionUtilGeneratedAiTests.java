package com.example.textapi.utils;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset for this utility class
    }

    @Test
    void testConvertJsonToYamlWithValidJson() {
        // GIVEN a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN the result should be a non-null YAML string containing the expected values
        assertNotNull(yaml, "YAML output should not be null");
        assertTrue(yaml.startsWith("---"), "YAML output should start with '---'");
        assertTrue(yaml.contains("name:"), "YAML should contain the name field");
        assertTrue(yaml.contains("age: 30"), "YAML should contain the age field");
    }

    @Test
    void testConvertJsonToYamlWithInvalidJson() {
        // GIVEN an invalid JSON string
        String invalidJson = "invalid json";

        // WHEN converting JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN the result should contain an error message
        assertNotNull(result, "Result should not be null");
        assertTrue(result.contains("Error converting JSON to YAML"), "Error message should be present");
    }
}