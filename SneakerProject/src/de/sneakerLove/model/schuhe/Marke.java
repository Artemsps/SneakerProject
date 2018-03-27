package de.sneakerLove.model.schuhe;

public enum Marke {

	ADIDAS("Adidas"),
	ASICS("Asics"),
	NIKE("Nike"),
	TIMBERLAND("Timberland"),
	NEW_BALANCE("New Balance");

	String marke;

	Marke(String marke) {
		this.marke = marke;
	}

	public String getMarke() {
		return marke;
	}

}
