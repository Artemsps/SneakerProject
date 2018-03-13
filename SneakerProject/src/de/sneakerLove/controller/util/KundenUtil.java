package de.sneakerLove.controller.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import de.sneakerLove.database.DatabaseConnection;
import de.sneakerLove.model.personen.Kunde;

public class KundenUtil {
	private static final String SELECT_ALL = "SELECT * FROM kunden ORDER BY kundeId ASC";

	public Set<Kunde> getAlleKunden() throws Exception {

		Set<Kunde> kundenliste = new HashSet<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// einen SQL Statement erstellen
// String sql = "SELECT * FROM kunden NATURAL JOIN adressen NATURAL JOIN
// zahlungsdaten ORDER BY kundeId";
			myStmt = myConn.createStatement();

			// Query ausführen
			myRs = myStmt.executeQuery(SELECT_ALL);

			// Gehe durch die Datenbank
			while (myRs.next()) {

				// dann die Daten von der Datenbank entnehmen
// int kundeId = myRs.getInt("kundeId");
				String vorname = myRs.getString("vorname");
				String nachname = myRs.getString("nachname");
				String nutzername = myRs.getString("nutzername");
				String passwort = myRs.getString("passwort");
				String email = myRs.getString("email");
				int alter = myRs.getInt("alter");

// String strasse = myRs.getString("strasse");
// String ort = myRs.getString("ort");
// int plz = myRs.getInt("plz");

// Adresse adresse = new Adresse(strasse, ort, plz);
//
// String bankinstitut = myRs.getString("bankinstitut");
// String iban = myRs.getString("iban");
// String bic = myRs.getString("bic");
//
// Zahlungsdaten zahlungsdaten = new Zahlungsdaten(bankinstitut, iban, bic);

				// Einen neuen Benutzer erstellen mit den Parametern (Daten)
				Kunde kunde = new Kunde(vorname, nachname, nutzername, passwort, email, alter);

				// Benutzer dem Array hinzufügen
				kundenliste.add(kunde);
			}

			// Benutzer Array zurückgeben
			return kundenliste;

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
