package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import bean.SmartphonesBean;

/**
 * Servlet implementation class Demo08aServlet
 */
@WebServlet("/smartphonesServlet")
public class smartphonesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Lesen der Daten in einer DB
		// und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		Long id = Long.valueOf(request.getParameter("id"));

		// DB-Zugriff
		SmartphonesBean s = read(id);

		// Scope "Request"
		request.setAttribute("smart", s);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("smartphones.jsp");
		dispatcher.forward(request, response);
	}

	private SmartphonesBean read(Long id) throws ServletException {
		SmartphonesBean s = new SmartphonesBean();
		s.setId(id);

		// DB-Zugriff
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM smartphones WHERE id = ?")) {

			pstmt.setLong(1, id);
			;
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {
					s.setBez("bez");
					s.setFarbe("farbe");
					s.setMarke("marke");
					s.setPreis(Integer.valueOf("preis"));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return s;
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
