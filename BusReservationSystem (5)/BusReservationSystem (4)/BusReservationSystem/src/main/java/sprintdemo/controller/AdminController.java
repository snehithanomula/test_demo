package sprintdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sprintdemo.DAO.AdminDAO;
import sprintdemo.exception.AdminNotFoundException;
import sprintdemo.model.Admin;

//@EnableSwagger2
@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	private AdminDAO dao;
	@PostMapping(path="/addAdmin")
public Admin addAdmin(@Valid @RequestBody Admin admin)  {
		
		return dao.addAdmin(admin);
	}
	
	@GetMapping (path="/adminlogin/{adminId}/{adminPassword}")
	public String adminlogin(@PathVariable int adminId, @PathVariable String adminPassword) {
		
		try {
			return dao.adminlogin(adminId,adminPassword);
			
		}
		catch(AdminNotFoundException n)
		{
			return n.getMessage();
			
		}
		

		
	}

}
