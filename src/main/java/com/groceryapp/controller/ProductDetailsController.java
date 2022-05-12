package com.groceryapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groceryapp.MessageDTO;
import com.groceryapp.model.Product;
import com.groceryapp.service.ProductService;

@RestController
public class ProductDetailsController {
//	@Autowired
//	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	@PostMapping("product/save")
	public ResponseEntity<?> save(@RequestBody Product product) {
		try {

			productService.save(product);
			return new ResponseEntity<>( HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("product/productlist")
	public List<Product> findAll() {
		List<Product> listProduct = null;
		try {

			listProduct = productService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	@DeleteMapping("product/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		try {
		
			productService.deleteById(id);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message,HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}

	}

	@PutMapping("product/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Product product) {
		try {
			productService.update(id, product);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}
	}
	@GetMapping("product/{id}") // find by user Id
	public Product findById(@PathVariable("id") Integer id) {
		System.out.println("findById " + id);
		Product product= productService.findById(id);
		return product;
	}


}

/*
 * @PutMapping("product/{id}") public void update(@PathVariable("id") Integer
 * id, @RequestBody Product product) { try { product.setId(id);
 * 
 * Product productObj = productService.findById(id).get();
 * productObj.setName(product.getName());// update productService.save(product);
 * } catch (Exception e) { e.printStackTrace(); } }
 * 
 * @GetMapping("product/{id}") public Product findById(@PathVariable("id")
 * Integer id) { Optional<Product> product = productService.findById(id); try {
 * if (product.isPresent()) { Product productObj = product.get(); return
 * productObj; } else { return null; } } catch (Exception e) {
 * e.printStackTrace(); } return null; }
 * 
 * }
 */
