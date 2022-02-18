package com.jaden.expenses.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.jaden.expenses.models.Expense;
import com.jaden.expenses.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
 
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}

	public Expense createExpense(Expense b) {
		return expenseRepository.save(b);
	}

	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
	    	return optionalExpense.get();
	    }
		else {
	    	return null;
	    }
	}
	
	public void deleteExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			expenseRepository.deleteById(id);
	    }
	}
	
	public Expense updateExpense(@Valid Expense expense) {
		Optional<Expense> optionalExpense = expenseRepository.findById(expense.getId());
		if(optionalExpense.isPresent()) {
	    	Expense newExpense = optionalExpense.get();
	    	newExpense.setName(expense.getName());
	    	newExpense.setDescription(expense.getDescription());
	    	newExpense.setVendor(expense.getVendor());
	    	newExpense.setAmount(expense.getAmount());
	    	return expenseRepository.save(newExpense);
	    }
		else {
	    	return null;
	    }
	}
}

