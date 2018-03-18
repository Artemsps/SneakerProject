package de.sneakerLove.model.schuhe;

public class Timberland extends Schuh {

	private String marke;
	private int timberlandId;

	public Timberland(String modell, double groesse, int anzahl, double preis) {
		super(modell, groesse, anzahl, preis);
		this.marke = "Timberland";
	}

	public int getTimberlandId() {
		return timberlandId;
	}

	public String getMarke() {
		return marke;
	}

	@Override
	public String toString() {
		return "Timberland [marke=" + marke + ", timberlandId=" + timberlandId + "]";
	}

}
