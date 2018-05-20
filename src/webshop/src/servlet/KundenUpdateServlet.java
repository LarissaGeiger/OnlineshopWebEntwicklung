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
		// Servlet zur Entgegennahme von Formularinhalten, Aktualisierung der Daten in
		// einer DB und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
		KundeBean kunde = new KundeBean();
		kunde.setId(Integer.valueOf(request.getParameter("id")));
		kunde.setNachname(request.getParameter("nachname"));
		kunde.setVorname(request.getParameter("vorname"));
		kunde.setPasswort(request.getParameter("passwort"));
		kunde.setEmail(request.getParameter("email"));
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
		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/kundeUpdate.jsp");
		dispatcher.forward(request, response);
	}

	private void persist(KundeBean k) throws ServletException {
		// DB-Zugriff
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("UPDATE customer "
						+ "SET vorname = ?, nachname = ?, passwort = ?, straﬂe = ?, hausnr = ?, plz = ?, ort = ?, telefonnr = ?, gebdatum = ?, email=? "
						+ "WHERE id = ?")) {

			pstmt.setString(1, k.getVorname());
			pstmt.setString(2, k.getNachname());
			pstmt.setString(3, k.getPasswort());
			pstmt.setString(4, k.getStraﬂe());
			pstmt.setInt(5, k.getHausnr());
			pstmt.setInt(6, k.getPlz());
			pstmt.setString(7, k.getOrt());
			pstmt.setString(8, k.getTelefonnr());
			pstmt.setString(9, k.getGebdatum());
			pstmt.setString(10, k.getEmail());
			pstmt.setInt(11, k.getId());
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
