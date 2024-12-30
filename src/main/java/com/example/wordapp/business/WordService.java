package com.example.wordapp.business;

import com.example.wordapp.entities.Word;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WordService {
    public Word getWord(int id);
    public void createWord(String word)throws Exception;
    public void updateWord(Word word);
    void learnedWord(int id);
    public void deleteWord(int id);
    public List<Word> randomWord();
}
