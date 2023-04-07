package sprintdemo.service;

import java.util.List;


import sprintdemo.exception.LoginException;
import sprintdemo.exception.NoRouteIdFoundException;
import sprintdemo.exception.NotAuthorizedException;
import sprintdemo.exception.RouteAlreadyexistException;
import sprintdemo.model.Route;

public interface IRouteService {
	Route addRoute(Route route)throws RouteAlreadyexistException, NotAuthorizedException, LoginException;
	Route updateRoute(Route route)throws RouteAlreadyexistException, NoRouteIdFoundException, NotAuthorizedException, LoginException;
	Route deleteRoute(int routeId) throws NoRouteIdFoundException, NotAuthorizedException, LoginException;
	Route viewRoute(int routeId) throws NoRouteIdFoundException, NotAuthorizedException, LoginException;
	List<Route> viewAllRoute() throws NotAuthorizedException, LoginException;
	
	//exception
	int findRouteFromandRouteTo(String routeFrom, String routeTo) throws NotAuthorizedException, LoginException;
}
