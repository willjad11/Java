package com.jaden.expenses.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaden.expenses.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{

    List<Expense> findAll();

    List<Expense> findByDescriptionContaining(String search);

    Long countByNameContaining(String search);

    void deleteById(Long Id);

    Optional<Expense> findById(Long Id);
}