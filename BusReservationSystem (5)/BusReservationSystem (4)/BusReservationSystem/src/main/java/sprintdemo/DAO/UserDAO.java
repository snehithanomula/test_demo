package sprintdemo.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sprintdemo.exception.UserAlreadyExistsException;
import sprintdemo.exception.UserNotFoundException;
import sprintdemo.model.Reservation;
import sprintdemo.model.User;
import sprintdemo.repository.IUserRepository;
import sprintdemo.service.IUserService;

@Service
public class UserDAO implements IUserService,UserDetailsService{
	int level=0;
	@Autowired
	private IUserRepository repository;

	@Override
	public User addUser(User user) throws UserAlreadyExistsException {
		if(repository.existsById(user.getUserLoginId())) {
			
			throw new UserAlreadyExistsException("User aready  exists with this User ID");
		}else{
			Reservation reservation=user.getReservation();
			user.setReservation(reservation);
		return repository.save(user);
		}
		 
	}

	
	@Override
	  public User updateUser(User user, int userLoginId) throws UserNotFoundException { 
		 Optional<User> optional =repository.findById(user.getUserLoginId()); 
		 User userdata=null;
		 if(optional.isPresent()) { 
			 userdata=optional.get();
			 userdata.setUserName(user.getUserName());
			 userdata.setFirstName(user.getFirstName());
			 userdata.setLastName(user.getLastName());
			 userdata.setEmail(user.getEmail());
			 userdata.setPassword(user.getPassword());
			 userdata.setContact(user.getContact()); 
			 userdata.setReservation(user.getReservation());
			 repository.save(userdata);
	  	}
		
		 return userdata;
		 } 
		
	@Override
	public void deleteUser(int userId) throws UserNotFoundException {
		if(repository.existsById(userId)) {
			
			 repository.deleteById(userId);	 
		}
		else {
			throw new UserNotFoundException ("User not found with this User Id");
		}
	
		
	}

	@Override
	public User viewUser(int userId) throws UserNotFoundException {
		if(repository.existsById(userId)) {
			return repository.viewUser(userId);
		}
		else {
			throw new UserNotFoundException ("User not found with this User Id");
		}
	
		
	}

	@Override
	public List<User> viewAllUser() {
		List<User> list=repository.findAll();
		return list;
	}
	
	public String logOutService() {
		level=0;
		return "Logged Out Successfully";
	}

	public String userlogin(int userId, String userpassword) throws UserNotFoundException{
		// TODO Auto-generated method stub
		
		if(repository.existsById(userId)) {
		String pw= repository.getPassword(userId);
		if(pw.equals(userpassword)) {
				level=1;
				return "logged in as User";	
			}
			
		
		else {
		
			throw new UserNotFoundException("Incorrect UserId or User Password");
		}
		
		}
		else {
				return "You are not a registered user, please sign-in to continue";
		}
	
	
	
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= repository.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList());
	}

}
