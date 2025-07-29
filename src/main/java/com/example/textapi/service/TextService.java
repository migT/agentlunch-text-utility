package com.example.textapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import jdk.internal.joptsimple.internal.Strings;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class TextService {

    private static final String HELLO_WORLD = "Hello, World!";
    public static final String VOWEL_PATTERN = "(?i)[^aeiou]";
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
        result.put("length", input.length());
        result.put("wordCount", input.split("\\s+").length);
        result.put("lineCount", input.split("\\R").length);
        result.put("VowelCount", getVowelCount(input));
        result.put("ConsonantCount", getConsonantCount(input));
        result.put("RepeatedWords", getRepeatedWords(input));
        return result;
    }

    private List<String> getRepeatedWords(String input) {
        String[] words = input.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        List<String> repeatedWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                repeatedWords.add(entry.getKey());
            }
        }
        return repeatedWords;
    }

    private int getConsonantCount(String input) {
        return input.replaceAll(consonantPattern, Strings.EMPTY).length();
    }

    private int getVowelCount(String input) {
        return input.replaceAll(VOWEL_PATTERN, Strings.EMPTY).length();
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