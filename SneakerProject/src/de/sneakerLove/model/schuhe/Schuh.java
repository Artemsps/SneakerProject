package de.sneakerLove.model.schuhe;

import java.util.List;

public class Schuh {

	private int schuhId;
	private String marke;
	private String modell;
	private List<Double> groesse;
	private int anzahl;
	private double preis;

	public Schuh(int schuhId, String marke, String modell, List<Double> groesse, int anzahl, double preis) {
		this.schuhId = schuhId;
		this.marke = marke;
		this.modell = modell;
		this.anzahl = anzahl;
		this.groesse = groesse;
		this.preis = preis;
	}

	public int getSchuhId() {
		return schuhId;
	}

	public String getMarke() {
		return marke;
	}

	public String getModell() {
		return modell;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public List<Double> getGroesse() {
		return groesse;
	}

	public double getPreis() {
		return preis;
	}

	@Override
	public String toString() {
		return "Schuh [modell=" + modell + ", groesse=" + groesse + ", anzahl=" + anzahl + ", preis=" + preis + "]";
	}

// public static void main(String[] args) {
//
// List<Groesse> groessse = new ArrayList<>();
// groessse.add(Groesse.GROESSE_40);
// groessse.add(Groesse.GROESSE_40);
// groessse.add(Groesse.GROESSE_40);
// groessse.add(Groesse.GROESSE_40);
// groessse.add(Groesse.GROESSE_40);
// groessse.add(Groesse.GROESSE_40);
// groessse.add(Groesse.GROESSE_40);
// groessse.add(Groesse.GROESSE_40);
// System.out.println("Anzahl " + Groesse.GROESSE_40 + " = " + groessse.size());
// System.out.println();
// groessse.forEach(items -> System.out.println(items));
// }

}
