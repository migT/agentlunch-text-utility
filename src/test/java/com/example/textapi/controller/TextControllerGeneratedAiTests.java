package com.example.textapi.controller;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

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
    void helloWorldReturnsServiceResult() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String actual = textController.helloWorld();

        // THEN
        assertThat(actual).isEqualTo(expected);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void reverseReturnsReversedString() {
        // GIVEN
        String input = "abcd";
        String expected = "dcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String actual = textController.reverse(input);

        // THEN
        assertThat(actual).isEqualTo(expected);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void uppercaseReturnsUpperCaseString() {
        // GIVEN
        String input = "TestString";
        String expected = "TESTSTRING";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String actual = textController.uppercase(input);

        // THEN
        assertThat(actual).isEqualTo(expected);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void statsReturnsCorrectStatistics() {
        // GIVEN
        String input = "Hello world\nHello again";
        Map<String, Object> expected = Map.of(
                "length", 24,
                "wordCount", 5,
                "lineCount", 2,
                "VowelCount", 7,
                "ConsonantCount", 15,
                "RepeatedWords", List.of("hello : 2")
        );
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> actual = textController.stats(input);

        // THEN
        assertThat(actual).isEqualTo(expected);
        verify(textService, times(1)).stats(input);
    }