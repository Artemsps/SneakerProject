package de.sneakerLove.model.personen;

public class Kunde extends Person {

	private int kundenId;
	private int alter;
	private Adresse adresse;
	private Bankverbindung bankverbindung;

	public Kunde(String vorname, String nachname, String benutzername, String passwort) {
		super(vorname, nachname, benutzername, passwort);
	}

	public Kunde(String vorname, String nachname, String benutzername, String passwort, int alter, Adresse adresse,
			Bankverbindung bankverbindung) {
		super(vorname, nachname, benutzername, passwort);
		this.alter = alter;
		this.adresse = adresse;
		this.bankverbindung = bankverbindung;
	}

	public int getKundenId() {
		return kundenId;
	}

	public int getAlter() {
		return alter;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public Bankverbindung getBankverbindung() {
		return bankverbindung;
	}

}
