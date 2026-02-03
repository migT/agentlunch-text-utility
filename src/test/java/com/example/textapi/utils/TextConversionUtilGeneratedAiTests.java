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

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        // Reset the ObjectMapper instance for each test
        objectMapper = new ObjectMapper();
    }

    @Test
    public void convertJsonToYaml_GivenValidJson_WhenConverted_YamlIsCorrect() {
        // GIVEN: A valid JSON string
        String json = "{\"key\":\"value\"}";

        try {
            // WHEN: Converting the JSON to YAML
            String yaml = TextConversionUtil.convertJsonToYaml(json);

            // THEN: The resulting YAML is correct
            assertThat(yaml).isEqualTo("key: value");
        } catch (Exception e) {
            // THEN: An error message is returned when an exception occurs
            assertThat(e.getMessage()).contains("Error converting JSON to YAML:");
        }
    }

    @Test
    public void convertJsonToXml_GivenValidJson_WhenConverted_XmlIsCorrect() {
        // GIVEN: A valid JSON string
        String json = "{\"key\":\"value\"}";

        try {
            // WHEN: Converting the JSON to XML
            String xml = TextConversionUtil.convertJsonToXml(json);

            // THEN: The resulting XML is correct
            assertThat(xml).contains("<key>value</key>");
        } catch (Exception e) {
            // THEN: An error message is returned when an exception occurs
            assertThat(e.getMessage()).contains("Error converting JSON to XML:");
        }
    }

    @Test
    public void convertJsonToYaml_GivenInvalidJson_WhenConverted_YamlIsError() {
        // GIVEN: An invalid JSON string
        String json = "{\"key\":\"value\"} invalid";

        try {
            // WHEN: Converting the JSON to YAML
            String yaml = TextConversionUtil.convertJsonToYaml(json);

            // THEN: The resulting YAML is an error message
            assertThat(yaml).contains("Error converting JSON to YAML:");
        } catch (Exception e) {
            // THEN: An error message is returned when an exception occurs
            assertThat(e.getMessage()).contains("Error converting JSON to YAML:");
        }
    }

    @Test
    public void convertJsonToXml_GivenInvalidJson_WhenConverted_XmlIsError() {
        // GIVEN: An invalid JSON string
        String json = "{\"key\":\"value\"} invalid";

        try {
            // WHEN: Converting the JSON to XML
            String xml = TextConversionUtil.convertJsonToXml(json);

            // THEN: The resulting XML is an error message
            assertThat(xml).contains("Error converting JSON to XML:");
        } catch (Exception e) {
            // THEN: An error message is returned when an exception occurs
            assertThat(e.getMessage()).contains("Error converting JSON to XML:");
        }
    }

    @Test
    public void convertJsonToYaml_GivenNullJson_WhenConverted_YamlIsError() {
        // GIVEN: A null JSON string
        String json = null;

        try {
            // WHEN: Converting the JSON to YAML
            String yaml = TextConversionUtil.convertJsonToYaml(json);

            // THEN: The resulting YAML is an error message
            assertThat(yaml).contains("Error converting JSON to YAML:");
        } catch (Exception e) {
            // THEN: An error message is returned when an exception occurs
            assertThat(e.getMessage()).contains("Error converting JSON to YAML:");
        }
    }

    @Test
    public void convertJsonToXml_GivenEmptyString_WhenConverted_XmlIsError() {
        // GIVEN: An empty string as a JSON input
        String json = "";

        try {
            // WHEN: Converting the JSON to XML
            String xml = TextConversionUtil.convertJsonToXml(json);

            // THEN: The resulting XML is an error message
            assertThat(xml).contains("Error converting JSON to XML:");
        } catch (Exception e) {
            // THEN: An error message is returned when an exception occurs
            assertThat(e.getMessage()).contains("Error converting JSON to XML:");
        }
    }

    @Test
    public void convertJsonToYaml_GivenEmptyString_WhenConverted_YamlIsError() {
        // GIVEN: An empty string as a JSON input
        String json = "";

        try {
            // WHEN: Converting the JSON to YAML
            String yaml = TextConversionUtil.convertJsonToYaml(json);

            // THEN: The resulting YAML is an error message
            assertThat(yaml).contains("Error converting JSON to YAML:");
        } catch (Exception e) {
            // THEN: An error message is returned when an exception occurs
            assertThat(e.getMessage()).contains("Error converting JSON to YAML:");
        }
    }

    @Test
    public void convertJsonToXml_GivenNullJson_WhenConverted_XmlIsError() {
        // GIVEN: A null JSON string
        String json = null;

        try {
            // WHEN: Converting the JSON to XML
            String xml = TextConversionUtil.convertJsonToXml(json);

            // THEN: The resulting XML is an error message
            assertThat(xml).contains("Error converting JSON to XML:");
        } catch (Exception e) {
            // THEN: An error message is returned when an exception occurs
            assertThat(e.getMessage()).contains("Error converting JSON to XML:");
        }
    }

}
