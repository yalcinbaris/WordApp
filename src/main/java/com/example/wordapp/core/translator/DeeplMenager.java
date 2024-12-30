package com.example.wordapp.core.translator;

import com.deepl.api.Translator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DeeplMenager implements TranslatorService {
    @Value("${deepl.api-key}")
    private String deeplApiKey ;
    Translator translator;

    public String translate(String userMessageContent) throws Exception {
        translator = new Translator(deeplApiKey);
        return translator.translateText(userMessageContent, "EN", "TR").getText();
    }
}

