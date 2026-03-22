package com.ok.controller;

import com.ok.exception.UserException;
import com.ok.model.User;
import com.ok.repo.UserRepo;
import com.ok.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

//	@Autowired
//	private UserRepo userRepo;
	private final UserService userService;

	@PostMapping("/api/users")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
		//! return userRepo.save(user);
		User createdUser = userService.createUser(user);

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("api/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws Exception {
//* 1
//		User user = new User();
//		user.setEmail("user@mail.com");
//		user.setFullName("John Doe");
//		user.setPhone("+998 90 123 45 67");
//		user.setRole("CUSTOMER");
//		return user;

		//* 2 user present or not - Optional
//		Optional<User> user = userRepo.findById(id);
//
//		if (user.isPresent()) {
//			return user.get();
//		}
//
//		throw new UserException("User not found!");

		//* 3
		User user = userService.getUserById(id);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/api/users")
	public ResponseEntity<List<User>> getUsers() {
		//! return userRepo.findAll();

		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("/api/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,
												@PathVariable Long id) throws Exception {

//		Optional<User> updatedUser = userRepo.findById(id);
//		if (updatedUser.isEmpty()) {
//			throw new UserException("User not found with id: " + id);
//		}
//
//		User existingUser = updatedUser.get();
//
//		existingUser.setFullName(user.getFullName());
//		existingUser.setEmail(user.getEmail());
//		existingUser.setPhone(user.getPhone());
//		existingUser.setRole(user.getRole());
//
//		return userRepo.save(existingUser);

		//* 2
		User updatedUser = userService.updateUser(id, user);

		return new ResponseEntity<>(updatedUser, HttpStatus.OK);

	}

	@DeleteMapping("/api/users/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws Exception {
//		Optional<User> user = userRepo.findById(id);
//		if (user.isEmpty()) {
//			throw new UserException("User not found with id: " + id);
//		}
//
//		userRepo.deleteById(user.get().getId());
//
//		return "User deleted!";

		userService.deleteUser(id);
		return new ResponseEntity<>("User deleted!", HttpStatus.ACCEPTED);
	}

	//* 1-45
}
