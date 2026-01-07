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
    void convertJsonToYaml_shouldConvertValidJsonToYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertThat(yaml).contains("name: \"John\"").contains("age: 30");
    }

    @Test
    void convertJsonToYaml_shouldReturnErrorMessageForInvalidJson() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void convertJsonToYaml_shouldHandleEmptyJson() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String result = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to YAML:");
    }

    @Test
    void convertJsonToXml_shouldConvertValidJsonToXml() {
        // GIVEN
        String json = "{\"name\":\"Alice\",\"age\":25}";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertThat(xml).contains("<name>Alice</name>").contains("<age>25</age>");
    }

    @Test
    void convertJsonToXml_shouldReturnErrorMessageForInvalidJson() {
        // GIVEN
        String invalidJson = "{name:Alice,age:25}";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to XML:");
    }

    @Test
    void convertJsonToXml_shouldHandleEmptyJson() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String result = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertThat(result).startsWith("Error converting JSON to XML:");
    }

    @Test
    void convertJsonToYaml_shouldConvertJsonArray() {
        // GIVEN
        String jsonArray = "[{\"id\":1,\"val\":\"a\"},{\"id\":2,\"val\":\"b\"}]";

        // WHEN
        String yaml = TextConversionUtil.convertJsonToYaml(jsonArray);

        // THEN
        assertThat(yaml).contains("- id: 1").contains("val: \"a\"").contains("- id: 2").contains("val: \"b\"");
    }

    @Test
    void convertJsonToXml_shouldConvertJsonArray() {
        // GIVEN
        String jsonArray = "[{\"id\":1,\"val\":\"a\"},{\"id\":2,\"val\":\"b\"}]";

        // WHEN
        String xml = TextConversionUtil.convertJsonToXml(jsonArray);

        // THEN
        assertThat(xml).contains("<id>1</id>").contains("<val>a</val>").contains("<id>2</id>").contains("<val>b</val>");
    }
}
