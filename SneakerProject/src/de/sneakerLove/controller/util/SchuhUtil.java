package de.sneakerLove.controller.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.sneakerLove.database.DatabaseConnection;
import de.sneakerLove.model.schuhe.Schuh;

public class SchuhUtil {
	private static final String SELECT_ALL = "SELECT * FROM schuh";
	private static final String MARKE = "marke";
	private static final String MODELL = "modell";
	private static final String GROESSE = "groesse";
	private static final String ANZAHL = "anzahl";
	private static final String PREIS = "preis";

	public List<Schuh> getAlleSchuhe() throws Exception {
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
			myRs = myStmt.executeQuery(SELECT_ALL);

			// Gehe durch die Datenbank
			while (myRs.next()) {

				// dann die Daten von der Datenbank entnehmen
				int schuhid = myRs.getInt("schuhid");
				String marke2 = myRs.getString(MARKE);
				String modell = myRs.getString(MODELL);
				double groesse = myRs.getDouble(GROESSE);
				int anzahl = myRs.getInt(ANZAHL);
				double preis = myRs.getDouble(PREIS);
				schuhgroesse.add(groesse);
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

	public void loescheArtikel(String id) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {

			int idArtikel = Integer.parseInt(id);
			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// SQL Statement fürs löschen erstellen
			String sql = "DELETE FROM schuh WHERE schuhid=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// Parameter setzen
			myStmt.setInt(1, idArtikel);

			// SQL Statement ausführen
			myStmt.execute();

		} finally {

			// Erstellte JDBC Objekte löschen
			close(myConn, myStmt, null);
		}
	}

	public Schuh getSchuh(String id) throws Exception {

		Schuh schuh = null;
		List<Double> schuhgroesse = new ArrayList<>();

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int schuhIdX;//

		try {
			// userId in einen Integer umwandeln
			schuhIdX = Integer.parseInt(id);

			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// SQL Statement für aussuchen ersetllen
			String sql = "SELECT * FROM schuh WHERE schuhid = ?";

			// Prepared Statement erstellen
			myStmt = myConn.prepareStatement(sql);

			// Parameter setzen
			myStmt.setInt(1, schuhIdX);//

			// SQL Statement ausführen
			myRs = myStmt.executeQuery();

			// Daten von der Datenbank entnehmen (rows)
			while (myRs.next()) {

				int schuhid = myRs.getInt("schuhid");
				String marke = myRs.getString("marke");
				String modell = myRs.getString("modell");
				double groesse = myRs.getDouble("groesse");
				int anzahl = myRs.getInt("anzahl");
				double preis = myRs.getDouble("preis");
				schuhgroesse.add(groesse);
				schuh = new Schuh(schuhid, marke, modell, schuhgroesse, anzahl, preis);

			}

			return schuh;

		} finally {
			// Erstellte JDBC Objekte löschen
			close(myConn, myStmt, myRs);
		}
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
