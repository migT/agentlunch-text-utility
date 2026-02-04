package com.example.textapi.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil;

    @BeforeEach
    public void setup() {
        textConversionUtil = new TextConversionUtil();
    }

    @Test
    public void convertJsonToYaml_GIVEN_validJson_WHEN_convertToJsonToYaml_THEN_returnYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String result = textConversionUtil.convertJsonToYaml(json);

        // THEN
        assertEquals("{\"key: value}\n  key: value", result);
    }

    @Test
    public void convertJsonToYaml_GIVEN_invalidJson_WHEN_convertToJsonToYaml_THEN_throwException() {
        // GIVEN
        String json = "{\"key\":\"value\"";

        // WHEN
        Exception exception = assertThrows(JsonProcessingException.class, () -> textConversionUtil.convertJsonToYaml(json));

        // THEN
        assertEquals("Unrecognized token 'value'", exception.getMessage());
    }

    @Test
    public void convertJsonToXml_GIVEN_validJson_WHEN_convertToJsonToXml_THEN_returnXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String result = textConversionUtil.convertJsonToXml(json);

        // THEN
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        assertEquals("<key>value</key>", "<key>value</key>");
    }

    @Test
    public void convertJsonToXml_GIVEN_invalidJson_WHEN_convertToJsonToXml_THEN_throwException() {
        // GIVEN
        String json = "{\"key\":\"value\"";

        // WHEN
        Exception exception = assertThrows(JsonProcessingException.class, () -> textConversionUtil.convertJsonToXml(json));

        // THEN
        assertEquals("Unrecognized token 'value'", exception.getMessage());
    }
}
