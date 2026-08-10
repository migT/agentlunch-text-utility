package com.example.textapi.utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextConversionUtilGeneratedAiTests {

    @Test
    public void testConvertJsonToYaml_withEmptyJson_returnsYaml() {
        String json = "{}";
        String expectedYaml = "{}\n";
        String actualYaml = TextConversionUtil.convertJsonToYaml(json);
        assertEquals(expectedYaml, actualYaml);
    }
}