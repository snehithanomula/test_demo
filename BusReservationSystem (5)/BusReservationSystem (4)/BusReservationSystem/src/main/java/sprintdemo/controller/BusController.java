package sprintdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sprintdemo.DAO.BusDAO;
import sprintdemo.exception.BusAlreadyExistsException;
import sprintdemo.exception.BusNotFoundException;
import sprintdemo.exception.LoginException;
import sprintdemo.exception.NotAuthorizedException;
import sprintdemo.model.Bus;
//@EnableSwagger2
@RestController
@CrossOrigin
public class BusController {
	@Autowired
	private BusDAO dao;
	@GetMapping(path="/Bus")
	public List<Bus> getBus()
	{
		return dao.viewAllBus();
	}
	@PostMapping(path="/addBus")
	public Bus createBus(@Valid @RequestBody Bus bus) throws BusAlreadyExistsException, NotAuthorizedException, LoginException
	{
		
		
		return dao.addBus(bus);
		
	}
	@GetMapping(path="/viewBus/{busid}")
	public Bus getBusById(@PathVariable int busid) throws BusNotFoundException
	{
		
 return dao.viewBus(busid);
 //System.out.println(Bus.getBusId() + " "+Bus.getBusType() + " "+Bus.getBusName());
 
	}
	
	@PutMapping(path="/bus/update/{busid}")
	public ResponseEntity<Bus> saveOrUpdate(@Valid @RequestBody Bus newbus, @PathVariable int busid) throws LoginException
	{
		
	Bus b=	dao.updateBus(newbus);
	return new ResponseEntity<Bus>(b, HttpStatus.OK);
	}
	
	@DeleteMapping(path="bus/delete/{busid}") 
	public Bus deleteBus(@PathVariable int busid) throws BusNotFoundException, NotAuthorizedException, LoginException
	{
		return  dao.deletebus(busid);
		 
	}
	@GetMapping(path = "/bustype/{busType}")
	public List<Bus> viewBusByType(@PathVariable String busType) throws NotAuthorizedException, LoginException
	{
		return dao.viewBusByType(busType);
	}

}
