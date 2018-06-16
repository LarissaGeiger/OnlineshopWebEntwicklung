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

import bean.KundeBean;

/**
 * Servlet implementation class kundeUpdateServlet
 */
@WebServlet("/KundenUpdateServlet")
public class KundenUpdateServlet extends HttpServlet {
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
		KundeBean kunde = new KundeBean();
		kunde.setId(Integer.valueOf(request.getParameter("id")));
		kunde.setGebdatum(request.getParameter("geburtsdatum"));
		kunde.setHausnr(Integer.valueOf(request.getParameter("hausnummer")));
		kunde.setOrt(request.getParameter("ort"));
		kunde.setPlz(Integer.valueOf(request.getParameter("postleitzahl")));
		kunde.setStraﬂe(request.getParameter("straﬂe"));
		kunde.setTelefonnr(request.getParameter("telefonnummer"));

		// DB-Zugriff
		persist(kunde);

		// Scope "Request"
		request.setAttribute("myKunde", kunde);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/admin/adminKunden.html");
		dispatcher.forward(request, response);
	}

	private void persist(KundeBean k) throws ServletException {
		// DB-Zugriff
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("UPDATE customer "
						+ "SET  straﬂe = ?, hausnr = ?, plz = ?, ort = ?, telefonnr = ?, gebdatum = ? "
						+ "WHERE id = ?")) {

			pstmt.setString(1, k.getStraﬂe());
			pstmt.setInt(2, k.getHausnr());
			pstmt.setInt(3, k.getPlz());
			pstmt.setString(4, k.getOrt());
			pstmt.setString(5, k.getTelefonnr());
			pstmt.setString(6, k.getGebdatum());

			pstmt.setInt(7, k.getId());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
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

}
