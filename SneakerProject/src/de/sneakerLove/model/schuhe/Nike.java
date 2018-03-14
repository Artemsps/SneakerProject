package de.sneakerLove.model.schuhe;

public class Nike extends Schuh {

	private int nikeId;

	public Nike(String modell, double groesse, int anzahl, double preis) {
		super(modell, groesse, anzahl, preis);
	}

	public int getNikeId() {
		return nikeId;
	}

}
