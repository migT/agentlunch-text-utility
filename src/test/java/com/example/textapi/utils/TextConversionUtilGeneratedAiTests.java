package com.example.textapi.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TextConversionUtilGeneratedAiTests {

    @Test
    public void testConvertTextToJson() throws JsonProcessingException {
        // ... (rest of the test remains unchanged)
        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(text);
        assertEquals(json, expectedJson);
    }

    @Test
    public void testConvertTextToJson_throwsException() {
        assertThrows(JsonProcessingException.class, () -> textConversionUtil.convertTextToJson(text));
    }
}
