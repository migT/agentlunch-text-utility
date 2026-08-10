package com.example.textapi.utils;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: No state to reset, as TextConversionUtil has only static methods
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

        // WHEN: Converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the expected YAML keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
        assertTrue(yaml.contains("city: \"New York\""));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30,city:New York}";

        // WHEN: Converting invalid JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"Alice\",\"age\":25,\"city\":\"London\"}";

        // WHEN: Converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain the expected XML elements
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<age>25</age>"));
        assertTrue(xml.contains("<city>London</city>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:Alice,age:25,city:London}";

        // WHEN: Converting invalid JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsEmptyYaml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should be a valid empty YAML (just "---\n" or similar)
        assertTrue(yaml.trim().startsWith("---"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsEmptyXml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should be a valid empty XML (may be "<ObjectNode/>" or similar)
        assertTrue(xml.contains("/>") || xml.contains("<ObjectNode"));
    }
}

/*
2025-10-02 14:21:40.313 INFO [main] [io.github.adamw7.testing.generator.prompt.UnitTestingPromptProvider.getPromptMessages(UnitTestingPromptProvider.java:40)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Building a prompt for fixing unit tests issue...
2025-10-02 14:21:40.351 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Generating code...
2025-10-02 14:21:40.362 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Using prompt:

There is an error in the previously generated test class.

>> ERROR:

[ERROR] COMPILATION ERROR : 
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-5531950797714618170/src/test/java/com/example/textapi/utils/TextConversionUtilGeneratedAiTests.java:[10,15] '.' expected
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project text-api: Compilation failure
[ERROR] /C:/Users/JOSCAMAC/AppData/Local/Temp/codeai-test-5531950797714618170/src/test/java/com/example/textapi/utils/TextConversionUtilGeneratedAiTests.java:[10,15] '.' expected
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

2025-10-02 14:21:40.363 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Generate code iteration # 1
2025-10-02 14:21:40.364 INFO [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:46)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - AI CALL #19 with 8 messages
2025-10-02 14:21:44.782 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:48)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 1845, outputTokenCount = 723, totalTokenCount = 2568 }
2025-10-02 14:21:44.784 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Done
2025-10-02 14:21:44.784 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Generated code:
package com.example.textapi.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: No state to reset, as TextConversionUtil has only static methods
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

        // WHEN: Converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the expected YAML keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
        assertTrue(yaml.contains("city: \"New York\""));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30,city:New York}";

        // WHEN: Converting invalid JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"Alice\",\"age\":25,\"city\":\"London\"}";

        // WHEN: Converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain the expected XML elements
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<age>25</age>"));
        assertTrue(xml.contains("<city>London</city>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:Alice,age:25,city:London}";

        // WHEN: Converting invalid JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsEmptyYaml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should be a valid empty YAML (just "---\n" or similar)
        assertTrue(yaml.trim().startsWith("---"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsEmptyXml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should be a valid empty XML (may be "<ObjectNode/>" or similar)
        assertTrue(xml.contains("/>") || xml.contains("<ObjectNode"));
    }
}
2025-10-02 14:21:44.786 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Refining code...
2025-10-02 14:21:44.789 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Done
2025-10-02 14:21:44.790 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.utils;

import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // GIVEN: No state to reset, as TextConversionUtil has only static methods
    }

    @Test
    void testConvertJsonToYaml_withValidJson_returnsYaml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

        // WHEN: Converting JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should contain the expected YAML keys and values
        assertTrue(yaml.contains("name: \"John\""));
        assertTrue(yaml.contains("age: 30"));
        assertTrue(yaml.contains("city: \"New York\""));
    }

    @Test
    void testConvertJsonToYaml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:John,age:30,city:New York}";

        // WHEN: Converting invalid JSON to YAML
        String result = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON to YAML:"));
    }

    @Test
    void testConvertJsonToXml_withValidJson_returnsXml() {
        // GIVEN: A valid JSON string
        String json = "{\"name\":\"Alice\",\"age\":25,\"city\":\"London\"}";

        // WHEN: Converting JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should contain the expected XML elements
        assertTrue(xml.contains("<name>Alice</name>"));
        assertTrue(xml.contains("<age>25</age>"));
        assertTrue(xml.contains("<city>London</city>"));
    }

    @Test
    void testConvertJsonToXml_withInvalidJson_returnsErrorMessage() {
        // GIVEN: An invalid JSON string
        String invalidJson = "{name:Alice,age:25,city:London}";

        // WHEN: Converting invalid JSON to XML
        String result = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: The result should be an error message
        assertTrue(result.startsWith("Error converting JSON to XML:"));
    }

    @Test
    void testConvertJsonToYaml_withEmptyJson_returnsEmptyYaml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to YAML
        String yaml = TextConversionUtil.convertJsonToYaml(json);

        // THEN: The result should be a valid empty YAML (just "---\n" or similar)
        assertTrue(yaml.trim().startsWith("---"));
    }

    @Test
    void testConvertJsonToXml_withEmptyJson_returnsEmptyXml() {
        // GIVEN: An empty JSON object
        String json = "{}";

        // WHEN: Converting empty JSON to XML
        String xml = TextConversionUtil.convertJsonToXml(json);

        // THEN: The result should be a valid empty XML (may be "<ObjectNode/>" or similar)
        assertTrue(xml.contains("/>") || xml.contains("<ObjectNode"));
    }
}
*/
