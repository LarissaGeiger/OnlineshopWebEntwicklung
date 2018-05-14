package bean;

import java.io.Serializable;
import java.sql.Date;

public class kundeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	String firstname;
	String lastname;
	String email;
	String gebdate; // String??
	String password;
	Integer id;
	String telefonnr;
	String straﬂe;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGebdate() {
		return gebdate;
	}
	public void setGebdate(String gebdate) {
		this.gebdate = gebdate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTelefonnr() {
		return telefonnr;
	}
	public void setTelefonnr(String telefonnr) {
		this.telefonnr = telefonnr;
	}
	public String getStraﬂe() {
		return straﬂe;
	}
	public void setStraﬂe(String straﬂe) {
		this.straﬂe = straﬂe;
	}

	
}
