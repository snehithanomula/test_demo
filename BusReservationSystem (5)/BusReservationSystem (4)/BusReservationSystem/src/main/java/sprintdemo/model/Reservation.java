package sprintdemo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;


import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="Reservation_Info")
public class Reservation {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int reservationId;
	
	@NotNull(message = "should not be empty")
	@Column
	private String reservationStatus;
	
	@NotNull(message = "should not be empty")
	@Column
	private String reservationType;
	
	@NotNull(message = "should not be empty")
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate reservationDate;
	
	@NotNull(message = "should not be empty")
	@Column
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime reservationTime;
	
	@NotNull(message = "should not be empty")
	@Size(min = 3, message = "Source should have atleast 3 characters")
	@Column
	private String source;
	
	@NotNull(message = "should not be empty")
	@Size(min = 3, message = "destination should have atleast 3 characters")
	@Column
	private String destination;
	
	@OneToOne(targetEntity=Bus.class, cascade = CascadeType.ALL)
	private Bus bus;
	
	
    public Bus getBus() {
		return bus;
	}
	@Autowired
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public String getReservationType() {
		return reservationType;
	}
	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	public LocalTime getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Reservation(int reservationId, String reservationStatus, String reservationType, LocalDate reservationDate,
			LocalTime reservationTime, String source, String destination, Bus bus) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
