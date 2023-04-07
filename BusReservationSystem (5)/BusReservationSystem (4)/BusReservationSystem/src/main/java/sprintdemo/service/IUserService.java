package sprintdemo.service;

import java.util.List;

import sprintdemo.exception.UserAlreadyExistsException;
import sprintdemo.exception.UserNotFoundException;
import sprintdemo.model.User;

public interface IUserService {
	public User addUser(User user) throws UserAlreadyExistsException;
	public void deleteUser(int userId) throws UserNotFoundException;
	public User viewUser(int userId) throws UserNotFoundException;
	public List<User> viewAllUser() throws UserNotFoundException;

	public User updateUser(User user, int userLoginId) throws UserNotFoundException;
}
