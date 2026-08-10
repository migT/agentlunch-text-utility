package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TextControllerGeneratedAiTests {

    private MockMvc mockMvc;

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController controller;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        // GIVEN: No preconditions needed

        // WHEN: Call the helloWorld method
        String result = mockMvc.perform(post("/text/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // THEN: Verify that the response is correct
        assertThat(result).isEqualTo("Hello, World!");
    }

    @Test
    public void testReverse() throws Exception {
        // GIVEN: A sample input string
        String input = "Hello, World!";

        // WHEN: Call the reverse method with the input string
        when(textService.reverse(input)).thenReturn("!dlroW ,olleH");

        String result = mockMvc.perform(post("/text/reverse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // THEN: Verify that the response is correct
        assertThat(result).isEqualTo("!dlroW ,olleH");
    }

    @Test
    public void testUppercase() throws Exception {
        // GIVEN: A sample input string
        String input = "hello, world!";

        // WHEN: Call the uppercase method with the input string
        when(textService.uppercase(input)).thenReturn("HELLO, WORLD!");

        String result = mockMvc.perform(post("/text/uppercase")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // THEN: Verify that the response is correct
        assertThat(result).isEqualTo("HELLO, WORLD!");
    }

    @Test
    public void testStats() throws Exception {
        // GIVEN: A sample input string
        String input = "Hello, World!";

        // WHEN: Call the stats method with the input string
        when(textService.stats(input)).thenReturn(Map.of(
                "length", 13,
                "wordCount", 2,
                "lineCount", 1,
                "VowelCount", 3,
                "ConsonantCount", 10,
                "RepeatedWords", List.of("Hello : 1")
        ));

        String result = mockMvc.perform(post("/text/stats")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // THEN: Verify that the response is correct
        assertThat(result).isEqualTo("{\"length\":13,\"wordCount\":2,\"lineCount\":1,\"VowelCount\":3,\"ConsonantCount\":10,\"RepeatedWords\":[\"Hello : 1\"]}");
    }

    @Test
    public void testReplace() throws Exception {
        // GIVEN: A sample input string, target and replacement strings
        String input = "Hello, World!";
        String target = "World";
        String replacement = "Earth";

        // WHEN: Call the replace method with the input, target and replacement strings
        when(textService.replace(input, target, replacement)).thenReturn("Hello, Earth!");

        String result = mockMvc.perform(post("/text/replace")
                .contentType(MediaType.APPLICATION_JSON)
                .param("target", target)
                .param("replacement", replacement)
                .content(input))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // THEN: Verify that the response is correct
        assertThat(result).isEqualTo("Hello, Earth!");
    }

    @Test
    public void testRemoveVowels() throws Exception {
        // GIVEN: A sample input string

        // WHEN: Call the removeVowels method with the input string
        when(textService.removeVowels("Hello, World!")).thenReturn("Hll, Wrld!");

        String result = mockMvc.perform(post("/text/remove-vowels")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Hello, World!"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        // THEN: Verify that the response is correct
        assertThat(result).isEqualTo("Hll, Wrld!");
    }
