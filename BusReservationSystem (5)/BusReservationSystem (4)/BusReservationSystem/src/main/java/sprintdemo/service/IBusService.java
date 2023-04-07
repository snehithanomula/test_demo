package sprintdemo.service;

import java.util.List;

import sprintdemo.exception.BusAlreadyExistsException;
import sprintdemo.exception.BusNotFoundException;
import sprintdemo.exception.LoginException;
import sprintdemo.exception.NotAuthorizedException;
import sprintdemo.model.Bus;

public interface IBusService {
	 Bus addBus(Bus bus) throws BusAlreadyExistsException, NotAuthorizedException, LoginException;
	  List<Bus> viewAllBus();
	  Bus	viewBus(int busid) throws BusNotFoundException;
	  Bus deletebus(int busid) throws BusNotFoundException, NotAuthorizedException, LoginException;
	  Bus updateBus(Bus bus) throws LoginException;
	  List<Bus> viewBusByType(String busType) throws NotAuthorizedException, LoginException;

}
