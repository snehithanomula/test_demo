package sprintdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sprintdemo.exception.UserNotFoundException;
import sprintdemo.model.User;

public interface IUserRepository extends JpaRepository<User, Integer>{
	@Query(value="SELECT * FROM user_table where user_login_id = ?1", nativeQuery=true)
	public User viewUser(int userId);
	
	@Query(value="select password from user_table where user_login_id=:id",nativeQuery=true )
	public String getPassword(@Param("id") int id);
	
	@Query(value="delete  from user_table where user_login_id = ?1", nativeQuery=true)
	public void deleteUser(int userId) throws UserNotFoundException;

	public User findByUserName(String username);
	

}
