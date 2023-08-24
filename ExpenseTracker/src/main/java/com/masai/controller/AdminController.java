package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Expense;
import com.masai.Entity.User;
import com.masai.Service.AdminServices;

@RestController
public class AdminController {

	@Autowired
	private AdminServices adminServices;
	
	@GetMapping("admin/allExpenses")
	public ResponseEntity<List<Expense>> getallExpenses(){
		List<Expense> allExp = adminServices.getAllExpenses();
		return new ResponseEntity<>(allExp, HttpStatus.OK);
	}
	
	@GetMapping("admin/allUser")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> users = adminServices.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("admin/getExpByUser")
	public ResponseEntity<List<Expense>> expense(@RequestBody User user){
		List<Expense> exp = adminServices.getUserExpense(user);
		return new ResponseEntity<>(exp, HttpStatus.OK);
	}
	
}
