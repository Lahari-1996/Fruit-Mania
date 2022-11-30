package com.mania.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mania.model.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
public Optional<User>findByUsername(String username);

}
