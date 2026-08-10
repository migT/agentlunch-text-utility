package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "hello";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("olleh", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "test";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("TEST", result);
    }

    @Test
    void testUppercase_withMixedCase_returnsUppercase() {
        // GIVEN
        String input = "TeSt123";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("TEST123", result);
    }

    @Test
    void testStats_withNormalText_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(23, stats.get("length"));
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertTrue(stats.get("VowelCount") instanceof Integer);
        assertTrue(stats.get("ConsonantCount") instanceof Integer);
        assertTrue(stats.get("RepeatedWords") instanceof List);
    }

    @Test
    void testStats_withEmptyString_returnsZeroes() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertTrue(stats.get("VowelCount") instanceof Integer);
        assertTrue(stats.get("ConsonantCount") instanceof Integer);
        assertTrue(stats.get("RepeatedWords") instanceof List);
    }

    @Test
    void testGetRepeatedWords_withRepeatedWords_returnsList() {
        // GIVEN
        String input = "cat dog cat bird dog dog";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.contains("cat : 2"));
        assertTrue(repeated.contains("dog : 3"));
        assertFalse(repeated.contains("bird : 1"));
    }

    @Test
    void testGetRepeatedWords_withNoRepeatedWords_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyString_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> repeated = textService.getRepeatedWords(input);
        // THEN
        assertTrue(repeated.isEmpty());
    }

    @Test
    void testReplace_withExistingTarget_replacesCorrectly() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("baz bar baz", result);
    }

    @Test
    void testReplace_withNonExistingTarget_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "test";
        String replacement = "xyz";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_removesAllVowels() {
        // GIVEN
        String input = "Beautiful";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_removesAllConsonants() {
        // GIVEN
        String input = "Beautiful";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu", result);
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiouAEIOU";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiouAEIOU", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "cat dog cat bird cat";
        String keyword = "cat";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "apple banana orange";
        String keyword = "cat";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_caseInsensitive() {
        // GIVEN
        String input = "Cat cat CAT cAt";
        String keyword = "cat";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(4, count);
    }

    @Test
    void testHelloworld_returnsHelloWorld() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsError() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsError() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

/*
2025-10-06 09:54:14.659 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 09:54:14.679 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:14.681 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.850 s <<< FAILURE! -- in com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats -- Time elapsed: 0.021 s <<< FAILURE!
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants -- Time elapsed: 0.003 s <<< FAILURE!
[ERROR] Failures: 
[ERROR]   TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants:175 expected: <eauiua> but was: <eauiu a>
[ERROR]   TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats:66 expected: <28> but was: <29>
[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project text-api: There are test failures.
[ERROR] 
[ERROR] Please refer to C:\Users\JOSCAMAC\AppData\Local\Temp\codeai-test-14938987443307845673\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# TASK: Correct the error in the test class.

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.

2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #14 with 11 messages
2025-10-06 09:54:20.798 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 3946, outputTokenCount = 1024, totalTokenCount = 4970 }
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #15 with 13 messages
2025-10-06 09:54:25.209 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 4982, outputTokenCount = 741, totalTokenCount = 5723 }
2025-10-06 09:54:25.210 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.210 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:25.211 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:25.214 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.214 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

2025-10-06 09:54:40.850 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:40.851 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:40.852 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}


# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:40.853 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:40.854 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #17 with 15 messages
2025-10-06 09:54:46.218 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 7686, outputTokenCount = 1024, totalTokenCount = 8710 }
2025-10-06 09:54:46.219 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:46.220 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #18 with 17 messages
2025-10-06 09:54:50.485 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 8722, outputTokenCount = 819, totalTokenCount = 9541 }
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.487 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:50.488 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.489 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:58.007 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:58.008 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:58.009 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:58.011 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:58.012 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #19 with 19 messages
2025-10-06 09:55:06.948 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 11507, outputTokenCount = 1024, totalTokenCount = 12531 }
2025-10-06 09:55:06.950 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:06.951 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #20 with 21 messages
2025-10-06 09:55:28.963 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 12543, outputTokenCount = 819, totalTokenCount = 13362 }
2025-10-06 09:55:28.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.964 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:28.965 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:55:28.966 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.967 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:40.029 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:55:40.030 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:55:40.031 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:55:40.033 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:55:40.034 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #21 with 23 messages
2025-10-06 09:55:53.449 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 15328, outputTokenCount = 1024, totalTokenCount = 16352 }
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #22 with 25 messages
2025-10-06 09:56:02.960 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 16364, outputTokenCount = 819, totalTokenCount = 17183 }
2025-10-06 09:56:02.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.965 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:56:02.967 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:56:02.968 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.968 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 10:04:33.932 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-10-06 10:04:33.935 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:39)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing exceptions handling issue...
2025-10-06 10:04:33.938 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 10:04:33.940 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.service;

import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class TextService {

    private static final String HELLO_WORLD = "Hello, World!";
    public static final String VOWEL_PATTERN = "(?i)[^aeiou]";
    public static final String STRING_EMPTY = "";
    private static final String consonantPattern = "(?i)[^b-df-hj-np-tv-z]";

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String uppercase(String input) {
        return input.toUpperCase();
    }

    public Map<String, Object> stats(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("length", getLength(input));
        result.put("wordCount", getSplitCount(input, "\\s+"));
        result.put("lineCount", getSplitCount(input, "\\n"));
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    private Integer getLength(String input) {
        if (input == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(input.length());
    }

    private static Integer getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return Integer.valueOf(length);
    }

    public List<String> getRepeatedWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        // Normalize input: lowercase and remove punctuation (except digits/letters)
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        // Count word occurrences
        for (String word : words) {
            wordCount.put(word, Integer.valueOf(wordCount.getOrDefault(word, Integer.valueOf(0)) + 1));
        }

        // Collect only repeated words with their count
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey() + " : " + entry.getValue());
            }
        }

        return result;
    }

    private Integer getConsonantCount(String input) {
        return Integer.valueOf(input.replaceAll(consonantPattern, STRING_EMPTY).length());
    }

    private Integer getVowelCount(String input) {
        return Integer.valueOf(input.replaceAll(VOWEL_PATTERN, STRING_EMPTY).length());
    }

    public String replace(String input, String target, String replacement) {
        return input.replace(target, replacement);
    }

    public String removeVowels(String input) {
        return removePattern(input,"(?i)[aeiou]");
    }

    public String removeConsonants(String input) {
        return removePattern(input,"(?i)[b-df-hj-np-tv-z]");
    }

    private String removePattern(String input, String regex) {
        return input.replaceAll(regex, "");
    }

    public int countOccurrence(String input, String keyword) {
        return input.split("(?i)\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1;
    }

    public String helloworld() {
        return HELLO_WORLD;
    }

    public String convertJsonToYaml(String json) {
        return TextConversionUtil.convertJsonToYaml(json);
    }

    public String convertJsonToXml(String json) {
        return TextConversionUtil.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
/*
2025-10-06 09:54:14.659 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 09:54:14.679 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:14.681 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.850 s <<< FAILURE! -- in com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats -- Time elapsed: 0.021 s <<< FAILURE!
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants -- Time elapsed: 0.003 s <<< FAILURE!
[ERROR] Failures: 
[ERROR]   TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants:175 expected: <eauiua> but was: <eauiu a>
[ERROR]   TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats:66 expected: <28> but was: <29>
[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project text-api: There are test failures.
[ERROR] 
[ERROR] Please refer to C:\Users\JOSCAMAC\AppData\Local\Temp\codeai-test-14938987443307845673\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# TASK: Correct the error in the test class.

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.

2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #14 with 11 messages
2025-10-06 09:54:20.798 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 3946, outputTokenCount = 1024, totalTokenCount = 4970 }
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #15 with 13 messages
2025-10-06 09:54:25.209 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 4982, outputTokenCount = 741, totalTokenCount = 5723 }
2025-10-06 09:54:25.210 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.210 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:25.211 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:25.214 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.214 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

2025-10-06 09:54:40.850 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:40.851 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:40.852 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}


# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:40.853 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:40.854 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #17 with 15 messages
2025-10-06 09:54:46.218 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 7686, outputTokenCount = 1024, totalTokenCount = 8710 }
2025-10-06 09:54:46.219 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:46.220 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #18 with 17 messages
2025-10-06 09:54:50.485 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 8722, outputTokenCount = 819, totalTokenCount = 9541 }
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.487 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:50.488 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.489 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:58.007 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:58.008 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:58.009 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:58.011 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:58.012 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #19 with 19 messages
2025-10-06 09:55:06.948 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 11507, outputTokenCount = 1024, totalTokenCount = 12531 }
2025-10-06 09:55:06.950 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:06.951 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #20 with 21 messages
2025-10-06 09:55:28.963 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 12543, outputTokenCount = 819, totalTokenCount = 13362 }
2025-10-06 09:55:28.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.964 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:28.965 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:55:28.966 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.967 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:40.029 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:55:40.030 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:55:40.031 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:55:40.033 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:55:40.034 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #21 with 23 messages
2025-10-06 09:55:53.449 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 15328, outputTokenCount = 1024, totalTokenCount = 16352 }
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #22 with 25 messages
2025-10-06 09:56:02.960 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 16364, outputTokenCount = 819, totalTokenCount = 17183 }
2025-10-06 09:56:02.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.965 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:56:02.967 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:56:02.968 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.968 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
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

Correct the following error:

[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project text-api: Compilation failure: Compilation failure: 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR]   symbol:   variable Stringinput
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR]   symbol:   variable input
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# REQUIREMENTS:
1. Respond with the corrected class code.
2. Do not provide explanations or comments.

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.
ts

2025-10-06 10:04:33.950 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 10:04:33.951 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #33 with 31 messages
2025-10-06 10:06:37.425 ERROR [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:52)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI ERROR - did not generate response
dev.langchain4j.exception.RateLimitException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at dev.langchain4j.internal.ExceptionMapper$DefaultExceptionMapper.mapHttpStatusCode(ExceptionMapper.java:68)
	at dev.langchain4j.model.azure.AzureOpenAiExceptionMapper.mapException(AzureOpenAiExceptionMapper.java:30)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:31)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.doChat(AzureOpenAiChatModel.java:207)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:46)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:92)
	at io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:47)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:79)
	at io.github.adamw7.orchestrator.generator.persistence.PersistingImprovementGenerator.create(PersistingImprovementGenerator.java:36)
	at io.github.adamw7.orchestrator.generator.RetryImprovementGenerator.createInternal(RetryImprovementGenerator.java:80)
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
Caused by: com.azure.core.exception.HttpResponseException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at com.azure.core.implementation.http.rest.RestProxyBase.instantiateUnexpectedException(RestProxyBase.java:388)
	at com.azure.core.implementation.http.rest.SyncRestProxy.ensureExpectedStatus(SyncRestProxy.java:133)
	at com.azure.core.implementation.http.rest.SyncRestProxy.handleRestReturnType(SyncRestProxy.java:211)
	at com.azure.core.implementation.http.rest.SyncRestProxy.invoke(SyncRestProxy.java:86)
	at com.azure.core.implementation.http.rest.RestProxyBase.invoke(RestProxyBase.java:124)
	at com.azure.core.http.rest.RestProxy.invoke(RestProxy.java:95)
	at jdk.proxy2/jdk.proxy2.$Proxy71.getChatCompletionsSync(Unknown Source)
	at com.azure.ai.openai.implementation.OpenAIClientImpl.getChatCompletionsWithResponse(OpenAIClientImpl.java:1972)
	at com.azure.ai.openai.OpenAIClient.getChatCompletionsWithResponse(OpenAIClient.java:350)
	at com.azure.ai.openai.OpenAIClient.getChatCompletions(OpenAIClient.java:760)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.lambda$doChat$0(AzureOpenAiChatModel.java:208)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:29)
	... 46 more
2025-10-06 10:06:37.431 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:121)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Failed to generate code
2025-10-06 10:06:37.432 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 10:06:37.432 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:83)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - No code to be used! Generated code is empty
2025-10-06 10:06:52.787 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-10-06 10:06:52.787 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:39)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing exceptions handling issue...
2025-10-06 10:06:52.792 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 10:06:52.794 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.service;

import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class TextService {

    private static final String HELLO_WORLD = "Hello, World!";
    public static final String VOWEL_PATTERN = "(?i)[^aeiou]";
    public static final String STRING_EMPTY = "";
    private static final String consonantPattern = "(?i)[^b-df-hj-np-tv-z]";

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String uppercase(String input) {
        return input.toUpperCase();
    }

    public Map<String, Object> stats(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("length", getLength(input));
        result.put("wordCount", getSplitCount(input, "\\s+"));
        result.put("lineCount", getSplitCount(input, "\\n"));
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    private Integer getLength(String input) {
        if (input == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(input.length());
    }

    private static Integer getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return Integer.valueOf(length);
    }

    public List<String> getRepeatedWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        // Normalize input: lowercase and remove punctuation (except digits/letters)
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        // Count word occurrences
        for (String word : words) {
            wordCount.put(word, Integer.valueOf(wordCount.getOrDefault(word, Integer.valueOf(0)) + 1));
        }

        // Collect only repeated words with their count
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey() + " : " + entry.getValue());
            }
        }

        return result;
    }

    private Integer getConsonantCount(String input) {
        return Integer.valueOf(input.replaceAll(consonantPattern, STRING_EMPTY).length());
    }

    private Integer getVowelCount(String input) {
        return Integer.valueOf(input.replaceAll(VOWEL_PATTERN, STRING_EMPTY).length());
    }

    public String replace(String input, String target, String replacement) {
        return input.replace(target, replacement);
    }

    public String removeVowels(String input) {
        return removePattern(input,"(?i)[aeiou]");
    }

    public String removeConsonants(String input) {
        return removePattern(input,"(?i)[b-df-hj-np-tv-z]");
    }

    private String removePattern(String input, String regex) {
        return input.replaceAll(regex, "");
    }

    public int countOccurrence(String input, String keyword) {
        return input.split("(?i)\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1;
    }

    public String helloworld() {
        return HELLO_WORLD;
    }

    public String convertJsonToYaml(String json) {
        return TextConversionUtil.convertJsonToYaml(json);
    }

    public String convertJsonToXml(String json) {
        return TextConversionUtil.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
/*
2025-10-06 09:54:14.659 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 09:54:14.679 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:14.681 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.850 s <<< FAILURE! -- in com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats -- Time elapsed: 0.021 s <<< FAILURE!
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants -- Time elapsed: 0.003 s <<< FAILURE!
[ERROR] Failures: 
[ERROR]   TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants:175 expected: <eauiua> but was: <eauiu a>
[ERROR]   TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats:66 expected: <28> but was: <29>
[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project text-api: There are test failures.
[ERROR] 
[ERROR] Please refer to C:\Users\JOSCAMAC\AppData\Local\Temp\codeai-test-14938987443307845673\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# TASK: Correct the error in the test class.

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.

2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #14 with 11 messages
2025-10-06 09:54:20.798 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 3946, outputTokenCount = 1024, totalTokenCount = 4970 }
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #15 with 13 messages
2025-10-06 09:54:25.209 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 4982, outputTokenCount = 741, totalTokenCount = 5723 }
2025-10-06 09:54:25.210 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.210 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:25.211 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:25.214 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.214 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

2025-10-06 09:54:40.850 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:40.851 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:40.852 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}


# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:40.853 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:40.854 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #17 with 15 messages
2025-10-06 09:54:46.218 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 7686, outputTokenCount = 1024, totalTokenCount = 8710 }
2025-10-06 09:54:46.219 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:46.220 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #18 with 17 messages
2025-10-06 09:54:50.485 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 8722, outputTokenCount = 819, totalTokenCount = 9541 }
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.487 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:50.488 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.489 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:58.007 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:58.008 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:58.009 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:58.011 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:58.012 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #19 with 19 messages
2025-10-06 09:55:06.948 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 11507, outputTokenCount = 1024, totalTokenCount = 12531 }
2025-10-06 09:55:06.950 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:06.951 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #20 with 21 messages
2025-10-06 09:55:28.963 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 12543, outputTokenCount = 819, totalTokenCount = 13362 }
2025-10-06 09:55:28.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.964 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:28.965 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:55:28.966 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.967 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:40.029 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:55:40.030 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:55:40.031 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:55:40.033 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:55:40.034 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #21 with 23 messages
2025-10-06 09:55:53.449 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 15328, outputTokenCount = 1024, totalTokenCount = 16352 }
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #22 with 25 messages
2025-10-06 09:56:02.960 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 16364, outputTokenCount = 819, totalTokenCount = 17183 }
2025-10-06 09:56:02.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.965 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:56:02.967 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:56:02.968 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.968 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
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

Correct the following error:

[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project text-api: Compilation failure: Compilation failure: 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR]   symbol:   variable Stringinput
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR]   symbol:   variable input
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# REQUIREMENTS:
1. Respond with the corrected class code.
2. Do not provide explanations or comments.

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.
ts

2025-10-06 10:06:52.822 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 10:06:52.823 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #34 with 36 messages
2025-10-06 10:08:56.177 ERROR [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:52)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI ERROR - did not generate response
dev.langchain4j.exception.RateLimitException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at dev.langchain4j.internal.ExceptionMapper$DefaultExceptionMapper.mapHttpStatusCode(ExceptionMapper.java:68)
	at dev.langchain4j.model.azure.AzureOpenAiExceptionMapper.mapException(AzureOpenAiExceptionMapper.java:30)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:31)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.doChat(AzureOpenAiChatModel.java:207)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:46)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:92)
	at io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:47)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:79)
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
Caused by: com.azure.core.exception.HttpResponseException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at com.azure.core.implementation.http.rest.RestProxyBase.instantiateUnexpectedException(RestProxyBase.java:388)
	at com.azure.core.implementation.http.rest.SyncRestProxy.ensureExpectedStatus(SyncRestProxy.java:133)
	at com.azure.core.implementation.http.rest.SyncRestProxy.handleRestReturnType(SyncRestProxy.java:211)
	at com.azure.core.implementation.http.rest.SyncRestProxy.invoke(SyncRestProxy.java:86)
	at com.azure.core.implementation.http.rest.RestProxyBase.invoke(RestProxyBase.java:124)
	at com.azure.core.http.rest.RestProxy.invoke(RestProxy.java:95)
	at jdk.proxy2/jdk.proxy2.$Proxy71.getChatCompletionsSync(Unknown Source)
	at com.azure.ai.openai.implementation.OpenAIClientImpl.getChatCompletionsWithResponse(OpenAIClientImpl.java:1972)
	at com.azure.ai.openai.OpenAIClient.getChatCompletionsWithResponse(OpenAIClient.java:350)
	at com.azure.ai.openai.OpenAIClient.getChatCompletions(OpenAIClient.java:760)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.lambda$doChat$0(AzureOpenAiChatModel.java:208)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:29)
	... 47 more
2025-10-06 10:08:56.187 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:121)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Failed to generate code
2025-10-06 10:08:56.189 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 10:08:56.190 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:83)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - No code to be used! Generated code is empty
2025-10-06 10:09:30.015 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-10-06 10:09:30.017 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:39)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing exceptions handling issue...
2025-10-06 10:09:30.026 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 10:09:30.034 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.service;

import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class TextService {

    private static final String HELLO_WORLD = "Hello, World!";
    public static final String VOWEL_PATTERN = "(?i)[^aeiou]";
    public static final String STRING_EMPTY = "";
    private static final String consonantPattern = "(?i)[^b-df-hj-np-tv-z]";

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String uppercase(String input) {
        return input.toUpperCase();
    }

    public Map<String, Object> stats(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("length", getLength(input));
        result.put("wordCount", getSplitCount(input, "\\s+"));
        result.put("lineCount", getSplitCount(input, "\\n"));
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    private Integer getLength(String input) {
        if (input == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(input.length());
    }

    private static Integer getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return Integer.valueOf(length);
    }

    public List<String> getRepeatedWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        // Normalize input: lowercase and remove punctuation (except digits/letters)
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        // Count word occurrences
        for (String word : words) {
            wordCount.put(word, Integer.valueOf(wordCount.getOrDefault(word, Integer.valueOf(0)) + 1));
        }

        // Collect only repeated words with their count
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey() + " : " + entry.getValue());
            }
        }

        return result;
    }

    private Integer getConsonantCount(String input) {
        return Integer.valueOf(input.replaceAll(consonantPattern, STRING_EMPTY).length());
    }

    private Integer getVowelCount(String input) {
        return Integer.valueOf(input.replaceAll(VOWEL_PATTERN, STRING_EMPTY).length());
    }

    public String replace(String input, String target, String replacement) {
        return input.replace(target, replacement);
    }

    public String removeVowels(String input) {
        return removePattern(input,"(?i)[aeiou]");
    }

    public String removeConsonants(String input) {
        return removePattern(input,"(?i)[b-df-hj-np-tv-z]");
    }

    private String removePattern(String input, String regex) {
        return input.replaceAll(regex, "");
    }

    public int countOccurrence(String input, String keyword) {
        return input.split("(?i)\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1;
    }

    public String helloworld() {
        return HELLO_WORLD;
    }

    public String convertJsonToYaml(String json) {
        return TextConversionUtil.convertJsonToYaml(json);
    }

    public String convertJsonToXml(String json) {
        return TextConversionUtil.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
/*
2025-10-06 09:54:14.659 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 09:54:14.679 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:14.681 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.850 s <<< FAILURE! -- in com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats -- Time elapsed: 0.021 s <<< FAILURE!
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants -- Time elapsed: 0.003 s <<< FAILURE!
[ERROR] Failures: 
[ERROR]   TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants:175 expected: <eauiua> but was: <eauiu a>
[ERROR]   TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats:66 expected: <28> but was: <29>
[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project text-api: There are test failures.
[ERROR] 
[ERROR] Please refer to C:\Users\JOSCAMAC\AppData\Local\Temp\codeai-test-14938987443307845673\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# TASK: Correct the error in the test class.

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.

2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #14 with 11 messages
2025-10-06 09:54:20.798 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 3946, outputTokenCount = 1024, totalTokenCount = 4970 }
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #15 with 13 messages
2025-10-06 09:54:25.209 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 4982, outputTokenCount = 741, totalTokenCount = 5723 }
2025-10-06 09:54:25.210 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.210 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:25.211 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:25.214 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.214 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

2025-10-06 09:54:40.850 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:40.851 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:40.852 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}


# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:40.853 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:40.854 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #17 with 15 messages
2025-10-06 09:54:46.218 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 7686, outputTokenCount = 1024, totalTokenCount = 8710 }
2025-10-06 09:54:46.219 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:46.220 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #18 with 17 messages
2025-10-06 09:54:50.485 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 8722, outputTokenCount = 819, totalTokenCount = 9541 }
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.487 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:50.488 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.489 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:58.007 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:58.008 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:58.009 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:58.011 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:58.012 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #19 with 19 messages
2025-10-06 09:55:06.948 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 11507, outputTokenCount = 1024, totalTokenCount = 12531 }
2025-10-06 09:55:06.950 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:06.951 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #20 with 21 messages
2025-10-06 09:55:28.963 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 12543, outputTokenCount = 819, totalTokenCount = 13362 }
2025-10-06 09:55:28.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.964 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:28.965 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:55:28.966 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.967 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:40.029 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:55:40.030 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:55:40.031 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:55:40.033 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:55:40.034 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #21 with 23 messages
2025-10-06 09:55:53.449 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 15328, outputTokenCount = 1024, totalTokenCount = 16352 }
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #22 with 25 messages
2025-10-06 09:56:02.960 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 16364, outputTokenCount = 819, totalTokenCount = 17183 }
2025-10-06 09:56:02.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.965 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:56:02.967 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:56:02.968 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.968 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
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

Correct the following error:

[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project text-api: Compilation failure: Compilation failure: 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR]   symbol:   variable Stringinput
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR]   symbol:   variable input
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# REQUIREMENTS:
1. Respond with the corrected class code.
2. Do not provide explanations or comments.

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.
ts

2025-10-06 10:09:30.057 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 10:09:30.059 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #35 with 41 messages
2025-10-06 10:11:33.874 ERROR [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:52)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI ERROR - did not generate response
dev.langchain4j.exception.RateLimitException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at dev.langchain4j.internal.ExceptionMapper$DefaultExceptionMapper.mapHttpStatusCode(ExceptionMapper.java:68)
	at dev.langchain4j.model.azure.AzureOpenAiExceptionMapper.mapException(AzureOpenAiExceptionMapper.java:30)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:31)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.doChat(AzureOpenAiChatModel.java:207)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:46)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:92)
	at io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:47)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:79)
	at io.github.adamw7.orchestrator.generator.persistence.PersistingImprovementGenerator.create(PersistingImprovementGenerator.java:36)
	at io.github.adamw7.orchestrator.generator.RetryImprovementGenerator.createInternal(RetryImprovementGenerator.java:80)
	at io.github.adamw7.orchestrator.generator.RetryImprovementGenerator.createInternal(RetryImprovementGenerator.java:105)
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
Caused by: com.azure.core.exception.HttpResponseException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at com.azure.core.implementation.http.rest.RestProxyBase.instantiateUnexpectedException(RestProxyBase.java:388)
	at com.azure.core.implementation.http.rest.SyncRestProxy.ensureExpectedStatus(SyncRestProxy.java:133)
	at com.azure.core.implementation.http.rest.SyncRestProxy.handleRestReturnType(SyncRestProxy.java:211)
	at com.azure.core.implementation.http.rest.SyncRestProxy.invoke(SyncRestProxy.java:86)
	at com.azure.core.implementation.http.rest.RestProxyBase.invoke(RestProxyBase.java:124)
	at com.azure.core.http.rest.RestProxy.invoke(RestProxy.java:95)
	at jdk.proxy2/jdk.proxy2.$Proxy71.getChatCompletionsSync(Unknown Source)
	at com.azure.ai.openai.implementation.OpenAIClientImpl.getChatCompletionsWithResponse(OpenAIClientImpl.java:1972)
	at com.azure.ai.openai.OpenAIClient.getChatCompletionsWithResponse(OpenAIClient.java:350)
	at com.azure.ai.openai.OpenAIClient.getChatCompletions(OpenAIClient.java:760)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.lambda$doChat$0(AzureOpenAiChatModel.java:208)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:29)
	... 48 more
2025-10-06 10:11:33.885 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:121)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Failed to generate code
2025-10-06 10:11:33.885 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 10:11:33.885 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:83)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - No code to be used! Generated code is empty
2025-10-06 10:21:35.376 INFO [main] [io.github.adamw7.testing.generator.prompt.ImproveUnitTestsPromptProvider.getPromptMessages(ImproveUnitTestsPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for improving unit tests generation...
2025-10-06 10:21:35.379 INFO [main] [io.github.adamw7.testing.generator.prompt.ImproveUnitTestsPromptProvider.getPromptMessages(ImproveUnitTestsPromptProvider.java:39)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 10:21:35.382 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 10:21:35.386 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.service;

import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class TextService {

    private static final String HELLO_WORLD = "Hello, World!";
    public static final String VOWEL_PATTERN = "(?i)[^aeiou]";
    public static final String STRING_EMPTY = "";
    private static final String consonantPattern = "(?i)[^b-df-hj-np-tv-z]";

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String uppercase(String input) {
        return input.toUpperCase();
    }

    public Map<String, Object> stats(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("length", getLength(input));
        result.put("wordCount", getSplitCount(input, "\\s+"));
        result.put("lineCount", getSplitCount(input, "\\n"));
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    private Integer getLength(String input) {
        if (input == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(input.length());
    }

    private static Integer getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return Integer.valueOf(length);
    }

    public List<String> getRepeatedWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        // Normalize input: lowercase and remove punctuation (except digits/letters)
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        // Count word occurrences
        for (String word : words) {
            wordCount.put(word, Integer.valueOf(wordCount.getOrDefault(word, Integer.valueOf(0)) + 1));
        }

        // Collect only repeated words with their count
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey() + " : " + entry.getValue());
            }
        }

        return result;
    }

    private Integer getConsonantCount(String input) {
        return Integer.valueOf(input.replaceAll(consonantPattern, STRING_EMPTY).length());
    }

    private Integer getVowelCount(String input) {
        return Integer.valueOf(input.replaceAll(VOWEL_PATTERN, STRING_EMPTY).length());
    }

    public String replace(String input, String target, String replacement) {
        return input.replace(target, replacement);
    }

    public String removeVowels(String input) {
        return removePattern(input,"(?i)[aeiou]");
    }

    public String removeConsonants(String input) {
        return removePattern(input,"(?i)[b-df-hj-np-tv-z]");
    }

    private String removePattern(String input, String regex) {
        return input.replaceAll(regex, "");
    }

    public int countOccurrence(String input, String keyword) {
        return input.split("(?i)\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1;
    }

    public String helloworld() {
        return HELLO_WORLD;
    }

    public String convertJsonToYaml(String json) {
        return TextConversionUtil.convertJsonToYaml(json);
    }

    public String convertJsonToXml(String json) {
        return TextConversionUtil.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests, please review the following test class, fix any compilation error, improve the tests,
 and suggest corrections that could enhance their quality. If there are any logical errors or issues with the tests themselves, please address them.


package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
/*
2025-10-06 09:54:14.659 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 09:54:14.679 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:14.681 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.850 s <<< FAILURE! -- in com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats -- Time elapsed: 0.021 s <<< FAILURE!
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants -- Time elapsed: 0.003 s <<< FAILURE!
[ERROR] Failures: 
[ERROR]   TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants:175 expected: <eauiua> but was: <eauiu a>
[ERROR]   TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats:66 expected: <28> but was: <29>
[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project text-api: There are test failures.
[ERROR] 
[ERROR] Please refer to C:\Users\JOSCAMAC\AppData\Local\Temp\codeai-test-14938987443307845673\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# TASK: Correct the error in the test class.

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.

2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #14 with 11 messages
2025-10-06 09:54:20.798 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 3946, outputTokenCount = 1024, totalTokenCount = 4970 }
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #15 with 13 messages
2025-10-06 09:54:25.209 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 4982, outputTokenCount = 741, totalTokenCount = 5723 }
2025-10-06 09:54:25.210 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.210 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:25.211 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:25.214 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.214 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

2025-10-06 09:54:40.850 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:40.851 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:40.852 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}


# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:40.853 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:40.854 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #17 with 15 messages
2025-10-06 09:54:46.218 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 7686, outputTokenCount = 1024, totalTokenCount = 8710 }
2025-10-06 09:54:46.219 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:46.220 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #18 with 17 messages
2025-10-06 09:54:50.485 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 8722, outputTokenCount = 819, totalTokenCount = 9541 }
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.487 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:50.488 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.489 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:58.007 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:58.008 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:58.009 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:58.011 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:58.012 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #19 with 19 messages
2025-10-06 09:55:06.948 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 11507, outputTokenCount = 1024, totalTokenCount = 12531 }
2025-10-06 09:55:06.950 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:06.951 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #20 with 21 messages
2025-10-06 09:55:28.963 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 12543, outputTokenCount = 819, totalTokenCount = 13362 }
2025-10-06 09:55:28.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.964 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:28.965 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:55:28.966 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.967 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:40.029 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:55:40.030 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:55:40.031 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:55:40.033 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:55:40.034 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #21 with 23 messages
2025-10-06 09:55:53.449 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 15328, outputTokenCount = 1024, totalTokenCount = 16352 }
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #22 with 25 messages
2025-10-06 09:56:02.960 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 16364, outputTokenCount = 819, totalTokenCount = 17183 }
2025-10-06 09:56:02.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.965 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:56:02.967 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:56:02.968 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.968 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
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

Correct the following error:

[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project text-api: Compilation failure: Compilation failure: 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR]   symbol:   variable Stringinput
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR]   symbol:   variable input
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# REQUIREMENTS:
1. Respond with the corrected class code.
2. Do not provide explanations or comments.

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.
2025-10-06 10:21:35.398 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 10:21:35.399 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #42 with 46 messages
2025-10-06 10:23:38.957 ERROR [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:52)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI ERROR - did not generate response
dev.langchain4j.exception.RateLimitException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at dev.langchain4j.internal.ExceptionMapper$DefaultExceptionMapper.mapHttpStatusCode(ExceptionMapper.java:68)
	at dev.langchain4j.model.azure.AzureOpenAiExceptionMapper.mapException(AzureOpenAiExceptionMapper.java:30)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:31)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.doChat(AzureOpenAiChatModel.java:207)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:46)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:92)
	at io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:47)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:79)
	at io.github.adamw7.orchestrator.generator.persistence.PersistingImprovementGenerator.create(PersistingImprovementGenerator.java:36)
	at io.github.adamw7.orchestrator.generator.RetryImprovementGenerator.createInternal(RetryImprovementGenerator.java:80)
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
	at io.github.adamw7.testing.steps.ImproveGeneratedTestsStep.improveGeneratedUnitTests(ImproveGeneratedTestsStep.java:62)
	at io.github.adamw7.testing.steps.ImproveGeneratedTestsStep.process(ImproveGeneratedTestsStep.java:41)
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
Caused by: com.azure.core.exception.HttpResponseException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at com.azure.core.implementation.http.rest.RestProxyBase.instantiateUnexpectedException(RestProxyBase.java:388)
	at com.azure.core.implementation.http.rest.SyncRestProxy.ensureExpectedStatus(SyncRestProxy.java:133)
	at com.azure.core.implementation.http.rest.SyncRestProxy.handleRestReturnType(SyncRestProxy.java:211)
	at com.azure.core.implementation.http.rest.SyncRestProxy.invoke(SyncRestProxy.java:86)
	at com.azure.core.implementation.http.rest.RestProxyBase.invoke(RestProxyBase.java:124)
	at com.azure.core.http.rest.RestProxy.invoke(RestProxy.java:95)
	at jdk.proxy2/jdk.proxy2.$Proxy71.getChatCompletionsSync(Unknown Source)
	at com.azure.ai.openai.implementation.OpenAIClientImpl.getChatCompletionsWithResponse(OpenAIClientImpl.java:1972)
	at com.azure.ai.openai.OpenAIClient.getChatCompletionsWithResponse(OpenAIClient.java:350)
	at com.azure.ai.openai.OpenAIClient.getChatCompletions(OpenAIClient.java:760)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.lambda$doChat$0(AzureOpenAiChatModel.java:208)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:29)
	... 46 more
2025-10-06 10:23:38.965 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:121)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Failed to generate code
2025-10-06 10:23:38.965 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 10:23:38.965 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:83)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - No code to be used! Generated code is empty
2025-10-06 10:23:51.606 INFO [main] [io.github.adamw7.testing.generator.prompt.ImproveUnitTestsPromptProvider.getPromptMessages(ImproveUnitTestsPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for improving unit tests generation...
2025-10-06 10:23:51.606 INFO [main] [io.github.adamw7.testing.generator.prompt.ImproveUnitTestsPromptProvider.getPromptMessages(ImproveUnitTestsPromptProvider.java:39)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 10:23:51.611 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 10:23:51.615 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.service;

import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class TextService {

    private static final String HELLO_WORLD = "Hello, World!";
    public static final String VOWEL_PATTERN = "(?i)[^aeiou]";
    public static final String STRING_EMPTY = "";
    private static final String consonantPattern = "(?i)[^b-df-hj-np-tv-z]";

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String uppercase(String input) {
        return input.toUpperCase();
    }

    public Map<String, Object> stats(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("length", getLength(input));
        result.put("wordCount", getSplitCount(input, "\\s+"));
        result.put("lineCount", getSplitCount(input, "\\n"));
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    private Integer getLength(String input) {
        if (input == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(input.length());
    }

    private static Integer getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return Integer.valueOf(length);
    }

    public List<String> getRepeatedWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        // Normalize input: lowercase and remove punctuation (except digits/letters)
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        // Count word occurrences
        for (String word : words) {
            wordCount.put(word, Integer.valueOf(wordCount.getOrDefault(word, Integer.valueOf(0)) + 1));
        }

        // Collect only repeated words with their count
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey() + " : " + entry.getValue());
            }
        }

        return result;
    }

    private Integer getConsonantCount(String input) {
        return Integer.valueOf(input.replaceAll(consonantPattern, STRING_EMPTY).length());
    }

    private Integer getVowelCount(String input) {
        return Integer.valueOf(input.replaceAll(VOWEL_PATTERN, STRING_EMPTY).length());
    }

    public String replace(String input, String target, String replacement) {
        return input.replace(target, replacement);
    }

    public String removeVowels(String input) {
        return removePattern(input,"(?i)[aeiou]");
    }

    public String removeConsonants(String input) {
        return removePattern(input,"(?i)[b-df-hj-np-tv-z]");
    }

    private String removePattern(String input, String regex) {
        return input.replaceAll(regex, "");
    }

    public int countOccurrence(String input, String keyword) {
        return input.split("(?i)\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1;
    }

    public String helloworld() {
        return HELLO_WORLD;
    }

    public String convertJsonToYaml(String json) {
        return TextConversionUtil.convertJsonToYaml(json);
    }

    public String convertJsonToXml(String json) {
        return TextConversionUtil.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests, please review the following test class, fix any compilation error, improve the tests,
 and suggest corrections that could enhance their quality. If there are any logical errors or issues with the tests themselves, please address them.


package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
/*
2025-10-06 09:54:14.659 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 09:54:14.679 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:14.681 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.850 s <<< FAILURE! -- in com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats -- Time elapsed: 0.021 s <<< FAILURE!
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants -- Time elapsed: 0.003 s <<< FAILURE!
[ERROR] Failures: 
[ERROR]   TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants:175 expected: <eauiua> but was: <eauiu a>
[ERROR]   TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats:66 expected: <28> but was: <29>
[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project text-api: There are test failures.
[ERROR] 
[ERROR] Please refer to C:\Users\JOSCAMAC\AppData\Local\Temp\codeai-test-14938987443307845673\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# TASK: Correct the error in the test class.

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.

2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #14 with 11 messages
2025-10-06 09:54:20.798 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 3946, outputTokenCount = 1024, totalTokenCount = 4970 }
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #15 with 13 messages
2025-10-06 09:54:25.209 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 4982, outputTokenCount = 741, totalTokenCount = 5723 }
2025-10-06 09:54:25.210 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.210 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:25.211 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:25.214 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.214 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

2025-10-06 09:54:40.850 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:40.851 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:40.852 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}


# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:40.853 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:40.854 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #17 with 15 messages
2025-10-06 09:54:46.218 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 7686, outputTokenCount = 1024, totalTokenCount = 8710 }
2025-10-06 09:54:46.219 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:46.220 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #18 with 17 messages
2025-10-06 09:54:50.485 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 8722, outputTokenCount = 819, totalTokenCount = 9541 }
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.487 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:50.488 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.489 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:58.007 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:58.008 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:58.009 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:58.011 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:58.012 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #19 with 19 messages
2025-10-06 09:55:06.948 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 11507, outputTokenCount = 1024, totalTokenCount = 12531 }
2025-10-06 09:55:06.950 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:06.951 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #20 with 21 messages
2025-10-06 09:55:28.963 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 12543, outputTokenCount = 819, totalTokenCount = 13362 }
2025-10-06 09:55:28.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.964 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:28.965 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:55:28.966 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.967 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:40.029 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:55:40.030 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:55:40.031 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:55:40.033 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:55:40.034 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #21 with 23 messages
2025-10-06 09:55:53.449 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 15328, outputTokenCount = 1024, totalTokenCount = 16352 }
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #22 with 25 messages
2025-10-06 09:56:02.960 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 16364, outputTokenCount = 819, totalTokenCount = 17183 }
2025-10-06 09:56:02.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.965 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:56:02.967 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:56:02.968 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.968 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
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

Correct the following error:

[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project text-api: Compilation failure: Compilation failure: 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR]   symbol:   variable Stringinput
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR]   symbol:   variable input
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# REQUIREMENTS:
1. Respond with the corrected class code.
2. Do not provide explanations or comments.

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.
2025-10-06 10:23:51.629 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 10:23:51.629 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #43 with 51 messages
2025-10-06 10:25:55.329 ERROR [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:52)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI ERROR - did not generate response
dev.langchain4j.exception.RateLimitException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at dev.langchain4j.internal.ExceptionMapper$DefaultExceptionMapper.mapHttpStatusCode(ExceptionMapper.java:68)
	at dev.langchain4j.model.azure.AzureOpenAiExceptionMapper.mapException(AzureOpenAiExceptionMapper.java:30)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:31)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.doChat(AzureOpenAiChatModel.java:207)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:46)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:92)
	at io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:47)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:79)
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
	at io.github.adamw7.testing.steps.ImproveGeneratedTestsStep.improveGeneratedUnitTests(ImproveGeneratedTestsStep.java:62)
	at io.github.adamw7.testing.steps.ImproveGeneratedTestsStep.process(ImproveGeneratedTestsStep.java:41)
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
Caused by: com.azure.core.exception.HttpResponseException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at com.azure.core.implementation.http.rest.RestProxyBase.instantiateUnexpectedException(RestProxyBase.java:388)
	at com.azure.core.implementation.http.rest.SyncRestProxy.ensureExpectedStatus(SyncRestProxy.java:133)
	at com.azure.core.implementation.http.rest.SyncRestProxy.handleRestReturnType(SyncRestProxy.java:211)
	at com.azure.core.implementation.http.rest.SyncRestProxy.invoke(SyncRestProxy.java:86)
	at com.azure.core.implementation.http.rest.RestProxyBase.invoke(RestProxyBase.java:124)
	at com.azure.core.http.rest.RestProxy.invoke(RestProxy.java:95)
	at jdk.proxy2/jdk.proxy2.$Proxy71.getChatCompletionsSync(Unknown Source)
	at com.azure.ai.openai.implementation.OpenAIClientImpl.getChatCompletionsWithResponse(OpenAIClientImpl.java:1972)
	at com.azure.ai.openai.OpenAIClient.getChatCompletionsWithResponse(OpenAIClient.java:350)
	at com.azure.ai.openai.OpenAIClient.getChatCompletions(OpenAIClient.java:760)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.lambda$doChat$0(AzureOpenAiChatModel.java:208)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:29)
	... 47 more
2025-10-06 10:25:55.332 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:121)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Failed to generate code
2025-10-06 10:25:55.333 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 10:25:55.333 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:83)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - No code to be used! Generated code is empty
2025-10-06 10:26:08.342 INFO [main] [io.github.adamw7.testing.generator.prompt.ImproveUnitTestsPromptProvider.getPromptMessages(ImproveUnitTestsPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for improving unit tests generation...
2025-10-06 10:26:08.343 INFO [main] [io.github.adamw7.testing.generator.prompt.ImproveUnitTestsPromptProvider.getPromptMessages(ImproveUnitTestsPromptProvider.java:39)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 10:26:08.346 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 10:26:08.350 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.service;

import com.example.textapi.utils.TextConversionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class TextService {

    private static final String HELLO_WORLD = "Hello, World!";
    public static final String VOWEL_PATTERN = "(?i)[^aeiou]";
    public static final String STRING_EMPTY = "";
    private static final String consonantPattern = "(?i)[^b-df-hj-np-tv-z]";

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String uppercase(String input) {
        return input.toUpperCase();
    }

    public Map<String, Object> stats(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("length", getLength(input));
        result.put("wordCount", getSplitCount(input, "\\s+"));
        result.put("lineCount", getSplitCount(input, "\\n"));
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    private Integer getLength(String input) {
        if (input == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(input.length());
    }

    private static Integer getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return Integer.valueOf(length);
    }

    public List<String> getRepeatedWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        // Normalize input: lowercase and remove punctuation (except digits/letters)
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        // Count word occurrences
        for (String word : words) {
            wordCount.put(word, Integer.valueOf(wordCount.getOrDefault(word, Integer.valueOf(0)) + 1));
        }

        // Collect only repeated words with their count
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey() + " : " + entry.getValue());
            }
        }

        return result;
    }

    private Integer getConsonantCount(String input) {
        return Integer.valueOf(input.replaceAll(consonantPattern, STRING_EMPTY).length());
    }

    private Integer getVowelCount(String input) {
        return Integer.valueOf(input.replaceAll(VOWEL_PATTERN, STRING_EMPTY).length());
    }

    public String replace(String input, String target, String replacement) {
        return input.replace(target, replacement);
    }

    public String removeVowels(String input) {
        return removePattern(input,"(?i)[aeiou]");
    }

    public String removeConsonants(String input) {
        return removePattern(input,"(?i)[b-df-hj-np-tv-z]");
    }

    private String removePattern(String input, String regex) {
        return input.replaceAll(regex, "");
    }

    public int countOccurrence(String input, String keyword) {
        return input.split("(?i)\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1;
    }

    public String helloworld() {
        return HELLO_WORLD;
    }

    public String convertJsonToYaml(String json) {
        return TextConversionUtil.convertJsonToYaml(json);
    }

    public String convertJsonToXml(String json) {
        return TextConversionUtil.convertJsonToXml(json);
    }
}

>> TASK: Below is the class with the originally generated tests, please review the following test class, fix any compilation error, improve the tests,
 and suggest corrections that could enhance their quality. If there are any logical errors or issues with the tests themselves, please address them.


package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
/*
2025-10-06 09:54:14.659 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-06 09:54:14.679 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:14.681 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0, Time elapsed: 0.850 s <<< FAILURE! -- in com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats -- Time elapsed: 0.021 s <<< FAILURE!
[ERROR] com.example.textapi.service.TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants -- Time elapsed: 0.003 s <<< FAILURE!
[ERROR] Failures: 
[ERROR]   TextServiceGeneratedAiTests.testRemoveConsonants_withConsonants_removesConsonants:175 expected: <eauiua> but was: <eauiu a>
[ERROR]   TextServiceGeneratedAiTests.testStats_withMixedInput_returnsCorrectStats:66 expected: <28> but was: <29>
[ERROR] Tests run: 22, Failures: 2, Errors: 0, Skipped: 0
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.2:test (default-test) on project text-api: There are test failures.
[ERROR] 
[ERROR] Please refer to C:\Users\JOSCAMAC\AppData\Local\Temp\codeai-test-14938987443307845673\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# TASK: Correct the error in the test class.

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.

2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:14.681 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #14 with 11 messages
2025-10-06 09:54:20.798 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 3946, outputTokenCount = 1024, totalTokenCount = 4970 }
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:20.809 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #15 with 13 messages
2025-10-06 09:54:25.209 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 4982, outputTokenCount = 741, totalTokenCount = 5723 }
2025-10-06 09:54:25.210 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.210 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:25.211 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:25.214 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:25.214 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

2025-10-06 09:54:40.850 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:40.851 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:40.852 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(4, stats.get("wordCount"));
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}


# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:40.853 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:40.854 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #17 with 15 messages
2025-10-06 09:54:46.218 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 7686, outputTokenCount = 1024, totalTokenCount = 8710 }
2025-10-06 09:54:46.219 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:54:46.220 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #18 with 17 messages
2025-10-06 09:54:50.485 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 8722, outputTokenCount = 819, totalTokenCount = 9541 }
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.487 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:50.487 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:54:50.488 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:54:50.489 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:54:58.007 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:54:58.008 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:54:58.009 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:54:58.011 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:54:58.012 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #19 with 19 messages
2025-10-06 09:55:06.948 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 11507, outputTokenCount = 1024, totalTokenCount = 12531 }
2025-10-06 09:55:06.950 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:06.951 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #20 with 21 messages
2025-10-06 09:55:28.963 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 12543, outputTokenCount = 819, totalTokenCount = 13362 }
2025-10-06 09:55:28.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.964 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:28.965 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:55:28.966 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:55:28.967 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:55:40.029 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-06 09:55:40.030 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:62)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generating code...
2025-10-06 09:55:40.031 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:113)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

In the method testStats_withMixedInput_returnsCorrectStats, change:
assertEquals(4, stats.get("wordCount"));
to:
assertEquals(5, stats.get("wordCount"));

In this code:

package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}

# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-06 09:55:40.033 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 09:55:40.034 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #21 with 23 messages
2025-10-06 09:55:53.449 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 15328, outputTokenCount = 1024, totalTokenCount = 16352 }
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-06 09:55:53.450 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #22 with 25 messages
2025-10-06 09:56:02.960 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 16364, outputTokenCount = 819, totalTokenCount = 17183 }
2025-10-06 09:56:02.964 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.965 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:86)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
}
2025-10-06 09:56:02.967 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:87)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refining code...
2025-10-06 09:56:02.968 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 09:56:02.968 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:90)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.service;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset the TextService instance before each test
        textService = new TextService();
    }

    @Test
    void testReverse_withNormalString_returnsReversed() {
        // GIVEN
        String input = "abcdef";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("fedcba", result);
    }

    @Test
    void testReverse_withEmptyString_returnsEmpty() {
        // GIVEN
        String input = "";
        // WHEN
        String result = textService.reverse(input);
        // THEN
        assertEquals("", result);
    }

    @Test
    void testUppercase_withLowercase_returnsUppercase() {
        // GIVEN
        String input = "hello world";
        // WHEN
        String result = textService.uppercase(input);
        // THEN
        assertEquals("HELLO WORLD", result);
    }

    @Test
    void testStats_withMixedInput_returnsCorrectStats() {
        // GIVEN
        String input = "Hello world\nHello again world";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(29, stats.get("length")); // corrected from 28 to 29
        assertEquals(5, stats.get("wordCount")); // corrected from 4 to 5
        assertEquals(2, stats.get("lineCount"));
        assertEquals(8, stats.get("VowelCount"));
        assertEquals(13, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("hello")));
        assertTrue(repeatedWords.stream().anyMatch(s -> s.startsWith("world")));
    }

    @Test
    void testStats_withEmptyInput_returnsZeroStats() {
        // GIVEN
        String input = "";
        // WHEN
        Map<String, Object> stats = textService.stats(input);
        // THEN
        assertEquals(0, stats.get("length"));
        assertEquals(1, stats.get("wordCount"));
        assertEquals(1, stats.get("lineCount"));
        assertEquals(0, stats.get("VowelCount"));
        assertEquals(0, stats.get("ConsonantCount"));
        List<String> repeatedWords = (List<String>) stats.get("RepeatedWords");
        assertTrue(repeatedWords.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withRepeats_returnsRepeatedWords() {
        // GIVEN
        String input = "apple banana apple orange banana apple";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.contains("apple : 3"));
        assertTrue(result.contains("banana : 2"));
        assertFalse(result.stream().anyMatch(s -> s.contains("orange")));
    }

    @Test
    void testGetRepeatedWords_withNoRepeats_returnsEmptyList() {
        // GIVEN
        String input = "apple banana orange";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetRepeatedWords_withEmptyInput_returnsEmptyList() {
        // GIVEN
        String input = "";
        // WHEN
        List<String> result = textService.getRepeatedWords(input);
        // THEN
        assertTrue(result.isEmpty());
    }

    @Test
    void testReplace_withValidTarget_replacesTarget() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello java", result);
    }

    @Test
    void testReplace_withNoMatch_returnsOriginal() {
        // GIVEN
        String input = "hello world";
        String target = "python";
        String replacement = "java";
        // WHEN
        String result = textService.replace(input, target, replacement);
        // THEN
        assertEquals("hello world", result);
    }

    @Test
    void testRemoveVowels_withVowels_removesVowels() {
        // GIVEN
        Stringinput = "Beautiful day";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("Btfl dy", result);
    }

    @Test
    void testRemoveVowels_withNoVowels_returnsOriginal() {
        // GIVEN
        String input = "rhythm";
        // WHEN
        String result = textService.removeVowels(input);
        // THEN
        assertEquals("rhythm", result);
    }

    @Test
    void testRemoveConsonants_withConsonants_removesConsonants() {
        // GIVEN
        String input = "Beautiful day";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("eauiu a", result); // corrected from "eauiua" to "eauiu a"
    }

    @Test
    void testRemoveConsonants_withNoConsonants_returnsOriginal() {
        // GIVEN
        String input = "aeiou";
        // WHEN
        String result = textService.removeConsonants(input);
        // THEN
        assertEquals("aeiou", result);
    }

    @Test
    void testCountOccurrence_withMultipleOccurrences_returnsCorrectCount() {
        // GIVEN
        String input = "apple banana apple orange apple";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testCountOccurrence_withNoOccurrences_returnsZero() {
        // GIVEN
        String input = "banana orange";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(0, count);
    }

    @Test
    void testCountOccurrence_withCaseInsensitiveKeyword_returnsCorrectCount() {
        // GIVEN
        String input = "Apple apple APPLE";
        String keyword = "apple";
        // WHEN
        int count = textService.countOccurrence(input, keyword);
        // THEN
        assertEquals(3, count);
    }

    @Test
    void testHelloworld_returnsHelloWorldConstant() {
        // GIVEN
        // No setup needed
        // WHEN
        String result = textService.helloworld();
        // THEN
        assertEquals("Hello, World!", result);
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.contains("name: \"John\"") || yaml.contains("name: John"));
        assertTrue(yaml.contains("age: 30"));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String yaml = textService.convertJsonToYaml(json);
        // THEN
        assertTrue(yaml.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.contains("<name>John</name>"));
        assertTrue(xml.contains("<age>30</age>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN
        String json = "{name:John,age:30}";
        // WHEN
        String xml = textService.convertJsonToXml(json);
        // THEN
        assertTrue(xml.startsWith("Error converting JSON to XML"));
    }
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

Correct the following error:

[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project text-api: Compilation failure: Compilation failure: 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[150,9] cannot find symbol
[ERROR]   symbol:   variable Stringinput
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-14938987443307845673/src/test/java/com/example/textapi/service/TextServiceGeneratedAiTests.java:[152,50] cannot find symbol
[ERROR]   symbol:   variable input
[ERROR]   location: class com.example.textapi.service.TextServiceGeneratedAiTests
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException


# REQUIREMENTS:
1. Respond with the corrected class code.
2. Do not provide explanations or comments.

# SECURITY REQUIREMENTS:
1. Security Requirements are applicable to the all files, including those that are not security-sensitive
2. If you encounter code that handles security-critical operations, mark it as security-sensitive in the generated code.
3. Don't include any secrets, passwords, API keys, tokens, actual connection strings, authentication details, environment-specific configurations, sensitive configuration values, or personal and sensitive information in the generated code.
2025-10-06 10:26:08.363 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:117)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-06 10:26:08.363 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI CALL #44 with 56 messages
2025-10-06 10:28:11.946 ERROR [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:52)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - AI ERROR - did not generate response
dev.langchain4j.exception.RateLimitException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at dev.langchain4j.internal.ExceptionMapper$DefaultExceptionMapper.mapHttpStatusCode(ExceptionMapper.java:68)
	at dev.langchain4j.model.azure.AzureOpenAiExceptionMapper.mapException(AzureOpenAiExceptionMapper.java:30)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:31)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.doChat(AzureOpenAiChatModel.java:207)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:46)
	at dev.langchain4j.model.chat.ChatModel.chat(ChatModel.java:92)
	at io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:47)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)
	at io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:79)
	at io.github.adamw7.orchestrator.generator.persistence.PersistingImprovementGenerator.create(PersistingImprovementGenerator.java:36)
	at io.github.adamw7.orchestrator.generator.RetryImprovementGenerator.createInternal(RetryImprovementGenerator.java:80)
	at io.github.adamw7.orchestrator.generator.RetryImprovementGenerator.createInternal(RetryImprovementGenerator.java:105)
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
	at io.github.adamw7.testing.steps.ImproveGeneratedTestsStep.improveGeneratedUnitTests(ImproveGeneratedTestsStep.java:62)
	at io.github.adamw7.testing.steps.ImproveGeneratedTestsStep.process(ImproveGeneratedTestsStep.java:41)
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
Caused by: com.azure.core.exception.HttpResponseException: Status code 429, "{"error":{"code":"429","message": "Requests to the ChatCompletions_Create Operation under Azure OpenAI API version 2025-01-01-preview have exceeded token rate limit of your current OpenAI S0 pricing tier. Please retry after 60 seconds. Please go here: https://aka.ms/oai/quotaincrease if you would like to further increase the default rate limit. For Free Account customers, upgrade to Pay as you Go here: https://aka.ms/429TrialUpgrade."}}"
	at com.azure.core.implementation.http.rest.RestProxyBase.instantiateUnexpectedException(RestProxyBase.java:388)
	at com.azure.core.implementation.http.rest.SyncRestProxy.ensureExpectedStatus(SyncRestProxy.java:133)
	at com.azure.core.implementation.http.rest.SyncRestProxy.handleRestReturnType(SyncRestProxy.java:211)
	at com.azure.core.implementation.http.rest.SyncRestProxy.invoke(SyncRestProxy.java:86)
	at com.azure.core.implementation.http.rest.RestProxyBase.invoke(RestProxyBase.java:124)
	at com.azure.core.http.rest.RestProxy.invoke(RestProxy.java:95)
	at jdk.proxy2/jdk.proxy2.$Proxy71.getChatCompletionsSync(Unknown Source)
	at com.azure.ai.openai.implementation.OpenAIClientImpl.getChatCompletionsWithResponse(OpenAIClientImpl.java:1972)
	at com.azure.ai.openai.OpenAIClient.getChatCompletionsWithResponse(OpenAIClient.java:350)
	at com.azure.ai.openai.OpenAIClient.getChatCompletions(OpenAIClient.java:760)
	at dev.langchain4j.model.azure.AzureOpenAiChatModel.lambda$doChat$0(AzureOpenAiChatModel.java:208)
	at dev.langchain4j.internal.ExceptionMapper.withExceptionMapper(ExceptionMapper.java:29)
	... 48 more
2025-10-06 10:28:11.953 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:121)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Failed to generate code
2025-10-06 10:28:11.953 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:80)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - Done
2025-10-06 10:28:11.953 WARN [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:83)] [{conversationName=com.example.textapi.service.TextServiceGeneratedAiTests.java}] - No code to be used! Generated code is empty
*/
