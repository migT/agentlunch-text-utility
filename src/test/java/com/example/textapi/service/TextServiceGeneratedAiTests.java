package com.example.textapi.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)
class TextServiceGeneratedAiTests {

    @Test
    void convertJsonToYaml_shouldConvertJsonToYaml() {
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String yaml = TextConversionUtil.convertJsonToYaml(json);
    }

    @Test
    void convertJsonToXml_shouldConvertJsonToXml() {
        String json = "{ \"name\": \"John\", \"age\": 30 }";
        String xml = TextConversionUtil.convertJsonToXml(json);
    }
}
