package de.sneakerLove.model.personen;

public abstract class Person {

	private String vorname;
	private String nachname;
	private String nutzername;
	private String passwort;

	public Person(String vorname, String nachname, String benutzername, String passwort) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.nutzername = benutzername;
		this.passwort = passwort;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getNutzername() {
		return nutzername;
	}

	public String getPasswort() {
		return passwort;
	}
}
