package com.example.textapi.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.*;

public class TextService {

    public Integer getLengthPublic(String input) {
        return input.length();
    }

    public Integer getSplitCountPublic(String input, String splitRegex) {
        return (int) input.split(splitRegex).length;
    }

    public Integer getConsonantCountPublic(String input) {
        int consonants = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (!"aeiou".contains(String.valueOf(c))) {
                    consonants++;
                }
            }
        }
        return consonants;
    }

    public Integer getVowelCountPublic(String input) {
        int vowels = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if ("aeiou".contains(String.valueOf(c))) {
                    vowels++;
                }
            }
        }
        return vowels;
    }

    public String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    public String uppercase(String input) {
        return input.toUpperCase();
    }

    public Map<String, Object> stats(String input) {
        String[] words = input.split("\\s+");
        int length = 0;
        for (String word : words) {
            length += word.length() + 1;
        }
        return Map.of("length", length - 1, "wordCount", words.length, "lineCount", 1);
    }

    public String replace(String input, String target, String replacement) {
        return input.replace(target, replacement);
    }

    public String removeVowels(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toLowerCase().toCharArray()) {
            if (!"aeiou".contains(String.valueOf(c))) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeConsonants(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toLowerCase().toCharArray()) {
            if ("aeiou".contains(String.valueOf(c))) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public int countOccurrence(String input, String keyword) {
        return (int) input.split(keyword).length - 1;
    }

    public String helloworld() {
        return "Hello, World!";
    }

    public String convertJsonToYaml(String json) {
        // implement JSON to YAML conversion
        return "";
    }

    public String convertJsonToXml(String json) {
        // implement JSON to XML conversion
        return "";
    }
}
