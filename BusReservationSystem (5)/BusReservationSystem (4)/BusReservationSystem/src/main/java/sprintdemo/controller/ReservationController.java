package sprintdemo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonFormat;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sprintdemo.DAO.ReservationDAO;
import sprintdemo.exception.LoginException;
import sprintdemo.exception.ReservationAlreadyExists;
import sprintdemo.exception.ReservationNotFound;
import sprintdemo.model.Reservation;
import sprintdemo.repository.IReservationRepository;
//@EnableSwagger2
@RestController
@CrossOrigin
public class ReservationController {
	@Autowired
	private ReservationDAO reservationdao;
	
	@PostMapping(path="/addReservation")
	public Reservation addReservation(@Valid @RequestBody Reservation reservation) throws ReservationAlreadyExists, LoginException {
		Reservation R1= reservationdao.addReservation(reservation);
		return R1;
		
	}
	//notworking
	@PutMapping(path="/updateReservation/{id}")
	public Optional<Reservation> updateReservation(@Valid @RequestBody Reservation reservation,@PathVariable int id) throws ReservationNotFound, LoginException{
		
		Optional<Reservation> R1=reservationdao.updateReservation(reservation,id);
		return R1;
		
		
	}
	
	@DeleteMapping("/removeReservation/{id}")
	public void removeReservation(@PathVariable int id) throws ReservationNotFound, LoginException{
		 reservationdao.deleteReservation(id);
		
		
	}
	
	@GetMapping("/viewReservation/{id}")
	public Optional<Reservation> viewReservation(@PathVariable int id) throws ReservationNotFound, LoginException{ 
		Optional<Reservation> R1= reservationdao.viewReservation(id);
		return R1;
	}
	
	@GetMapping("/viewAllReservation")
	public List<Reservation> viewAllReservation() throws LoginException{
		List<Reservation> L1= reservationdao.viewAllReservation();
		return L1;
	}
	
	@GetMapping("/viewAllReservationByDate/{date}")
	
	public List<Reservation> viewAllReservationByDate(@PathVariable String date) throws LoginException{ 
		LocalDate D1= LocalDate.parse(date);
		List<Reservation> L1= reservationdao.getAllReservation(D1);
		return L1;
	}
	

}
