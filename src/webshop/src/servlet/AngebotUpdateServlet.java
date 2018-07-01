package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

		if (check(kategorieName, produkt.getArtikelnr())) {
			update(produkt, kategorieName);

			request.setAttribute("angebot", produkt);

			final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/updateAdmin.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("angebot", produkt.getArtikelnr());
			final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/fehlerAdmin.jsp");
			dispatcher.forward(request, response);
		}

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

	private void update(ProduktBean p, String name) throws ServletException {

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

	private boolean check(String name, Integer nr) throws ServletException {

		ProduktBean p = new ProduktBean();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT artikelnr FROM " + name + " WHERE artikelnr = ?")) {
			pstmt.setInt(1, nr);

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					p.setArtikelnr(Integer.valueOf(rs.getInt("artikelnr")));

				}
			}

		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		if (p.getArtikelnr() == nr) {
			return true;
		} else {
			return false;
		}
	}
}
