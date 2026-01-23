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
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController controller;

    @BeforeEach
    public void setUp() {
        // Initialize any necessary state or mocks before each test
    }

    @Test
    public void testHelloWorld() {
        GIVEN();
        WHEN();
        THEN();
    }

    @Test
    public void testReverse() {
        String input = "test";
        String expectedOutput = textService.reverse(input);
        assertThat(expectedOutput).isEqualTo("tset");
    }

    @Test
    public void testUppercase() {
        String input = "test";
        String expectedOutput = textService.uppercase(input);
        assertThat(expectedOutput).isEqualTo("TEST");
    }

    @Test
    public void testStats() {
        String input = "test test";
        Map<String, Object> expectedOutput = new HashMap<>();
        expectedOutput.put("length", 9);
        expectedOutput.put("wordCount", 2);
        expectedOutput.put("lineCount", 1);
        expectedOutput.put("VowelCount", 2);
        expectedOutput.put("ConsonantCount", 6);
        assertThat(textService.stats(input)).isEqualTo(expectedOutput);
    }

    @Test
    public void testReplace() {
        String input = "test";
        String target = "t";
        String replacement = "T";
        String expectedOutput = textService.replace(input, target, replacement);
        assertThat(expectedOutput).isEqualTo("TesT");
    }

    @Test
    public void testRemoveVowels() {
        String input = "test";
        String expectedOutput = textService.removeVowels(input);
        assertThat(expectedOutput).isEqualTo("tst");
    }

    @Test
    public void testRemoveConsonants() {
        String input = "test";
        String expectedOutput = textService.removeConsonants(input);
        assertThat(expectedOutput).isEqualTo("ea");
    }

    @Test
    public void testCountOccurrence() {
        String input = "test test";
        String keyword = "t";
        int expectedOutput = 2;
        assertThat(textService.countOccurrence(input, keyword)).isEqualTo(expectedOutput);
    }

    @Test
    public void testJsonToYaml() {
        String json = "{\"key\":\"value\"}";
        String expectedOutput = textService.convertJsonToYaml(json);
        assertThat(expectedOutput).isNotNull();
    }

    @Test
    public void testJsonToXml() {
        String json = "{\"key\":\"value\"}";
        String expectedOutput = textService.convertJsonToXml(json);
        assertThat(expectedOutput).isNotNull();
    }
}
