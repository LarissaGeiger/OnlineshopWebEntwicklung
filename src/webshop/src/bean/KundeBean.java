package bean;

import java.io.Serializable;

public class KundeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String vorname;
	private String nachname;
	private String email;
	private String gebdatum; // String??
	private String passwort;
	private Integer id;
	private String telefonnr;
	public String getTelefonnr() {
		return telefonnr;
	}

	public void setTelefonnr(String telefonnr) {
		this.telefonnr = telefonnr;
	}

	private String straﬂe;
	private Integer hausnr;
	private Integer plz;
	private String ort;
	private boolean admin;

	public Integer getHausnr() {
		return hausnr;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setHausnr(Integer hausnr) {
		this.hausnr = hausnr;
	}

	public Integer getPlz() {
		return plz;
	}

	public void setPlz(Integer plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

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

	public String getGebdatum() {
		return gebdatum;
	}

	public void setGebdatum(String gebdatum) {
		this.gebdatum = gebdatum;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getStraﬂe() {
		return straﬂe;
	}

	public void setStraﬂe(String straﬂe) {
		this.straﬂe = straﬂe;
	}

}
