package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.AngeboteBean;

/**
 * Servlet implementation class AngebotUpdateServlet
 */
@WebServlet("/AngebotUpdateServlet")
public class AngebotUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AngebotUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AngeboteBean angebot = new AngeboteBean();
		angebot.setProduktID(Integer.valueOf(request.getParameter("id")));
		angebot.setKategorieName(request.getParameter("kategorieName"));
		angebot.setAngebot(Boolean.valueOf(request.getParameter("angebot")));

		// DB-Zugriff
		persist(angebot);

		// Scope "Request"
		request.setAttribute("angebot", angebot);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("angebote.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void persist(AngeboteBean a) throws ServletException {

		try (
//Datenbankabfrage fehlt
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("UPDATE x "
						+ "SET  angebot = ? "
						+ "WHERE id = ?")) {

			pstmt.setBoolean(1, a.isAngebot());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
}
