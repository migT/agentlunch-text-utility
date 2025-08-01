package com.example.textapi.utils;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil = new TextConversionUtil();

    @BeforeEach
    public void resetState() {
        // Reset any modified state before each test
    }

    @Test
    public void testConvertJsonToYaml() {
        String json = "{\"key\":\"value\"}";
        given("Valid JSON input");
        when().thenReturn(textConversionUtil.convertJsonToYaml(json));
        then("Expected YAML output").assertThat(textConversionUtil.convertJsonToYaml(json), Assert::assertEquals("key: value\n"));
    }

    @Test
    public void testConvertJsonToXml() {
        String json = "{\"key\":\"value\"}";
        given("Valid JSON input");
        when().thenReturn(textConversionUtil.convertJsonToXml(json));
        then("Expected XML output").assertThat(textConversionUtil.convertJsonToXml(json), Assert::assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><key>value</key></root>", textConversionUtil.convertJsonToXml(json)));
    }

    @Test
    public void testConvertJsonToYamlInvalidInput() {
        String json = "{\"key\":\"value\"}";
        given("Invalid JSON input");
        when().thenReturn(textConversionUtil.convertJsonToYaml(json + " invalid"));
        then("Expected error message").assertThat(textConversionUtil.convertJsonToYaml(json + " invalid"), Assert::assertEquals("Error converting JSON to YAML: com.fasterxml.jackson.core.JsonParseException: Unrecognized token 'invalid'", textConversionUtil.convertJsonToYaml(json + " invalid")));
    }

    @Test
    public void testConvertJsonToXmlInvalidInput() {
        String json = "{\"key\":\"value\"}";
        given("Invalid JSON input");
        when().thenReturn(textConversionUtil.convertJsonToXml(json + " invalid"));
        then("Expected error message").assertThat(textConversionUtil.convertJsonToXml(json + " invalid"), Assert::assertEquals("Error converting JSON to XML: com.fasterxml.jackson.core.JsonParseException: Unrecognized token 'invalid'", textConversionUtil.convertJsonToXml(json + " invalid")));
    }
}
