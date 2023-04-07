package sprintdemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprintdemo.exception.BusAlreadyExistsException;
import sprintdemo.exception.BusNotFoundException;
import sprintdemo.exception.LoginException;
import sprintdemo.exception.NotAuthorizedException;
import sprintdemo.model.Bus;
import sprintdemo.repository.IBusRepository;
import sprintdemo.service.IBusService;

@Service
public class BusDAO implements IBusService {
	@Autowired
	private IBusRepository repository;
	@Autowired
	UserDAO lid;
	@Override
	public Bus addBus(Bus bus) throws BusAlreadyExistsException, NotAuthorizedException,LoginException{
		if(lid.level==1||lid.level==2) {
		if(lid.level==2) 
		{
		if(repository.existsById(bus.getBusId()))
		{
			throw new BusAlreadyExistsException("Bus Already exists");
		}
	
		 return repository.save(bus);
		
	}
		else {
			throw new NotAuthorizedException("You must login as an administrator ");
		}
		}
		else {
			throw new LoginException("You need to login!");
		}
	}	

	@Override
	public List<Bus> viewAllBus() {
	List<Bus> list=repository.findAll();

		return list;
	}

	@Override
	public Bus viewBus(int busid) throws BusNotFoundException {
	if(repository.existsById(busid))
	{
     return repository.viewbyId(busid);
	}
     else
 	{
 		throw new BusNotFoundException("Bus not found with"+ " "+busid);
 	}
	
	}


	@Override
	public Bus deletebus(int busid) throws BusNotFoundException, NotAuthorizedException, LoginException {
		//Bus bus=repository.getById(busid);
		// TODO Auto-generated method stub
		if(lid.level==1||lid.level==2) {
			if(lid.level==2) 
		{
		if(repository.existsById(busid))
		{
	     repository.deleteById(busid);
	     
		}
	     else
	 	{
	 		throw new BusNotFoundException("Bus not found with"+ " "+busid);
	 	}
		}
			else {
				throw new NotAuthorizedException("You must login as an administrator");
			}
			}
			else {
				throw new LoginException("You need to login!");
			}
		return null;
		
	}

	@Override
	public Bus updateBus(Bus bus) throws LoginException {
		// TODO Auto-generated method stub
		if(lid.level==1||lid.level==2) {
		return repository.save(bus);
		}
		else {
			throw new LoginException("You need to login!");
		}
		
	}

	@Override
	public List<Bus> viewBusByType(String busType) throws NotAuthorizedException, LoginException {
		if(lid.level==1||lid.level==2) {
			if(lid.level==2) 
			{
			return repository.viewBusByType(busType);
			
		}
			else {
				throw new NotAuthorizedException("You must login as an administrator");
			}
			}
			else {
				throw new LoginException("You need to login!");
			}
		
		
		
	}
}
