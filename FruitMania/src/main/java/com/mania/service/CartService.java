package com.mania.service;

import com.mania.exception.LoginException;
import com.mania.exception.ProductException;
import com.mania.model.Product;

public interface CartService {

	public Product addToCart(Product product, String key) throws ProductException,LoginException;
	
	public Product updateCart (Product product, String key) throws ProductException,LoginException;
	
	public Product viewCart() throws ProductException,LoginException;
	
	public Product checkOutCart() throws ProductException,LoginException;
	
	public Product calcUnitPrice() throws ProductException,LoginException;
	
	public Product calcTotalPrice() throws ProductException,LoginException;
}
