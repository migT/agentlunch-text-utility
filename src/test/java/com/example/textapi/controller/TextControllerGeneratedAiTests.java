package com.example.textapi.controller;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TextControllerGeneratedAiTests {

    private TextService textService;
    private TextController textController;

    @BeforeEach
    void setUp() {
        textService = new TextService();
        textController = new TextController(textService);
    }

    // ... rest of the test code ...
}
