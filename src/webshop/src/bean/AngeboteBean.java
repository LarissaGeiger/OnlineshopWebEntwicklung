package bean;

import java.io.Serializable;

public class AngeboteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titel;


	private Integer produktID;


	private String name;
	private boolean angebot;
	private Integer bildID;
	private String pageName;
	private Integer kategorieID;


	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Integer getKategorieID() {
		return kategorieID;
	}

	public void setKategorieID(Integer kategorieID) {
		this.kategorieID = kategorieID;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

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


	

	public Integer getProduktID() {
		return produktID;
	}

	public void setProduktID(Integer produktID) {
		this.produktID = produktID;
	}

	public boolean isAngebot() {
		return angebot;
	}

	public void setAngebot(boolean angebot) {
		this.angebot = angebot;
	}

}