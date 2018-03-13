package de.sneakerLove.model.schuhe;

public abstract class Schuh {

	private int schuhId;
	private String modell;
	private int anzahl;
	private double groesse;

	public Schuh(int schuhId, String modell, int anzahl, double groesse) {
		this.schuhId = schuhId;
		this.modell = modell;
		this.anzahl = anzahl;
		this.groesse = groesse;
	}

	public int getSchuhId() {
		return schuhId;
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

}
