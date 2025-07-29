package com.example.textapi.controller;

import com.example.textapi.service.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/speech")
public class SpeechController {

    @Autowired
    private SpeechService speechService;

    @PostMapping("/text2speech")
    public ResponseEntity<ByteArrayResource> textToSpeech(@RequestBody String text) {
        if (text.length() > 1000) {
            return ResponseEntity.badRequest().body(null);
        }
        byte[] audio = speechService.textToSpeech(text);
        ByteArrayResource resource = new ByteArrayResource(audio);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=output.wav")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(audio.length)
                .body(resource);
    }

    @PostMapping("/speech2text")
    public String speechToText(@RequestParam("file") MultipartFile file) {
        if (file.getSize() > 100 * 1024 * 1024) { // 100 MB
            return "Audio file too large. Limit is 100MB.";
        }
        return speechService.speechToText(file);
    }
}
