package com.example.textapi.controller;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
    }

    @Test
    void testHelloWorld_returnsHelloWorldString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverse_returnsReversedString() {
        // GIVEN
        String input = "abcdef";
        String expected = "fedcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercase_returnsUppercaseString() {
        // GIVEN
        String input = "abcDef";
        String expected = "ABCDEF";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStats_returnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", List.of("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplace_returnsReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "Java";
        String expected = "hello Java";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveVowels_removesVowelsFromString() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveConsonants_removesConsonantsFromString() {
        // GIVEN
        String input = "hello";
        String expected = "eo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrence_returnsCorrectCount() {
        // GIVEN
        String input = "Java is great. Java is powerful.";
        String keyword = "Java";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYaml_returnsConvertedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expected = "name: \"John\"\nage: 30\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToXml_returnsConvertedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expected = "<ObjectNode><name>John</name><age>30</age></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
    }
}

/*
2025-10-02 12:20:33.969 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-02 12:20:33.986 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generating code...
2025-10-02 12:20:33.987 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-6904663240171026768/src/test/java/com/example/textapi/controller/TextControllerGeneratedAiTests.java:[18,15] cannot find symbol
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project text-api: Compilation failure
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-6904663240171026768/src/test/java/com/example/textapi/controller/TextControllerGeneratedAiTests.java:[18,15] cannot find symbol
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

2025-10-02 12:20:33.988 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-02 12:20:33.988 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - AI CALL #2 with 9 messages
2025-10-02 12:20:41.250 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:53)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 3528, outputTokenCount = 1063, totalTokenCount = 4591 }
2025-10-02 12:20:41.251 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-10-02 12:20:41.252 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Generated code:
package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
    }

    @Test
    void testHelloWorld_returnsHelloWorldString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverse_returnsReversedString() {
        // GIVEN
        String input = "abcdef";
        String expected = "fedcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercase_returnsUppercaseString() {
        // GIVEN
        String input = "abcDef";
        String expected = "ABCDEF";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStats_returnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", List.of("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplace_returnsReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "Java";
        String expected = "hello Java";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveVowels_removesVowelsFromString() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveConsonants_removesConsonantsFromString() {
        // GIVEN
        String input = "hello";
        String expected = "eo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrence_returnsCorrectCount() {
        // GIVEN
        String input = "Java is great. Java is powerful.";
        String keyword = "Java";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYaml_returnsConvertedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expected = "name: \"John\"\nage: 30\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToXml_returnsConvertedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expected = "<ObjectNode><name>John</name><age>30</age></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
    }
}
2025-10-02 12:20:41.252 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refining code...
2025-10-02 12:20:41.254 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Done
2025-10-02 12:20:41.254 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.controller.TextControllerGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.controller;

import static org.mockito.Mockito.mock;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        reset(textService);
    }

    @Test
    void testHelloWorld_returnsHelloWorldString() {
        // GIVEN
        String expected = "Hello, World!";
        when(textService.helloworld()).thenReturn(expected);

        // WHEN
        String result = textController.helloWorld();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReverse_returnsReversedString() {
        // GIVEN
        String input = "abcdef";
        String expected = "fedcba";
        when(textService.reverse(input)).thenReturn(expected);

        // WHEN
        String result = textController.reverse(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testUppercase_returnsUppercaseString() {
        // GIVEN
        String input = "abcDef";
        String expected = "ABCDEF";
        when(textService.uppercase(input)).thenReturn(expected);

        // WHEN
        String result = textController.uppercase(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testStats_returnsStatsMap() {
        // GIVEN
        String input = "Hello World\nHello";
        Map<String, Object> expected = new HashMap<>();
        expected.put("length", 17);
        expected.put("wordCount", 3);
        expected.put("lineCount", 2);
        expected.put("VowelCount", 5);
        expected.put("ConsonantCount", 8);
        expected.put("RepeatedWords", List.of("hello : 2"));
        when(textService.stats(input)).thenReturn(expected);

        // WHEN
        Map<String, Object> result = textController.stats(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testReplace_returnsReplacedString() {
        // GIVEN
        String input = "hello world";
        String target = "world";
        String replacement = "Java";
        String expected = "hello Java";
        when(textService.replace(input, target, replacement)).thenReturn(expected);

        // WHEN
        String result = textController.replace(target, replacement, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveVowels_removesVowelsFromString() {
        // GIVEN
        String input = "hello";
        String expected = "hll";
        when(textService.removeVowels(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeVowels(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testRemoveConsonants_removesConsonantsFromString() {
        // GIVEN
        String input = "hello";
        String expected = "eo";
        when(textService.removeConsonants(input)).thenReturn(expected);

        // WHEN
        String result = textController.removeConsonants(input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testCountOccurrence_returnsCorrectCount() {
        // GIVEN
        String input = "Java is great. Java is powerful.";
        String keyword = "Java";
        int expected = 2;
        when(textService.countOccurrence(input, keyword)).thenReturn(expected);

        // WHEN
        int result = textController.countOccurrence(keyword, input);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToYaml_returnsConvertedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expected = "name: \"John\"\nage: 30\n";
        when(textService.convertJsonToYaml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToYaml(json);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void testJsonToXml_returnsConvertedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";
        String expected = "<ObjectNode><name>John</name><age>30</age></ObjectNode>";
        when(textService.convertJsonToXml(json)).thenReturn(expected);

        // WHEN
        String result = textController.jsonToXml(json);

        // THEN
        assertEquals(expected, result);
    }
}
*/
