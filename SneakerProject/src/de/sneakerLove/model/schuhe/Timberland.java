package de.sneakerLove.model.schuhe;

public class Timberland extends Schuh {

	private int timberlandId;

	public Timberland(String modell, double groesse, int anzahl, double preis) {
		super(modell, groesse, anzahl, preis);
	}

	public int getTimberlandId() {
		return timberlandId;
	}

}
