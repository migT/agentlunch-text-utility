package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collections;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> expectedStats = Collections.singletonMap("length", 11);
        when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expectedStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello World Hello";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}

/*
2025-09-30 16:55:11.544 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 16:55:11.554 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-09-30 16:55:11.555 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/hello")
    public String helloWorld() {
        return textService.helloworld();
    }

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}


>> REQUIREMENTS:

1. The response must contain fully functional test code.
2. The response must be in plain text (no code block formatting like '''java ''').
3. Place the generated tests in the SAME PACKAGE as the input JAVA class.
4. Follow this naming convention for the test class: use the original class name and append "GeneratedAiTests".
  - Do not add another "s" if the class name already ends with "s".
  - Do not append "Tests" if the class name ends with "x", "ch", "sh", or "ss".
    Example: `HelloAction` becomes `HelloActionGeneratedAiTests`.
5. Use JUNIT5 for the test framework, MOCKITO for mocking, and ASSERTJ for assertions.
6. Exclude `DisplayName` annotations.
7. Include necessary imports for annotations like `@ExtendWith`.
8. Ensure each test method has at least one assertion.
9. Avoid generating tests for private methods—focus only on public and protected methods.
10. Ensure any modified state in the test is reset before each test with a `@BeforeEach` method.
11. Tests should be independent; no test should rely on the result of another.
12. If no mocks are needed, skip importing mock-related libraries.
13. Organize the test methods using the GIVEN WHEN THEN structure. Each test should begin with a GIVEN section that sets up the necessary preconditions or context, followed by a WHEN section that describes the action being tested, and concluding with a THEN section that specifies the expected outcome. Include comments for each section to clearly indicate their purpose.
14. If error compilation refers to 'reference to assertThat is ambiguous' please do not use org.assertj.core.api.Assertions.assertThat, apart that please use assertEquals(expected, actual) from org.junit.jupiter.api.Assertions.assertEquals
15. Please do not forget about necessary imports
16. Check if the class name matches the requirements, e.g. classWithUnitTests instead of classWithUnitTest
17. If a test fails, check it again to see if it's well written, is assertion correct

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.

2025-09-30 16:55:11.556 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 16:55:17.931 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 5229, outputTokenCount = 1024, totalTokenCount = 6253 }
2025-09-30 16:55:17.932 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 2
2025-09-30 16:55:24.535 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 6265, outputTokenCount = 1024, totalTokenCount = 7289 }
2025-09-30 16:55:58.204 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:129)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Terminating generation due to repeating response
2025-09-30 16:55:58.205 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:55:58.205 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
2025-09-30 16:55:58.206 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-09-30 16:55:58.207 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:55:58.207 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

2025-09-30 16:56:39.202 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 16:56:39.204 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-09-30 16:56:39.204 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/hello")
    public String helloWorld() {
        return textService.helloworld();
    }

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}


>> REQUIREMENTS:

1. The response must contain fully functional test code.
2. The response must be in plain text (no code block formatting like '''java ''').
3. Place the generated tests in the SAME PACKAGE as the input JAVA class.
4. Follow this naming convention for the test class: use the original class name and append "GeneratedAiTests".
  - Do not add another "s" if the class name already ends with "s".
  - Do not append "Tests" if the class name ends with "x", "ch", "sh", or "ss".
    Example: `HelloAction` becomes `HelloActionGeneratedAiTests`.
5. Use JUNIT5 for the test framework, MOCKITO for mocking, and ASSERTJ for assertions.
6. Exclude `DisplayName` annotations.
7. Include necessary imports for annotations like `@ExtendWith`.
8. Ensure each test method has at least one assertion.
9. Avoid generating tests for private methods—focus only on public and protected methods.
10. Ensure any modified state in the test is reset before each test with a `@BeforeEach` method.
11. Tests should be independent; no test should rely on the result of another.
12. If no mocks are needed, skip importing mock-related libraries.
13. Organize the test methods using the GIVEN WHEN THEN structure. Each test should begin with a GIVEN section that sets up the necessary preconditions or context, followed by a WHEN section that describes the action being tested, and concluding with a THEN section that specifies the expected outcome. Include comments for each section to clearly indicate their purpose.
14. If error compilation refers to 'reference to assertThat is ambiguous' please do not use org.assertj.core.api.Assertions.assertThat, apart that please use assertEquals(expected, actual) from org.junit.jupiter.api.Assertions.assertEquals
15. Please do not forget about necessary imports
16. Check if the class name matches the requirements, e.g. classWithUnitTests instead of classWithUnitTest
17. If a test fails, check it again to see if it's well written, is assertion correct

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.

2025-09-30 16:56:39.205 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 16:56:45.688 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 8342, outputTokenCount = 1024, totalTokenCount = 9366 }
2025-09-30 16:56:45.689 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 2
2025-09-30 16:56:50.882 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 9378, outputTokenCount = 1024, totalTokenCount = 10402 }
2025-09-30 16:57:21.055 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:129)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Terminating generation due to repeating response
2025-09-30 16:57:21.057 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:57:21.057 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
2025-09-30 16:57:21.058 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-09-30 16:57:21.059 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:57:21.060 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

2025-09-30 16:57:56.008 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 16:57:56.009 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-09-30 16:57:56.010 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/hello")
    public String helloWorld() {
        return textService.helloworld();
    }

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}


>> REQUIREMENTS:

1. The response must contain fully functional test code.
2. The response must be in plain text (no code block formatting like '''java ''').
3. Place the generated tests in the SAME PACKAGE as the input JAVA class.
4. Follow this naming convention for the test class: use the original class name and append "GeneratedAiTests".
  - Do not add another "s" if the class name already ends with "s".
  - Do not append "Tests" if the class name ends with "x", "ch", "sh", or "ss".
    Example: `HelloAction` becomes `HelloActionGeneratedAiTests`.
5. Use JUNIT5 for the test framework, MOCKITO for mocking, and ASSERTJ for assertions.
6. Exclude `DisplayName` annotations.
7. Include necessary imports for annotations like `@ExtendWith`.
8. Ensure each test method has at least one assertion.
9. Avoid generating tests for private methods—focus only on public and protected methods.
10. Ensure any modified state in the test is reset before each test with a `@BeforeEach` method.
11. Tests should be independent; no test should rely on the result of another.
12. If no mocks are needed, skip importing mock-related libraries.
13. Organize the test methods using the GIVEN WHEN THEN structure. Each test should begin with a GIVEN section that sets up the necessary preconditions or context, followed by a WHEN section that describes the action being tested, and concluding with a THEN section that specifies the expected outcome. Include comments for each section to clearly indicate their purpose.
14. If error compilation refers to 'reference to assertThat is ambiguous' please do not use org.assertj.core.api.Assertions.assertThat, apart that please use assertEquals(expected, actual) from org.junit.jupiter.api.Assertions.assertEquals
15. Please do not forget about necessary imports
16. Check if the class name matches the requirements, e.g. classWithUnitTests instead of classWithUnitTest
17. If a test fails, check it again to see if it's well written, is assertion correct

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.

2025-09-30 16:57:56.011 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 16:58:03.147 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 11455, outputTokenCount = 1024, totalTokenCount = 12479 }
2025-09-30 16:58:03.152 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 2
2025-09-30 16:58:08.670 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 12491, outputTokenCount = 1024, totalTokenCount = 13515 }
2025-09-30 16:58:50.280 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:129)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Terminating generation due to repeating response
2025-09-30 16:58:50.281 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:58:50.281 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
2025-09-30 16:58:50.282 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-09-30 16:58:50.282 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:58:50.283 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

2025-09-30 17:03:24.183 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 17:03:24.196 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-09-30 17:03:24.196 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/hello")
    public String helloWorld() {
        return textService.helloworld();
    }

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collections;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> expectedStats = Collections.singletonMap("length", 11);
        when(textService.stats(input)).thenReturn(expectedStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expectedStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello World Hello";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}

/*
2025-09-30 16:55:11.544 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 16:55:11.554 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-09-30 16:55:11.555 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/hello")
    public String helloWorld() {
        return textService.helloworld();
    }

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}


>> REQUIREMENTS:

1. The response must contain fully functional test code.
2. The response must be in plain text (no code block formatting like '''java ''').
3. Place the generated tests in the SAME PACKAGE as the input JAVA class.
4. Follow this naming convention for the test class: use the original class name and append "GeneratedAiTests".
  - Do not add another "s" if the class name already ends with "s".
  - Do not append "Tests" if the class name ends with "x", "ch", "sh", or "ss".
    Example: `HelloAction` becomes `HelloActionGeneratedAiTests`.
5. Use JUNIT5 for the test framework, MOCKITO for mocking, and ASSERTJ for assertions.
6. Exclude `DisplayName` annotations.
7. Include necessary imports for annotations like `@ExtendWith`.
8. Ensure each test method has at least one assertion.
9. Avoid generating tests for private methods—focus only on public and protected methods.
10. Ensure any modified state in the test is reset before each test with a `@BeforeEach` method.
11. Tests should be independent; no test should rely on the result of another.
12. If no mocks are needed, skip importing mock-related libraries.
13. Organize the test methods using the GIVEN WHEN THEN structure. Each test should begin with a GIVEN section that sets up the necessary preconditions or context, followed by a WHEN section that describes the action being tested, and concluding with a THEN section that specifies the expected outcome. Include comments for each section to clearly indicate their purpose.
14. If error compilation refers to 'reference to assertThat is ambiguous' please do not use org.assertj.core.api.Assertions.assertThat, apart that please use assertEquals(expected, actual) from org.junit.jupiter.api.Assertions.assertEquals
15. Please do not forget about necessary imports
16. Check if the class name matches the requirements, e.g. classWithUnitTests instead of classWithUnitTest
17. If a test fails, check it again to see if it's well written, is assertion correct

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.

2025-09-30 16:55:11.556 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 16:55:17.931 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 5229, outputTokenCount = 1024, totalTokenCount = 6253 }
2025-09-30 16:55:17.932 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 2
2025-09-30 16:55:24.535 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 6265, outputTokenCount = 1024, totalTokenCount = 7289 }
2025-09-30 16:55:58.204 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:129)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Terminating generation due to repeating response
2025-09-30 16:55:58.205 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:55:58.205 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
2025-09-30 16:55:58.206 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-09-30 16:55:58.207 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:55:58.207 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

2025-09-30 16:56:39.202 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 16:56:39.204 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-09-30 16:56:39.204 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/hello")
    public String helloWorld() {
        return textService.helloworld();
    }

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}


>> REQUIREMENTS:

1. The response must contain fully functional test code.
2. The response must be in plain text (no code block formatting like '''java ''').
3. Place the generated tests in the SAME PACKAGE as the input JAVA class.
4. Follow this naming convention for the test class: use the original class name and append "GeneratedAiTests".
  - Do not add another "s" if the class name already ends with "s".
  - Do not append "Tests" if the class name ends with "x", "ch", "sh", or "ss".
    Example: `HelloAction` becomes `HelloActionGeneratedAiTests`.
5. Use JUNIT5 for the test framework, MOCKITO for mocking, and ASSERTJ for assertions.
6. Exclude `DisplayName` annotations.
7. Include necessary imports for annotations like `@ExtendWith`.
8. Ensure each test method has at least one assertion.
9. Avoid generating tests for private methods—focus only on public and protected methods.
10. Ensure any modified state in the test is reset before each test with a `@BeforeEach` method.
11. Tests should be independent; no test should rely on the result of another.
12. If no mocks are needed, skip importing mock-related libraries.
13. Organize the test methods using the GIVEN WHEN THEN structure. Each test should begin with a GIVEN section that sets up the necessary preconditions or context, followed by a WHEN section that describes the action being tested, and concluding with a THEN section that specifies the expected outcome. Include comments for each section to clearly indicate their purpose.
14. If error compilation refers to 'reference to assertThat is ambiguous' please do not use org.assertj.core.api.Assertions.assertThat, apart that please use assertEquals(expected, actual) from org.junit.jupiter.api.Assertions.assertEquals
15. Please do not forget about necessary imports
16. Check if the class name matches the requirements, e.g. classWithUnitTests instead of classWithUnitTest
17. If a test fails, check it again to see if it's well written, is assertion correct

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.

2025-09-30 16:56:39.205 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 16:56:45.688 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 8342, outputTokenCount = 1024, totalTokenCount = 9366 }
2025-09-30 16:56:45.689 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 2
2025-09-30 16:56:50.882 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 9378, outputTokenCount = 1024, totalTokenCount = 10402 }
2025-09-30 16:57:21.055 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:129)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Terminating generation due to repeating response
2025-09-30 16:57:21.057 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:57:21.057 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
2025-09-30 16:57:21.058 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-09-30 16:57:21.059 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:57:21.060 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

2025-09-30 16:57:56.008 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 16:57:56.009 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-09-30 16:57:56.010 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/hello")
    public String helloWorld() {
        return textService.helloworld();
    }

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }
}


>> REQUIREMENTS:

1. The response must contain fully functional test code.
2. The response must be in plain text (no code block formatting like '''java ''').
3. Place the generated tests in the SAME PACKAGE as the input JAVA class.
4. Follow this naming convention for the test class: use the original class name and append "GeneratedAiTests".
  - Do not add another "s" if the class name already ends with "s".
  - Do not append "Tests" if the class name ends with "x", "ch", "sh", or "ss".
    Example: `HelloAction` becomes `HelloActionGeneratedAiTests`.
5. Use JUNIT5 for the test framework, MOCKITO for mocking, and ASSERTJ for assertions.
6. Exclude `DisplayName` annotations.
7. Include necessary imports for annotations like `@ExtendWith`.
8. Ensure each test method has at least one assertion.
9. Avoid generating tests for private methods—focus only on public and protected methods.
10. Ensure any modified state in the test is reset before each test with a `@BeforeEach` method.
11. Tests should be independent; no test should rely on the result of another.
12. If no mocks are needed, skip importing mock-related libraries.
13. Organize the test methods using the GIVEN WHEN THEN structure. Each test should begin with a GIVEN section that sets up the necessary preconditions or context, followed by a WHEN section that describes the action being tested, and concluding with a THEN section that specifies the expected outcome. Include comments for each section to clearly indicate their purpose.
14. If error compilation refers to 'reference to assertThat is ambiguous' please do not use org.assertj.core.api.Assertions.assertThat, apart that please use assertEquals(expected, actual) from org.junit.jupiter.api.Assertions.assertEquals
15. Please do not forget about necessary imports
16. Check if the class name matches the requirements, e.g. classWithUnitTests instead of classWithUnitTest
17. If a test fails, check it again to see if it's well written, is assertion correct

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.

2025-09-30 16:57:56.011 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 16:58:03.147 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 11455, outputTokenCount = 1024, totalTokenCount = 12479 }
2025-09-30 16:58:03.152 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 2
2025-09-30 16:58:08.670 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 12491, outputTokenCount = 1024, totalTokenCount = 13515 }
2025-09-30 16:58:50.280 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:129)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Terminating generation due to repeating response
2025-09-30 16:58:50.281 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:58:50.281 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
2025-09-30 16:58:50.282 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-09-30 16:58:50.282 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 16:58:50.283 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }
* /


>> REQUIREMENTS:

1. The response must contain fully functional test code.
2. The response must be in plain text (no code block formatting like '''java ''').
3. Place the generated tests in the SAME PACKAGE as the input JAVA class.
4. Follow this naming convention for the test class: use the original class name and append "GeneratedAiTests".
  - Do not add another "s" if the class name already ends with "s".
  - Do not append "Tests" if the class name ends with "x", "ch", "sh", or "ss".
    Example: `HelloAction` becomes `HelloActionGeneratedAiTests`.
5. Use JUNIT5 for the test framework, MOCKITO for mocking, and ASSERTJ for assertions.
6. Exclude `DisplayName` annotations.
7. Include necessary imports for annotations like `@ExtendWith`.
8. Ensure each test method has at least one assertion.
9. Avoid generating tests for private methods—focus only on public and protected methods.
10. Ensure any modified state in the test is reset before each test with a `@BeforeEach` method.
11. Tests should be independent; no test should rely on the result of another.
12. If no mocks are needed, skip importing mock-related libraries.
13. Organize the test methods using the GIVEN WHEN THEN structure. Each test should begin with a GIVEN section that sets up the necessary preconditions or context, followed by a WHEN section that describes the action being tested, and concluding with a THEN section that specifies the expected outcome. Include comments for each section to clearly indicate their purpose.
14. If error compilation refers to 'reference to assertThat is ambiguous' please do not use org.assertj.core.api.Assertions.assertThat, apart that please use assertEquals(expected, actual) from org.junit.jupiter.api.Assertions.assertEquals
15. Please do not forget about necessary imports
16. Check if the class name matches the requirements, e.g. classWithUnitTests instead of classWithUnitTest
17. If a test fails, check it again to see if it's well written, is assertion correct

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.

2025-09-30 17:03:24.200 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 17:03:35.900 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 19950, outputTokenCount = 1936, totalTokenCount = 21886 }
2025-09-30 17:03:35.901 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 17:03:35.901 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveVowelsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenThrow(new RuntimeException("Remove vowels error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
        assertEquals("Remove vowels error", ex.getMessage());
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testRemoveConsonantsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Remove consonants error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
        assertEquals("Remove consonants error", ex.getMessage());
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testCountOccurrenceThrowsException() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenThrow(new RuntimeException("Count occurrence error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.countOccurrence(keyword, input));
        assertEquals("Count occurrence error", ex.getMessage());
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToYamlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("JSON to YAML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals("JSON to YAML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }

    @Test
    void testJsonToXmlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("JSON to XML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals("JSON to XML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
2025-09-30 17:03:35.901 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-09-30 17:03:35.903 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 17:03:35.904 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveVowelsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenThrow(new RuntimeException("Remove vowels error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
        assertEquals("Remove vowels error", ex.getMessage());
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testRemoveConsonantsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Remove consonants error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
        assertEquals("Remove consonants error", ex.getMessage());
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testCountOccurrenceThrowsException() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenThrow(new RuntimeException("Count occurrence error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.countOccurrence(keyword, input));
        assertEquals("Count occurrence error", ex.getMessage());
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToYamlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("JSON to YAML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals("JSON to YAML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }

    @Test
    void testJsonToXmlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("JSON to XML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals("JSON to XML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToXml(json);
    }
}

2025-09-30 17:04:12.971 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 17:04:12.972 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-09-30 17:04:12.972 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/hello")
    public String helloWorld() {
        return textService.helloworld();
    }

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveVowelsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenThrow(new RuntimeException("Remove vowels error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
        assertEquals("Remove vowels error", ex.getMessage());
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testRemoveConsonantsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Remove consonants error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
        assertEquals("Remove consonants error", ex.getMessage());
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testCountOccurrenceThrowsException() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenThrow(new RuntimeException("Count occurrence error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.countOccurrence(keyword, input));
        assertEquals("Count occurrence error", ex.getMessage());
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToYamlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("JSON to YAML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals("JSON to YAML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }

    @Test
    void testJsonToXmlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("JSON to XML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals("JSON to XML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToXml(json);
    }
}


>> REQUIREMENTS:

1. The response must contain fully functional test code.
2. The response must be in plain text (no code block formatting like '''java ''').
3. Place the generated tests in the SAME PACKAGE as the input JAVA class.
4. Follow this naming convention for the test class: use the original class name and append "GeneratedAiTests".
  - Do not add another "s" if the class name already ends with "s".
  - Do not append "Tests" if the class name ends with "x", "ch", "sh", or "ss".
    Example: `HelloAction` becomes `HelloActionGeneratedAiTests`.
5. Use JUNIT5 for the test framework, MOCKITO for mocking, and ASSERTJ for assertions.
6. Exclude `DisplayName` annotations.
7. Include necessary imports for annotations like `@ExtendWith`.
8. Ensure each test method has at least one assertion.
9. Avoid generating tests for private methods—focus only on public and protected methods.
10. Ensure any modified state in the test is reset before each test with a `@BeforeEach` method.
11. Tests should be independent; no test should rely on the result of another.
12. If no mocks are needed, skip importing mock-related libraries.
13. Organize the test methods using the GIVEN WHEN THEN structure. Each test should begin with a GIVEN section that sets up the necessary preconditions or context, followed by a WHEN section that describes the action being tested, and concluding with a THEN section that specifies the expected outcome. Include comments for each section to clearly indicate their purpose.
14. If error compilation refers to 'reference to assertThat is ambiguous' please do not use org.assertj.core.api.Assertions.assertThat, apart that please use assertEquals(expected, actual) from org.junit.jupiter.api.Assertions.assertEquals
15. Please do not forget about necessary imports
16. Check if the class name matches the requirements, e.g. classWithUnitTests instead of classWithUnitTest
17. If a test fails, check it again to see if it's well written, is assertion correct

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.

2025-09-30 17:04:12.973 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 17:04:13.648 ERROR [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:49)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - AI ERROR - did not generate response
java.lang.IllegalStateException: channel not registered to an event loop
	at io.netty.channel.AbstractChannel.eventLoop(AbstractChannel.java:163)
	at com.azure.core.http.netty.implementation.NettyUtility.closeConnection(NettyUtility.java:79)
	at com.azure.core.http.netty.implementation.NettyAsyncHttpResponse.close(NettyAsyncHttpResponse.java:116)
	at com.azure.core.http.policy.RetryPolicy.attemptSync(RetryPolicy.java:249)
	at com.azure.core.http.policy.RetryPolicy.processSync(RetryPolicy.java:161)
	at com.azure.core.http.HttpPipelineNextSyncPolicy.processSync(HttpPipelineNextSyncPolicy.java:53)
	at com.azure.core.http.policy.AddHeadersPolicy.processSync(AddHeadersPolicy.java:66)
	at com.azure.core.http.HttpPipelineNextSyncPolicy.processSync(HttpPipelineNextSyncPolicy.java:53)
	at com.azure.core.http.policy.AddHeadersFromContextPolicy.processSync(AddHeadersFromContextPolicy.java:67)
	at com.azure.core.http.HttpPipelineNextSyncPolicy.processSync(HttpPipelineNextSyncPolicy.java:53)
	at com.azure.core.http.policy.RequestIdPolicy.processSync(RequestIdPolicy.java:77)
	at com.azure.core.http.HttpPipelineNextSyncPolicy.processSync(HttpPipelineNextSyncPolicy.java:53)
	at com.azure.core.http.policy.HttpPipelineSyncPolicy.processSync(HttpPipelineSyncPolicy.java:51)
	at com.azure.core.http.policy.UserAgentPolicy.processSync(UserAgentPolicy.java:174)
	at com.azure.core.http.HttpPipelineNextSyncPolicy.processSync(HttpPipelineNextSyncPolicy.java:53)
	at com.azure.core.http.HttpPipeline.sendSync(HttpPipeline.java:138)
	at com.azure.core.implementation.http.rest.SyncRestProxy.send(SyncRestProxy.java:62)
	at com.azure.core.implementation.http.rest.SyncRestProxy.invoke(SyncRestProxy.java:83)
	at com.azure.core.implementation.http.rest.RestProxyBase.invoke(RestProxyBase.java:124)
	at com.azure.core.http.rest.RestProxy.invoke(RestProxy.java:95)
	at jdk.proxy2/jdk.proxy2.$Proxy68.getChatCompletionsSync(Unknown Source)
	at com.azure.ai.openai.implementation.OpenAIClientImpl.getChatCompletionsWithResponse(OpenAIClientImpl.java:1972)
	at com.azure.ai.openai.OpenAIClient.getChatCompletionsWithResponse(OpenAIClient.java:350)
	at com.azure.ai.openai.OpenAIClient.getChatCompletions(OpenAIClient.java:760)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.lambda$doChat$0(AzureOpenAiChatModel.java:208)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:29)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.doChat(AzureOpenAiChatModel.java:207)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:46)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:92)
	at io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:44)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:121)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:81)
	at io.github.adamw7.orchestrator.generator.persistence.PersistingImprovementGenerator.create(PersistingImprovementGenerator.java:36)
	at io.github.adamw7.orchestrator.generator.RetryImprovementGenerator.createInternal(RetryImprovementGenerator.java:80)
	at io.github.adamw7.orchestrator.generator.RetryImprovementGenerator.createInternal(RetryImprovementGenerator.java:105)
	at io.github.adamw7.orchestrator.generator.RetryImprovementGenerator.create(RetryImprovementGenerator.java:64)
	at io.github.adamw7.testing.generator.persistence.CodeRevertingGenerator.create(CodeRevertingGenerator.java:43)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
	at java.base/java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
	at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
	at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
	at java.base/java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
	at io.github.adamw7.testing.steps.ExceptionsHandlingGeneratorStep.improveExceptionsHandlingInGeneratedUnitTests(ExceptionsHandlingGeneratorStep.java:62)
	at io.github.adamw7.testing.steps.ExceptionsHandlingGeneratorStep.process(ExceptionsHandlingGeneratorStep.java:41)
	at io.github.adamw7.testing.steps.ProcessingPipeline.execute(ProcessingPipeline.java:17)
	at io.github.adamw7.testing.engine.UnitTestingEngine.execute(UnitTestingEngine.java:73)
	at io.github.adamw7.testing.cases.TestCase.execute(TestCase.java:21)
	at io.github.adamw7.testing.services.OrchestrationClientFacadeImpl.execute(OrchestrationClientFacadeImpl.java:15)
	at io.github.adamw7.testing.UnitTesting$1.run(UnitTesting.java:43)
	at org.springframework.boot.SpringApplication.lambda$callRunner$5(SpringApplication.java:788)
	at org.springframework.util.function.ThrowingConsumer$1.acceptWithException(ThrowingConsumer.java:82)
	at org.springframework.util.function.ThrowingConsumer.accept(ThrowingConsumer.java:60)
	at org.springframework.util.function.ThrowingConsumer$1.accept(ThrowingConsumer.java:86)
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:796)
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:787)
	at org.springframework.boot.SpringApplication.lambda$callRunners$3(SpringApplication.java:772)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
	at java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
	at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:772)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:325)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1361)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1350)
	at io.github.adamw7.testing.UnitTesting.main(UnitTesting.java:31)
2025-09-30 17:04:13.654 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:123)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Failed to generate code
2025-09-30 17:04:13.654 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 17:04:13.655 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:85)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - No code to be used! Generated code is empty
2025-09-30 17:04:53.665 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 17:04:53.665 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-09-30 17:04:53.666 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {

    private final TextService textService;

    @GetMapping("/hello")
    public String helloWorld() {
        return textService.helloworld();
    }

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveVowelsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenThrow(new RuntimeException("Remove vowels error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
        assertEquals("Remove vowels error", ex.getMessage());
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testRemoveConsonantsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Remove consonants error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
        assertEquals("Remove consonants error", ex.getMessage());
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testCountOccurrenceThrowsException() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenThrow(new RuntimeException("Count occurrence error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.countOccurrence(keyword, input));
        assertEquals("Count occurrence error", ex.getMessage());
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToYamlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("JSON to YAML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals("JSON to YAML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }

    @Test
    void testJsonToXmlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("JSON to XML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals("JSON to XML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToXml(json);
    }
}


>> REQUIREMENTS:

1. The response must contain fully functional test code.
2. The response must be in plain text (no code block formatting like '''java ''').
3. Place the generated tests in the SAME PACKAGE as the input JAVA class.
4. Follow this naming convention for the test class: use the original class name and append "GeneratedAiTests".
  - Do not add another "s" if the class name already ends with "s".
  - Do not append "Tests" if the class name ends with "x", "ch", "sh", or "ss".
    Example: `HelloAction` becomes `HelloActionGeneratedAiTests`.
5. Use JUNIT5 for the test framework, MOCKITO for mocking, and ASSERTJ for assertions.
6. Exclude `DisplayName` annotations.
7. Include necessary imports for annotations like `@ExtendWith`.
8. Ensure each test method has at least one assertion.
9. Avoid generating tests for private methods—focus only on public and protected methods.
10. Ensure any modified state in the test is reset before each test with a `@BeforeEach` method.
11. Tests should be independent; no test should rely on the result of another.
12. If no mocks are needed, skip importing mock-related libraries.
13. Organize the test methods using the GIVEN WHEN THEN structure. Each test should begin with a GIVEN section that sets up the necessary preconditions or context, followed by a WHEN section that describes the action being tested, and concluding with a THEN section that specifies the expected outcome. Include comments for each section to clearly indicate their purpose.
14. If error compilation refers to 'reference to assertThat is ambiguous' please do not use org.assertj.core.api.Assertions.assertThat, apart that please use assertEquals(expected, actual) from org.junit.jupiter.api.Assertions.assertEquals
15. Please do not forget about necessary imports
16. Check if the class name matches the requirements, e.g. classWithUnitTests instead of classWithUnitTest
17. If a test fails, check it again to see if it's well written, is assertion correct

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.

2025-09-30 17:04:53.668 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 17:05:03.200 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 27883, outputTokenCount = 1936, totalTokenCount = 29819 }
2025-09-30 17:05:03.201 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 17:05:03.202 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveVowelsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenThrow(new RuntimeException("Remove vowels error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
        assertEquals("Remove vowels error", ex.getMessage());
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testRemoveConsonantsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Remove consonants error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
        assertEquals("Remove consonants error", ex.getMessage());
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testCountOccurrenceThrowsException() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenThrow(new RuntimeException("Count occurrence error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.countOccurrence(keyword, input));
        assertEquals("Count occurrence error", ex.getMessage());
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToYamlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("JSON to YAML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals("JSON to YAML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }

    @Test
    void testJsonToXmlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("JSON to XML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals("JSON to XML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
2025-09-30 17:05:03.202 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-09-30 17:05:03.203 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-09-30 17:05:03.204 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // Reset or prepare mocks before each test
    }

    @Test
    void testHelloWorld() {
        // GIVEN
        when(textService.helloworld()).thenReturn("Hello, World!");

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals("Hello, World!", result);
        verify(textService, times(1)).helloworld();
    }

    @Test
    void testReverse() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenReturn("cba");

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals("cba", result);
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testReverseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.reverse(input)).thenThrow(new RuntimeException("Reverse error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.reverse(input));
        assertEquals("Reverse error", ex.getMessage());
        verify(textService, times(1)).reverse(input);
    }

    @Test
    void testUppercase() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenReturn("ABC");

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals("ABC", result);
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testUppercaseThrowsException() {
        // GIVEN
        String input = "abc";
        when(textService.uppercase(input)).thenThrow(new RuntimeException("Uppercase error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.uppercase(input));
        assertEquals("Uppercase error", ex.getMessage());
        verify(textService, times(1)).uppercase(input);
    }

    @Test
    void testStats() {
        // GIVEN
        String input = "Hello World";
        Map<String, Object> mockStats = Map.of("length", 11);
        when(textService.stats(input)).thenReturn(mockStats);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(mockStats, result);
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testStatsThrowsException() {
        // GIVEN
        String input = "Hello World";
        when(textService.stats(input)).thenThrow(new RuntimeException("Stats error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.stats(input));
        assertEquals("Stats error", ex.getMessage());
        verify(textService, times(1)).stats(input);
    }

    @Test
    void testReplace() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenReturn("Hello Java");

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals("Hello Java", result);
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testReplaceThrowsException() {
        // GIVEN
        String input = "Hello World";
        String target = "World";
        String replacement = "Java";
        when(textService.replace(input, target, replacement)).thenThrow(new RuntimeException("Replace error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.replace(target, replacement, input));
        assertEquals("Replace error", ex.getMessage());
        verify(textService, times(1)).replace(input, target, replacement);
    }

    @Test
    void testRemoveVowels() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenReturn("Hll");

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals("Hll", result);
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveVowelsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeVowels(input)).thenThrow(new RuntimeException("Remove vowels error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeVowels(input));
        assertEquals("Remove vowels error", ex.getMessage());
        verify(textService, times(1)).removeVowels(input);
    }

    @Test
    void testRemoveConsonants() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenReturn("eo");

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals("eo", result);
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testRemoveConsonantsThrowsException() {
        // GIVEN
        String input = "Hello";
        when(textService.removeConsonants(input)).thenThrow(new RuntimeException("Remove consonants error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.removeConsonants(input));
        assertEquals("Remove consonants error", ex.getMessage());
        verify(textService, times(1)).removeConsonants(input);
    }

    @Test
    void testCountOccurrence() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenReturn(2);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(2, result);
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testCountOccurrenceThrowsException() {
        // GIVEN
        String input = "Hello Hello World";
        String keyword = "Hello";
        when(textService.countOccurrence(input, keyword)).thenThrow(new RuntimeException("Count occurrence error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.countOccurrence(keyword, input));
        assertEquals("Count occurrence error", ex.getMessage());
        verify(textService, times(1)).countOccurrence(input, keyword);
    }

    @Test
    void testJsonToYaml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String yaml = "key: value";
        when(textService.convertJsonToYaml(json)).thenReturn(yaml);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(yaml, result);
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToYamlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToYaml(json)).thenThrow(new RuntimeException("JSON to YAML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToYaml(json));
        assertEquals("JSON to YAML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToYaml(json);
    }

    @Test
    void testJsonToXml() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String xml = "<key>value</key>";
        when(textService.convertJsonToXml(json)).thenReturn(xml);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(xml, result);
        verify(textService, times(1)).convertJsonToXml(json);
    }

    @Test
    void testJsonToXmlThrowsException() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        when(textService.convertJsonToXml(json)).thenThrow(new RuntimeException("JSON to XML error"));

        // WHEN & THEN
        RuntimeException ex = assertThrows(RuntimeException.class, () -> textController.jsonToXml(json));
        assertEquals("JSON to XML error", ex.getMessage());
        verify(textService, times(1)).convertJsonToXml(json);
    }
}
*/
