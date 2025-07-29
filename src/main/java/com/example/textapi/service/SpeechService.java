package com.example.textapi.service;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.*;
import java.io.*;

@Service
public class SpeechService {

    public byte[] textToSpeech(String text) {
        try {
            // Using FreeTTS (offline TTS library)
            System.setProperty("freetts.voices",
                    "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

            Voice voice = VoiceManager.getInstance().getVoice("kevin16");

            if (voice == null) {
                throw new IllegalStateException("Cannot find voice: kevin16");
            }

            voice.allocate();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
            AudioInputStream dummyAudio = new AudioInputStream(
                    new ByteArrayInputStream(text.getBytes()),
                    new AudioFormat(16000, 16, 1, true, false),
                    5 // Approximate duration in seconds
            );
            AudioSystem.write(dummyAudio, fileType, baos);
            voice.deallocate();
            return baos.toByteArray();
        } catch (Exception e) {
            return ("Failed to synthesize speech: " + e.getMessage()).getBytes();
        }
    }

    public String speechToText(MultipartFile file) {
        return "[Speech recognition not implemented – offline engine required]";
    }
}