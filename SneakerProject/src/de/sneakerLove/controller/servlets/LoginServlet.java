package de.sneakerLove.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.sneakerLove.controller.Authentifizierung;
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

		Authentifizierung authentifizierung = new Authentifizierung();
		Kunde kunde = authentifizierung.authentifizierung(mail, pw);

		// Session wird erstellt von LOGIN_KUNDE - DARF NICHT FALSE SEIN!!!
		HttpSession session = request.getSession();

		session.removeAttribute("LOGIN_REGISTER");
		session.setAttribute("LOGIN_KUNDE", kunde);
		session.setAttribute("ABMELDEN", "Abmelden");
		request.getRequestDispatcher("/profil.jsp").forward(request, response);
		System.out.println(kunde.getNutzername() + " hat sich eingeloggt");

	}

}
