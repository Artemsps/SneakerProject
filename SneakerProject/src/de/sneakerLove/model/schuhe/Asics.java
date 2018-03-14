package de.sneakerLove.model.schuhe;

public class Asics extends Schuh {

	private int asicsId;

	public Asics(String modell, double groesse, int anzahl, double preis) {
		super(modell, groesse, anzahl, preis);
	}

	public int getAsicsId() {
		return asicsId;
	}
}
