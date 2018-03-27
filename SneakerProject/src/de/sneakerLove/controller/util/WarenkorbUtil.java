package de.sneakerLove.controller.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.sneakerLove.database.DatabaseConnection;
import de.sneakerLove.model.personen.Warenkorb;
import de.sneakerLove.model.schuhe.Schuh;

public class WarenkorbUtil {

	public Warenkorb getWarenkorb(String id) throws Exception {

		Warenkorb warenkorb = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int kundeId;//

		try {
			// userId in einen Integer umwandeln
			kundeId = Integer.parseInt(id);

			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// SQL Statement für aussuchen ersetllen
			String sql = "SELECT * FROM warenkorb WHERE kundeid = ?";

			// Prepared Statement erstellen
			myStmt = myConn.prepareStatement(sql);

			// Parameter setzen
			myStmt.setInt(1, kundeId);//

			// SQL Statement ausführen
			myRs = myStmt.executeQuery();

			// Daten von der Datenbank entnehmen (rows)
			while (myRs.next()) {

				int idWarenkorb = myRs.getInt("warenkorbid");
				int idKunde = myRs.getInt("kundeid");

				// Person wird erstellt
				warenkorb = new Warenkorb(idWarenkorb, idKunde);
			}

			return warenkorb;

		} finally {
			// Erstellte JDBC Objekte löschen
			close(myConn, myStmt, myRs);
		}
	}

	public void artikelWarenkorbHinzufuegen(Schuh schuh, Warenkorb warenkorb) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// einen SQL Statement erstellen
			String sql = "INSERT INTO warenkorb_hat_artikel (schuhid, warenkorbid) VALUES (?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// Die Parameter für den neuen Benutzer erstellen - SQL
			myStmt.setInt(1, schuh.getSchuhid());
			myStmt.setInt(2, warenkorb.getWarenkorbId());

			// SQL Statement ausführen
			myStmt.execute();

		} finally {

			// Alle erstellten JDBC objekte löschen
			close(myConn, myStmt, null);
		}
	}

	public List<Schuh> getArtikelImWarenkorb(String id) throws Exception {

		List<Schuh> warenkorb = new ArrayList<>();
		List<Double> schuhgroesse = new ArrayList<>();

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int idWarenkorb;//

		try {
			// userId in einen Integer umwandeln
			idWarenkorb = Integer.parseInt(id);

			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// SQL Statement für aussuchen ersetllen
			String sql = "SELECT * FROM warenkorb_hat_artikel NATURAL JOIN schuh WHERE warenkorbid = ?";

			// Prepared Statement erstellen
			myStmt = myConn.prepareStatement(sql);

			// Parameter setzen
			myStmt.setInt(1, idWarenkorb);//

			// SQL Statement ausführen
			myRs = myStmt.executeQuery();

			// Daten von der Datenbank entnehmen (rows)
			while (myRs.next()) {

				// dann die Daten von der Datenbank entnehmen
				int schuhId = myRs.getInt("schuhid");
				String marke = myRs.getString("marke");
				String modell = myRs.getString("modell");
				double groesse = myRs.getDouble("groesse");
				int anzahl = myRs.getInt("anzahl");
				double preis = myRs.getDouble("preis");

				// Einen neuen Artikel erstellen mit den Parametern (Daten)

				schuhgroesse.add(groesse);
				Schuh schuh = new Schuh(schuhId, marke, modell, schuhgroesse, anzahl, preis);

				// Artikel dem Array hinzufügen
				warenkorb.add(schuh);
			}

			return warenkorb;

		} finally {
			// Erstellte JDBC Objekte löschen
			close(myConn, myStmt, myRs);
		}
	}

	public void loescheArtikelAusWarenkorb(String schuhid, String warenkorbId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		int idschuh = Integer.parseInt(schuhid);
		int idwarenkorb = Integer.parseInt(warenkorbId);

		try {

			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// SQL Statement fürs löschen erstellen
			String sql = "DELETE FROM warenkorb_hat_artikel WHERE schuhid=? AND warenkorbid=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// Parameter setzen
			myStmt.setInt(1, idschuh);
			myStmt.setInt(2, idwarenkorb);

			// SQL Statement ausführen
			myStmt.execute();

		} finally {

			// Erstellte JDBC Objekte löschen
			close(myConn, myStmt, null);
		}

	}

	public double getSumme(String idWarenkorb) throws Exception {

		double summe = 0;
		List<Schuh> warenkorbliste = getArtikelImWarenkorb(idWarenkorb);

		for (int i = 0; i < warenkorbliste.size(); i++) {
			summe += warenkorbliste.get(i).getPreis();
		}

		return summe;
	}

	// Hauptmethode zum schliessen aller JDBC Objekte
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {

			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) { // wird nicht richtig geschlossen..., sondern
				myConn.close(); // geht nur wieder in den "connection pool"
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
