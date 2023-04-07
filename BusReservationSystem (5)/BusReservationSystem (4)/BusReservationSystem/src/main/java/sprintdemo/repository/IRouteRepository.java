package sprintdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sprintdemo.exception.NoRouteIdFoundException;
import sprintdemo.model.Bus;
import sprintdemo.model.Route;

public interface IRouteRepository extends JpaRepository<Route, Integer>{
	
		
		
	@Query("Select r from Route r where routeId=?1")
	Route viewRoute(int routeId) throws NoRouteIdFoundException;
	
	

	
	@Query(value = "select count(route_id) from route where UPPER(route_from) = UPPER(?1) and UPPER(route_to) = UPPER(?2)", 
			nativeQuery = true)
	int findRouteFromandRouteTo(String routeFrom, String routeTo);
	

}
