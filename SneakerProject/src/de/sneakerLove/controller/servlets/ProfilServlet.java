package de.sneakerLove.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfilServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Hole die Session, aber erstelle keine neue
		HttpSession session = request.getSession(false);

		// Überprüfung ob Kund eingeloggt ist
		if (session.getAttribute("LOGIN_KUNDE") == null || session.getAttribute("LOGIN_KUNDE") == "") {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/profil.jsp").forward(request, response);
		}
	}
}
