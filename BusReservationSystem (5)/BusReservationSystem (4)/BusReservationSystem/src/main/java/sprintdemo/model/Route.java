package sprintdemo.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int routeId;
	
	@NotNull
	@Size(min=2, message="Route From Should have Atleast 2 or more characters")
	@Pattern(regexp = "[a-zA-Z \\s]+", message = " ! Error in ROUTE FROM  contains numbers or Special Characters")
	@Column
	private String routeFrom;
	
	@NotNull
	@Size(min=2, message="Route to Should have Atleast 2 or more characters")
	@Pattern(regexp = "[a-zA-Z \\s]+", message = " ! Error in ROUTE TO contains numbers or Special Characters")
	@Column
	private String routeTo;
	
	@NotNull
	@Min(value=01, message="Given value is invalid, DISTANCE should greater than one")
	
	@Column
	private int distance;
	
	@OneToMany(targetEntity = Bus.class,cascade = CascadeType.ALL)
	private List<Bus> bus;


	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
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
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}

	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Route(int routeId,
			@NotNull @Size(min = 2, message = "Route From Should have Atleast 2 or more characters") @Pattern(regexp = "[a-zA-Z \\s]+", message = " ! Error in ROUTE FROM  contains numbers or Special Characters") String routeFrom,
			@NotNull @Size(min = 2, message = "Route to Should have Atleast 2 or more characters") @Pattern(regexp = "[a-zA-Z \\s]+", message = " ! Error in ROUTE TO contains numbers or Special Characters") String routeTo,
			@NotNull @Min(value = 1, message = "Error in DISTANCE  values should be possitive") int distance,
			List<Bus> bus) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.distance = distance;
		this.bus = bus;
	}
	
	
}
