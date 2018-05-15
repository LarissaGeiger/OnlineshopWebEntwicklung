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

	@Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Aktualisierung der Daten in einer DB und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		KundeBean kunde = new KundeBean();
		kunde.setId(Integer.valueOf(request.getParameter("id")));
		kunde.setNachname(request.getParameter("nachname"));
		kunde.setVorname(request.getParameter("vorname"));
		kunde.setPasswort(request.getParameter("age"));
		
		// DB-Zugriff
		persist(kunde);
		
		// Scope "Request"
		request.setAttribute("myKunde", kunde);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("registrierung.jsp");
		dispatcher.forward(request, response);
	}

	private void persist(KundeBean k) throws ServletException {
		// DB-Zugriff
		try (Connection con = ds.getConnection();
		     PreparedStatement pstmt = con.prepareStatement("UPDATE kunden "
		     		                                      + "SET vorname = ?, nachname = ?, passwort = ? "
		     		                                      + "WHERE id = ?")) {
			
			pstmt.setString(1, k.getVorname());
			pstmt.setString(2, k.getNachname());
			pstmt.setString(3, k.getPasswort());
			pstmt.setInt(4, k.getId());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
