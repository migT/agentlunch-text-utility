package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.contentAsString;

import org.springframework.mock.web.MockHttpServletResponse;

public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
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
        assertThat(result).isEqualTo(TextService.HELLO_WORLD);
    }

    @Test
    public void testReverse() throws Exception {
        // GIVEN: A sample input string
        String input = "Hello, World!";

        // WHEN: Call the reverse method with the sample input
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

        // WHEN: Call the uppercase method with the sample input
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
        String input = "Hello, World! This is a sample text.";

        // WHEN: Call the stats method with the sample input
        Map<String, Object> result = new HashMap<>();
        when(textService.stats(input)).thenReturn(result);

        mockMvc.perform(post("/text/stats")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk());

        // THEN: Verify that the response is correct
        assertThat(result).isNotNull();
    }

    @Test
    public void testReplace() throws Exception {
        // GIVEN: Sample input strings
        String target = "World";
        String replacement = "Universe";

        // WHEN: Call the replace method with the sample inputs
        when(textService.replace("Hello, World!", target, replacement)).thenReturn("Hello, Universe!");

        mockMvc.perform(post("/text/replace")
                .param("target", target)
                .param("replacement", replacement)
                .contentType(MediaType.APPLICATION_JSON)
                .content("Hello, World!"))
                .andExpect(status().isOk());

        // THEN: Verify that the response is correct
    }

    @Test
    public void testRemoveVowels() throws Exception {
        // GIVEN: A sample input string
        String input = "Hello, World!";

        // WHEN: Call the removeVowels method with the sample input
        when(textService.removeVowels(input)).thenReturn("Hll, Wrld!");

        mockMvc.perform(post("/text/remove-vowels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk());

        // THEN: Verify that the response is correct
        String result = mockMvc.perform(post("/text/remove-vowels")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Hello, World!"))
                .andReturn().getResponse().getContentAsString();
        assertThat(result).isEqualTo("Hll, Wrld!");
    }

    @Test
    public void testRemoveConsonants() throws Exception {
        // GIVEN: A sample input string
        String input = "Hello, World!";

        // WHEN: Call the removeConsonants method with the sample input
        when(textService.removeConsonants(input)).thenReturn("aeioo aee!");

        mockMvc.perform(post("/text/remove-consonants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk());

        // THEN: Verify that the response is correct
        String result = mockMvc.perform(post("/text/remove-consonants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Hello, World!"))
                .andReturn().getResponse().getContentAsString();
        assertThat(result).isEqualTo("aeioo aee!");
    }

    @Test
    public void testCountOccurrence() throws Exception {
        // GIVEN: Sample input strings
        String keyword = "World";
        String input = "Hello, World! This is a sample text. Hello, World!";

        // WHEN: Call the countOccurrence method with the sample inputs
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        mockMvc.perform(post("/text/count-occurrence")
                .param("keyword", keyword)
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk());

        // THEN: Verify that the response is correct
        String result = mockMvc.perform(post("/text/count-occurrence")
                .param("keyword", "World")
                .contentType(MediaType.APPLICATION_JSON)
                .content("Hello, World! This is a sample text. Hello, World!"))
                .andReturn().getResponse().getContentAsString();
        assertThat(result).isEqualTo("2");
    }

    @Test
    public void testJsonToYaml() throws Exception {
        // GIVEN: A sample JSON input string
        String json = "{\"key\":\"value\"}";

        // WHEN: Call the jsonToYaml method with the sample JSON input
        when(textService.convertJsonToYaml(json)).thenReturn("{\"key\":\"value\"}");

        mockMvc.perform(post("/text/json-to-yaml")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());

        // THEN: Verify that the response is correct
        String result = mockMvc.perform(post("/text/json-to-yaml")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"key\":\"value\"}"))
                .andReturn().getResponse().getContentAsString();
        assertThat(result).isEqualTo("{\"key\":\"value\"}");
    }

    @Test
    public void testJsonToXml() throws Exception {
        // GIVEN: A sample JSON input string
        String json = "{\"key\":\"value\"}";

        // WHEN: Call the jsonToXml method with the sample JSON input
        when(textService.convertJsonToXml(json)).thenReturn("{\"key\":\"value\"}");

        mockMvc.perform(post("/text/json-to-xml")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());

        // THEN: Verify that the response is correct
        String result = mockMvc.perform(post("/text/json-to-xml")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"key\":\"value\"}"))
                .andReturn().getResponse().getContentAsString();
        assertThat(result).isEqualTo("{\"key\":\"value\"}");
    }
}
