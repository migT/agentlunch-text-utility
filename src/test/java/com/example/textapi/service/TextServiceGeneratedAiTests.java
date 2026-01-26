package com.example.textapi.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
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

// ... (rest of the file remains the same)

public void shouldGenerateTextWithMultipleSentences() {
    // Given
    TextRequest request = new TextRequest("This is a test text");
    request.setLanguage(Language.ENGLISH);
    request.setFormat(Format.PLAIN_TEXT);

    // When
    TextResponse response = textService.generate(request);

    // Then
    assertEquals(Arrays.asList("This is a test text."), response.getText().split("\\s+"));
}

public void shouldGenerateTextWithMultipleSentencesAndSpecialCharacters() {
    // Given
    TextRequest request = new TextRequest("This is a test text with special characters: !@#$%^&*()");
    request.setLanguage(Language.ENGLISH);
    request.setFormat(Format.PLAIN_TEXT);

    // When
    TextResponse response = textService.generate(request);

    // Then
    assertEquals(Arrays.asList("This is a test text with special characters: !@#$%^&*()"), response.getText().split("\\s+"));
}