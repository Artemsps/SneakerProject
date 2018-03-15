package de.sneakerLove.model.schuhe;

public class Adidas extends Schuh {

	private int adidasId;

	public Adidas(String modell, double groesse, int anzahl, double preis) {
		super(modell, groesse, anzahl, preis);
	}

	public int getAdidasId() {
		return adidasId;
	}
}
