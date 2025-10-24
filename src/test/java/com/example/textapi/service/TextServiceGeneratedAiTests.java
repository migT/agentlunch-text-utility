package com.example.textapi.service;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class TextServiceGeneratedAiTests {

    private TextService textService;
    private TextRepository textRepository;

    @BeforeEach
    void setUp() {
        textRepository = Mockito.mock(TextRepository.class);
        textService = new TextService(textRepository);
    }

    @Test
    void testProcessTextReturnsExpectedResponse() {
        TextRequest request = new TextRequest();
        request.setText("Hello World");

        TextResponse expectedResponse = new TextResponse();
        expectedResponse.setProcessedText("HELLO WORLD");

        Mockito.when(textRepository.save(any(TextRequest.class))).thenReturn(request);

        TextResponse actualResponse = textService.processText(request);

        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getProcessedText(), actualResponse.getProcessedText());
    }

    @Test
    void testProcessTextHandlesNullInput() {
        assertThrows(IllegalArgumentException.class, () -> textService.processText(null));
    }

    @Test
    void testProcessTextHandlesEmptyString() {
        TextRequest request = new TextRequest();
        request.setText("");

        TextResponse actualResponse = textService.processText(request);

        assertNotNull(actualResponse);
        assertEquals("", actualResponse.getProcessedText());
    }

    @Test
    void testProcessTextTrimsInput() {
        TextRequest request = new TextRequest();
        request.setText("   hello   ");

        TextResponse actualResponse = textService.processText(request);

        assertNotNull(actualResponse);
        assertEquals("HELLO", actualResponse.getProcessedText());
    }

    static class TextRequest {
        private String text;
        public void setText(String text) { this.text = text; }
        public String getText() { return text; }
    }

    static class TextResponse {
        private String processedText;
        public void setProcessedText(String processedText) { this.processedText = processedText; }
        public String getProcessedText() { return processedText; }
    }

    interface TextRepository {
        TextRequest save(TextRequest request);
    }
}