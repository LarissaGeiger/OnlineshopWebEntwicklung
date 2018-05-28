package bean;

import java.io.Serializable;

public class AngeboteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String kategorieName;
	private Integer artikelnr;


	

	private String name;
	private boolean angebot;
	private Integer bildID;




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBildID() {
		return bildID;
	}

	public void setBildID(Integer bildID) {
		this.bildID = bildID;
	}

	public String getKategorieName() {
		return kategorieName;
	}

	public void setKategorieName(String kategorieName) {
		this.kategorieName = kategorieName;
	}

	

	public boolean isAngebot() {
		return angebot;
	}

	public void setAngebot(boolean angebot) {
		this.angebot = angebot;
	}
	public Integer getArtikelnr() {
		return artikelnr;
	}

	public void setArtikelnr(Integer artikelnr) {
		this.artikelnr = artikelnr;
	}
}
