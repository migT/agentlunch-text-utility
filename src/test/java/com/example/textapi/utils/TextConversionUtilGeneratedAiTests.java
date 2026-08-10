package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TextConversionUtilGeneratedAiTests {

    private TextConversionUtil textConversionUtil = mock(TextConversionUtil.class);

    @BeforeEach
    public void setUp() {
        // Reset any modified state before each test
    }

    @Test
    public void convertJsonToYaml_GivenValidJson_WhenConverted_YamlIsReturned() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        JsonNode jsonNode = new ObjectMapper().readValue(json, JsonNode.class);
        when(textConversionUtil.getJsonNode(json)).thenReturn(jsonNode);

        // WHEN
        String yaml = textConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).isNotNull();
    }

    @Test
    public void convertJsonToXml_GivenValidJson_WhenConverted_XmlIsReturned() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        JsonNode jsonNode = new ObjectMapper().readValue(json, JsonNode.class);
        when(textConversionUtil.getJsonNode(json)).thenReturn(jsonNode);

        // WHEN
        String xml = textConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).isNotNull();
    }

    @Test
    public void convertJsonToYaml_GivenInvalidJson_WhenConverted_ErrorMessageIsReturned() {
        // GIVEN
        String json = "{\"key\":\"value\"} invalid";

        // WHEN
        String yaml = textConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).contains("Error converting JSON to YAML:");
    }

    @Test
    public void convertJsonToXml_GivenInvalidJson_WhenConverted_ErrorMessageIsReturned() {
        // GIVEN
        String json = "{\"key\":\"value\"} invalid";

        // WHEN
        String xml = textConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).contains("Error converting JSON to XML:");
    }
}
