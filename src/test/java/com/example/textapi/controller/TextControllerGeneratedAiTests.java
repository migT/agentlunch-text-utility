package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

@ExtendWith(com.example.textapi.controller.TextControllerGeneratedAiTests.class)
public class TextControllerGeneratedAiTests {
    @Mock
    private TextService textService;

    @Autowired
    public void setService(TextService textService) {
        this.textService = textService;
    }

    @BeforeEach
    void setUp() {
        Mockito.reset(textService);
    }

    public static class TextControllerGeneratedAiTests {}

    public void helloWorldTest() {
        // GIVEN
        String expected = "Hello, World!";

        // WHEN
        String actual = MockMvc.action(MockMvcRequestBuilders.get("/text/hello")).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }

    public void reverseTest() {
        // GIVEN
        String input = "hello";
        String expected = "olleh";

        // WHEN
        String actual = MockMvc.action(MockMvcRequestBuilders.post("/text/reverse")).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }

    public void uppercaseTest() {
        // GIVEN
        String input = "hello";
        String expected = "HELLO";

        // WHEN
        String actual = MockMvc.action(MockMvcRequestBuilders.post("/text/uppercase")).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }

    public void statsTest() {
        // GIVEN
        String input = "This is a test string.";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 16);
        expected.put("wordCount", 3);
        expected.put("lineCount", 1);
        expected.put("VowelCount", 3);
        expected.put("ConsonantCount", 11);
        expected.put("RepeatedWords", Collections.emptyList());

        // WHEN
        Map<String, Object> actual = MockMvc.action(MockMvcRequestBuilders.post("/text/stats")).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }

    public void replaceTest() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "universe";
        String expected = "hello universe";

        // WHEN
        String actual = MockMvc.action(MockMvcRequestBuilders.post("/text/replace?target=" + target + "&replacement=" + replacement)).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }

    public void removeVowelsTest() {
        // GIVEN
        String input = "hello world";
        String expected = "hll wrld";

        // WHEN
        String actual = MockMvc.action(MockMvcRequestBuilders.post("/text/remove-vowels")).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }

    public void removeConsonantsTest() {
        // GIVEN
        String input = "hello world";
        String expected = "aeiou";

        // WHEN
        String actual = MockMvc.action(MockMvcRequestBuilders.post("/text/remove-consonants")).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }

    public void countOccurrenceTest() {
        // GIVEN
        String input = "hello world";
        String keyword = "world";
        String expected = 1;

        // WHEN
        int actual = MockMvc.action(MockMvcRequestBuilders.post("/text/count-occurrence?keyword=" + keyword)).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }

    public void jsonToYamlTest() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";java
        String expected = "name: John\nage: 30\n";

        // WHEN
        String actual = MockMvc.action(MockMvcRequestBuilders.post("/text/json-to-yaml")).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }

    public void jsonToXmlTest() {
        // GIVEN
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String expected = "<root>\n  <name>John</name>\n  <age>30</age>\n</root>";

        // WHEN
        String actual = MockMvc.action(MockMvcRequestBuilders.post("/text/json-to-xml")).andReturn(expected).toString();

        // THEN
        assertEquals(expected, actual);
    }
}
