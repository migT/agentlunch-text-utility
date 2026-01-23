package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TextConversionUtilGeneratedAiTests {

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        // Reset the ObjectMapper instance for each test
        objectMapper = new ObjectMapper();
    }

    @Test
    public void convertJsonToYaml_GivenValidJson_WhenConverted_ReturnsCorrectYaml() throws JsonProcessingException {
        // GIVEN: A valid JSON string
        String json = "{\"key\":\"value\"}";

        // WHEN: Converting the JSON to YAML using TextConversionUtil.convertJsonToYaml()
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The resulting YAML should match the expected output
        assertThat(yaml).isEqualTo("key: value");
    }

    @Test
    public void convertJsonToXml_GivenValidJson_WhenConverted_ReturnsCorrectXml() throws JsonProcessingException {
        // GIVEN: A valid JSON string
        String json = "{\"key\":\"value\"}";

        // WHEN: Converting the JSON to XML using TextConversionUtil.convertJsonToXml()
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The resulting XML should match the expected output
        assertThat(xml).isEqualTo("<root><key>value</key></root>");
    }

    @Test
    public void convertJsonToYaml_GivenInvalidJson_WhenConverted_ReturnsError() {
        // GIVEN: An invalid JSON string (not a valid JSON object)
        String json = "invalid json";

        // WHEN: Converting the JSON to YAML using TextConversionUtil.convertJsonToYaml()
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The resulting YAML should be an error message
        assertThat(yaml).isEqualTo("Error converting JSON to YAML: org.json.JSONException: Unterminated object");
    }

    @Test
    public void convertJsonToXml_GivenInvalidJson_WhenConverted_ReturnsError() {
        // GIVEN: An invalid JSON string (not a valid JSON object)
        String json = "invalid json";

        // WHEN: Converting the JSON to XML using TextConversionUtil.convertJsonToXml()
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The resulting XML should be an error message
        assertThat(xml).isEqualTo("Error converting JSON to XML: org.json.JSONException: Unterminated object");
    }
}
