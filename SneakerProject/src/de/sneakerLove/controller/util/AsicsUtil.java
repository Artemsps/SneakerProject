package de.sneakerLove.controller.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.sneakerLove.database.DatabaseConnection;
import de.sneakerLove.model.schuhe.Asics;
import de.sneakerLove.model.schuhe.Schuh;

public class AsicsUtil {
	private static final String SELECT_ALL_ASICS = "SELECT * FROM kunden ORDER BY kundeId ASC";

	public List<Schuh> getAlleAsics() throws Exception {

		List<Schuh> asicsListe = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// einen SQL Statement erstellen
			myStmt = myConn.createStatement();

			// Query ausführen
			myRs = myStmt.executeQuery(SELECT_ALL_ASICS);

			// Gehe durch die Datenbank
			while (myRs.next()) {

				// dann die Daten von der Datenbank entnehmen
				String modell = myRs.getString("modell");
				int anzahl = myRs.getInt("anzahl");
				double groesse = myRs.getDouble("groesse");
				double preis = myRs.getDouble("preis");

				// Einen neuen Benutzer erstellen mit den Parametern (Daten)
				Asics asics = new Asics(modell, groesse, anzahl, preis);

				// Benutzer dem Array hinzufügen
				asicsListe.add(asics);
			}

			// Benutzer Array zurückgeben
			return asicsListe;

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
