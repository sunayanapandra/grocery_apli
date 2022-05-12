package com.groceryapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryapp.Exceptions.ValidationException;
import com.groceryapp.dao.ProductRepository;
import com.groceryapp.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public void save(Product product) throws ValidationException {
		try {
			productRepository.save(product);
		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}
	}

	public List<Product> findAll() throws ValidationException {
		List<Product> listProduct = null;
		try {
			listProduct = productRepository.findAll();

		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}
		return listProduct;
	}

	public void deleteById(Integer id) throws ValidationException {
		try {
			productRepository.deleteById(id);
		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}
	}

	public void update(Integer id, Product product) throws ValidationException {
		try {
			product.setId(id);
			productRepository.save(product);

		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}
	}
public Product findById(Integer id) {
		
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			Product productObj = product.get();
			return productObj;
		} else {
			return null;
		}
	}

	
}