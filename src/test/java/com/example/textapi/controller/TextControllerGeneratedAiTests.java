package com.example.textapi.controller;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.angka.util.TestParameterUtils;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(TextControllerGeneratedAiTests.class)
class TextControllerGeneratedAiTests {
    private TextService textService;

    @BeforeEach
    void setUp(TextService textService) {
        this.textService = textService;
    }
}

class TextControllerGeneratedAiTests implements TestExtension {
    @Override
    public void tearDown(ExtensionContext context) {}
}

class TextControllerGeneratedAiTests {
    @ParameterizedTest
    void helloWorld(String input) {
        // GIVEN: A string input
        // WHEN: The helloWorld method is called
        // THEN: The method returns "Hello, World!"
        String result = textService.helloworld();
        assertEquals("Hello, World!", result);
    }

    @ParameterizedTest
    void reverse(String input) {
        // GIVEN: An input string
        // WHEN: The reverse method is called
        // THEN: The method returns the reversed string
        String reversed = textService.reverse(input);
        assertEquals(new StringBuilder(input).reverse().toString(), reversed);
    }

    @ParameterizedTest
    void uppercase(String input) {
        // GIVEN: An input string
        // WHEN: The uppercase method is called
        // THEN: The method returns the uppercase version of the string
        String uppercase = textService.uppercase(input);
        assertEquals(input.toUpperCase(), uppercase);
    }

    @ParameterizedTest
    void stats(String input) {
        // GIVEN: An input string
        // WHEN: The stats method is called
        // THEN: The method returns a map containing the length, word count, line count, vowel count, consonant count, and repeated words
        Map<String, Object> stats = textService.stats(input);
        assertEquals(7, stats.size());
        assertEquals(Integer.valueOf(input.length()), stats.get("length"));
        assertEquals(Integer.valueOf(input.split("\\s+").length), stats.get("wordCount"));
        assertEquals(Integer.valueOf(input.split("\\n").length), stats.get("lineCount"));
        assertEquals(Integer.valueOf(textService.getVowelCount(input)), stats.get("VowelCount"));
        assertEquals(Integer.valueOf(textService.getConsonantCount(input)), stats.get("ConsonantCount"));
        assertEquals(textService.getRepeatedWords(input).size(), stats.get("RepeatedWords").size());
    }

    @ParameterizedTest
    void replace(String target, String replacement, String input) {
        // GIVEN: A target string, a replacement string, and an input string
        // WHEN: The replace method is called
        // THEN: The method returns the input string with all occurrences of the target string replaced by the replacement string
        String replaced = textService.replace(input, target, replacement);
        assertEquals(input.replace(target, replacement), replaced);
    }

    @ParameterizedTest
    void removeVowels(String input) {
        // GIVEN: An input string
        // WHEN: The removeVowels method is called
        // THEN: The method returns the input string with all vowels removed
        String withoutVowels = textService.removeVowels(input);
        assertEquals(input.replaceAll("[aeiou]", ""), withoutVowels);
    }

    @ParameterizedTest
    void removeConsonants(String input) {
        // GIVEN: An input string
        // WHEN: The removeConsonants method is called
        // THEN: The method returns the input string with all consonants removed
        String withoutConsonantsjava
        // GIVEN: An input string
        // WHEN: The removeConsonants method is called
        // THEN: The method returns the input string with all consonants removed
        String withoutConsonants = textService.removeConsonants(input);
        assertEquals(input.replaceAll("[b-df-hj-np-tv-z]", ""), withoutConsonants);
    }

    @ParameterizedTest
    void countOccurrence(String keyword, String input) {
        // GIVEN: A keyword and an input string
        // WHEN: The countOccurrence method is called
        // THEN: The method returns the number of occurrences of the keyword in the input string
        int occurrences = textService.countOccurrence(input, keyword);
        assertEquals(input.split("\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1, occurrences);
    }

    @ParameterizedTest
    void helloworld() {
        // GIVEN: No input
        // WHEN: The helloworld method is called
        // THEN: The method returns "Hello, World!"
        String result = textService.helloworld();
        assertEquals("Hello, World!", result);
    }

    @ParameterizedTest
    void convertJsonToYaml(String json) {
        // GIVEN: A JSON string
        // WHEN: The convertJsonToYaml method is called
        // THEN: The method returns the YAML representation of the JSON string
        String yaml = textService.convertJsonToYaml(json);
        assertEquals("YAML representation of the JSON string", yaml);
    }

    @ParameterizedTest
    void convertJsonToXml(String json) {
        // GIVEN: A JSON string
        // WHEN: The convertJsonToXml method is called
        // THEN: The method returns the XML representation of the JSON string
        String xml = textService.convertJsonToXml(json);
        assertEquals("XML representation of the JSON string", xml);
    }
}