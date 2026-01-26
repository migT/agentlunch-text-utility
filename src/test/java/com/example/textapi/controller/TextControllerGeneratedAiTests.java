package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.textapi.service.TextService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    private TextService textServiceMock;
    private TextController controller;

    @BeforeEach
    public void setup() {
        textServiceMock = mock(TextService.class);
        controller = new TextController(textServiceMock);
    }

    @Test
    public void testHelloWorld() {
        // GIVEN: No preconditions needed

        // WHEN: Call the helloWorld method
        String result = controller.helloWorld();

        // THEN: Verify that the correct response is returned
        assertThat(result).isEqualTo(TextService.HELLO_WORLD);
    }

    @Test
    public void testReverse() {
        // GIVEN: A sample input string
        String input = "Hello, World!";

        // WHEN: Call the reverse method with the input string
        when(textServiceMock.reverse(anyString())).thenReturn("dlroW ,olleH");

        String result = controller.reverse(input);

        // THEN: Verify that the correct reversed string is returned
        assertThat(result).isEqualTo("dlroW ,olleH");
    }

    @Test
    public void testUppercase() {
        // GIVEN: A sample input string
        String input = "hello, world!";

        // WHEN: Call the uppercase method with the input string
        when(textServiceMock.uppercase(anyString())).thenReturn("HELLO, WORLD!");

        String result = controller.uppercase(input);

        // THEN: Verify that the correct uppercased string is returned
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats() {
        // GIVEN: A sample input string with some stats
        String input = "Hello, World! This is a sample text.";

        // WHEN: Call the stats method with the input string
        when(textServiceMock.stats(anyString())).thenReturn(Map.of(
                "length", 31,
                "wordCount", 5,
                "lineCount", 1,
                "VowelCount", 7,
                "ConsonantCount", 12,
                "RepeatedWords", List.of("This : 2")
        ));

        Map<String, Object> result = controller.stats(input);

        // THEN: Verify that the correct stats map is returned
        assertThat(result).isEqualTo(Map.of(
                "length", 31,
                "wordCount", 5,
                "lineCount", 1,
                "VowelCount", 7,
                "ConsonantCount", 12,
                "RepeatedWords", List.of("This : 2")
        ));
    }

    @Test
    public void testReplace() {
        // GIVEN: A sample input string and replacement values
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Earth";

        // WHEN: Call the replace method with the input string and replacement values
        when(textServiceMock.replace(anyString(), anyString(), anyString())).thenReturn("Hello, Earth!");

        String result = controller.replace(target, replacement, input);

        // THEN: Verify that the correct replaced string is returned
        assertThat(result).isEqualTo("Hello, Earth!");
    }

    @Test
    public void testRemoveVowels() {
        // GIVEN: A sample input string with vowels
        String input = "aeiou";

        // WHEN: Call the removeVowels method with the input string
        when(textServiceMock.removeVowels(anyString())).thenReturn("");

        String result = controller.removeVowels(input);

        // THEN: Verify that the correct string without vowels is returned
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testRemoveConsonants() {
        // GIVEN: A sample input string with consonants
        String input = "bcdfghjklmnpqrstvwxyz";

        // WHEN: Call the removeConsonants method with the input string
        when(textServiceMock.removeConsonants(anyString())).thenReturn("");

        String result = controller.removeConsonants(input);

        // THEN: Verify that the correct string without consonants is returned
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testCountOccurrence() {
        // GIVEN: A sample input string and keyword
        String input = "Hello, World! Hello again!";
        String keyword = "Hello";

        // WHEN: Call the countOccurrence method with the input string and keyword
        when(textServiceMock.countOccurrence(anyString(), anyString())).thenReturn(2);

        int result = controller.countOccurrence(keyword, input);

        // THEN: Verify that the correct occurrence count is returned
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testJsonToYaml() {
        // GIVEN: A sample JSON string
        String json = "{\"key\":\"value\"}";

        // WHEN: Call the jsonToYaml method with the JSON string
        when(textServiceMock.convertJsonToYaml(anyString())).thenReturn("key: value");

        String result = controller.jsonToYaml(json);

        // THEN: Verify that the correct YAML string is returned
        assertThat(result).isEqualTo("key: value");
    }

    @Test
    public void testJsonToXml() {
        // GIVEN: A sample JSON string
        String json = "{\"key\":\"value\"}";

        // WHEN: Call the jsonToXml method with the JSON string
        when(textServiceMock.convertJsonToXml(anyString())).thenReturn("<root><key>value</key></root>");

        String result = controller.jsonToXml(json);

        // THEN: Verify that the correct XML string is returned
        assertThat(result).isEqualTo("<root><key>value</key></root>");
    }
}
