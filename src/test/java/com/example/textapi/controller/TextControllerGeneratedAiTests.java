package com.example.textapi.controller;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.textapi.service.TextService;

class TextControllerTest {

    @Test
    void testGetText() {
        TextController controller = new TextController();
        String text = controller.getText("hello");
        assertEquals("hello", text);
    }

    @Test
    void testGetTextWithEmptyString() {
        TextController controller = new TextController();
        String text = controller.getText("");
        assertEquals("", text);
    }

    @Test
    void testGetTextWithNullString() {
        TextController controller = new TextController();
        String text = controller.getText(null);
        assertEquals(null, text);
    }
}
