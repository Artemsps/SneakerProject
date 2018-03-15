package de.sneakerLove.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.sneakerLove.database.DatabaseConnection;
import de.sneakerLove.model.personen.Kunde;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Abmelden
		// alle Session werden geholt und komplett geschlossen
		HttpSession session = request.getSession();
		session.invalidate();

		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Parameter aus der Form holen
		String mail = request.getParameter("email");
		String pw = request.getParameter("passwort");

		Kunde kunde = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {

			// Datenbankverbindung aufbauen
			myConn = DatabaseConnection.getConnection();

			// SQL Statement für aussuchen ersetllen
			String sql = "SELECT * FROM kunden WHERE email=? AND passwort=?";

			// Prepared Statement erstellen
			myStmt = myConn.prepareStatement(sql);

			// Parameter setzen
			myStmt.setString(1, mail);
			myStmt.setString(2, pw);

			// SQL Statement ausführen
			myRs = myStmt.executeQuery();

			// Daten von der Datenbank entnehmen (rows)
			if (myRs.next()) {

				String vorname = myRs.getString("vorname");
				String nachname = myRs.getString("nachname");
				String nutzername = myRs.getString("nutzername");
				String passwort = myRs.getString("passwort");
				String email = myRs.getString("email");
				int alter = myRs.getInt("alter");

				if (nutzername.contains("admin")) {

					// Adminbereich
					request.getRequestDispatcher("/AdminServlet").forward(request, response);

				} else {

					// Kunde wird mit den Parametern erstellt
					kunde = new Kunde(vorname, nachname, nutzername, passwort, email, alter);

					// Session wird erstellt von LOGIN_KUNDE - DARF NICHT FALSE SEIN!!!
					HttpSession session = request.getSession();

					session.removeAttribute("LOGIN_REGISTER");
					session.setAttribute("LOGIN_KUNDE", kunde);
					session.setAttribute("ABMELDEN", "Abmelden");
					request.getRequestDispatcher("/profil.jsp").forward(request, response);
					System.out.println(nutzername + " hat sich eingeloggt");
				}

			} else {
				// Fehlermeldung ausgeben
				request.setAttribute("FEHLER", "Benutzername und Passwort stimmen nicht überein!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();

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
