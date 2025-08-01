package com.example.textapi.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
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
    void reverse_givenNormalString_returnsReversedString() {
        // GIVEN
        String input = "abcde";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("edcba", result);
    }

    @Test
    void reverse_givenEmptyString_returnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void uppercase_givenMixedCaseString_returnsUppercaseString() {
        // GIVEN
        String input = "AbCdEf";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("ABCDEF", result);
    }

    @Test
    void uppercase_givenEmptyString_returnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void stats_givenNormalString_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(22, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(7, stats.get("VowelCount"));
        assertEquals(8, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.contains("hello : 2"));
    }

    @Test
    void stats_givenEmptyString_returnsZeroStats() {
        // GIVEN
        String input = "";

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount")); // split on whitespace returns array with one empty string
        assertEquals(1, stats.get("lineCount")); // split on \n returns array with one empty string
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void stats_givenNullInput_returnsZeroStats() {
        // GIVEN
        String input = null;

        // WHEN
        Map<String, Object> stats = textService.stats(input);

        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenStringWithRepeatedWords_returnsListOfRepeatedWords() {
        // GIVEN
        String input = "Test test TEST example example test";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.contains("test : 3"));
        assertTrue(repeatedWords.contains("example : 2"));
        assertEquals(2, repeatedWords.size());
    }

    @Test
    void getRepeatedWords_givenStringWithNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "unique words only";

        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);

        // THEN
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void getRepeatedWords_givenNullOrEmptyInput_returnsEmptyList() {
        // GIVEN
        String inputNull = null;
        String inputEmpty = "";

        // WHEN
        List<String> resultNull = textService.getRepeatedWords(inputNull);
        List<String> resultEmpty = textService.getRepeatedWords(inputEmpty);

        // THEN
        assertTrue(resultNull.isEmpty());
        assertTrue(resultEmpty.isEmpty());
    }

    @Test
    void getConsonantCount_givenEmptyString_returnsZero() {
        // GIVEN
        String input = "";

        // WHEN
        int count = textService.getConsonantCount(input);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void getConsonantCount_givenString_returnsCorrectCount() {
        // GIVEN
        String input = "Hello World!";

        // WHEN
        int count = textService.getConsonantCount(input);

        // THEN
        assertEquals(7, count);
    }

    @Test
    void getVowelCount_givenString_returnsCorrectCount() {
        // GIVEN
        String input = "Hello World!";

        // WHEN
        int count = textService.getVowelCount(input);

        // THEN
        assertEquals(3, count);
    }

    @Test
    void getVowelCount_givenEmptyString_returnsZero() {
        // GIVEN
        String input = "";

        // WHEN
        int count = textService.getVowelCount(input);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void replace_givenString_replacesTargetWithReplacement() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("Hello Java", result);
    }

    @Test
    void replace_givenStringWithNoTarget_returnsOriginalString() {
        // GIVEN
        String input = "Hello World";
        String target = "Python";
        String replacement = "Java";

        // WHEN
        String result = textService.replace(input, target, replacement);

        // THEN
        assertEquals("Hello World", result);
    }

    @Test
    void removeVowels_givenString_removesAllVowels() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("Hll Wrld", result);
    }

    @Test
    void removeVowels_givenEmptyString_returnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void removeConsonants_givenString_removesAllConsonants() {
        // GIVEN
        String input = "Hello World";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("eo o", result);
    }

    @Test
    void removeConsonants_givenEmptyString_returnsEmptyString() {
        // GIVEN
        String input = "";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals("", result);
    }

    @Test
    void countOccurrence_givenStringAndKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Java is great. I love Java. JAVA is powerful.";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(3, count);
    }

    @Test
    void countOccurrence_givenStringWithNoKeyword_returnsZero() {
        // GIVEN
        String input = "No matching words here.";
        String keyword = "java";

        // WHEN
        int count = textService.countOccurrence(input, keyword);

        // THEN
        assertEquals(0, count);
    }

    @Test
    void helloworld_returnsHelloWorldString() {
        // GIVEN no setup needed

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void convertJsonToYaml_givenValidJson_returnsYamlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void convertJsonToYaml_givenInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{invalid json}";

        // WHEN
        String yaml = textService.convertJsonToYaml(json);

        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void convertJsonToXml_givenValidJson_returnsXmlString() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void convertJsonToXml_givenInvalidJson_returnsErrorMessage() {
               // GIVEN
        String json = "{invalid json}";

        // WHEN
        String xml = textService.convertJsonToXml(json);

        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML:"));
    }
}
