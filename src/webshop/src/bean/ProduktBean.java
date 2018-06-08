package bean;

public class ProduktBean {
	//müssen bei jedem Produkt dabei sein (NOT NULL)
	private int artikelnr; //primaryKey
	private String name;
	private double preis;
	private String farbe;
	private String marke;
	
	//sollen automatisch gesetzt werden (NOT NULL)
	private int bildID;
	private int kategorieID;
	private boolean angebot;

	//können bei einem Produkt dabei sein (NULL)
	private String modell;
	private double bildschirmdiagonale;
	private String displaytech;
	private int gewicht;
	private String betriebssystem;
	private int speicherplatz;
	private int baujahr;
	private int arbeitsspeicher;
	private int sensorauflösung;
	private int leistung;
	private double länge;
	private double breite;
	private String besonderheit;
	private int modelljahr;
	private double höhe;
	private double displaygröße;

	

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

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

	public int getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
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

	public int getLeistung() {
		return leistung;
	}

	public void setLeistung(int leistung) {
		this.leistung = leistung;
	}




	public String getBesonderheit() {
		return besonderheit;
	}

	public void setBesonderheit(String besonderheit) {
		this.besonderheit = besonderheit;
	}

	public int getModelljahr() {
		return modelljahr;
	}

	public void setModelljahr(int modelljahr) {
		this.modelljahr = modelljahr;
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

	public double getLänge() {
		return länge;
	}

	public void setLänge(double länge) {
		this.länge = länge;
	}

	public double getBreite() {
		return breite;
	}

	public void setBreite(double breite) {
		this.breite = breite;
	}

	public double getHöhe() {
		return höhe;
	}

	public void setHöhe(double höhe) {
		this.höhe = höhe;
	}

	public double getDisplaygröße() {
		return displaygröße;
	}

	public void setDisplaygröße(double displaygröße) {
		this.displaygröße = displaygröße;
	}



}
