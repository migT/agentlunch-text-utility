package com.example.textapi.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.junit.jupiter.MockitoExtension;

void testHelloWorld() throws Exception {
    // GIVEN: No preconditions needed

    // WHEN: Call the helloWorld method
    String result = mockMvc.perform(post("/text/hello")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

    // THEN: Verify that the response is as expected
    assertThat(result).isEqualTo("Hello, World!");
}

// ...

void testJsonToYaml() throws Exception {
    // GIVEN: A sample JSON string

    // WHEN: Call the convertJsonToYaml method with the JSON string
    when(textService.convertJsonToYaml("{\"key\":\"value\"}")).thenReturn("key: value");

    // WHEN: Perform a POST request to the /json-to-yaml endpoint with the JSON string
    mockMvc.perform(post("/text/json-to-yaml")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"key\":\"value\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("key: value"));

    // THEN: Verify that the response is as expected
}
