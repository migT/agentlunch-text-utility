package com.example.textapi.utils;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any state if needed before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN: a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: converting JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN: the YAML result should contain the keys and values
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN: an invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: converting invalid JSON to YAML
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN: the result should contain an error message
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN: a valid JSON string
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN: converting JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN: the XML result should contain the keys and values
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN: an invalid JSON string
        String invalidJson = "{name:John,age:30}";

        // WHEN: converting invalid JSON to XML
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN: the result should contain an error message
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }
}

/*
2025-09-30 17:09:05.153 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 17:09:05.212 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Generating code...
2025-09-30 17:09:05.213 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class TextConversionUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertJsonToYaml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new YAMLMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to YAML: " + e.getMessage();
        }
    }

    public static String convertJsonToXml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new XmlMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to XML: " + e.getMessage();
        }
    }

    private static JsonNode getJsonNode(String json) throws JsonProcessingException {
        return objectMapper.readTree(json);
    }
}


>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.utils;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any required state before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
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

2025-09-30 17:09:05.214 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 17:09:09.819 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 2543, outputTokenCount = 797, totalTokenCount = 3340 }
2025-09-30 17:09:09.820 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Done
2025-09-30 17:09:09.820 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Generated code:
package com.example.textapi.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any required state before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToYaml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(malformedJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToXml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(malformedJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }
}
2025-09-30 17:09:09.821 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Refining code...
2025-09-30 17:09:09.822 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Done
2025-09-30 17:09:09.822 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.utils;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any required state before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToYaml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(malformedJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToXml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(malformedJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }
}

2025-09-30 17:09:48.746 INFO [main] [io.github.adamw7.testing.generator.prompt.ExceptionsHandlingPromptProvider.getPromptMessages(ExceptionsHandlingPromptProvider.java:37)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Building a prompt for exceptions handling in unit tests...
2025-09-30 17:09:48.748 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:64)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Generating code...
2025-09-30 17:09:48.748 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.printPromptMessages(CodeGenerator.java:115)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Using prompt:

>> INPUT JAVA here you can find original code of CLASS:

package com.example.textapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class TextConversionUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertJsonToYaml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new YAMLMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to YAML: " + e.getMessage();
        }
    }

    public static String convertJsonToXml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new XmlMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to XML: " + e.getMessage();
        }
    }

    private static JsonNode getJsonNode(String json) throws JsonProcessingException {
        return objectMapper.readTree(json);
    }
}


>> TASK: Below is the class with the originally generated tests. Please review the tests and check if exceptions are correctly handled. If methods in the original class can throw exceptions, ensure there are dedicated tests for those scenarios using assertThrows. Add or improve tests to cover exception handling, fix any related compilation errors, and suggest corrections to enhance quality. If there are logical errors in exception testing, address them.


package com.example.textapi.utils;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any required state before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToYaml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(malformedJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToXml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(malformedJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
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

2025-09-30 17:09:48.751 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.generateTillEnd(CodeGenerator.java:119)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Generate code iteration # 1
2025-09-30 17:09:55.798 DEBUG [main] [io.github.adamw7.orchestrator.ai.langchain.LangChainAiService.generate(LangChainAiService.java:45)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - TokenUsage { inputTokenCount = 5023, outputTokenCount = 953, totalTokenCount = 5976 }
2025-09-30 17:09:55.799 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:82)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Done
2025-09-30 17:09:55.799 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:88)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Generated code:
package com.example.textapi.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any required state before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToYaml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(malformedJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToXml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(malformedJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenEmptyJsonString_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenEmptyJsonString_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }
}
2025-09-30 17:09:55.799 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:89)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Refining code...
2025-09-30 17:09:55.800 INFO [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:91)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Done
2025-09-30 17:09:55.800 DEBUG [main] [io.github.adamw7.orchestrator.generator.CodeGenerator.create(CodeGenerator.java:92)] [{conversationName=com.example.textapi.utils.TextConversionUtilGeneratedAiTests.java}] - Refined generated code:
package com.example.textapi.utils;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextConversionUtilGeneratedAiTests {

    @BeforeEach
    void setUp() {
        // Reset or initialize any required state before each test
    }

    @Test
    void givenValidJson_whenConvertJsonToYaml_thenReturnsExpectedYaml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(json);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.contains("name: \"John\""));
        assertTrue(yamlResult.contains("age: 30"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(invalidJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenValidJson_whenConvertJsonToXml_thenReturnsExpectedXml() {
        // GIVEN
        String json = "{\"name\":\"John\",\"age\":30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(json);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.contains("<name>John</name>"));
        assertTrue(xmlResult.contains("<age>30</age>"));
    }

    @Test
    void givenInvalidJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String invalidJson = "{name:John,age:30}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(invalidJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(nullJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenNullJson_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String nullJson = null;

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(nullJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToYaml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(malformedJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenMalformedJson_whenConvertJsonToXml_thenHandlesExceptionGracefully() {
        // GIVEN
        String malformedJson = "{\"name\":\"John\",\"age\":}";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(malformedJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }

    @Test
    void givenEmptyJsonString_whenConvertJsonToYaml_thenReturnsErrorMessage() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String yamlResult = TextConversionUtil.convertJsonToYaml(emptyJson);

        // THEN
        assertNotNull(yamlResult);
        assertTrue(yamlResult.startsWith("Error converting JSON to YAML"));
    }

    @Test
    void givenEmptyJsonString_whenConvertJsonToXml_thenReturnsErrorMessage() {
        // GIVEN
        String emptyJson = "";

        // WHEN
        String xmlResult = TextConversionUtil.convertJsonToXml(emptyJson);

        // THEN
        assertNotNull(xmlResult);
        assertTrue(xmlResult.startsWith("Error converting JSON to XML"));
    }
}
*/
