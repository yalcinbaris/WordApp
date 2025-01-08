package com.example.wordapp.controller;

import com.example.wordapp.business.WordManager;
import com.example.wordapp.business.WordService;
import com.example.wordapp.entities.Word;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word")
@CrossOrigin(origins = "http://localhost:4200")
public class WordController {
    private final WordService service;

    public WordController(WordService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public Word getWord(@PathVariable int id){
        return service.getWord(id);
    }

    @PostMapping
    public void addWord(String word) throws Exception {
        this.service.createWord(word);
    }

    @DeleteMapping("/{id}")
    public void deleteWord(@PathVariable int id){
        this.service.deleteWord(id);
    }

    @GetMapping("/random")
    public List<Word> getRandomWord(){
        return service.randomWord();
    }
    @GetMapping("/learned/{id}")
    public void learnedWord(@PathVariable int id){
        service.learnedWord(id);
    }
}
