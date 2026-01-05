package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset as all methods are static and stateless
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).contains("name: \"John\"").contains("age: 30");
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).contains("<name>John</name>").contains("<age>30</age>");
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to XML:");
    }

    @Test
    void givenEmptyJson_whenConvertJsonToYaml_thenReturnsYaml() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertThat(yaml.trim()).isEqualTo("{}");
    }

    @Test
    void givenEmptyJson_whenConvertJsonToXml_thenReturnsXml() {
        // GIVEN
        String emptyJson = "{}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertThat(xml.trim()).isEqualTo("<ObjectNode/>");
    }

    @Test
    void givenJsonArray_whenConvertJsonToYaml_thenReturnsYamlArray() {
        // GIVEN
        String jsonArray = "[{\"id\":1},{\"id\":2}]";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(jsonArray);

        // THEN
        assertThat(yaml).contains("- id: 1").contains("- id: 2");
    }

    @Test
    void givenJsonArray_whenConvertJsonToXml_thenReturnsXmlArray() {
        // GIVEN
        String jsonArray = "[{\"id\":1},{\"id\":2}]";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(jsonArray);

        // THEN
        assertThat(xml).contains("<ArrayNode>").contains("<id>1</id>").contains("<id>2</id>");
    }
}
