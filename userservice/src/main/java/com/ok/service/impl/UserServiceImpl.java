package com.ok.service.impl;

import com.ok.exception.UserException;
import com.ok.model.User;
import com.ok.repo.UserRepo;
import com.ok.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserById(long id) throws UserException {
		Optional<User> user = userRepo.findById(id);

		if (user.isPresent()) {
			return user.get();
		}

		throw new UserException("User not found!");

	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(Long id) throws UserException {
		Optional<User> user = userRepo.findById(id);
		if (user.isEmpty()) {
			throw new UserException("User not found with id: " + id);
		}

		userRepo.deleteById(user.get().getId());
	}

	@Override
	public User updateUser(Long id, User user) throws UserException {
		Optional<User> updatedUser = userRepo.findById(id);
		if (updatedUser.isEmpty()) {
			throw new UserException("User not found with id: " + id);
		}

		User existingUser = updatedUser.get();

		existingUser.setFullName(user.getFullName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhone(user.getPhone());
		existingUser.setRole(user.getRole());
		existingUser.setUsername(user.getUsername());

		return userRepo.save(existingUser);
	}
}
