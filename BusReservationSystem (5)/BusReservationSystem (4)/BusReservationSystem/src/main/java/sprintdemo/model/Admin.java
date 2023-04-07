package sprintdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Admin {
    @Id
	@Column
	private int adminId;

	@NotNull(message="Admin UserName Should not be null")
	private String adminUsername;

	@NotNull(message="Admin Password should not be null")
	@NotEmpty(message="Password should not be empty")
	@Size(min=3,max=30,message="Password has min 3 and max 9 characters")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$")
	private String adminPassword;

	
	public Admin() {
	super();
	// TODO Auto-generated constructor stub
	}
	public int getAdminId() {
	return adminId;
	}
	public void setAdminId(int adminId) {
	this.adminId = adminId;
	}
	public String getAdminUsername() {
	return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
	this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
	return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
	this.adminPassword = adminPassword;
	}
	public Admin(int adminId, @NotNull(message = "Admin UserName Should not be null") String adminUsername,
			@NotNull(message = "Admin Password should not be null") @NotEmpty(message = "Password should not be empty") @Size(min = 3, max = 30, message = "Password has min 3 and max 9 characters") @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$") String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	
	
}
