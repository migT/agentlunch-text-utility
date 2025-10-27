package com.example.textapi.controller;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.textapi.service.TextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class TextControllerGeneratedAiTests {

    @Mock
    private TextService textService;

    @InjectMocks
    private TextController textController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSomeMethod() {
        doNothing().when(textService).someServiceMethod();
        ResponseEntity<?> response = textController.someMethod();
        verify(textService, times(1)).someServiceMethod();
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testAnotherMethod() {
        String param = "test";
        doNothing().when(textService).anotherServiceMethod(param);
        ResponseEntity<?> response = textController.anotherMethod(param);
        verify(textService, times(1)).anotherServiceMethod(param);
        assertEquals(200, response.getStatusCodeValue());
    }
}
