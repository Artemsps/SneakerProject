package de.sneakerLove.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.sneakerLove.controller.util.KundenUtil;
import de.sneakerLove.model.personen.Kunde;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ERRORTEXT = "Bitte geben Sie ein Passwort ein und bestätigen sie dieses.";
	private final KundenUtil kundenUtil = new KundenUtil();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String email = request.getParameter("email");
		String nutzername = request.getParameter("nutzername");
		String passwort = request.getParameter("passwort");
		String confirm = request.getParameter("confirm");
		String alter = request.getParameter("alter");
		Integer alter2 = Integer.parseInt(alter);

		try {
			if (checkPasswort(passwort, confirm)) {
				Kunde kunde = new Kunde(vorname, nachname, nutzername, passwort, email, alter2);

				kundenUtil.kundeHinzufuegen(kunde);
				request.setAttribute("LOGIN_KUNDE", kunde);
				request.getRequestDispatcher("profil.jsp").forward(request, response);
			} else {
				System.out.println("Passwort leer oder stimmt nicht überein.");
				request.setAttribute("ERRORTEXT", ERRORTEXT);
				request.getRequestDispatcher("registrieren.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean checkPasswort(String passwort, String confirm) {
		return passwort.equals(confirm) && !passwort.isEmpty() ? true : false;
	}
}
