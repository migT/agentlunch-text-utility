package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TextConversionUtilGeneratedAiTests {

    @Mock
    private ObjectMapper objectMapperMock;

    private JsonNode jsonNode = mock(JsonNode.class);

    @BeforeEach
    public void setup() {
        when(objectMapperMock.readTree(any())).thenReturn(jsonNode);
    }

    @Test
    public void testConvertJsonToYaml_GivenValidJson_WhenConverted_ThenReturnsYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        
        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);
        
        // THEN
        assertThat(yaml).isNotEmpty();
    }

    @Test
    public void testConvertJsonToXml_GivenValidJson_WhenConverted_ThenReturnsXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        
        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);
        
        // THEN
        assertThat(xml).isNotEmpty();
    }

    @Test
    public void testConvertJsonToYaml_GivenInvalidJson_WhenConverted_ThenReturnsError() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(objectMapperMock.readTree(any())).thenThrow(new JsonProcessingException("Invalid JSON", null));
        
        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);
        
        // THEN
        assertThatThrownBy(() -> TextConversionUtil.convertJsonToYaml(json)).isInstanceOf(JsonProcessingException.class)
                .hasMessageContaining("Invalid JSON");
    }

    @Test
    public void testConvertJsonToXml_GivenInvalidJson_WhenConverted_ThenReturnsError() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(objectMapperMock.readTree(any())).thenThrow(new JsonProcessingException("Invalid JSON", null));
        
        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);
        
        // THEN
        assertThatThrownBy(() -> TextConversionUtil.convertJsonToXml(json)).isInstanceOf(JsonProcessingException.class)
                .hasMessageContaining("Invalid JSON");
    }
}
