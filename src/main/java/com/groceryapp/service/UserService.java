package com.groceryapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groceryapp.Exceptions.ValidationException;
import com.groceryapp.dao.UserRepository;
import com.groceryapp.model.User;
import com.groceryapp.validation.UserValidation;

@Service
	public class UserService {
		@Autowired
		UserRepository userRepository;

		public void save(User user) throws ValidationException {
			try {
				UserValidation.validate(user);
				
				userRepository.save(user);
			} catch (ValidationException e) {
				e.printStackTrace();
				throw new ValidationException(e.getMessage());
			}
		}
		
		
		public String  login(User user) throws ValidationException {
			try {
				UserValidation.loginvalidate(user);
				Optional<User> userObj = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
				if (userObj.isPresent()) {
					// User userObj = user.get();
					return "success";
				} else {
					return null;
				}
	
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidationException(e.getMessage());
			}
		}		
			
	/*		public String forgotPassword(User user) throws Exception {
				
				
				try {
					
					UserValidation.fogetvalidate(user);
					Optional  <User> userObj = userRepository.forgetPassword(user.getEmail(),user.getPassword());
					if (userObj.isPresent()) {
						// User userObj = user.get();
						return "success";
					} else {
						return null;
					}
		
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception(e.getMessage());
				}
			}	*/
			


		public List<User> findAll() throws ValidationException {
			List<User> listuser = null;
			try {
				listuser= userRepository.findAll();

			} catch (Exception e) {
				throw new ValidationException(e.getMessage());
			}
			return listuser;
		}

		public void deleteById(Integer id) throws ValidationException {
			try {
				userRepository.deleteById(id);
			} catch (Exception e) {
				throw new ValidationException(e.getMessage());
			}
		}

		public void update(Integer id, User user) throws ValidationException {
			try {
				user.setId(id);
				userRepository.save(user);

			} catch (Exception e) {
				throw new ValidationException(e.getMessage());
			}
		}
		public User findById(Integer id) {
			
			Optional<User> user = userRepository.findById(id);
			if (user.isPresent()) {
				User userObj = user.get();
				return userObj;
			} else {
				return null;
			}
		}


	}


