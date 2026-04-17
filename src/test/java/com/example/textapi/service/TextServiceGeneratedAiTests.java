package com.example.textapi.service;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void reverse_ShouldReturnReversedString() {
        // GIVEN
        String input = "abc";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("cba", result);
    }

    @Test
    void reverse_WithEmptyString_ShouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void uppercase_ShouldConvertToUpperCase() {
        // GIVEN
        String input = "hello";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("HELLO", result);
    }

    @Test
    void uppercase_WithEmptyString_ShouldReturnEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void replace_ShouldReplaceTargetWithReplacement() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("hello there", result);
    }

    @Test
    void replace_WithEmptyReplacement_ShouldRemoveTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("hello ", result);
    }

    @Test
    void removeVowels_ShouldRemoveAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeConsonants_ShouldRemoveAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void countOccurrence_ShouldCountCaseInsensitiveOccurrences() {
        // GIVEN
        String input = "test Test testing";
        String keyword = "test";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(2, count);
    }

    @Test
    void helloworld_ShouldReturnHelloWorldString() {
        // GIVEN

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void convertJsonToYaml_WithValidJson_ShouldReturnYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertNotNull(yaml);
        assertTrue(yaml.contains("name:") && yaml.contains("age:"));
    }

    @Test
    void convertJsonToYaml_WithInvalidJson_ShouldReturnErrorMessage() {
        // GIVEN
        String json = "{name:\"John\",age:30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_WithValidJson_ShouldReturnXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_WithInvalidJson_ShouldReturnErrorMessage() {
        // GIVEN
        String json = "{name:\"John\",age:30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void stats_ShouldReturnCorrectStatistics() {
        // GIVEN
        String input = "Hello world\nHello";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(17, stats.get("length"));
        assertEquals(3, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(5, stats.get("VowelCount"));
        assertEquals(10, stats.get("ConsonantCount"));
        @SuppressWarnings("unchecked")
        List<String> repeated = (List<String>) stats.get("RepeatedWords");
        assertNotNull(repeated);
        assertEquals(1, repeated.size());
        assertEquals("hello : 2", repeated.get(0));
    }
}