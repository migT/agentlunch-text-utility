package com.example.textapi.controller;

import com.example.textapi.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/text")
public class TextController {

    @Autowired
    private TextService textService;

    @PostMapping("/reverse")
    public String reverse(@RequestBody String input) {
        return textService.reverse(input);
    }

    @PostMapping("/uppercase")
    public String uppercase(@RequestBody String input) {
        return textService.uppercase(input);
    }

    @PostMapping("/stats")
    public Map<String, Object> stats(@RequestBody String input) {
        return textService.stats(input);
    }

    @PostMapping("/camelcase")
    public String camelCase(@RequestBody String input) {
        return textService.toCamelCase(input);
    }

    @PostMapping("/replace")
    public String replace(@RequestParam String target, @RequestParam String replacement, @RequestBody String input) {
        return textService.replace(input, target, replacement);
    }

    @PostMapping("/remove-vowels")
    public String removeVowels(@RequestBody String input) {
        return textService.removeVowels(input);
    }

    @PostMapping("/remove-consonants")
    public String removeConsonants(@RequestBody String input) {
        return textService.removeConsonants(input);
    }

    @PostMapping("/count-occurrence")
    public int countOccurrence(@RequestParam String keyword, @RequestBody String input) {
        return textService.countOccurrence(input, keyword);
    }

    @PostMapping(value = "/json-to-yaml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToYaml(@RequestBody String json) {
        return textService.convertJsonToYaml(json);
    }

    @PostMapping(value = "/json-to-xml", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonToXml(@RequestBody String json) {
        return textService.convertJsonToXml(json);
    }
}