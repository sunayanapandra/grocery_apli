
package com.groceryapp.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.groceryapp.dao.UserRepository;
import com.groceryapp.model.Product;
import com.groceryapp.model.User;
import com.groceryapp.service.UserService;

@RestController

public class UserDetailsController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@PostMapping("user/save") // register
	public ResponseEntity<?> save(@RequestBody User user) {
		try {
			userService.save(user);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("user/userlist")
	public List<User> findAll() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@DeleteMapping("user/{id}")
	/*
	 * public void delete(@PathVariable("id") Integer id) {
	 * 
	 * log.debug(" deletebyid -{}", id); userRepository.deleteById(id);
	 */
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		try {

			userService.deleteById(id);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}

	}

	/*@PutMapping("user/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setId(id);
		userRepository.save(user);
	}*/
	@PutMapping("user/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody User user) {
		try {
			userService.update(id, user);
			MessageDTO message = new MessageDTO("success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("user/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		log.info(" get -{}", id);
		boolean exists = userRepository.existsById(id);
		System.out.println("Id exists:" + exists);
		if (!exists) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Optional<User> user = userRepository.findById(id);

			if (user.isPresent()) {
				User userObj = user.get();
				return new ResponseEntity<>(userObj, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
	}

	@PostMapping("user/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		try {
			String ln = userService.login(user);
			MessageDTO message = new MessageDTO("success");
			if (ln == "success") {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			MessageDTO message = new MessageDTO(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// log.info(" get -{}", id);

	/*
	 * @PostMapping("user/forgetPassword") public ResponseEntity<String>
	 * forgetpassword(@RequestBody User user) { try { String
	 * ln=userService.forgotPassword(user); if(ln=="success") { return new
	 * ResponseEntity<String>("Successfully login", HttpStatus.OK); }else { return
	 * new ResponseEntity<String>("UnSuccessfully login", HttpStatus.OK); } } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
	 * return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); }
	 * }
	 */

}
