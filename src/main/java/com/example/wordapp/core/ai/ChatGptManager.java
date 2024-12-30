package com.example.wordapp.core.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatGptManager implements AIService{
    private ChatClient chatClient;


    public ChatGptManager(ChatClient.Builder modelBuilder) {
        this.chatClient=modelBuilder.defaultSystem("""
                         Asistan,verilen kelime ile ilgili ingilizce bir cümle kurar.""")
                .build();
    }

    public String createSentence(String userMessageContent){
        return this.chatClient.prompt()
                .user(userMessageContent)
                .call()
                .content();
    }
}
