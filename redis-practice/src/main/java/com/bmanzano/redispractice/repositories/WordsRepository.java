package com.bmanzano.redispractice.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WordsRepository extends CrudRepository<Words, String> {
    Optional<Words> findByKey(String key);
}
