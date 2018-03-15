package de.sneakerLove.controller.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.sneakerLove.database.DatabaseConnection;
import de.sneakerLove.model.schuhe.Adidas;
import de.sneakerLove.model.schuhe.Asics;
import de.sneakerLove.model.schuhe.Nike;
import de.sneakerLove.model.schuhe.Schuh;
import de.sneakerLove.model.schuhe.Timberland;

public class SchuhUtil {
	private static final String SELECT_ALL = "SELECT * FROM ";
	private static final String MODELL = "modell";
	private static final String GROESSE = "groesse";
	private static final String ANZAHL = "anzahl";
	private static final String PREIS = "preis";

	public List<Schuh> getAlleSchuheVon(Marke marke) throws Exception {
		List<Schuh> schuhliste = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String modell = null;
		double groesse = 0.0;
		int anzahl = 0;
		double preis = 0.0;

		try {
			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// einen SQL Statement erstellen
			myStmt = myConn.createStatement();

			// Query ausführen
			myRs = myStmt.executeQuery(SELECT_ALL + marke.getMarke());

			// Gehe durch die Datenbank
			while (myRs.next()) {

				// dann die Daten von der Datenbank entnehmen
				modell = myRs.getString(MODELL);
				groesse = myRs.getDouble(GROESSE);
				anzahl = myRs.getInt(ANZAHL);
				preis = myRs.getDouble(PREIS);
			}

			switch (marke) {
			case ADIDAS:
				Adidas adidas = new Adidas(modell, groesse, anzahl, preis);
				schuhliste.add(adidas);
				break;
			case ASICS:
				Asics asics = new Asics(modell, groesse, anzahl, preis);
				schuhliste.add(asics);
				break;
			case NIKE:
				Nike nike = new Nike(modell, groesse, anzahl, preis);
				schuhliste.add(nike);
				break;
			case TIMBERLAND:
				Timberland timberland = new Timberland(modell, groesse, anzahl, preis);
				schuhliste.add(timberland);
				break;
			default:
				break;
			}

			// Schuh Array zurückgeben
			return schuhliste;

		} finally {

			// Alle erstellten JDBC objekte löschen (Methodenaufruf)
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) throws Exception {
		if (myConn != null) {
			myConn.close();
		}
		if (myStmt != null) {
			myStmt.close();
		}
		if (myRs != null) {
			myRs.close();
		}
	}

	public enum Marke {

		ADIDAS("Adidas"),
		ASICS("Asics"),
		NIKE("Nike"),
		TIMBERLAND("Timberland");

		String marke;

		Marke(String marke) {
			this.marke = marke;
		}

		public String getMarke() {
			return marke;
		}
	}

}
