package de.sneakerLove.model.personen;

public class Bankverbindung {

	private String iban;
	private String bic;
	private String institut;

	public Bankverbindung(String iban, String bic, String institut) {
		this.iban = iban;
		this.bic = bic;
		this.institut = institut;
	}

	public String getIban() {
		return iban;
	}

	public String getBic() {
		return bic;
	}

	public String getInstitut() {
		return institut;
	}

}
