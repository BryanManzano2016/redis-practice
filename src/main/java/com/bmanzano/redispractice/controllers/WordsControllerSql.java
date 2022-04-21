package com.bmanzano.redispractice.controllers;

import com.bmanzano.redispractice.repositoriesSql.WordsSql;
import com.bmanzano.redispractice.service.WordsService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("words")
@RestController
@NoArgsConstructor
@Slf4j
public class WordsControllerSql {
    @Autowired
    WordsService wordsService;

    @GetMapping("/sql/all")
    public Iterable<WordsSql> getAll() {
        return wordsService.findAll();
    }

    @GetMapping("/sql/{key}")
    public WordsSql getById(@PathVariable String key) {
        var t1 = System.currentTimeMillis();
        WordsSql result = wordsService.findByKey(key);
        log.info("getById: {}", System.currentTimeMillis() - t1);
        return result;
    }

}
