package com.example.textapi.utils;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil = new TextConversionUtil();

    @BeforeEach
    void setUp() {
        // Reset any modified state before each test
    }

    @Test
    void testConvertJsonToYaml() {
        // GIVEN: A JSON string to be converted
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        
        // WHEN: Converting the JSON to YAML
        JsonNode jsonNode = textConversionUtil.convertJsonToYaml(json);
        
        // THEN: The YAML should match the expected result
        assertEquals("{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}", jsonNode.toString());
    }
