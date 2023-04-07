package sprintdemo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprintdemo.exception.AdminNotFoundException;
import sprintdemo.model.Admin;
import sprintdemo.repository.IadminRepository;
import sprintdemo.service.IadminService;

@Service
public class AdminDAO implements IadminService{
	@Autowired
	IadminRepository adminRepository ;
@Autowired
UserDAO dao;


	@Override
	public Admin addAdmin( Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}
@Override
	public String adminlogin(int adminId, String adminpassword) throws AdminNotFoundException{
		if(adminRepository.existsById(adminId)) {
		String pw= adminRepository.getPassword(adminId);
		if(pw.equals(adminpassword)) {
				dao.level=2;
				return "Welcome Admin";	
			}
			
		
		else {
		
			throw new AdminNotFoundException("Incorrect AdminId or Password");
		}
		
		}
		
		else {
			return "You are not a registered admin, please sign-in to continue";
	}

	
	
	}

}
