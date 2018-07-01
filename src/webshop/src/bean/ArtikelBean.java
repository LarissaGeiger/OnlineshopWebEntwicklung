package bean;

public class ArtikelBean {

	private ProduktBean produkt;
	private int anzahl;
	private double gesamtPreisProArtikel;

	public double getGesamtPreisProArtikel() {
		this.gesamtPreisProArtikel = getAnzahl() * produkt.getPreis();
		return this.gesamtPreisProArtikel;
	}

	public void setGesamtPreisProArtikel(int gesamtPreisProArtikel) {
		this.gesamtPreisProArtikel = produkt.getPreis() * getAnzahl();
	}

	public ArtikelBean(ProduktBean produkt) {
		this.produkt = produkt;
	}

	public ProduktBean getProdukt() {
		return produkt;
	}

	public void setProdukt(ProduktBean produkt) {
		this.produkt = produkt;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

}
