package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil;

    @BeforeEach
    public void setup() {
        textConversionUtil = new TextConversionUtil();
    }

    @Test
    public void convertJsonToYaml_GivenValidJson_WhenConverted_ThenResultIsYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        // WHEN
        String result = textConversionUtil.convertJsonToYaml(json);
        // THEN
        assertThat(result).isNotEmpty();
    }

    @Test
    public void convertJsonToXml_GivenValidJson_WhenConverted_ThenResultIsXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        // WHEN
        String result = textConversionUtil.convertJsonToXml(json);
        // THEN
        assertThat(result).isNotEmpty();
    }

    @Test
    public void convertJsonToYaml_GivenInvalidJson_WhenConverted_ThenResultIsError() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textConversionUtil.getJsonNode(json)).thenThrow(new JsonProcessingException("Mocked exception"));
        // WHEN
        String result = textConversionUtil.convertJsonToYaml(json);
        // THEN
        assertThat(result).contains("Error converting JSON to YAML: Mocked exception");
    }

    @Test
    public void convertJsonToXml_GivenInvalidJson_WhenConverted_ThenResultIsError() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textConversionUtil.getJsonNode(json)).thenThrow(new JsonProcessingException("Mocked exception"));
        // WHEN
        String result = textConversionUtil.convertJsonToXml(json);
        // THEN
        assertThat(result).contains("Error converting JSON to XML: Mocked exception");
    }
}
