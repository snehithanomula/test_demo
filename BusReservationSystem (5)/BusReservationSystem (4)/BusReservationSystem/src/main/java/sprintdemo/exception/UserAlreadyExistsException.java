package sprintdemo.exception;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String str) {
		super(str);
	}

}
