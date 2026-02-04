package com.example.textapi.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil;

    @BeforeEach
    public void setup() {
        textConversionUtil = new TextConversionUtil();
    }

    @Test
    public void testConvertJsonToYaml_GivenValidJson_WhenConvertedToJsonNode_ThenReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String yaml = textConversionUtil.convertJsonToYaml(json);

        // THEN
        assertEquals("key: value", yaml);
    }

    @Test
    public void testConvertJsonToXml_GivenValidJson_WhenConvertedToJsonNode_ThenReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String xml = textConversionUtil.convertJsonToXml(json);

        // THEN
        assertEquals("<root><key>value</key></root>", xml);
    }

    @Test
    public void testConvertJsonToYaml_GivenInvalidJson_WhenConvertedToJsonNode_ThenThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN & THEN
        assertThrows(JsonProcessingException, () -> textConversionUtil.convertJsonToYaml(json));
    }

    @Test
    public void testConvertJsonToXml_GivenInvalidJson_WhenConvertedToJsonNode_ThenThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN & THEN
        assertThrows(JsonProcessingException, () -> textConversionUtil.convertJsonToXml(json));
    }
}
