package de.sneakerLove.controller.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.sneakerLove.database.DatabaseConnection;
import de.sneakerLove.model.personen.Kunde;

public class KundenUtil {
	private static final String SELECT_ALL = "SELECT * FROM kunden ORDER BY kundeId ASC";

	public List<Kunde> getAlleKunden() throws Exception {

		List<Kunde> kundenliste = new ArrayList<>();

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

	public void kundeHinzufuegen(Kunde kunde) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// einen SQL Statement erstellen
			String sql = "INSERT INTO kunden (vorname, nachname, nutzername, passwort, email, alter) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// Die Parameter für den neuen Benutzer erstellen - SQL
			myStmt.setString(1, kunde.getVorname());
			myStmt.setString(2, kunde.getNachname());
			myStmt.setString(3, kunde.getNutzername());
			myStmt.setString(4, kunde.getPasswort());
			myStmt.setString(5, kunde.getEmail());
			myStmt.setInt(6, kunde.getAlter());

			// SQL Statement ausführen
			myStmt.execute();
// TODO
// // Adresse
// String sql2 = "INSERT INTO adressen " + "(idKunde, strasse, ort, plz) "
// + "VALUES (@idKunde:= LAST_INSERT_ID(), ?, ?, ?)";
//
// myStmt2 = myConn.prepareStatement(sql2);
//
// myStmt2.setString(1, kunde.getAdresse().getStrasse());
// myStmt2.setString(2, kunde.getAdresse().getOrt());
// myStmt2.setInt(3, kunde.getAdresse().getPlz());
//
// myStmt2.execute();
//
// // Zahlungsdaten
// String sql3 = "INSERT INTO zahlungsdaten (idKunde, bankinstitut, iban, bic) "
// + "VALUES (@idKunde, ?, ?, ?)";
//
// myStmt3 = myConn.prepareStatement(sql3);
//
// myStmt3.setString(1, kunde.getZahlungsdaten().getBankinstitut());
// myStmt3.setString(2, kunde.getZahlungsdaten().getIban());
// myStmt3.setString(3, kunde.getZahlungsdaten().getBic());
//
// myStmt3.execute();
//
// // Warenkorb
// String sql4 = "INSERT INTO warenkorb (idKunde) VALUES (@idKunde)";
//
// myStmt4 = myConn.prepareStatement(sql4);
// myStmt4.execute();

		} finally {

			// Alle erstellten JDBC objekte löschen
			close(myConn, myStmt, null);
// myStmt2.close();
// myStmt3.close();
// myStmt4.close();
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
