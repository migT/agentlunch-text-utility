package com.example.textapi.utils;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class TextConversionUtilTest {

    @Test
    void givenEmptyJson_whenConvertJsonToYaml_thenReturnsEmptyYamlStructure() {
        String json = "{}";
        String expectedYaml = "{}";
        String actualYaml = TextConversionUtil.convertJsonToYaml(json);
        assertEquals(expectedYaml.trim(), actualYaml.trim());
    }
}