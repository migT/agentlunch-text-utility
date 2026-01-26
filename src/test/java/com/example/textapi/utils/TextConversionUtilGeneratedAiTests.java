package com.example.textapi.utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

public void testConvertJsonToXmlNullInput() {
    // Given
    String input = null;

    // When
    String result = textConversionUtil.convertJsonToXml(input);

    // Then
    assertNull(result);
}

public void testConvertJsonToYamlNullInput() {
    // Given
    String input = null;

    // When
    String result = textConversionUtil.convertJsonToYaml(input);

    // Then
    assertNull(result);
}

public void testConvertJsonToXml() {
    // Given
    String input = "{\"key\":\"value\"}";

    // When
    String result = textConversionUtil.convertJsonToXml(input);

    // Then
    assertNotNull(result);
    assertEquals("<root><key>value</key></root>", result.trim());
}

public void testConvertJsonToYaml() {
    // Given
    String input = "{\"key\":\"value\"}";

    // When
    String result = textConversionUtil.convertJsonToYaml(input);

    // Then
    assertNotNull(result);
    assertEquals("key: value", result.trim());
}
