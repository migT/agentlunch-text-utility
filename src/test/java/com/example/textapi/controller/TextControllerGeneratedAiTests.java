package com.example.textapi.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    public void setUp() {
        // Reset any modified state before each test
    }

    @Test
    public void testHelloWorld() {
        // GIVEN: No preconditions needed for this method

        // WHEN: Call the helloWorld method
        String result = textController.helloWorld();

        // THEN: Verify the expected outcome
        assertThat(result).isEqualTo(TextService.HELLO_WORLD);
    }

    @Test
    public void testReverse() {
        // GIVEN: A sample input string for testing
        String input = "Hello, World!";

        // WHEN: Call the reverse method with the given input
        String result = textController.reverse(input);

        // THEN: Verify the expected outcome
        assertThat(result).isEqualTo(new StringBuilder(input).reverse().toString());
    }

    @Test
    public void testUppercase() {
        // GIVEN: A sample input string for testing
        String input = "hello, world!";

        // WHEN: Call the uppercase method with the given input
        String result = textController.uppercase(input);

        // THEN: Verify the expected outcome
        assertThat(result).isEqualTo(input.toUpperCase());
    }

    @Test
    public void testStats() {
        // GIVEN: A sample input string for testing
        String input = "Hello, World! This is a test.";

        // WHEN: Call the stats method with the given input
        Map<String, Object> result = textController.stats(input);

        // THEN: Verify the expected outcome
        assertThat(result).containsEntry("length", 31);
        assertThat(result).containsEntry("wordCount", 5);
        assertThat(result).containsEntry("lineCount", 1);
    }

    @Test
    public void testReplace() {
        // GIVEN: Sample input strings for testing
        String target = "World";
        String replacement = "Universe";
        String input = "Hello, World! This is a test.";

        // WHEN: Call the replace method with the given inputs
        String result = textController.replace(target, replacement, input);

        // THEN: Verify the expected outcome
        assertThat(result).isEqualTo(input.replace(target, replacement));
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN: A sample input string for testing
        String input = "Hello, World! This is a test.";

        // WHEN: Call the removeVowels method with the given input
        String result = textController.removeVowels(input);

        // THEN: Verify the expected outcome
        assertThat(result).isEqualTo(TextService.removePattern(input, TextService.VOWEL_PATTERN));
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN: A sample input string for testing
        String input = "Hello, World! This is a test.";

        // WHEN: Call the removeConsonants method with the given input
        String result = textController.removeConsonants(input);

        // THEN: Verify the expected outcome
        assertThat(result).isEqualTo(TextService.removePattern(input, TextService.consonantPattern));
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN: Sample input strings for testing
        String keyword = "World";
        String input = "Hello, World! This is a test. World again.";

        // WHEN: Call the countOccurrence method with the given inputs
        int result = textController.countOccurrence(keyword, input);

        // THEN: Verify the expected outcome
        assertThat(result).isEqualTo(input.split("(?i)\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1);
    }

    @Test
    public void testJsonToYaml() {
        // GIVEN: A sample JSON string for testing
        String json = "{\"key\":\"value\"}";

        // WHEN: Call the jsonToYaml method with the given input
        String result = textController.jsonToYaml(json);

        // THEN: Verify the expected outcome (Note: YAML output may vary)
        assertThat(result).isNotNull();
    }

    @Test
    public void testJsonToXml() {
        // GIVEN: A sample JSON string for testing
       String json = "{\"key\":\"value\"}".replaceFirst("^\\uFEFF", "");

// WHEN: Call the jsonToXml method with the given input
String result = textController.jsonToXml(json);

// THEN: Verify the expected outcome
assertThat(result).isNotNull();

json = "{\"key\":\"value\"}
