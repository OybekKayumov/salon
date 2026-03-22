package com.ok.service;

import com.ok.exception.UserException;
import com.ok.model.User;

import java.util.List;

public interface UserService {

	User createUser(User user);

	User getUserById(long id) throws UserException;

	List<User> getAllUsers();

	void deleteUser(Long id) throws UserException;

	User updateUser(Long id, User user) throws UserException;
}
