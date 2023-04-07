package sprintdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sprintdemo.DAO.RouteDAO;
import sprintdemo.exception.LoginException;
import sprintdemo.exception.NoRouteIdFoundException;
import sprintdemo.exception.NotAuthorizedException;
import sprintdemo.exception.RouteAlreadyexistException;
import sprintdemo.model.Route;
//@EnableSwagger2
@RestController
@CrossOrigin
public class RouteController {
	@Autowired
	private RouteDAO dao; 

	
		
	@PostMapping(path="/addRoute")
	public Route addRoute(@Valid @RequestBody Route route)throws RouteAlreadyexistException, NotAuthorizedException, LoginException 
	{
		return dao.addRoute(route);
	}
	
	@PutMapping(path="/route/update")
	public Route updateRoute(@Valid @RequestBody Route route)throws RouteAlreadyexistException,NoRouteIdFoundException, NotAuthorizedException, LoginException {
		Route r=dao.updateRoute(route);
		return r;
	}
	
	@DeleteMapping(path="/route/delete/{routeId}")
	public Route deleteRoute(@PathVariable int routeId)  throws NoRouteIdFoundException, NotAuthorizedException, LoginException{
		return dao.deleteRoute(routeId);
	}
	
	@GetMapping(path="/viewRoute/{routeId}")
	public Route viewRoute(@PathVariable int routeId) throws NoRouteIdFoundException, NotAuthorizedException, LoginException {
		return dao.viewRoute(routeId);
	}
	
	@GetMapping(path="/route/all")
	public List<Route> viewAllRoute() throws NotAuthorizedException, LoginException{
		return dao.viewAllRoute();
	}
}
