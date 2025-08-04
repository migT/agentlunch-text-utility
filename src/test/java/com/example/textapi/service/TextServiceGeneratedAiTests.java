package com.example.textapi.service;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TextServiceGeneratedAiTests.class)
class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void helloworld() {
        // GIVEN: A TextService instance is created.
        // WHEN: The helloworld() method is called.
        // THEN: "Hello, World!" is returned.
        assertEquals("Hello, World!", textService.helloworld());
    }

    @Test
    void reverse() {
        // GIVEN: An input string "hello".
        // WHEN: The reverse() method is called with "hello".
        // THEN: "olleh" is returned.
        assertEquals("olleh", textService.reverse("hello"));
    }

    @Test
    void uppercase() {
        // GIVEN: An input string "hello".
        // WHEN: The uppercase() method is called with "hello".
        // THEN: "HELLO" is returned.
        assertEquals("HELLO", textService.uppercase("hello"));
    }

    @Test
    void stats() {
        // GIVEN: An input string "Hello, World!".
        // WHEN: The stats() method is called with "Hello, World!".
        // THEN: A map with the following keys and values is returned:
        // length: 13
        // wordCount: 2
        // lineCount: 1
        // VowelCount: 3
        // ConsonantCount: 7
        // RepeatedWords: ["World"]
        Map<String, Object> result = textService.stats("Hello, World!");
        assertEquals(13, result.get("length"));
        assertEquals(2, result.get("wordCount"));
        assertEquals(1, result.get("lineCount"));
        assertEquals(3, result.get("VowelCount"));
        assertEquals(7, result.get("ConsonantCount"));
        assertEquals("World", result.get("RepeatedWords"));
    }

    @Test
    void replace() {
        // GIVEN: An input string "Hello, World!".
        // WHEN: The replace() method is called with "World", "World", and "Universe"
        // THEN: "Hello, Universe" is returned.
        assertEquals("Hello, Universe", textService.replace("Hello, World!", "World", "Universe"));
    }

    @Test
    void removeVowels() {
        // GIVEN: An input string "Hello, World!".
        // WHEN: The removeVowels() method is called with "Hello, World!".
        // THEN: "Hll, Wrld!" is returned.
        assertEquals("Hll, Wrld!", textService.removeVowels("Hello, World!"));
    }

    @Test
    void removeConsonants() {
        // GIVEN: An input string "Hello, World!".
        // WHEN: The removeConsonants() method is called with "Hello, World!".
        // THEN: "e, o!" is returned.
        assertEquals("e, o!", textService.removeConsonants("Hello, World!"));
    }

    @Test
    void countOccurrence() {
        // GIVEN: An input string "Hello, World!".
        // WHEN: The countOccurrence() method is called with "World" and "World".
        // THEN: 1 is returned.
        assertEquals(1, textService.countOccurrence("Hello, World!", "World"));
    }

    @Test
    void convertJsonToYaml() {
        // GIVEN: A JSON string "{ \"name\": \"John\", \"age\": 30 }".
        // WHEN: The convertJsonToYaml() method is called with the JSON string.
        // THEN: "key: value" is returned.
        assertEquals("key: value", textService.convertJsonToYaml("{ \"name\": \"John\", \"age\": 30 }"));
    }
}java
assertEquals("<root key=\"John\" age=\"30\"/>", textService.convertJsonToXml("{ \"name\": \"John\", \"age\": 30 }"));
    }
}
