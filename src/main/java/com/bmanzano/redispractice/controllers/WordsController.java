package com.bmanzano.redispractice.controllers;

import com.bmanzano.redispractice.repositories.Words;
import com.bmanzano.redispractice.repositories.WordsRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("words")
@RestController
@NoArgsConstructor
public class WordsController {
    @Autowired
    WordsRepository wordsRepository;

    @GetMapping("/all")
    public Iterable<Words> getAll() {
        return wordsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Words> getById(@PathVariable String id) {
        return wordsRepository.findByKey(id);
    }

    @GetMapping("/create/{keyV}/{valueV}")
    public Words create(@PathVariable String keyV,
                                  @PathVariable String valueV) {
        Words words = Words.builder().key(keyV).value(valueV).build();
        return wordsRepository.save(words);
    }

    @GetMapping("/all/limit")
    public Iterable<Words> getAllWithLambda() {
        Iterable<Words> all = wordsRepository.findAll();
        List<Words> listAll = new ArrayList<>();
        all.forEach(listAll::add);
        return listAll.stream().limit(2).toList();
    }
}
