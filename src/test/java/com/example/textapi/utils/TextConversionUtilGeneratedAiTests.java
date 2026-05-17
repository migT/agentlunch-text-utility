package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

public class TextConversionUtilGeneratedAiTests {

    @Mock
    private JsonNode jsonNode;

    @BeforeEach
    public void setup() {
        when(jsonNode.toString()).thenReturn("{\"key\":\"value\"}");
    }

    @Test
    public void convertJsonToYaml_GivenValidJson_WhenConverted_ThenResultIsYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        TextConversionUtil textConversionUtil = new TextConversionUtil();
        String result = textConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(result).isNotNull().contains("key: value");
    }

    @Test
    public void convertJsonToXml_GivenValidJson_WhenConverted_ThenResultIsXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        TextConversionUtil textConversionUtil = new TextConversionUtil();
        String result = textConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(result).isNotNull().contains("<key>value</key>");
    }
}
