package sprintdemo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import sprintdemo.exception.LoginException;
import sprintdemo.exception.ReservationAlreadyExists;
import sprintdemo.exception.ReservationNotFound;
import sprintdemo.model.Reservation;

public interface IReservationService {
Reservation addReservation(Reservation reservation) throws ReservationAlreadyExists, LoginException;
	
	void deleteReservation(int reservationId)throws ReservationNotFound, LoginException;
	Optional<Reservation> viewReservation(int reservationId) throws ReservationNotFound, LoginException;
	List<Reservation> viewAllReservation() throws LoginException;
	List<Reservation> getAllReservation(LocalDate date) throws LoginException;
	Optional<Reservation> updateReservation(Reservation reservation,int id)throws ReservationNotFound, LoginException ;
	
	

}
