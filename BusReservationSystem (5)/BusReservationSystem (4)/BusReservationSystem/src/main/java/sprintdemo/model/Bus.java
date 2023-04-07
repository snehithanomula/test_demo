package sprintdemo.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Bus_table")
public class Bus {
	@Id
	@Column(unique = true)
	private int busId;
	
	@NotNull
	@Size(min=4,message="Bus name should be atleast 4 characters")
	@Column
	private String busName;
	
	@NotNull
	@Size(min=2,message="Driver name should be atleast 2 characters")
	@Column
	private String driverName;
	
	@Column
	@NotNull
	@Size(min=2,message="should be atleast 2 characters")
	private String busType;
	
	@Column
	@NotNull
	private String routeFrom;
	
	@Column
	@NotNull
	private String routeTo;
	
	//@Column
	//@NotNull
	//@NotEmpty
	private LocalTime arrivalTime;
	
	//@Column
	//@NotNull
	//@NotEmpty
	private LocalTime departureTime;
	
	@Column
	@NotNull
	private int seats;
	
	@Column
	@NotNull
	private int avaiableSeats;
	
	
	
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getAvaiableSeats() {
		return avaiableSeats;
	}

	public void setAvaiableSeats(int avaiableSeats) {
		this.avaiableSeats = avaiableSeats;
	}
	
	

	public Bus(int busId, @NotNull @Size(min = 4, message = "Bus name should be atleast 4 characters") String busName,
			@NotNull @Size(min = 2, message = "Driver name should be atleast 2 characters") String driverName,
			@NotNull @Size(min = 4, message = "should be atleast 4 characters") String busType,
			@NotNull String routeFrom, @NotNull String routeTo, LocalTime arrivalTime, LocalTime departureTime,
			@NotNull int seats, @NotNull int avaiableSeats) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.avaiableSeats = avaiableSeats;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", driverName=" + driverName + ", busType=" + busType
				+ ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", seats=" + seats + ", avaiableSeats=" + avaiableSeats + "]";
	}
	

}
