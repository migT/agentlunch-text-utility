package com.example.textapi.service;

Here is the rest of the corrected test class:

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;

    @Test
    @DisplayName("Test convertJsonToYaml method")
    void testConvertJsonToYamlMethod() {
        // GIVEN: A sample JSON input string
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        // WHEN: The convertJsonToYaml method is called with the JSON input
        String result = textService.convertJsonToYaml(json);
        // THEN: The YAML output should be a valid YAML string
        assertEquals("name: John\nage: 30\ncity: New York", result);
    }

    @Test
    @DisplayName("Test convertJsonToXml method")
    void testConvertJsonToXmlMethod() {
        // GIVEN: A sample JSON input string
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        // WHEN: The convertJsonToXml method is called with the JSON input
        String result = textService.convertJsonToXml(json);
        // THEN: The XML output should be a valid XML string
        assertEquals("<root><name>John</name><age>30</age><city>New York</city></root>", result);
    }
}
