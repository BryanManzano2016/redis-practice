package com.bmanzano.redispractice.service;

import com.bmanzano.redispractice.repositoriesSql.WordsRepositorySql;
import com.bmanzano.redispractice.repositoriesSql.WordsSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordsService {

   @Autowired
   WordsRepositorySql wordsRepoSql;

    /*@Cacheable(value = "wordCache")*/
    public WordsSql findByKey(String key) {
        return wordsRepoSql.findByKey(key);
    }

    public Iterable<WordsSql> findAll() {
       return wordsRepoSql.findAll();
    }
}
