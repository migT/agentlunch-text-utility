package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TextServiceGeneratedAiTests {

    @Mock
    private TextConversionUtil textConversionUtil;

    @InjectMocks
    private TextService textService;

    private String input = "Hello, World!";
    private String jsonInput = "{\"key\":\"value\"}";
    private Map<String, Object> statsResult = new HashMap<>();
    private List<String> repeatedWords = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        when(textConversionUtil.convertJsonToYaml(jsonInput)).thenReturn("yamlOutput");
        when(textConversionUtil.convertJsonToXml(jsonInput)).thenReturn("xmlOutput");
    }

    @Test
    public void testReverse_GivenString_WhenReversed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo(new StringBuilder(input).reverse().toString());
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
    public void testStats_GivenString_WhenStatisticsComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result.get("length")).isEqualTo(13);
        assertThat(result.get("wordCount")).isEqualTo(2);
        assertThat(result.get("lineCount")).isEqualTo(1);
        assertThat(result.get("VowelCount")).isEqualTo(3);
        assertThat(result.get("ConsonantCount")).isEqualTo(10);
    }

    @Test
    public void testGetLength_GivenString_WhenLengthComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getLength(input);

        // THEN
        assertThat(result).isEqualTo(13);
    }

    @Test
    public void testGetSplitCount_GivenStringAndRegex_WhenSplitCountComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        String regex = "\\s+";

        // WHEN
        Integer result = textService.getSplitCount(input, regex);

        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testGetConsonantCount_GivenString_WhenConsonantCountComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getConsonantCount(input);

        // THEN
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void testGetVowelCount_GivenString_WhenVowelCountComputed_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getVowelCount(input);

        // THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testReplace_GivenStringAndTarget_WhenReplaced_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";

        // WHEN
        String result = textService.replace(input, target, "Mock");

        // THEN
        assertThat(result).isEqualTo("Hello, Mock!");
    }

    @Test
    public void testRemoveVowels_GivenString_WhenVowelsRemoved_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants_GivenString_WhenConsonantsRemoved_ThenResultIsCorrect() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("aeio, a");
    }

    @Test
    public void testCountOccurrence_Given@Test
public void testCountOccurrence_GivenStringAndKeyword_WhenCounted_ThenResultIsCorrect() {
    // GIVEN
    String input = "Hello, World! Hello";
    String keyword = "Hello";

    // WHEN
    int result = textService.countOccurrence(input, keyword);

    // THEN
    assertThat(result).isEqualTo(2);
}

@Test
public void testHelloworld_GivenNoInput_WhenHelloWorldReturned_ThenResultIsCorrect() {
    // GIVEN
    // No input required

    // WHEN
    String result = textService.helloworld();

    // THEN
    assertThat(result).isEqualTo("Hello, World!");
}

@Test
public void testConvertJsonToYaml_GivenJsonInput_WhenConvertedToYaml_ThenResultIsCorrect() {
    // GIVEN
    String jsonInput = "{\"key\":\"value\"}";

    // WHEN
    String result = textService.convertJsonToYaml(jsonInput);

    // THEN
    assertThat(result).isEqualTo("yamlOutput");
}

@Test
public void testConvertJsonToXml_GivenJsonInput_WhenConvertedToXml_ThenResultIsCorrect() {
    // GIVEN
    String jsonInput = "{\"key\":\"value\"}";

    // WHEN
    String result = textService.convertJsonToXml(jsonInput);

    // THEN
    assertThat(result).isEqualTo("xmlOutput");
}
