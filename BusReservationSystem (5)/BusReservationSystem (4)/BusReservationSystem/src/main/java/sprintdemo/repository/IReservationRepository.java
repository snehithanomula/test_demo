package sprintdemo.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sprintdemo.model.Bus;
import sprintdemo.model.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation,Integer> {
	
	//@Query("select r from Reservation where r.reservationDate =:p1 ")
	//public List<Reservation> viewAllReservationByDate(@Param("p1") LocalDate d1);
	
	@Query(
			  value = "SELECT * FROM Reservation_Info  WHERE reservation_date = ?1 ", 
			  nativeQuery = true)
	          public List<Reservation> viewAllReservationByDate(LocalDate d1);
	
	
	@Modifying
	@Transactional
	@Query(" update Reservation r set r.source = :source, r.destination = :destination, r.reservationTime = :time, r.reservationDate = :date, r.bus = :bus where r.reservationId = :id")
	int updatereservation(@Param("source") String source,@Param("destination") String destination,@Param("time") LocalTime time, @Param("date") LocalDate date, @Param("bus") Bus bus, @Param("id") int id );
	
	/*@Query(
			value = "SELECT * FROM bus_table WHERE route_to = ?1 and route_from = ?2 and departure_time = ?3",
			nativeQuery = true )
	        List<Bus> getBusForReservation(String destination,String source,LocalTime T1);*/
	
	//@Query("select b from Bus where b.routeTo = :P1 and b.routeFrom = :P2 and b.departureTime = :P3")
	//List<Bus> getBusForReservation(@Param("P1")String destination,@Param("P2")String source,@Param("P3")LocalTime T1);
			 
}

/*@Modifying
@Query("update Flight f set f.flightPrice = :price where f.flightSource = :source and f.flightDest=:dest")
int updateFlightPriceBySourceandDestination(@Param("price") double price,@Param("source") String source, 
  @Param("dest") String destination);
	 * 
	 * 
	 *
*/