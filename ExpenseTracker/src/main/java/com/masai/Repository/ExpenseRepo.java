package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entity.Expense;
import com.masai.Entity.User;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Integer>{

	List<Expense> findByUserOrderByDateDesc(User user);
	
	List<Expense> findAllByOrderByDateDesc();
	
	List<Expense> findByUser(User user);
	
}
