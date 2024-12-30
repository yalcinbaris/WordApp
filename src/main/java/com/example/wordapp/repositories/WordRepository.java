package com.example.wordapp.repositories;

import com.example.wordapp.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WordRepository extends JpaRepository<Word,Integer> {
    @Query(value = "SELECT * FROM word ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Word> randomWords();
}
