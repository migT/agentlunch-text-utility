package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class TextControllerTest {

    @Mock
    private TextService textService;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Mockito.doNothing().when(textService.helloworld());
        Mockito.doNothing().when(textService.reverse("test"));
        Mockito.doNothing().when(textService.uppercase("test"));
        Mockito.doNothing().when(textService.stats("test"));
        Mockito.doNothing().when(textService.replace("test", "target", "replacement"));
        Mockito.doNothing().when(textService.removeVowels("test"));
        Mockito.doNothing().when(textService.removeConsonants("test"));
        Mockito.doNothing().when(textService.countOccurrence("test", "test"));
    }

    @org.junit.jupiter.api.Test
    void helloWorld() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertEquals("Hello, World!", textService.helloworld());
    }

    @org.junit.jupiter.api.Test
    void reverse() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertEquals("tset", textService.reverse("test"));
    }

    @org.junit.jupiter.api.Test
    void uppercase() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertEquals("TEST", textService.uppercase("test"));
    }

    @org.junit.jupiter.api.Test
    void stats() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertNotNull(textService.stats("test"));
    }

    @org.junit.jupiter.api.Test
    void replace() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertEquals("target replacement", textService.replace("test", "target", "replacement"));
    }

    @org.junit.jupiter.api.Test
    void removeVowels() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertEquals("tst", textService.removeVowels("test"));
    }

    @org.junit.jupiter.api.Test
    void removeConsonants() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertEquals("st", textService.removeConsonants("test"));
    }

    @org.junit.jupiter.api.Test
    void countOccurrence() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertEquals(1, textService.countOccurrence("test", "test"));
    }

    @org.junit.jupiter.api.Test
    void jsonToYaml() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertNotNull(textService.convertJsonToYaml("{\"key\": \"value\"}"));
    }

    @org.junit.jupiter.api.Test
    void jsonToXml() {
        // GIVEN
        // WHEN
        // THEN
        Assertions.assertNotNull(textService.convertJsonToXml("{\"key\": \"value\"}"));
    }
}
