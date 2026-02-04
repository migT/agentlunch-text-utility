package com.example.textapi.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TextServiceGeneratedAiTests {

    @InjectMocks
    private TextService textService;

    private String input;

    @BeforeEach
    public void setup() {
        textService = new TextService();
        input = "Hello, World!";
    }

    @Test
    public void GIVEN_validInput_WHEN_reverseCalled_THEN_reversedStringReturned() {
        // GIVEN
        String expected = "dlroW ,olleH";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_uppercaseCalled_THEN_uppercaseStringReturned() {
        // GIVEN
        String expected = "HELLO, WORLD!";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_statsCalled_THEN_statsMapReturned() {
        // GIVEN
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 13);
        expected.put("wordCount", 2);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 3);
        expected.put("ConsonantCount", 10);
        expected.put("RepeatedWords", Collections.emptyList());

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_getLengthCalled_THEN_lengthReturned() {
        // GIVEN
        int expected = 13;

        // WHEN
        int result = textService.getLength(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_getSplitCountCalled_THEN_splitCountReturned() {
        // GIVEN
        int expected = 2;

        // WHEN
        int result = textService.getSplitCount(input, "\\s+");

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_getSplitCountCalledWithInvalidSplitRegex_THEN_IllegalArgumentExceptionThrown() {
        // GIVEN
        String invalidSplitRegex = "Invalid Regex";

        // WHEN
        assertThrows(IllegalArgumentException.class, () -> textService.getSplitCount(input, invalidSplitRegex));

        // THEN
        // No assertion needed, assertThrows already checks for the exception
    }

    @Test
    public void GIVEN_validInput_WHEN_getRepeatedWordsCalled_THEN_repeatedWordsListReturned() {
        // GIVEN
        List<String> expected = Arrays.asList("hello : 1", "world : 1");

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_getRepeatedWordsCalledWithEmptyInput_THEN_emptyListReturned() {
        // GIVEN
        List<String> expected = Collections.emptyList();

        // WHEN
        List<String> result = textService.getRepeatedWords("");

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_getConsonantCountCalled_THEN_consonantCountReturned() {
        // GIVEN
        int expected = 10;

        // WHEN
        int result = textService.getConsonantCount(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_getVowelCountCalled_THEN_vowelCountReturned() {
        // GIVEN
        int expected = 3;

        // WHEN
        int result = textService.getVowelCount(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_replaceCalled_THEN_replacedStringReturned() {
        // GIVEN
        String expected = "Hello, New World!";

        // WHEN
        String result = textService.replace(input, "World", "New");

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_removeVowelsCalled_THEN_vowelRemovedStringReturned() {
        // GIVEN
        String expected = "Hll, Wrld!";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_removeConsonantsCalled_THEN_consonantRemovedStringReturned() {
        // GIVEN
        String expected = "o, e!";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_countOccurrenceCalled_THEN_occurrenceCountReturned() {
        // GIVEN
        int expected = 1;

        // WHEN
        int result = textService.countOccurrence(input, "World");

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_convertJsonToYamlCalled_THEN_yamlStringReturned() {
        // GIVEN
        String expected = TextConversionUtil.convertJsonToYaml(input);

        // WHEN
        String result = textService.convertJsonToYaml(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_convertJsonToXmlCalled_THEN_xmlStringReturned() {
        // GIVEN
        String expected = TextConversionUtil.convertJsonToXml(input);

        // WHEN
        String result = textService.convertJsonToXml(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    public void GIVEN_validInput_WHEN_helloworldCalled_THEN_helloWorldStringReturned() {
        // GIVEN
        String expected = "Hello, World!";

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertEquals(expected, result);
    }
}
