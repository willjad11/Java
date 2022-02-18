package com.jaden.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaden.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

    List<Language> findAll();

    List<Language> findByCreatorContaining(String search);

    Long countByNameContaining(String search);

    void deleteById(Long Id);

    Optional<Language> findById(Long Id);
}