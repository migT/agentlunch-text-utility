package com.example.textapi.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(textController).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        // GIVEN
        String expectedResponse = "Hello, World!";

        // WHEN
        when(textService.helloworld()).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(expectedResponse));
    }

    @Test
    public void testReverse() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String expectedResponse = " !dlroW ,olleH";

        // WHEN
        when(textService.reverse(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/reverse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(expectedResponse));
    }

    @Test
    public void testUppercase() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String expectedResponse = "HELLO, WORLD!";

        // WHEN
        when(textService.uppercase(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/uppercase")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(expectedResponse));
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
        expectedResponse.put("RepeatedWords", Collections.emptyList());

        // WHEN
        when(textService.stats(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/stats")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length").value(13))
                .andExpect(jsonPath("$.wordCount").value(2))
                .andExpect(jsonPath("$.lineCount").value(1))
                .andExpect(jsonPath("$.VowelCount").value(3))
                .andExpect(jsonPath("$.ConsonantCount").value(10))
                .andExpect(jsonPath("$.RepeatedWords").value(Collections.emptyList()));
    }

    @Test
    public void testReplace() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String target = "Hello";
        String replacement = "Goodbye";
        String expectedResponse = "Goodbye, World!";

        // WHEN
        when(textService.replace(input, target, replacement)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/replace")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"input\":\"" + input + "\",\"target\":\"" + target + "\",\"replacement\":\"" + replacement + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(expectedResponse));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String expectedResponse = "Hll, Wrld!";

        // WHEN
        when(textService.removeVowels(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/remove-vowels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(expectedResponse));
    }

    @Test
    public void testRemoveConsonants() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String expectedResponse = "eo, orld!";

        // WHEN
        when(textService.removeConsonants(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/remove-consonants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(expectedResponse));
    }

    @Test
    public void testCountOccurrence() throws Exception {
        // GIVEN
        String input = "Hello, World!";
        String keyword = "Hello";
        int expectedResponse = 1;

        // WHEN
        when(textService.countOccurrence(input, keyword)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/count-occurrence")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"input\":\"" + input + "\",\"keyword\":\"" + keyword + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(expectedResponse));
    }

    @Test
    public void testJsonToYaml() throws Exception {
        // GIVEN
        String input = "{\"key\":\"value\"}";
        String expectedResponse = "key: value\n...\n";

        // WHEN
        when(textService.convertJsonToYaml(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/json-to-yaml")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(expectedResponse));
    }

    @Test
    public void testJsonToXml() throws Exception {
        // GIVEN
        String input = "{\"key\":\"value\"}";
        String expectedResponse = "<key>value</key>\n...\n";

        // WHEN
        when(textService.convertJsonToXml(input)).thenReturn(expectedResponse);

        // THEN
        mockMvc.perform(post("/text/json-to-xml")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(expectedResponse));
    }
}
