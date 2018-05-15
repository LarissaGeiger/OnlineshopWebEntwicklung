package bean;

import java.io.Serializable;

public class KontaktBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String vorname;
	private String nachname;
	private String email;
	private String usereingabe;
	private String geschlecht;
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsereingabe() {
		return usereingabe;
	}
	public void setUsereingabe(String usereingabe) {
		this.usereingabe = usereingabe;
	}
	public String getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	
	
	
	
	
}
