package com.mania.service;

import java.util.List;

import com.mania.dto.LoginDTO;
import com.mania.exception.UserException;
import com.mania.model.CurrentUserSession;
import com.mania.model.User;

public interface UserService {

	public User registerUser(User user) throws UserException;
	
	public CurrentUserSession loginUser(LoginDTO user) throws UserException;
	
	public String logoutUser(String key) throws UserException;
	
	public User deleteCustomer(Integer customerId) throws UserException;
		
	public User viewCustomerById(Integer customerId) throws UserException;
	
	public List<User> viewAllCustomer() throws UserException;
	
	
 
}
