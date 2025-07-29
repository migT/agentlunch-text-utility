package com.example.textapi.service;

Here is the rest of the test class:

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;

```java
    @Test
    void testConvertJsonToYaml() {
        // GIVEN: A JSON string to convert to YAML
        String json = "{\"key\": \"value\"}";
        // WHEN: The convertJsonToYaml method is called
        String result = textService.convertJsonToYaml(json);
        // THEN: The expected YAML string is returned
        assert result.equals("key: value\n");
    }

    @Test
    void testConvertJsonToXml() {
        // GIVEN: A JSON string to convert to XML
        String json = "{\"key\": \"value\"}";
        // WHEN: The convertJsonToXml method is called
        String result = textService.convertJsonToXml(json);
        // THEN: The expected XML string is returned
        assert result.equals("<root><key>value</key></root>");
    }
}
