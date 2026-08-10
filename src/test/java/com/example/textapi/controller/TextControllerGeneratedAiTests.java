package com.example.textapi.controller;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset mocks and state before each test
        reset(textService);
    }

    @Test
    void testHelloWorldReturnsExpectedString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverseReturnsReversedString() {
        // GIVEN
        String input = "abcde";
        String expected = "edcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercaseReturnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStatsReturnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", Arrays.asList("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplaceReturnsReplacedString() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveVowelsRemovesVowels() {
        // GIVEN
        String input = "abcdef";
        String expected = "bcdf";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveConsonantsRemovesConsonants() {
        // GIVEN
        String input = "abcdef";
        String expected = "ae";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrenceReturnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "foo";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYamlReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: \"value\"\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToXmlReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<ObjectNode><key>value</key></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

       // THEN
        assertEquals(expected, result);
    }
}
/*
2025-10-02 14:18:33.237 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-02 14:18:33.252 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-10-02 14:18:33.254 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-5531950797714618170/src/test/java/com/example/textapi/controller/TextControllerGeneratedAiTests.java:[15,15] cannot find symbol
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project text-api: Compilation failure
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-5531950797714618170/src/test/java/com/example/textapi/controller/TextControllerGeneratedAiTests.java:[15,15] cannot find symbol
[ERROR]   symbol: class UNKNOWN
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

2025-10-02 14:18:33.255 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-02 14:18:33.256 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - AI CALL #2 with 9 messages
2025-10-02 14:18:39.279 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 3492, outputTokenCount = 1018, totalTokenCount = 4510 }
2025-10-02 14:18:39.279 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-10-02 14:18:39.280 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset mocks and state before each test
        reset(textService);
    }

    @Test
    void testHelloWorldReturnsExpectedString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverseReturnsReversedString() {
        // GIVEN
        String input = "abcde";
        String expected = "edcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercaseReturnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStatsReturnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", Arrays.asList("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplaceReturnsReplacedString() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveVowelsRemovesVowels() {
        // GIVEN
        String input = "abcdef";
        String expected = "bcdf";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveConsonantsRemovesConsonants() {
        // GIVEN
        String input = "abcdef";
        String expected = "ae";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrenceReturnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "foo";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYamlReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: \"value\"\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToXmlReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<ObjectNode><key>value</key></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
    }
}
2025-10-02 14:18:39.280 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-10-02 14:18:39.282 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-10-02 14:18:39.283 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset mocks and state before each test
        reset(textService);
    }

    @Test
    void testHelloWorldReturnsExpectedString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverseReturnsReversedString() {
        // GIVEN
        String input = "abcde";
        String expected = "edcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercaseReturnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStatsReturnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", Arrays.asList("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplaceReturnsReplacedString() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveVowelsRemovesVowels() {
        // GIVEN
        String input = "abcdef";
        String expected = "bcdf";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveConsonantsRemovesConsonants() {
        // GIVEN
        String input = "abcdef";
        String expected = "ae";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrenceReturnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "foo";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYamlReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: \"value\"\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToXmlReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<ObjectNode><key>value</key></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
    }
}

2025-10-02 14:18:50.758 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:37)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt with explanation how to fix issue...
2025-10-02 14:18:50.758 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-10-02 14:18:50.758 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

There is this issue with code and how to fix it, provide only code, no other explanations:

1. Add import static org.mockito.Mockito.when;
2. Add import static org.mockito.Mockito.reset;

In this code:

package com.example.textapi.controller;

import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset mocks and state before each test
        reset(textService);
    }

    @Test
    void testHelloWorldReturnsExpectedString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverseReturnsReversedString() {
        // GIVEN
        String input = "abcde";
        String expected = "edcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercaseReturnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStatsReturnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", Arrays.asList("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplaceReturnsReplacedString() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveVowelsRemovesVowels() {
        // GIVEN
        String input = "abcdef";
        String expected = "bcdf";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveConsonantsRemovesConsonants() {
        // GIVEN
        String input = "abcdef";
        String expected = "ae";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrenceReturnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "foo";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYamlReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: \"value\"\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToXmlReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<ObjectNode><key>value</key></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
    }
}


# Instructions:
1. Focus on the specific error given.
2. Ensure that the corrected code passes and assertions are valid.
3. Keep unrelated parts of the test unchanged.
4. Follow existing project standards, including naming and formatting.
5. Give output as a plain text
2025-10-02 14:18:50.759 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-02 14:18:50.759 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - AI CALL #4 with 11 messages
2025-10-02 14:18:56.081 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 5644, outputTokenCount = 1024, totalTokenCount = 6668 }
2025-10-02 14:18:56.082 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 2
2025-10-02 14:18:56.082 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - AI CALL #5 with 13 messages
2025-10-02 14:18:56.515 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 6680, outputTokenCount = 14, totalTokenCount = 6694 }
2025-10-02 14:18:56.516 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-10-02 14:18:56.518 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset mocks and state before each test
        reset(textService);
    }

    @Test
    void testHelloWorldReturnsExpectedString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverseReturnsReversedString() {
        // GIVEN
        String input = "abcde";
        String expected = "edcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercaseReturnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStatsReturnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", Arrays.asList("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplaceReturnsReplacedString() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveVowelsRemovesVowels() {
        // GIVEN
        String input = "abcdef";
        String expected = "bcdf";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveConsonantsRemovesConsonants() {
        // GIVEN
        String input = "abcdef";
        String expected = "ae";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrenceReturnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "foo";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYamlReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: \"value\"\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToXmlReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<ObjectNode><key>value</key></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

       // THEN
        assertEquals(expected, result);
    }
}
2025-10-02 14:18:56.520 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-10-02 14:18:56.524 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-10-02 14:18:56.525 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;
import org.mockito.Mockito;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        // GIVEN: Reset mocks and state before each test
        reset(textService);
    }

    @Test
    void testHelloWorldReturnsExpectedString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverseReturnsReversedString() {
        // GIVEN
        String input = "abcde";
        String expected = "edcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercaseReturnsUppercaseString() {
        // GIVEN
        String input = "abc";
        String expected = "ABC";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStatsReturnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", Arrays.asList("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplaceReturnsReplacedString() {
        // GIVEN
        String input = "foo bar foo";
        String target = "foo";
        String replacement = "baz";
        String expected = "baz bar baz";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveVowelsRemovesVowels() {
        // GIVEN
        String input = "abcdef";
        String expected = "bcdf";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveConsonantsRemovesConsonants() {
        // GIVEN
        String input = "abcdef";
        String expected = "ae";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrenceReturnsCorrectCount() {
        // GIVEN
        String input = "foo bar foo";
        String keyword = "foo";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYamlReturnsYamlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "key: \"value\"\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToXmlReturnsXmlString() {
        // GIVEN
        String json = "{\"key\":\"value\"}";
        String expected = "<ObjectNode><key>value</key></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

       // THEN
        assertEquals(expected, result);
    }
}
*/
