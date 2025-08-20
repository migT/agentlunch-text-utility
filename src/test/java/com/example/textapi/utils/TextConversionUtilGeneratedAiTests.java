package com.example.textapi.utils;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextConversionUtilGeneratedAiTests {
    @BeforeEach
    void setUp() {
    }

    @Test
    void convertJsonToYaml() {
        // GIVEN a JSON string
        String json = "{\"name\":\"John Doe\",\"age\":30,\"city\":\"New York\"}";
        // WHEN the JSON is converted to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);
        // THEN the resulting YAML string is as expected
        assertEquals("name: John Doe\nage: 30\ncity: New York", yaml);
    }

    @Test
    void convertJsonToXml() {
        // GIVEN a JSON string
        String json = "{\"name\":\"John Doe\",\"age\":30,\"city\":\"New York\"}";
        // WHEN the JSON is converted to XML
        String xml = TextConversionUtil.convertJsonToXml(json);
        // THEN the resulting XML string is as expected
        assertEquals("<root><name>John Doe</name><age>30</age><city>New York</city></root>", xml);
    }
}