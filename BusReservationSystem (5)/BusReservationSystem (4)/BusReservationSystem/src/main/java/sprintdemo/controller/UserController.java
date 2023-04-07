package sprintdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.web.bind.annotation.*;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sprintdemo.DAO.UserDAO;
import sprintdemo.exception.UserAlreadyExistsException;
import sprintdemo.exception.UserNotFoundException;
import sprintdemo.model.AuthRequest;
import sprintdemo.model.User;
import sprintdemo.repository.IUserRepository;
import sprintdemo.util.JwtUtil;

//@EnableSwagger2
@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private JwtUtil util;
	@Autowired
	   private AuthenticationManager authenticationManager;
	@Autowired
	private UserDAO dao;
	@Autowired
	   private IUserRepository repos;
	
	@GetMapping("/")
	public String welcome()
	{
		return "welcome to capgemini";
	}
	@GetMapping("/find/by/{userName}")
	public User getRole(@PathVariable String userName)
	{
		return repos.findByUserName(userName);
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception
	{
		System.out.println(authRequest.getUserName() + " "+authRequest.getPassword());
		try
		{
	     authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName().trim(),authRequest.getPassword().trim()));
		}catch(Exception ex)
		{
			throw new Exception("Invalid user name and password");
		}
		return util.generateToken(authRequest.getUserName());
	}
	
	@GetMapping(path="/user")
	public List<User> getUser()
	{
		return dao.viewAllUser();
	}
	
	
	@PostMapping(path="/addUser")
	public User addUser(@Valid @RequestBody User user) throws UserAlreadyExistsException {
		
		return dao.addUser(user);
	}
		
	
	
	@DeleteMapping(path="/user/delete/{userid}")
		public void deleteUser(@PathVariable int userid) throws UserNotFoundException
		{
			dao.deleteUser(userid);
			
		}
		
	@GetMapping(path="/viewUser/{userid}")
	public User viewUser(@PathVariable int userid) throws UserNotFoundException
	{
	     return  dao.viewUser(userid);
		   
	}
	
	@PutMapping("/updateUser/{userLoginId}")
	public ResponseEntity<User> updateUser( @RequestBody User user,@PathVariable int userLoginId) throws UserNotFoundException {
		User user1 = dao.updateUser(user, userLoginId);
		ResponseEntity<User> response = new ResponseEntity<>(user1,HttpStatus.OK);
		return response;
	}
	@GetMapping (path="/userlogin/{userId}/{userpassword}")
	public String userloginService(@PathVariable int userId, @PathVariable String userpassword) {
		
		try {
			return dao.userlogin(userId,userpassword);
			
		}
		catch(UserNotFoundException n)
		{
			return n.getMessage();
			
		}
		

		
	}

	@GetMapping(path="/logOut")
	public String logOut() {
		return dao.logOutService();
	}

}
