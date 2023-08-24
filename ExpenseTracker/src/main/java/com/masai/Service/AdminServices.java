package com.masai.Service;

import java.util.List;

import com.masai.Entity.Expense;
import com.masai.Entity.User;

public interface AdminServices {

	public List<Expense> getAllExpenses();
	
	public List<User> getAllUsers();
	
	public List<Expense> getUserExpense(User user);
	
}
