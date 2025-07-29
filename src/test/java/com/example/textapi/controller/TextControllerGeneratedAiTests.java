package com.example.textapi.controller;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class TextControllerGeneratedAiTests {

    private TextService textService;

    @BeforeEach
    public void setUp() {
        this.textService = new TextService();
    }

    @Test
    public void testHelloWorld() {
        String result = textService.convertJsonToYaml("{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}");
        assert result.equals("---\n- name: John\n  age: 30\n  city: New York\n");
    }

    @Test
    public void testJsonToXml() {
        String result = textService.convertJsonToXml("{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}");
        assert result.equals("<root><name>John</name><age>30</age><city>New York</city></root>");
    }
}
