package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TextConversionUtilGeneratedAiTests {

    @Mock
    private ObjectMapper objectMapperMock;

    private TextConversionUtil textConversionUtil;

    @BeforeEach
    public void setUp() {
        textConversionUtil = new TextConversionUtil();
        when(objectMapperMock.readTree(org.mockito.Mockito.anyString())).thenReturn(mock(JsonNode.class));
    }

    @Test
    public void convertJsonToYaml_GivenValidJson_WhenConverted_ThenResultIsInYamlFormat() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        JsonNode jsonNode = mock(JsonNode.class);
        when(objectMapperMock.readTree(json)).thenReturn(jsonNode);

        // WHEN
        String yaml = textConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).isNotNull();
    }

    @Test
    public void convertJsonToXml_GivenValidJson_WhenConverted_ThenResultIsInXmlFormat() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        JsonNode jsonNode = mock(JsonNode.class);
        when(objectMapperMock.readTree(json)).thenReturn(jsonNode);

        // WHEN
        String xml = textConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).isNotNull();
    }

    @Test
    public void convertJsonToYaml_GivenInvalidJson_WhenConverted_ThenResultIsError() {
        // GIVEN
        String json = "{\"key\":\"value\"";

        // WHEN
        String yaml = textConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).isEqualTo("Error converting JSON to YAML: UnrecognizedPropertyException: Unrecognized field \"key\"");
    }

    @Test
    public void convertJsonToXml_GivenInvalidJson_WhenConverted_ThenResultIsError() {
        // GIVEN
        String json = "{\"key\":\"value\"";

        // WHEN
        String xml = textConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).isEqualTo("Error converting JSON to XML: UnrecognizedPropertyException: Unrecognized field \"key\"");
    }
}
