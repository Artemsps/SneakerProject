package de.sneakerLove.model.personen;

public class Adresse {

	private String strasse;
	private int hausnummer;
	private int plz;
	private String stadt;
	private String land;

	public Adresse(String strasse, int hausnummer, int plz, String stadt, String land) {
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.stadt = stadt;
		this.land = land;
	}

	public String getStrasse() {
		return strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public int getPlz() {
		return plz;
	}

	public String getStadt() {
		return stadt;
	}

	public String getLand() {
		return land;
	}

}
