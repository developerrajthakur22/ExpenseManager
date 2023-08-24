package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Expense;
import com.masai.Entity.User;
import com.masai.Repository.ExpenseRepo;
import com.masai.Repository.UserRepo;

@Service
public class AdminServiceImpl implements AdminServices{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ExpenseRepo expenseRepo;
	
	@Override
	public List<Expense> getAllExpenses() {
		// TODO Auto-generated method stub
		return expenseRepo.findAll();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public List<Expense> getUserExpense(User user) {
		// TODO Auto-generated method stub
		return expenseRepo.findByUser(user);
	}

}
