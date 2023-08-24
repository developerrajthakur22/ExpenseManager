package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	Optional<User> findByUsername(String username);
	
}
