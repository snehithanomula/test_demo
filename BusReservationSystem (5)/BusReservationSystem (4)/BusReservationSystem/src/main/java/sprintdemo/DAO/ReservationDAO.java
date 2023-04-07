package sprintdemo.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprintdemo.exception.LoginException;
import sprintdemo.exception.ReservationAlreadyExists;
import sprintdemo.exception.ReservationNotFound;
import sprintdemo.model.Bus;
import sprintdemo.model.Reservation;
import sprintdemo.repository.IBusRepository;
import sprintdemo.repository.IReservationRepository;
import sprintdemo.service.IReservationService;

@Service
public class ReservationDAO implements IReservationService {
	@Autowired
	private IReservationRepository reservationRepo;
	
	@Autowired
	private IBusRepository busRepo;
	@Autowired
	BusDAO busdao;
	@Autowired
	UserDAO lid;

	@Override
	public Reservation addReservation(Reservation reservation) throws ReservationAlreadyExists, LoginException {
		if(lid.level==1||lid.level==2) {
		//Reservation R1= new Reservation();
	    int id = reservation.getReservationId();
		if(!reservationRepo.existsById(id)){
		reservationRepo.save(reservation);
		System.out.println("hello");
		List<Bus> L1 = busRepo.getBusForReservation(reservation.getDestination(), reservation.getSource(),reservation.getReservationTime(),reservation.getReservationType());
		System.out.println(L1);

		Bus bus= reservation.getBus();
		//System.out.println(bus);
		bus=busRepo.getById(reservation.getBus().getBusId());
		//System.out.println(bus);
		if(bus.getAvaiableSeats()>0)
		    reservation.setBus(bus);
		int availableSeats = bus.getAvaiableSeats();
		bus.setAvaiableSeats(availableSeats-1);
		//System.out.println(bus);
		busdao.updateBus(bus);

		}
		else{
			throw new ReservationAlreadyExists("This reservation already exists. Add new one.");
		}
		return reservation;
		}
		else {
			throw new LoginException("You need to login!");
		
	}
	}

	@Override
	public Optional<Reservation> updateReservation( Reservation reservation,int id) throws ReservationNotFound, LoginException {
		if(lid.level==1||lid.level==2) {
		if(reservationRepo.existsById(id)){
			List<Bus> L1 = busRepo.getBusForReservation(reservation.getDestination(), reservation.getSource(),reservation.getReservationTime(),reservation.getReservationType());
			System.out.println(L1);
			Scanner s= new Scanner(System.in);
			System.out.println("enter updated bus id");
			int a= s.nextInt();
			Bus bus= reservation.getBus();
			bus= busRepo.getById(a);
			if(bus.getAvaiableSeats()>0)
			   reservation.setBus(bus);
	        int b =reservationRepo.updatereservation(reservation.getSource(),reservation.getDestination(),reservation.getReservationTime(),reservation.getReservationDate(),reservation.getBus(), id);
		if(b==1){
		   System.out.println(a);
		   int availableSeats = bus.getAvaiableSeats();
			bus.setAvaiableSeats(availableSeats-1);
			busdao.updateBus(bus);
		}
		
		return viewReservation(id);
		}
		else{
			throw new  ReservationNotFound("Can't update! No reservation found for given id");
		}
		}
		else {
			throw new LoginException("You need to login!");
		
	}
		
	}

	@Override
	public void deleteReservation(int reservationId) throws ReservationNotFound, LoginException {
		if(lid.level==1||lid.level==2) {
		if(reservationRepo.existsById(reservationId)){
			reservationRepo.deleteById(reservationId);
		}
		else{
			throw new  ReservationNotFound("No reservation found for given id");
		}
	}
	else {
		throw new LoginException("You need to login!");
}
		
	}

	@Override
	public Optional<Reservation> viewReservation(int reservationId) throws ReservationNotFound, LoginException{
		if(lid.level==1||lid.level==2) {
		Optional <Reservation> R1 = null;
		if(reservationRepo.existsById(reservationId)){
			R1=reservationRepo.findById(reservationId);
		}
		else{
			throw new  ReservationNotFound("Sorry! No reservation found for given id");
		}
		return R1;
		}
		else {
			throw new LoginException("You need to login!");
	}
	}

	@Override
	public List<Reservation> viewAllReservation() throws LoginException {
		if(lid.level==1||lid.level==2) {
		List<Reservation> L1=reservationRepo.findAll();
		return L1;
		}
		else {
			throw new LoginException("You need to login!");
	}
	}

	@Override
	public List<Reservation> getAllReservation(LocalDate date) throws LoginException {
		if(lid.level==1||lid.level==2) {
		List<Reservation> L1= reservationRepo.viewAllReservationByDate(date);
		return L1;
		}
		else {
			throw new LoginException("You need to login!");
	}
	}

	

}
