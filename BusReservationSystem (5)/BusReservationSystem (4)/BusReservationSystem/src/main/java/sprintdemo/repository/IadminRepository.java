package sprintdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sprintdemo.model.Admin;

public interface IadminRepository extends JpaRepository<Admin, Integer>{
	@Query("SELECT adminPassword FROM Admin i WHERE i.adminId= ?1")
	public String getPassword(int id);
	/*v@Query(value="select adminPassword from admin where user_login_id=:id",nativeQuery=true )
	public String getPassword(@Param("id") int id);*/

}
