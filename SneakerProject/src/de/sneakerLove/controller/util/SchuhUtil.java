package de.sneakerLove.controller.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.sneakerLove.database.DatabaseConnection;
import de.sneakerLove.model.schuhe.Marke;
import de.sneakerLove.model.schuhe.Schuh;

public class SchuhUtil {
	private static final String SELECT_ALL = "SELECT * FROM ";
	private static final String MARKE = "marke";
	private static final String MODELL = "modell";
	private static final String GROESSE = "groesse";
	private static final String ANZAHL = "anzahl";
	private static final String PREIS = "preis";

	public List<Schuh> getAlleSchuhe(Marke marke) throws Exception {
		List<Schuh> schuhliste = new ArrayList<>();
		List<Double> schuhgroesse = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

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
				int schuhid = myRs.getInt("schuhid");
				String marke2 = myRs.getString(MARKE);
				String modell = myRs.getString(MODELL);
				double groesse = myRs.getDouble(GROESSE);
				int anzahl = myRs.getInt(ANZAHL);
				double preis = myRs.getDouble(PREIS);

				Schuh schuh = new Schuh(schuhid, marke2, modell, schuhgroesse, anzahl, preis);
				schuhliste.add(schuh);

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
}
