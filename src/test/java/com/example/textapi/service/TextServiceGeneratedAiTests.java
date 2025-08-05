package com.example.textapi.service;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class HelloActionGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void helloworld() {
        // GIVEN: An instance of TextService is created.
        // WHEN: The helloworld() method is called.
        // THEN: "Hello, World!" should be returned.
        assertEquals("Hello, World!", textService.helloworld());
    }

    @Test
    void reverse() {
        // GIVEN: An input string "hello".
        // WHEN: The reverse() method is called with "hello".
        // THEN: "olleh" should be returned.
        assertEquals("olleh", textService.reverse("hello"));
    }

    @Test
    void uppercase() {
        // GIVEN: An input string "hello".
        // WHEN: The uppercase() method is called with "hello".
        // THEN: "HELLO" should be returned.
        assertEquals("HELLO", textService.uppercase("hello"));
    }

    @Test
    void stats() {
        // GIVEN: An input string "Hello, World!".
        // WHEN: The stats() method is called with "Hello, World!".
        // THEN: A map with the following keys and values should be returned:
        // length: 13
        // wordCount: 2
        // lineCount: 1
        // VowelCount: 3
        // ConsonantCount: 7
        // RepeatedWords: []
        Map<String, Object> result = textService.stats("Hello, World!");
        assertEquals(13, result.get("length"));
        assertEquals(2, result.get("wordCount"));
        assertEquals(1, result.get("lineCount"));
        assertEquals(3, result.get("VowelCount"));
        assertEquals(7, result.get("ConsonantCount"));
        assertEquals(0, result.get("RepeatedWords").length);
    }

    @Test
    void replace() {
        // GIVEN: An input string "Hello, World!".
        // WHEN: The replace() method is called with "World!", "World", "Universe".
        // THEN: "Hello, Universe!" should be returned.
        assertEquals("Hello, Universe!", textService.replace("Hello, World!", "World", "Universe"));
    }

    @Test
    void removeVowels() {
        // GIVEN: An input string "Hello, World!".
        // WHEN: The removeVowels() method is called with "Hello, World!".
        // THEN: "Hll, Wrld!" should be returned.
        assertEquals("Hll, Wrld!", textService.removeVowels("Hello, World!"));
    }

    @Test
    void removeConsonants() {
        // GIVEN: An input string "Hello, World!".
        // WHEN: The removeConsonants() method is called with "Hello, World!".
        // THEN: "e, o!" should be returned.
        assertEquals("e, o!", textService.removeConsonants("Hello, World!"));
    }

    @Test
    void countOccurrence() {
        // GIVEN: An input string "Hello, World!", and a keyword "World".
        // WHEN: The countOccurrence() method is called with "Hello, World!" and "World".
        // THEN: 1 should be returned.
        assertEquals(1, textService.countOccurrence("Hello, World!", "World"));
    }

    @Test
    void convertJsonToYaml() {
        // GIVEN: A JSON string "{ \"name\": \"John\", \"age\": 30 }".
        // WHEN: The convertJsonToYaml() method is called with the JSON string.
        // THEN: "key: John\nvalue: 30" should be returned.
        assertEquals("key: John\nvalue: 30", textService.convertJsonToYaml("{ \"name\": \"John\", \"age\": 30 }"));
    }

    @Test
    void convertJsonToXml() {
        // GIVEN: A JSON string "{ \"name\": \"John\", \"age\": 30 }".
        // WHEN: The convertJsonToXml() method is called with the JSON string.
        // THEN: "<name>John</name><age>30</age>" should bejava
        // GIVEN: A JSON string "{ \"name\": \"John\", \"age\": 30 }".
        // THEN: "<name>John</name><age>30</age>" should be returned.
        assertEquals("<name>John</name><age>30</age>", textService.convertJsonToXml("{ \"name\": \"John\", \"age\": 30 }"));
    }
}
