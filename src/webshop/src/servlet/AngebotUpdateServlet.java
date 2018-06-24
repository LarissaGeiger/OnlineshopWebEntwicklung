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

import bean.ProduktBean;

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

		String kategorieName = request.getParameter("kategorieName");

		ProduktBean produkt = new ProduktBean();
		produkt.setArtikelnr(Integer.valueOf(request.getParameter("artikelnr")));
		produkt.setAngebot(Boolean.valueOf(request.getParameter("angebot")));

		persist(produkt, kategorieName);

		request.setAttribute("angebot", produkt);

		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/admin/adminAngebot.html");
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

	private void persist(ProduktBean p, String name) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("UPDATE " + name + " SET angebot = ? WHERE artikelnr = ?")) {

			pstmt.setBoolean(1, p.isAngebot());
			pstmt.setInt(2, p.getArtikelnr());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
}
