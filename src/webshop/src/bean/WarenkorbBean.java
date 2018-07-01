package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WarenkorbBean {

	private ArrayList<ArtikelBean> warenkorb;

	private double preis;
	private int anzahl;
	private double gesamtpreis;

	public WarenkorbBean(Double gesamtsumme, Integer anzahl, ArrayList<ArtikelBean> warenkorb) {
		super();
		this.gesamtpreis = gesamtsumme;
		this.anzahl = anzahl;
		this.warenkorb = warenkorb;
	}

	

	public ArrayList<ArtikelBean> getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(ArrayList<ArtikelBean> warenkorb) {
		this.warenkorb = warenkorb;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public double getGesamtpreis() {
		gesamtpreis = 0.0;
		for(ArtikelBean artikel : warenkorb) {
			gesamtpreis = gesamtpreis + artikel.getGesamtPreisProArtikel();
		}
		return gesamtpreis;
	}

	public void setGesamtpreis(double gesamtpreis) {

		this.gesamtpreis = gesamtpreis;
	}
	
	
	public WarenkorbBean() {
		warenkorb = new ArrayList<ArtikelBean>();
	}

}
