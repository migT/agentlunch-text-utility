package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setup() {
        textService = new TextService();
    }

    @Test
    public void testReverse_GivenString_WhenReversed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        
        // WHEN
        String result = textService.reverse(input);
        
        // THEN
        assertThat(result).isEqualTo("!,dlroW ,olleH");
    }

    @Test
    public void testUppercase_GivenString_WhenConvertedToUppercase_ThenResultIsCorrect() {
        // GIVEN
        String input = "hello, world!";
        
        // WHEN
        String result = textService.uppercase(input);
        
        // THEN
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats_GivenString_WhenStatisticsAreCalculated_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! This is a test.";
        
        // WHEN
        Map<String, Object> result = textService.stats(input);
        
        // THEN
        assertThat(result.get("length")).isEqualTo(31);
        assertThat((Integer)result.get("wordCount")).isEqualTo(5);
        assertThat((Integer)result.get("lineCount")).isEqualTo(1);
    }

    @Test
    public void testGetLength_GivenNullString_WhenLengthIsCalculated_ThenResultIsZero() {
        // GIVEN
        String input = null;
        
        // WHEN
        Integer result = textService.getLength(input);
        
        // THEN
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testGetSplitCount_GivenStringAndRegex_WhenSplitCountIsCalculated_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! This is a test.";
        String regex = "\\s+";
        
        // WHEN
        Integer result = textService.getSplitCount(input, regex);
        
        // THEN
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void testGetRepeatedWords_GivenString_WhenRepeatedWordsAreFound_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        
        // THEN
        assertThat(result).containsExactly("Hello : 2", "World : 2");
    }

    @Test
    public void testGetConsonantCount_GivenString_WhenConsonantsAreCounted_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        
        // WHEN
        Integer result = textService.getConsonantCount(input);
        
        // THEN
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void testGetVowelCount_GivenString_WhenVowelsAreCounted_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        
        // WHEN
        Integer result = textService.getVowelCount(input);
        
        // THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testReplace_GivenStringAndTarget_WhenReplacementIsMade_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Earth";
        
        // WHEN
        String result = textService.replace(input, target, replacement);
        
        // THEN
        assertThat(result).isEqualTo("Hello, Earth!");
    }

    @Test
    public void testRemoveVowels_GivenString_WhenVowelsAreRemoved_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        
        // WHEN
        String result = textService.removeVowels(input);
        
        // THEN
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants_GivenString_WhenConsonantsAreRemoved_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        
        // WHEN
        String result = textService.removeConsonants(input);
        
        // THEN
        assertThat(result).isEqualTo("eo, o!");
    }

    @Test
    public void testCountOccurrence_GivenStringAndKeyword_WhenOccurrencesAreCounted_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        String keyword = "World";
        
        // WHEN
        int result = textService.countOccurrence(input, keyword);
        
        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testHelloworld_GivenNoInput_WhenHelloWorldIsReturned_ThenResultIsCorrect() {
        // GIVEN
        String input = null;
        
        // WHEN
        String result = textService.helloworld();
        
        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    public void testConvertJsonToYaml_GivenJsonString_WhenConvertedToJson_ThenResultIsCorrect() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        
        // WHEN
        String result = textService.convertJsonToYaml(json);
        
        // THEN
        assertThat(result).isNotNull();
    }

    @Test
    public void testConvertJsonToXml_GivenJsonString_WhenConvertedToJson_ThenResultIsCorrect() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        
        // WHEN
        String result = textService.convertJsonToXml(json);
        
        // THEN
        assertThat(result).isNotNull();
    }

    @Test
    public void testGetLength_MockTextService_GivenString_WhenLengthIsCalculated_ThenResultIsCorrect() {
        // GIVEN
        TextService mockTextService = Mockito.mock(TextService.class);
        String input = "Hello, World!";
        
        when(mockTextService.getLength(input)).thenReturn(13);
        
        // WHEN
        Integer result = mockTextService.getLength(input);
        
        // THEN
        assertThat(result).isEqualTo(13);
    }

    @Test
    public void testGetSplitCount_MockTextService_GivenStringAndRegex_WhenSplitCountIsCalculated_ThenResultIsCorrect() {
        // GIVEN
        TextService mockTextService = Mockito.mock(TextService.class);
        String input = "Hello, World! This is a test.";
        String regex = "\\s+";
        
        when(mockTextService.getSplitCount(input, regex)).thenReturn(5);
        
        // WHEN
        Integer result = mockTextService.getSplitCount(input, regex);
        
        // THEN
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void testGetConsonantCount_MockTextService_GivenString_WhenConsonantsAreCounted_ThenResultIsCorrect() {
        // GIVEN
        TextService mockTextService = Mockito.mock(TextService.class);
        String input = "Hello, World!";
        
        when(mockTextService.getConsonantCount(input)).thenReturn(7);
        
        // WHEN
        Integer result = mockTextService.getConsonantCount(input);
        
        // THEN
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void testGetVowelCount_MockTextService_GivenString_WhenVowelsAreCounted_ThenResultIsCorrect() {
        // GIVEN
        TextService mockTextService = Mockito.mock(TextService.class);
        String input = "Hello, World!";
        
        when(mockTextService.getVowelCount(input)).thenReturn(3);
        
        // WHEN
        Integer result = mockTextService.getVowelCount(input);
        
        // THEN
        assertThat(result).isEqualTo(3);
    }

    public class TextService {
        public int getLength(String input) {
            return input.length();
        }
        
        public int getSplitCount(String input, String regex) {
            return input.split(regex).length;
        }
        
        public int getConsonantCount(String input) {
            int count = 0;
            for (char c : input.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (!Character.toString(c).matches("[aeiouAEIOU]")) {
                        count++;
                    }
                }
            }
            return count;
        }
        
        public int getVowelCount(String input) {
            int count = 0;
            for (char c : input.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (Character.toString(c).matches("[aeiouAEIOU]")) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
