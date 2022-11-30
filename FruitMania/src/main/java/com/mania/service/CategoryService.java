package com.mania.service;

import java.util.List;

import com.mania.exception.CategoryException;
import com.mania.exception.LoginException;
import com.mania.exception.ProductException;
import com.mania.model.Category;
import com.mania.model.Product;

public interface CategoryService {

	public List<Category> viewAllCatagories() throws CategoryException,LoginException;
	
	public List<Product> viewProductsCatagoryWise(String category) throws ProductException,LoginException,CategoryException;

    public Category addCategory(Category category, String key) throws CategoryException,LoginException;
	
}
