package de.sneakerLove.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.sneakerLove.controller.util.SchuhUtil;
import de.sneakerLove.controller.util.SchuhUtil.Marke;
import de.sneakerLove.model.schuhe.Schuh;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final SchuhUtil schuhUtil = new SchuhUtil();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Schuh> schuhliste = schuhUtil.getAlleSchuheVon(Marke.TIMBERLAND);
			request.setAttribute("SCHUHLISTE", schuhliste);
			request.getRequestDispatcher("test.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
