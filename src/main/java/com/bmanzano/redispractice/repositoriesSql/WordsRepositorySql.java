package com.bmanzano.redispractice.repositoriesSql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepositorySql extends CrudRepository<WordsSql, String> {
    WordsSql findByKey(String key);
}
