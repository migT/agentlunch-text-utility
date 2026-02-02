package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.contentAsString;

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
        // GIVEN: No preconditions needed for this method
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN: Call the helloWorld method
        MvcResult result = mockMvc.perform(post("/text/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo("Hello, World!");
    }

    @Test
    public void testReverse() throws Exception {
        // GIVEN: A string to be reversed
        String input = "hello";
        when(textService.reverse(input)).thenReturn(new StringBuilder(input).reverse().toString());

        // WHEN: Call the reverse method
        MvcResult result = mockMvc.perform(post("/text/reverse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo(new StringBuilder(input).reverse().toString());
    }

    @Test
    public void testUppercase() throws Exception {
        // GIVEN: A string to be uppercased
        String input = "hello";
        when(textService.uppercase(input)).thenReturn(input.toUpperCase());

        // WHEN: Call the uppercase method
        MvcResult result = mockMvc.perform(post("/text/uppercase")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo(input.toUpperCase());
    }

    @Test
    public void testStats() throws Exception {
        // GIVEN: A string to be processed for stats
        String input = "hello world";
        when(textService.stats(input)).thenReturn(Map.of(
                "length", 11,
                "wordCount", 2,
                "lineCount", 1,
                "VowelCount", 3,
                "ConsonantCount", 4,
                "RepeatedWords", List.of("hello : 1")
        ));

        // WHEN: Call the stats method
        MvcResult result = mockMvc.perform(post("/text/stats")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo(Map.of(
                "length", 11,
                "wordCount", 2,
                "lineCount", 1,
                "VowelCount", 3,
                "ConsonantCount", 4,
                "RepeatedWords", List.of("hello : 1")
        ));
    }

    @Test
    public void testReplace() throws Exception {
        // GIVEN: A string to be processed for replacement
        String input = "hello world";
        when(textService.replace(input, "world", "earth")).thenReturn(input.replace("world", "earth"));

        // WHEN: Call the replace method
        MvcResult result = mockMvc.perform(post("/text/replace")
                .contentType(MediaType.APPLICATION_JSON)
                .param("target", "world")
                .param("replacement", "earth")
                .content(input))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo(input.replace("world", "earth"));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        // GIVEN: A string to be processed for removing vowels
        String input = "hello world";
        when(textService.removeVowels(input)).thenReturn(input.replaceAll("(?i)[aeiou]", ""));

        // WHEN: Call the removeVowels method
        MvcResult result = mockMvc.perform(post("/text/remove-vowels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo(input.replaceAll("(?i)[aeiou]", ""));
    }

    @Test
    public void testRemoveConsonants() throws Exception {
        // GIVEN: A string to be processed for removing consonants
        String input = "hello world";
        when(textService.removeConsonants(input)).thenReturn(input.replaceAll("(?i)[b-df-hj-np-tv-z]", ""));

        // WHEN: Call the removeConsonants method
        MvcResult result = mockMvc.perform(post("/text/remove-consonants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo(input.replaceAll("(?i)[b-df-hj-np-tv-z]", ""));
    }

    @Test
    public void testCountOccurrence() throws Exception {
        // GIVEN: A string and a keyword to be processed for occurrence count
        String input = "hello world";
        when(textService.countOccurrence(input, "world")).thenReturn(1);

        // WHEN: Call the countOccurrence method
        MvcResult result = mockMvc.perform(post("/text/count-occurrence")
                .contentType(MediaType.APPLICATION_JSON)
                .param("keyword", "world")
                .content(input))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo(String.valueOf(1));
    }

    @Test
    public void testJsonToYaml() throws Exception {
        // GIVEN: A JSON string to be converted to YAML
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenReturn(TextConversionUtil.convertJsonToYaml(json));

        // WHEN: Call the jsonToYaml method
        MvcResult result = mockMvc.perform(post("/text/json-to-yaml")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo(TextConversionUtil.convertJsonToYaml(json));
    }

    @Test
    public void testJsonToXml() throws Exception {
        // GIVEN: A JSON string to be converted to XML
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenReturn(TextConversionUtil.convertJsonToXml(json));

        // WHEN: Call the jsonToXml method
        MvcResult result = mockMvc.perform(post("/text/json-to-xml")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        // THEN: Verify that the response is as expected
        assertThat(contentAsString).isEqualTo(TextConversionUtil.convertJsonToXml(json));
    }
}
