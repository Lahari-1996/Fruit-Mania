package com.mania.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mania.exception.CategoryException;
import com.mania.exception.LoginException;
import com.mania.exception.ProductException;
import com.mania.model.Category;
import com.mania.model.CurrentUserSession;
import com.mania.model.Product;
import com.mania.model.User;
import com.mania.model.UserType;
import com.mania.repository.CategoryDao;
import com.mania.repository.CurrentUserSessionDao;
import com.mania.repository.ProductDao;
import com.mania.repository.UserDao;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private UserDao userDao;


	@Override
	public List<Category> viewAllCatagories() throws CategoryException, LoginException {
		
		List<Category> categories = categoryDao.findAll();
		
		if(categories.size()==0) throw new CategoryException("Category List is empty");
			
	    return categories;
	}

	@Override
	public List<Product> viewProductsCatagoryWise(String category) throws ProductException, LoginException, CategoryException {
		
		List<Product> products = categoryDao.viewProductsCatagoryWise(category);
		
		if(products.size()==0) throw new CategoryException("product List is empty");
			
	    return products;
	}

	@Override
	public Category addCategory(Category category, String key) throws CategoryException, LoginException {
		Optional<CurrentUserSession> cuss = currentUserSessionDao.findByUuid(key);
		
		if(cuss.isEmpty()) {
			
			throw new LoginException("Admin is not logged in !!!");
			
		}
		
		Optional<User> opt= userDao.findByUsername(cuss.get().getUserName());
		
		if(! opt.get().getUserType().equals(UserType.ADMIN)) {
			throw new LoginException("This Access is only given to Admin");
		}
		
		Category newcategory = categoryDao.save(category);
		
		return newcategory;

    }

}
