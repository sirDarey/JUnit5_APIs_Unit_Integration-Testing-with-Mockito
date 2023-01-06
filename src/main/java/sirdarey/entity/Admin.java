package sirdarey.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="admins")
@Table (name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="admins_id")
	private int admins_id;
	
	@Column (name="name")
	private String name; 
	
	@Column (name="email")
	private String email;
	
	@Column (name="pw")
	private String pw;
	
	@Column (name="role")
	private String role; 
	
	@Column (name="pp")
	private String pp; 
	
	@Column (name="regby")
	private String regby;
	
	public Admin () {}

	public Admin(String name, String email, String pw, String role, String pp, String regby) {
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.role = role;
		this.pp = pp;
		this.regby = regby;
	}

	public int getAdmins_id() {
		return admins_id;
	}

	public void setAdmins_id(int admins_id) {
		this.admins_id = admins_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}

	public String getRegby() {
		return regby;
	}

	public void setRegby(String regby) {
		this.regby = regby;
	}
	
}
