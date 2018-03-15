package de.sneakerLove.model.schuhe;

public abstract class Schuh {

	private String modell;
	private double groesse;
	private int anzahl;
	private double preis;

	public Schuh(String modell, double groesse, int anzahl, double preis) {
		this.modell = modell;
		this.anzahl = anzahl;
		this.groesse = groesse;
		this.preis = preis;
	}

	public String getModell() {
		return modell;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public double getGroesse() {
		return groesse;
	}

	public double getPreis() {
		return preis;
	}
}
