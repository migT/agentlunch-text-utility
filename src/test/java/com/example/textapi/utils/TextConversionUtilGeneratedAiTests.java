package com.example.textapi.utils;

import org.junit.jupiter.api.BeforeAll;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextConversionUtilGeneratedAiTests {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private TextConversionUtil textConversionUtil;

    @BeforeEach
    public void setUp() {
        // Reset any state before each test
    }

    @Test
    public void testConvertJsonToYaml() {
        // GIVEN
        String json = "{\"name\": \"John\", \"age\": 30}";
        JsonNode jsonNode = new ObjectMapper().readTree(json);
        when(objectMapper.readTree(json)).thenReturn(jsonNode);

        // WHEN
        String result = textConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }

    @Test
    public void testConvertJsonToXml() {
        // GIVEN
        String json = "{\"name\": \"John\", \"age\": 30}";
        JsonNode jsonNode = new ObjectMapper().readTree(json);
        when(objectMapper.readTree(json)).thenReturn(jsonNode);

        // WHEN
        String result = textConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }
}
