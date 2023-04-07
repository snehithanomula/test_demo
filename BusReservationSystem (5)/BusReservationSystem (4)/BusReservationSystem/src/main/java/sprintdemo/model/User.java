package sprintdemo.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;


@Entity
@Table(name="UserTable")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int userLoginId;
	
	@NotNull(message="User Name should not be null")
	@NotEmpty(message="User name should not be empty")
	@Size(min=3,max=30,message="Username has min 3 and max 30 characters")
	
	private String userName;
	
	@NotNull(message="Password should not be null")
	@NotEmpty(message="Password should not be empty")
	@Size(min=3,max=30,message="Password has min 3 and max 9 characters")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$")
	private String password;
	
	@NotNull(message="First Name should not be null")
	@NotEmpty(message="First name should not be empty")
	@Size(min=3,max=30,message="First has min 3 and max 30 characters")
	
	private String firstName;
	
	@NotNull(message="Last Name should not be null")
	@NotEmpty(message="Last name should not be empty")
	@Size(min=3,max=30,message="Last has min 3 and max 30 characters")
	
	private String lastName;
	
	@NotNull(message="Contact should not be null")
	
	@Min(value= 10, message = "Contact must have 10 digits")
	private long contact;
	
	@NotNull(message="Email should not be null")
	@Email
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Reservation reservation;
	
	
	public int getUserLoginId() {
		return userLoginId;
	}
	
	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userLoginId,
			@NotNull(message = "User Name should not be null") @NotEmpty(message = "User name should not be empty") @Size(min = 3, max = 30, message = "Username has min 3 and max 30 characters") String userName,
			@NotNull(message = "Password should not be null") @NotEmpty(message = "Password should not be empty") @Size(min = 3, max = 30, message = "Password has min 3 and max 9 characters") @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$") String password,
			@NotNull(message = "First Name should not be null") @NotEmpty(message = "First name should not be empty") @Size(min = 3, max = 30, message = "First has min 3 and max 30 characters") String firstName,
			@NotNull(message = "Last Name should not be null") @NotEmpty(message = "Last name should not be empty") @Size(min = 3, max = 30, message = "Last has min 3 and max 30 characters") String lastName,
			@NotNull(message = "Contact should not be null") @Min(value = 10, message = "Contact must have 10 digits") long contact,
			@NotNull(message = "Email should not be null") @Email String email, Reservation reservation) {
		super();
		this.userLoginId = userLoginId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.reservation = reservation;
	}
	
	
	

}
