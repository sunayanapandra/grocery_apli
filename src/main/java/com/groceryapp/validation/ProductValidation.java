package com.groceryapp.validation;

import com.groceryapp.Exceptions.ValidationException;
import com.groceryapp.model.Product;

public class ProductValidation {
	public static void validate(Product product) throws ValidationException {

		if (product.getName() == null || product.getName().trim().equals("")) {
			throw new ValidationException("Invalid Name. Name cannot be empty/blank");
		}
		if (product.getBrand() == null || product.getBrand().trim().equals("")) {
			throw new ValidationException("Invalid BrandName. BrandName cannot be empty/blank");
		}

		if (product.getCategory() == null || product.getCategory().trim().equals("")) {
			throw new ValidationException("Invalid CategoryName. CategoryNameame cannot be empty/blank");
		}
		if(product.getPrice()== null || product.getPrice()<=0) {
			throw new ValidationException("Price Must not be null");
}
}
}