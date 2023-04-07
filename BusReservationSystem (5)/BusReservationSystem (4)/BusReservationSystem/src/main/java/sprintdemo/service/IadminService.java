package sprintdemo.service;

import sprintdemo.exception.AdminNotFoundException;
import sprintdemo.exception.UserAlreadyExistsException;
import sprintdemo.model.Admin;

public interface IadminService {
	public Admin addAdmin(Admin admin) throws UserAlreadyExistsException;
	public String adminlogin(int adminId, String adminpassword) throws AdminNotFoundException;

}
