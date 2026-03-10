package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // No state to reset for this utility class
    }

    @Test
    void convertJsonToYaml_withSimpleJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).contains("name: John");
        assertThat(yaml).contains("age: 30");
    }

    @Test
    void convertJsonToXml_withSimpleJson_returnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).contains("<name>John</name>");
        assertThat(xml).contains("<age>30</age>");
    }

    @Test
    void convertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "invalid";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void convertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String invalidJson = "invalid";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to XML:");
    }

    @Test
    void convertJsonToYaml_withNestedJson_returnsYamlString() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"Alice\",\"details\":{\"age\":25,\"city\":\"NY\"}}}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).contains("person:");
        assertThat(yaml).contains("name: Alice");
        assertThat(yaml).contains("age: 25");
        assertThat(yaml).contains("city: NY");
    }

    @Test
    void convertJsonToXml_withNestedJson_returnsXmlString() {
        // GIVEN
        String json = "{\"person\":{\"name\":\"Alice\",\"details\":{\"age\":25,\"city\":\"NY\"}}}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).contains("<person>");
        assertThat(xml).contains("<name>Alice</name>");
        assertThat(xml).contains("<age>25</age>");
        assertThat(xml).contains("<city>NY</city>");
    }

    @Test
    void convertJsonToYaml_withArrayJson_returnsYamlString() {
        // GIVEN
        String json = "{\"items\":[1,2,3]}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).contains("items:");
        assertThat(yaml).contains("- 1");
        assertThat(yaml).contains("- 2");
        assertThat(yaml).contains("- 3");
    }

    @Test
    void convertJsonToXml_withArrayJson_returnsXmlString() {
        // GIVEN
        String json = "{\"items\":[1,2,3]}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).contains("<items>");
        assertThat(xml).contains("<item>1</item>");
        assertThat(xml).contains("<item>2</item>");
        assertThat(xml).contains("<item>3</item>");
    }
}
