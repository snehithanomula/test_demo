package sprintdemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import sprintdemo.exception.LoginException;
import sprintdemo.exception.NoRouteIdFoundException;
import sprintdemo.exception.NotAuthorizedException;
import sprintdemo.exception.RouteAlreadyexistException;
import sprintdemo.model.Bus;
import sprintdemo.model.Route;
import sprintdemo.repository.IBusRepository;
import sprintdemo.repository.IRouteRepository;
import sprintdemo.service.IRouteService;

@Service
public class RouteDAO implements IRouteService {
	@Autowired
	private IRouteRepository repository;
	
	@Autowired
	private IBusRepository repository2;
	@Autowired
	UserDAO loginCheck;
	
	@Override
	public Route addRoute(Route route) throws RouteAlreadyexistException, NotAuthorizedException, LoginException 
	{
		if(loginCheck.level==1||loginCheck.level==2) {
			if(loginCheck.level==2) 
			{
		String uRouteFrom=route.getRouteFrom();
		String uRouteTo=route.getRouteTo();
		
		int checkRoute=0;
		checkRoute=findRouteFromandRouteTo(uRouteFrom, uRouteTo);
		
		if(checkRoute==0) 
		{
			List<Bus> lbus=  route.getBus();
			lbus=repository2.findByrouteFromAndrouteTo(uRouteFrom, uRouteTo);
			route.setBus(lbus);
			//route.setBus(route.getBus());
			return repository.save(route);
			
		}
		else 
		{
			throw new RouteAlreadyexistException("Route already Exist");
		}
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
	public Route updateRoute(Route route) throws RouteAlreadyexistException,NoRouteIdFoundException,NotAuthorizedException, LoginException  {
		if(loginCheck.level==1||loginCheck.level==2) {
			if(loginCheck.level==2) 
			{
		String uRouteFrom=route.getRouteFrom();
		String uRouteTo=route.getRouteTo();
		int checkRoute=0;
		 checkRoute=findRouteFromandRouteTo(uRouteFrom, uRouteTo);
		
		if(checkRoute==0) 
		{
			if(repository.existsById(route.getRouteId())) 
			{
				List<Bus> lbus=  route.getBus();
				lbus=repository2.findByrouteFromAndrouteTo(uRouteFrom, uRouteTo);
				route.setBus(lbus);
				return repository.save(route);
			}
			else 
			{
				throw new NoRouteIdFoundException("Invalid RouteId");
			}
		}
		else 
		{
			throw new RouteAlreadyexistException("Route(from and To) already Exist");
		}
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
	public Route deleteRoute(int routeId)  throws NoRouteIdFoundException,NotAuthorizedException, LoginException{
		if(loginCheck.level==1||loginCheck.level==2) {
			if(loginCheck.level==2) 
			{
		if (repository.existsById(routeId)) 
		{
			repository.deleteById(routeId);
		}
		else 
		{
			throw new NoRouteIdFoundException("Invalid RouteId");
		}
		return null;
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
	public Route viewRoute(int routeId) throws NoRouteIdFoundException,NotAuthorizedException, LoginException
	{
		if(loginCheck.level==1||loginCheck.level==2) {
			if(loginCheck.level==2) 
			{
		if(repository.existsById(routeId)) 
		{
			return repository.viewRoute(routeId);
		}
		else 
		{
			throw new NoRouteIdFoundException("Invalid RouteId");
		}
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
	public List<Route> viewAllRoute() throws NotAuthorizedException, LoginException
	{
		if(loginCheck.level==1||loginCheck.level==2) {
			if(loginCheck.level==2) 
			{
		return repository.findAll();
	
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
	public int findRouteFromandRouteTo(String routeFrom, String routeTo) throws NotAuthorizedException, LoginException
	{
		if(loginCheck.level==1||loginCheck.level==2) {
			if(loginCheck.level==2) 
			{
	
		return repository.findRouteFromandRouteTo(routeFrom, routeTo);
	}
		
		else {
			throw new NotAuthorizedException("You must login as an administrator ");
		}
	}
		
		else {
			throw new LoginException("You need to login!");
		}
			
		}
	

	
	

}
	

