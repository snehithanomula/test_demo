package sprintdemo.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sprintdemo.model.Bus;

public interface IBusRepository extends JpaRepository<Bus, Integer>{
	@Query("SELECT b FROM Bus b WHERE b.busType= ?1")
	List<Bus> viewBusByType(String busType);

	@Query("SELECT i FROM Bus i WHERE i.busId= ?1")
    Bus viewbyId(int busId);
	
	//query for bus reservation
	@Query(
			value = "SELECT * FROM bus_table WHERE UPPER(route_to) = UPPER(?1) and UPPER(route_from) = UPPER(?2) and departure_time = ?3 and bus_type = ?4",
			nativeQuery = true )


	        List<Bus> getBusForReservation(String destination,String source,LocalTime T1,String type);
	
	//query for adding route
	
	@Query(value="SELECT * FROM bus_table WHERE UPPER(route_from) = UPPER(?1) and UPPER(route_to) = UPPER(?2) ",
			nativeQuery = true)

			List<Bus> findByrouteFromAndrouteTo(String routeFrom, String routeTo);

}
