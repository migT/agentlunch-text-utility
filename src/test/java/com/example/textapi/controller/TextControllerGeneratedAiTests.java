package com.example.textapi.controller;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
    }

    @Test
    void helloWorld_returnsHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertThat(result).isEqualTo("Hello, World!");
        verify(textService).helloworld();
    }

    @Test
    void reverse_returnsReversedString() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertThat(result).isEqualTo("cba");
        verify(textService).reverse(input);
    }

    @Test
    void uppercase_returnsUppercaseString() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertThat(result).isEqualTo("ABC");
        verify(textService).uppercase(input);
    }

    @Test
    void stats_returnsStatisticsMap() {
        // GIVEN
        String input = "test";
        Map<String, Object> statsMap = new HashMap<>();
        statsMap.put("length", 4);
        statsMap.put("wordCount", 1);
        statsMap.put("lineCount", 1);
        statsMap.put("VowelCount", 1);
        statsMap.put("ConsonantCount", 3);
        statsMap.put("RepeatedWords", new String[]{});
        when(textService.stats(input)).thenReturn(statsMap);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertThat(result).containsEntry("length", 4)
                          .containsEntry("wordCount", 1)
                          .containsEntry("lineCount", 1)
                          .containsEntry("VowelCount", 1)
                          .containsEntry("ConsonantCount", 3)
                          .containsEntry("RepeatedWords", new String[]{});
        verify(textService).stats(input);
    }

    @Test
    void replace_replacesTargetWithReplacement() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "there";
        String expected = "hello there";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService).replace(input, target, replacement);
    }

    @Test
    void removeVowels_removesAllVowels() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService).removeVowels(input);
    }

    @Test
    void removeConsonants_removesAllConsonants() {
        // GIVEN
        String input = "hello";
        String expected = "eoo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService).removeConsonants(input);
    }

    @Test
    void countOccurrence_countsKeywordOccurrences() {
        // GIVEN
        String input = "test test test";
        String keyword = "test";
        int expected = 3;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService).countOccurrence(input, keyword);
    }

    @Test
    void jsonToYaml_convertsJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: value\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService).convertJsonToYaml(json);
    }

    @Test
    void jsonToXml_convertsJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertThat(result).isEqualTo(expected);
        verify(textService).convertJsonToXml(json);
    }
}