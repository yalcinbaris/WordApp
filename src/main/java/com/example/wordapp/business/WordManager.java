package com.example.wordapp.business;

import com.example.wordapp.core.ai.AIService;
import com.example.wordapp.core.translator.TranslatorService;
import com.example.wordapp.entities.Word;
import com.example.wordapp.repositories.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordManager implements WordService {
    private final WordRepository repository;
    private final AIService aiService;
    private final TranslatorService translatorService;

    public WordManager (WordRepository repository,AIService aiService,TranslatorService translatorService){
        this.repository=repository;
        this.aiService=aiService;
        this.translatorService=translatorService;
    }

    @Override
    public Word getWord(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void createWord(String word) throws Exception {
        String sentence = aiService.createSentence(word);
        String turkish = translatorService.translate(word);
        String sentenceturkish = translatorService.translate(sentence);
        Word wordObject = new Word();
        wordObject.setWord(word);
        wordObject.setSentence(sentence);
        wordObject.setTurkish(turkish);
        wordObject.setSentenceTurkish(sentenceturkish);
        repository.save(wordObject);
    }


    @Override
    public void updateWord(Word word) {

    }

    @Override
    public void learnedWord(int id){
        Word word = repository.findById(id).orElseThrow();
        word.setLearned(true);
        repository.save(word);
    }

    @Override
    public void deleteWord(int id) {
        repository.deleteById(id);

    }
    public List<Word> randomWord(){
        return repository.randomWords();
    }
}
