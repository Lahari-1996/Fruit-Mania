package com.mania.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mania.model.Product;


public interface ProductDao extends JpaRepository<Product, Integer> {

	public Optional<Product> findByProductName(String productName);
	
	public List<Product> findAllByOrderByPriceDesc();
	
	public List<Product> findAllByOrderByPriceAsc();

}
