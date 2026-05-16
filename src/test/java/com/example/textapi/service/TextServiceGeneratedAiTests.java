package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import com.example.textapi.utils.TextConversionUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
public class TextServiceGeneratedAiTests {

    @Mock
    private TextConversionUtil textConversionUtilMock;

    private TextService textService;

    @BeforeEach
    public void setup() {
        textService = new TextService();
        when(textConversionUtilMock.convertJsonToYaml(any())).thenReturn("yaml");
        when(textConversionUtilMock.convertJsonToXml(any())).thenReturn("xml");
    }

    @Test
    public void testReverse_GivenInputString_WhenCalled_ThenReturnsReversedString() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.reverse(input);

        // THEN
        assertThat(result).isEqualTo(" !dlroW ,olleH");
    }

    @Test
    public void testUppercase_GivenInputString_WhenCalled_ThenReturnsUppercasedString() {
        // GIVEN
        String input = "hello, world!";

        // WHEN
        String result = textService.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats_GivenInputString_WhenCalled_ThenReturnsStatsMap() {
        // GIVEN
        String input = "Hello, World! This is a test string.";

        // WHEN
        Map<String, Object> result = textService.stats(input);

        // THEN
        assertThat(result).containsEntry("length", 32);
        assertThat(result).containsEntry("wordCount", 5);
        assertThat(result).containsEntry("lineCount", 1);
    }

    @Test
    public void testGetLength_GivenNullInput_WhenCalled_ThenReturnsZero() {
        // GIVEN
        String input = null;

        // WHEN
        Integer result = textService.getLength(input);

        // THEN
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testGetSplitCount_GivenInputStringAndRegex_WhenCalled_ThenReturnsSplitCount() {
        // GIVEN
        String input = "Hello, World!";
        String regex = "\\s+";

        // WHEN
        Integer result = textService.getSplitCount(input, regex);

        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testGetRepeatedWords_GivenInputString_WhenCalled_ThenReturnsRepeatedWordsList() {
        // GIVEN
        String input = "Hello, World! Hello, World!";

        // WHEN
        List<String> result = textService.getRepeatedWords(input);

        // THEN
        assertThat(result).containsExactly("Hello, World! : 2");
    }

    @Test
    public void testGetConsonantCount_GivenInputString_WhenCalled_ThenReturnsConsonantCount() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getConsonantCount(input);

        // THEN
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void testGetVowelCount_GivenInputString_WhenCalled_ThenReturnsVowelCount() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        Integer result = textService.getVowelCount(input);

        // THEN
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void testReplace_GivenInputStringAndTargetReplacement_WhenCalled_ThenReturnsReplacedString() {
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
    public void testRemoveVowels_GivenInputString_WhenCalled_ThenReturnsStringWithoutVowels() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants_GivenInputString_WhenCalled_ThenReturnsStringWithoutConsonants() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService    @Test
    public void testRemoveConsonants_GivenInputString_WhenCalled_ThenReturnsStringWithoutConsonants() {
        // GIVEN
        String input = "Hello, World!";

        // WHEN
        String result = textService.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo("eo, orld!");
    }

    @Test
    public void testCountOccurrence_GivenInputStringAndKeyword_WhenCalled_ThenReturnsOccurrenceCount() {
        // GIVEN
        String input = "Hello, World! Hello, World!";
        String keyword = "World";

        // WHEN
        int result = textService.countOccurrence(input, keyword);

        // THEN
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testHelloworld_GivenNoInput_WhenCalled_ThenReturnsHelloWorld() {
        // GIVEN

        // WHEN
        String result = textService.helloworld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    public void testConvertJsonToYaml_GivenJsonString_WhenCalled_ThenReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String result = textService.convertJsonToYaml(json);

        // THEN
        assertThat(result).isEqualTo("yaml");
    }

    @Test
    public void testConvertJsonToXml_GivenJsonString_WhenCalled_ThenReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";

        // WHEN
        String result = textService.convertJsonToXml(json);

        // THEN
        assertThat(result).isEqualTo("xml");
    }
}
