package de.sneakerLove.model.schuhe;

public enum Groesse {

	GROESSE_37(37.00),
	GROESSE_37_5(37.50),
	GROESSE_38(38.00),
	GROESSE_38_5(38.50),
	GROESSE_39(39.00),
	GROESSE_39_5(39.50),
	GROESSE_40(40.00),
	GROESSE_40_5(40.50),
	GROESSE_41(41.00),
	GROESSE_41_5(41.50),
	GROESSE_42(42.00),
	GROESSE_42_5(42.50),
	GROESSE_43(43.00),
	GROESSE_43_5(43.50),
	GROESSE_44(44.00),
	GROESSE_44_5(44.50),
	GROESSE_45(45.00),
	GROESSE_45_5(45.50),
	GROESSE_46(46.00);

	double groesse;

	Groesse(double groesse) {
		this.groesse = groesse;
	}

	public double getGroesse() {
		return groesse;
	}
}
