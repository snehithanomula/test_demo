package sprintdemo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="FeedBack")
public class Feedback {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedBackId;
	
	@NotNull
    @Min(value=1, message="Rating values should be positive")
	@Max(value=10, message="Rating maximum limit")
	@Column
	private int driverRating;
	
	@NotNull
	@Min(value=1, message="Rating values should be positive")
	@Max(value=10, message="Rating maximum limit")
	@Column
	private int serviceRating;
	
      @NotNull
	@Min(value=10, message="Rating maximum limit")
	@Max(value=10, message="Rating maximum limit")
	@Column
	private int overallRating;
	
	@NotNull
	@Size(min=2, message= "comment should have atleast 2 characters")
	@Pattern(regexp="[a-zA-Z\\s]+", message= "comments should not be empty")
	@Column
	private String comments;
	
	
	
	
	private LocalDate feedbackdate;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userLoginId")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="busId")
	private Bus bus;

	

	 
	
	public  int getFeedBackId() {
		return feedBackId;
	}
	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}
	public int getDriverRating() {
		return driverRating;
	}
	public void setDriverRating(int driverRating) {
		this.driverRating = driverRating;
	}
	public int getServiceRating() {
		return serviceRating;
	}
	public void setServiceRating(int serviceRating) {
		this.serviceRating = serviceRating;
	}
	public int getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
	this.comments = comments;
	}
	public LocalDate getFeedbackdate() {
		return feedbackdate;
	}
	public void setFeedbackdate(LocalDate string) {
		this.feedbackdate = string;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(int feedBackId,
			@NotNull @Min(value = 1, message = "Rating values should be positive") @Max(value = 10, message = "Rating maximum limit") int driverRating,
			@NotNull @Min(value = 1, message = "Rating values should be positive") @Max(value = 10, message = "Rating maximum limit") int serviceRating,
			@NotNull @Min(value = 10, message = "Rating maximum limit") @Max(value = 10, message = "Rating maximum limit") int overallRating,
			@NotNull @Size(min = 2, message = "comment should have atleast 2 characters") @Pattern(regexp = "[a-zA-Z\\s]+", message = "comments should not be empty") String comments,
			LocalDate feedbackdate, User user, Bus bus) {
		super();
		this.feedBackId = feedBackId;
		this.driverRating = driverRating;
		this.serviceRating = serviceRating;
		this.overallRating = overallRating;
		this.comments = comments;
		this.feedbackdate = feedbackdate;
		this.user = user;
		this.bus = bus;
	}
	
	
	

}
