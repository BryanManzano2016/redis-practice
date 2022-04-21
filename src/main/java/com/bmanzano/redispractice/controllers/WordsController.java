package com.bmanzano.redispractice.controllers;

import com.bmanzano.redispractice.repositories.Words;
import com.bmanzano.redispractice.repositories.WordsRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("words")
@RestController
@NoArgsConstructor
@Slf4j
public class WordsController {
    @Autowired
    WordsRepository wordsReposRedis;

    @GetMapping("/all")
    public Iterable<Words> getAllRedis() {
        return wordsReposRedis.findAll();
    }

    @GetMapping("/{key}")
    public Optional<Words> getByIdRedis(@PathVariable String key) {
        var t1 = System.currentTimeMillis();
        Optional<Words> result = wordsReposRedis.findByKey(key);
        log.info("getByIdRedis: {}", System.currentTimeMillis() - t1);
        return result;
    }

    @GetMapping("/create/{keyV}/{valueV}")
    public Words create(@PathVariable String keyV,
                                  @PathVariable String valueV) {
        Words words = Words.builder().key(keyV).value(valueV).build();
        return wordsReposRedis.save(words);
    }
}
