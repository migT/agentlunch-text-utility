package com.example.textapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class TextService {

    private static final String HELLO_WORLD = "Hello, World!";
    public static final String VOWEL_PATTERN = "(?i)[^aeiou]";
    public static final String STRING_EMPTY = "";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String consonantPattern = "(?i)[^b-df-hj-np-tv-z]";

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String uppercase(String input) {
        return input.toUpperCase();
    }

    public Map<String, Object> stats(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("length", getLength(input));
        result.put("wordCount", getSplitCount(input, "\\s+"));
        result.put("lineCount", getSplitCount(input, "\\n"));
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    private Integer getLength(String input) {
        if (input == null) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(input.length());
    }

    private static Integer getSplitCount(String input, String splitRegex) {
        int length = input.split(splitRegex).length;
        return Integer.valueOf(length);
    }

    public List<String> getRepeatedWords(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        List<String> result = new ArrayList<>();

        // Normalize input: lowercase and remove punctuation (except digits/letters)
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        // Count word occurrences
        for (String word : words) {
            wordCount.put(word, Integer.valueOf(wordCount.getOrDefault(word, Integer.valueOf(0)) + 1));
        }

        // Collect only repeated words with their count
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey() + " : " + entry.getValue());
            }
        }

        return result;
    }

    private Integer getConsonantCount(String input) {
        return Integer.valueOf(input.replaceAll(consonantPattern, STRING_EMPTY).length());
    }

    private Integer getVowelCount(String input) {
        return Integer.valueOf(input.replaceAll(VOWEL_PATTERN, STRING_EMPTY).length());
    }

    public String replace(String input, String target, String replacement) {
        return input.replace(target, replacement);
    }

    public String removeVowels(String input) {
        return removePattern(input,"(?i)[aeiou]");
    }

    public String removeConsonants(String input) {
        return removePattern(input,"(?i)[b-df-hj-np-tv-z]");
    }

    private String removePattern(String input, String regex) {
        return input.replaceAll(regex, "");
    }

    public int countOccurrence(String input, String keyword) {
        return input.split("(?i)\\b" + Pattern.quote(keyword) + "\\b", -1).length - 1;
    }

    public String convertJsonToYaml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new YAMLMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to YAML: " + e.getMessage();
        }
    }

    public String convertJsonToXml(String json) {
        try {
            JsonNode jsonNode = getJsonNode(json);
            return new XmlMapper().writeValueAsString(jsonNode);
        } catch (Exception e) {
            return "Error converting JSON to XML: " + e.getMessage();
        }
    }

    private JsonNode getJsonNode(String json) throws JsonProcessingException {
        return objectMapper.readTree(json);
    }

    public String helloworld() {
        return HELLO_WORLD;
    }
}