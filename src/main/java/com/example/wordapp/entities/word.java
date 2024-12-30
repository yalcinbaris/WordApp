package com.example.wordapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "word",unique = true)
    private String word;
    private String sentence;
    private String turkish;
    private String sentenceTurkish;
    private boolean isLearned = false;
}
