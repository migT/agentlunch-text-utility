package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class TextControllerGeneratedAiTests {

    private MockMvc mockMvc;

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(textController).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        // GIVEN
        String expectedResponse = "Hello, World!";

        // WHEN
        when(textService.helloworld()).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(expectedResponse));
    }

    @Test
    public void testReverse() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String expectedResponse = new StringBuilder(input).reverse().toString();

        // WHEN
        when(textService.reverse(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/reverse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(expectedResponse));
    }

    @Test
    public void testUppercase() throws Exception {
        // GIVEN
        String input = "hello, world!";
        String expectedResponse = input.toUpperCase();

        // WHEN
        when(textService.uppercase(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/uppercase")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(expectedResponse));
    }

    @Test
    public void testStats() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        Map<String, Object> expectedResponse = new HashMap<>();
        expectedResponse.put("length", 13);
        expectedResponse.put("wordCount", 2);
        expectedResponse.put("lineCount", 1);
        expectedResponse.put("VowelCount", 3);
        expectedResponse.put("ConsonantCount", 10);

        // WHEN
        when(textService.stats(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/stats")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.length").value(13))
                .andExpect(jsonPath("$.data.wordCount").value(2))
                .andExpect(jsonPath("$.data.lineCount").value(1))
                .andExpect(jsonPath("$.data.VowelCount").value(3))
                .andExpect(jsonPath("$.data.ConsonantCount").value(10));
    }

    @Test
    public void testReplace() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Universe";
        String expectedResponse = input.replace(target, replacement);

        // WHEN
        when(textService.replace(input, target, replacement)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/replace")
                .param("target", target)
                .param("replacement", replacement)
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(expectedResponse));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String expectedResponse = new StringBuilder(input).replaceAll("(?i)[aeiou]", "").toString();

        // WHEN
        when(textService.removeVowels(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/remove-vowels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(expectedResponse));
    }

    @Test
    public void testRemoveConsonants() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String expectedResponse = new StringBuilder(input).replaceAll("(?i)[b-df-hj-np-tv-z]", "").toString();

        // WHEN
        when(textService.removeConsonants(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/remove-consonants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(expectedResponse));
    }

    @Test
    public void testCountOccurrence() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String keyword = "o";
        int expectedResponse = 2;

        // WHEN
        when(textService.countOccurrence(input, keyword)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/count-occurrence")
                .param("keyword", keyword)
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(expectedResponse));
    }

    @Test
    public void testJsonToYaml() throws Exception {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedResponse = new YAMLMapper().writeValueAsString(new ObjectMapper().readTree(json));

        // WHEN
        when(textService.convertJsonToYaml(json)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/json-to-yaml")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(expectedResponse));
    }

    @Test
    public void testJsonToXml() throws Exception {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expectedResponse = new XmlMapper().writeValueAsString(new ObjectMapper().readTree(json));

        // WHEN
        when(textService.convertJsonToXml(json)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/json-to-xml")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(expectedResponse));
    }
}
