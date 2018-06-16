package bean;

public class ProduktBean {
	// müssen bei jedem Produkt dabei sein (NOT NULL)
	private int artikelnr; // primaryKey
	private String name;
	private double preis;
	private String farbe;
	private String marke;

	// sollen automatisch gesetzt werden (NOT NULL)
	private int bildID;
	private int kategorieID;
	private boolean angebot;

	// können bei einem Produkt dabei sein (NULL)
	private String modell;
	private int sensorauflösung;
	private double displaygröße;
	private int arbeitsspeicher;
	private double bildschirmdiagonale;
	private String displaytech;
	private String betriebssystem;
	private int speicherplatz;

	public String getBetriebssystem() {
		return betriebssystem;
	}

	public void setBetriebssystem(String betriebssystem) {
		this.betriebssystem = betriebssystem;
	}

	public int getSpeicherplatz() {
		return speicherplatz;
	}

	public void setSpeicherplatz(int speicherplatz) {
		this.speicherplatz = speicherplatz;
	}

	public int getArbeitsspeicher() {
		return arbeitsspeicher;
	}

	public void setArbeitsspeicher(int arbeitsspeicher) {
		this.arbeitsspeicher = arbeitsspeicher;
	}

	public int getSensorauflösung() {
		return sensorauflösung;
	}

	public void setSensorauflösung(int sensorauflösung) {
		this.sensorauflösung = sensorauflösung;
	}

	public boolean isAngebot() {
		return angebot;
	}

	public void setAngebot(boolean angebot) {
		this.angebot = angebot;
	}

	public int getArtikelnr() {
		return artikelnr;
	}

	public void setArtikelnr(int artikelnr) {
		this.artikelnr = artikelnr;
	}

	public int getBildID() {
		return bildID;
	}

	public void setBildID(int bildID) {
		this.bildID = bildID;
	}

	public String getDisplaytech() {
		return displaytech;
	}

	public void setDisplaytech(String displaytech) {
		this.displaytech = displaytech;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getKategorieID() {
		return kategorieID;
	}

	public void setKategorieID(int kategorieID) {
		this.kategorieID = kategorieID;
	}

	public double getBildschirmdiagonale() {
		return bildschirmdiagonale;
	}

	public void setBildschirmdiagonale(double bildschirmdiagonale) {
		this.bildschirmdiagonale = bildschirmdiagonale;
	}

	public double getDisplaygröße() {
		return displaygröße;
	}

	public void setDisplaygröße(double displaygröße) {
		this.displaygröße = displaygröße;
	}

}
