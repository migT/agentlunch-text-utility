package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TextConversionUtilGeneratedAiTests {

    private ObjectMapper objectMapper = mock(ObjectMapper.class);
    private YAMLMapper yamlMapper = mock(YAMLMapper.class);
    private XmlMapper xmlMapper = mock(XmlMapper.class);

    @BeforeEach
    public void setup() {
        when(objectMapper.readTree(mock(JsonNode.class))).thenReturn(mock(JsonNode.class));
        when(yamlMapper.writeValueAsString(mock(JsonNode.class))).thenReturn("yaml");
        when(xmlMapper.writeValueAsString(mock(JsonNode.class))).thenReturn("xml");
    }

    @Test
    public void testConvertJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(result).isEqualTo("yaml");
    }

    @Test
    public void testConvertJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(result).isEqualTo("xml");
    }
}
