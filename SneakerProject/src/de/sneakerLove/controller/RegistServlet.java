package de.sneakerLove.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.sneakerLove.model.personen.Kunde;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		if (checkPasswort(passwort, confirm)) {
			Kunde kunde = new Kunde(vorname, nachname, email, nutzername, passwort);
		}
	}

	private boolean checkPasswort(String passwort, String confirm) {
		return passwort.equals(confirm) ? true : false;
	}
}
