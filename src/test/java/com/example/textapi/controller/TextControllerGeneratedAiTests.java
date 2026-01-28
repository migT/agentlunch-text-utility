package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@AutoConfigureMockMvc
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(SpringApplication.run(SpringBootApp.class)).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        // GIVEN: No preconditions needed

        // WHEN: Call the helloWorld method
        String result = mockMvc.perform(post("/text/hello"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // THEN: The response should be "Hello, World!"
        assertThat(result).isEqualTo(TextService.HELLO_WORLD);
    }

    @Test
    public void testReverse() throws Exception {
        // GIVEN: A sample input string
        String input = "hello world";

        // WHEN: Call the reverse method with the input string
        when(textService.reverse(input)).thenReturn("dlrow olleh");

        // THEN: The response should be the reversed string
        mockMvc.perform(post("/text/reverse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(contentAsString().isEqualTo("dlrow olleh"));
    }

    @Test
    public void testUppercase() throws Exception {
        // GIVEN: A sample input string
        String input = "hello world";

        // WHEN: Call the uppercase method with the input string
        when(textService.uppercase(input)).thenReturn("HELLO WORLD");

        // THEN: The response should be the uppercase string
        mockMvc.perform(post("/text/uppercase")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(contentAsString().isEqualTo("HELLO WORLD"));
    }

    @Test
    public void testStats() throws Exception {
        // GIVEN: A sample input string
        String input = "hello world";

        // WHEN: Call the stats method with the input string
        when(textService.stats(input)).thenReturn(Map.of(
                "length", 11,
                "wordCount", 2,
                "lineCount", 1,
                "VowelCount", 3,
                "ConsonantCount", 8,
                "RepeatedWords", List.of("hello : 1")
        ));

        // THEN: The response should be the stats map
        mockMvc.perform(post("/text/stats")
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk());
    }

    @Test
    public void testReplace() throws Exception {
        // GIVEN: A sample input string, target, and replacement
        String input = "hello world";
        String target = "world";
        String replacement = "earth";

        // WHEN: Call the replace method with the input string, target, and replacement
        when(textService.replace(input, target, replacement)).thenReturn("hello earth");

        // THEN: The response should be the replaced string
        mockMvc.perform(post("/text/replace")
                .param("target", target)
                .param("replacement", replacement)
                .contentType(MediaType.APPLICATION_JSON)
                .content(input))
                .andExpect(status().isOk())
                .andExpect(contentAsString().isEqualTo("hello earth"));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        // GIVEN: A sample input string

        // WHEN: Call the removeVowels method with the input string
        when(textService.removeVowels("hello world")).thenReturn("hll wrld");

        // THEN: The response should be the string without vowels
        mockMvc.perform(post("/text/remove-vowels")
                .contentType(MediaType.APPLICATION_JSON)
                .content("hello world"))
                .andExpect(status().isOk())
                .andExpect(contentAsString().isEqualTo("hll wrld"));
    }

    @Test
    public void testRemoveConsonants() throws Exception {
        // GIVEN: A sample input string

        // WHEN: Call the removeConsonants method with the input string
        when(textService.removeConsonants("hello world")).thenReturn("eo o");

        // THEN: The response should be the string without consonants
        mockMvc.perform(post("/text/remove-consonants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("hello world"))
                .andExpect(status().isOk())
                .andExpect(contentAsString().isEqualTo("eo o"));
    }

    @Test
    public void testCountOccurrence() throws Exception {
        // GIVEN: A sample input string and keyword

        // WHEN: Call the countOccurrence method with the input string and keyword
        when(textService.countOccurrence("hello world", "world")).thenReturn(1);

        // THEN: The response should be the occurrence count
        mockMvc.perform(post("/text/count-occurrence")
                .param("keyword", "world")
                .contentType(MediaType.APPLICATION_JSON)
                .content("hello world"))
                .andExpect(status().isOk())
                .andExpect(contentAsString().isEqualTo("1"));
    }

    @Test
    public void testJsonToYaml() throws Exception {
        // GIVEN: A sample JSON string

        // WHEN: Call the jsonToYaml method with the JSON string
        when(textService.convertJsonToYaml("{\"key\":\"value\"}")).thenReturn("{\n  key: value\n}");

        // THEN: The response should be the YAML string
        mockMvc.perform(post("/text/json-to-yaml")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"key\":\"value\"}"))
                .andExpect(status().isOk())
                .andExpect(contentAsString().isEqualTo("{\n  key: value\n}"));
    }

    @Test
    public void testJsonToXml() throws Exception {
        // GIVEN: A sample JSON string

        // WHEN: Call the jsonToXml method with the JSON string
        when(textService.convertJsonToXml("{\"key\":\"value\"}")).thenReturn("<root><key>value</key></root>");

        // THEN: The response should be the XML string
        mockMvc.perform(post("/text/json-to-xml")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"key\":\"value\"}"))
                .andExpect(status().isOk())
                .andExpect(contentAsString().isEqualTo("<root><key>value</key></root>"));
    }
}
