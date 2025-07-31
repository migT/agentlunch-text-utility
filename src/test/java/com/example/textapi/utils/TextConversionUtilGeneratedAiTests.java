package com.example.textapi.utils;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil;

    @BeforeEach
    public void setUp() {
        textConversionUtil = new TextConversionUtil();
    }

    @Test
    public void testConvertJsonToYaml() {
        // GIVEN: A JSON string to be converted
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

        // WHEN: The JSON is converted to YAML
        String yaml = textConversionUtil.convertJsonToYaml(json);

        // THEN: The YAML output should match the expected result
        assertEquals("name: John\nage: 30\ncity: New York\n", yaml);
    }

    @Test
    public void testConvertJsonToXml() {
        // GIVEN: A JSON string to be converted
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

        // WHEN: The JSON is converted to XML
        String xml = textConversionUtil.convertJsonToXml(json);

        // THEN: The XML output should match the expected result
        assertEquals("<root><name>John</name><age>30</age><city>New York</city></root>", xml);
    }
}
