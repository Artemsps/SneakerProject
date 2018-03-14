package de.sneakerLove.controller.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.sneakerLove.database.DatabaseConnection;
import de.sneakerLove.model.schuhe.Nike;
import de.sneakerLove.model.schuhe.Schuh;

public class NikeUtil {
	private static final String SELECT_ALL_NIKE = "SELECT * FROM kunden ORDER BY kundeId ASC";

	public List<Schuh> getAlleNike() throws Exception {

		List<Schuh> nikeListe = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// einen SQL Statement erstellen
			myStmt = myConn.createStatement();

			// Query ausführen
			myRs = myStmt.executeQuery(SELECT_ALL_NIKE);

			// Gehe durch die Datenbank
			while (myRs.next()) {

				// dann die Daten von der Datenbank entnehmen
				String modell = myRs.getString("modell");
				int anzahl = myRs.getInt("anzahl");
				double groesse = myRs.getDouble("groesse");
				double preis = myRs.getDouble("preis");

				// Einen neuen Benutzer erstellen mit den Parametern (Daten)
				Nike nike = new Nike(modell, groesse, anzahl, preis);

				// Benutzer dem Array hinzufügen
				nikeListe.add(nike);
			}

			// Benutzer Array zurückgeben
			return nikeListe;

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
