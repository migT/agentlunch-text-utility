package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class TextServiceGeneratedAiTests {

    private TextService textService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        textService = Mockito.createMock(TextService.class);
        objectMapper = Mockito.createMock(ObjectMapper.class);
    }

    @Test
    void reverse_shouldReverseString() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String reversed = textService.reverse(input);
        // THEN
        assertEquals("!dlroW ,olleH", reversed);
    }

    @Test
    void uppercase_shouldReturnUppercaseString() {
        // GIVEN
        String input = "hello, world!";
        // WHEN
        String uppercase = textService.uppercase(input);
        // THEN
        assertEquals("HELLO, WORLD!", uppercase);
    }

    @Test
    void stats_shouldReturnStatsMap() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(7, stats.size());
        assertEquals(13, stats.get("length"));
        assertEquals(2, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(3, stats.get("VowelCount"));
        assertEquals(3, stats.get("ConsonantCount"));
        assertEquals(1, stats.get("RepeatedWords").size());
    }

    @Test
    void getLength_shouldReturnCorrectLength() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        Integer length = textService.getLength(input);
        // THEN
        assertEquals(13, length);
    }

    @Test
    void getSplitCount_shouldReturnCorrectCount() {
        // GIVEN
        String input = "Hello, World!";
        String splitRegex = "\\s+";
        // WHEN
        Integer count = textService.getSplitCount(input, splitRegex);
        // THEN
        assertEquals(2, count);
    }

    @Test
    void getRepeatedWords_shouldReturnRepeatedWordsList() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        // WHEN
        List<String> repeatedWords = textService.getRepeatedWords(input);
        // THEN
        assertEquals(2, repeatedWords.size());
        assertEquals("Hello, World! : 2", repeatedWords.get(0));
        assertEquals("Hello, World! : 2", repeatedWords.get(1));
    }

    @Test
    void getConsonantCount_shouldReturnCorrectConsonantCount() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        Integer consonantCount = textService.getConsonantCount(input);
        // THEN
        assertEquals(6, consonantCount);
    }

    @Test
    void getVowelCount_shouldReturnCorrectVowelCount() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        Integer vowelCount = textService.getVowelCount(input);
        // THEN
        assertEquals(3, vowelCount);
    }

    @Test
    void replace_shouldReplaceTargetWithReplacement() {
        // GIVENjava
        // WHEN
        String replaced = textService.replace(input, "World", "Universe");
        // THEN
        assertEquals("Hello, Universe!", replaced);
    }

    @Test
    void removeVowels_shouldRemoveVowels() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Hll, Wrld!", result);
    }

    @Test
    void removeConsonants_shouldRemoveConsonants() {
        // GIVEN
        String input = "Hello, World!";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("Heoo, Wrld!", result);
    }

    @Test
    void removePattern_shouldRemovePattern() {
        // GIVEN
        String input = "Hello, World!";
        String regex = "[aeiou]";
        // WHEN
        String result = textService.removePattern(input, regex);
        // THEN
        assertEquals("Hll, Wrld!", result);
    }

    @Test
    void countOccurrence_shouldReturnCorrectOccurrenceCount() {
        // GIVEN
        String input = "Hello, World!";
        String keyword = "World";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(1, count);
    }

    @Test
    void helloworld_shouldReturnHelloWorld() {
        // GIVEN
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void convertJsonToYaml_shouldConvertJsonToYaml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertEquals("""
                name: John
                age: 30
                """, yaml);
    }

    @Test
    void convertJsonToXml_shouldConvertJsonToXml() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertEquals("""
                <root>
                    <name>John</name>
                    <age>30</age>
                </root>
                """, xml);
    }
}