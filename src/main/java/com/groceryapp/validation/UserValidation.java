package com.groceryapp.validation;

import com.groceryapp.Exceptions.ValidationException;
import com.groceryapp.model.User;

public class UserValidation {

	public static void validate(User user) throws ValidationException {

		if (user.getName() == null || user.getName().trim().equals("")) {
			throw new ValidationException("Invalid Name. Name cannot be empty/blank");
		}
		if (user.getEmail() == null || user.getEmail().trim().equals("")) {
			throw new ValidationException("Invalid Name. Name cannot be empty/blank");
		}

		if (user.getMobile() == null || user.getMobile().length() < 10) {
			throw new ValidationException("mobile must be in 10 digits");
		}
		if (user.getPassword() == null || user.getPassword().length() < 8) {

			throw new ValidationException("password must be in 8 characters");
		}
	}

	public static void loginvalidate(User user) throws ValidationException {

		if (user.getEmail() == null || user.getEmail().trim().equals("")||!(user.getEmail()).contains("@gmail.com")) {
			throw new ValidationException("Invalid email. email cannot be empty/blank");
		}
		if (user.getPassword() == null || user.getPassword().length() < 8) {

			throw new ValidationException("password must be in 8 characters");
		}
		
	}
}
	/*	public static void fogetvalidate(User user) throws Exception {
			
			if (user.getEmail() == null || user.getEmail().trim().equals("")||!(user.getEmail()).contains("@gmail.com")) {
				throw new Exception("Invalid email. email cannot be empty/blank");
			}
			if (user.getPassword() == null || user.getPassword().length() < 8) {

				throw new Exception("password must be in 8 characters");
			}
			
		}
		

	/*	if (user.getEmail().equals(user.getEmail()) && user.getPassword().equals(user.getPassword())) {
			return "success";

		} else {
			return "INVALID CREDENTAILS";
		}*/

	
