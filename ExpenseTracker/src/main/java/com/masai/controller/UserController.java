package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Expense;
import com.masai.Entity.User;
import com.masai.Exception.NotFoundException;
import com.masai.Service.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@GetMapping("user/login/{username}")
	public ResponseEntity<User> loginUser(@PathVariable String username) throws NotFoundException{
		User user = userServices.getUser(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("user/signup")
	public ResponseEntity<User> signupUser(@RequestBody User user){
		User us = userServices.createUser(user);
		return new ResponseEntity<User>(us, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("user/AddExpense/{username}")
	public ResponseEntity<Expense> addExpense(@RequestBody Expense exp, @PathVariable String username) throws NotFoundException{
		Expense ex = userServices.createExpense(exp, username);
		return new ResponseEntity<Expense>(ex,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("user/getExpense")
	public ResponseEntity<List<Expense>> getExpense(@RequestBody User user){
		List<Expense> exp = userServices.getUserExpense(user);
		return new ResponseEntity<List<Expense>>(exp,HttpStatus.OK);
	}
	
	@GetMapping("user/getExpByDate")
	public ResponseEntity<List<Expense>> getByDate(@RequestBody User user){
		List<Expense> exp = userServices.getUserExpensesSortedByDate(user);
		return new ResponseEntity<List<Expense>>(exp, HttpStatus.OK);
	}
	
	@DeleteMapping("user/deleteExpense/{username}")
	public ResponseEntity<HttpStatus> deleteExpense(@RequestBody Expense exp, @PathVariable String username) throws NotFoundException{
		 userServices.removeExpense(exp, username);
		 return ResponseEntity.ok(HttpStatus.OK);
	}
	
}