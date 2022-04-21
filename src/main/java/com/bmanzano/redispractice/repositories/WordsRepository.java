package com.bmanzano.redispractice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WordsRepository extends CrudRepository<Words, String> {
    Optional<Words> findByKey(String key);
}
