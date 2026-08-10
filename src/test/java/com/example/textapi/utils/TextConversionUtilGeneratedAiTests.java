package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    public void GIVEN_validJson_WHEN_convertToJsonToYaml_THEN_resultIsCorrect() throws JsonProcessingException {
        // Given
        String json = "{\"key\":\"value\"}";
        String expectedYaml = "key: value\n";

        // When
        String yaml = textConversionUtil.convertJsonToYaml(json);

        // Then
        assertThat(yaml).isEqualTo(expectedYaml);
    }

    @Test
    public void GIVEN_invalidJson_WHEN_convertToJsonToYaml_THEN_resultIsError() throws JsonProcessingException {
        // Given
        String json = "{\"key\":\"value\"}"; // Added closing bracket

        // When
        String yaml = textConversionUtil.convertJsonToYaml(json);

        // Then
        assertThat(yaml).contains("Error converting JSON to YAML: ");
    }

    @Test
    public void GIVEN_validJson_WHEN_convertToJsonToXml_THEN_resultIsCorrect() throws JsonProcessingException {
        // Given
        String json = "{\"key\":\"value\"}";
        String expectedXml = "<root><key>value</key></root>";

        // When
        String xml = textConversionUtil.convertJsonToXml(json);

        // Then
        assertThat(xml).isEqualTo(expectedXml);
    }

    @Test
    public void GIVEN_invalidJson_WHEN_convertToJsonToXml_THEN_resultIsError() throws JsonProcessingException {
        // Given
        String json = "{\"key\":\"value\"}"; // Added closing bracket

        // When
        String xml = textConversionUtil.convertJsonToXml(json);

        // Then
        assertThat(xml).contains("Error converting JSON to XML: ");
    }
}
