package de.sneakerLove.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.sneakerLove.controller.util.KundenUtil;
import de.sneakerLove.model.personen.Kunde;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final KundenUtil kundenUtil = new KundenUtil();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Set<Kunde> kundenliste = kundenUtil.getAlleKunden();
			request.setAttribute("KUNDENLISTE", kundenliste);
			request.getRequestDispatcher("test.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
