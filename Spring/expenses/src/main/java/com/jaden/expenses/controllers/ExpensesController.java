package com.jaden.expenses.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaden.expenses.models.Expense;
import com.jaden.expenses.services.ExpenseService;

@Controller
public class ExpensesController {
	private final ExpenseService expenseService;
	public ExpensesController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }
	
	@GetMapping("/expenses")
    public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenseList = expenseService.allExpenses();
		model.addAttribute("expenseList", expenseList);
		return "index.jsp";
    }
    @PostMapping("/expenses/create")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Expense> expenseList = expenseService.allExpenses();
    		model.addAttribute("expenseList", expenseList);
            return "index.jsp";
        } else {
        	expenseService.createExpense(expense);
            return "redirect:/expenses";
        }
    }
    
    @DeleteMapping("/expenses/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
	
	@RequestMapping("/expenses/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "show.jsp";
    }
	
	@RequestMapping("/expenses/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }
    
    @PutMapping(value="/expenses/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }
}