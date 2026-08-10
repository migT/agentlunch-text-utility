package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        // GIVEN
        String input = "";

        // WHEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // THEN
        mockMvc.perform(post("/text/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("Hello, World!"));
    }

    @Test
    public void testReverse() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        when(textService.reverse(input)).thenReturn(new StringBuilder(input).reverse().toString());

        // WHEN
        mockMvc.perform(post("/text/reverse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("dlroW ,olleH"));
    }

    @Test
    public void testUppercase() throws Exception {
        // GIVEN
        String input = "hello, world!";
        when(textService.uppercase(input)).thenReturn(input.toUpperCase());

        // WHEN
        mockMvc.perform(post("/text/uppercase")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("HELLO, WORLD!"));
    }

    @Test
    public void testStats() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        when(textService.stats(input)).thenReturn(Map.of(
                "length", 13,
                "wordCount", 2,
                "lineCount", 1,
                "VowelCount", 3,
                "ConsonantCount", 10,
                "RepeatedWords", List.of("Hello : 1")
        ));

        // WHEN
        mockMvc.perform(post("/text/stats")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.length").value(13))
                .andExpect(jsonPath("$.data.wordCount").value(2))
                .andExpect(jsonPath("$.data.lineCount").value(1))
                .andExpect(jsonPath("$.data.VowelCount").value(3))
                .andExpect(jsonPath("$.data.ConsonantCount").value(10))
                .andExpect(jsonPath("$.data.RepeatedWords[0]").value("Hello : 1"));
    }

    @Test
    public void testReplace() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        when(textService.replace(input, "World", "Earth")).thenReturn(input.replace("World", "Earth"));

        // WHEN
        mockMvc.perform(post("/text/replace")
                .contentType(MediaType.APPLICATION_JSON)
                .param("target", "World")
                .param("replacement", "Earth")
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("Hello, Earth!"));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        when(textService.removeVowels(input)).thenReturn(input.replaceAll("(?i)[aeiou]", ""));

        // WHEN
        mockMvc.perform(post("/text/remove-vowels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("Hll, Wrld!"));
    }

    @Test
    public void testRemoveConsonants() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        when(textService.removeConsonants(input)).thenReturn(input.replaceAll("(?i)[b-df-hj-np-tv-z]", ""));

        // WHEN
        mockMvc.perform(post("/text/remove-consonants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value("aeiou, aeiou!"));
    }
