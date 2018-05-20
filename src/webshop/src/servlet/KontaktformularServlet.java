
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Servlet implementation class kontaktformularservlet
// */
//@WebServlet("/kontaktformularservlet")
//public class kontaktformularservlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	//Datum aus dem Internet
//	public kontaktformularservlet() {
//		super();
//	}
//	// Datum aus dem Internet
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// HTTP-Header setzen
//		response.setStatus(HttpServletResponse.SC_OK);	// nicht zwingend erforderlich; ist der default-Wert
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		
//		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
//		// Alternative: GlassFish dazu bewegen, die Formulardaten gleich
//		// als UTF-8 zu interpretieren. Dazu muss GlassFish auf UTF-8 umge-
//		// stellt werden. Eine neue Zeile in die Datei glassfish-web.xml
//		// ergänzen (zu finden im WEB-INF-Ordner des Projektes):
//		// <parameter-encoding default-charset="UTF-8" />
//		
//		final PrintWriter out = response.getWriter();
//		
//		// Datum aus dem Internet
//		Date dNow = new Date( );
//		SimpleDateFormat ft = 
//				new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss E  ");
//		// Datum aus dem Internet 
//		
//		
//		String geschlecht = request.getParameter("geschlecht");
//		String email = request.getParameter("email");
//		String vorname = request.getParameter("vorname");
//		String nachname = request.getParameter("nachname");
//		String usereingabe = request.getParameter("usereingabe");
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<h3>Empfangene Formulardaten</h3>");
//		out.println("Geschlecht: " + geschlecht + "<br>");
//		out.println("E-Mail: " + email + "<br>");
//		out.println("Vorname: " + vorname + "<br>");
//		out.println("Nachname: " + nachname + "<br>");
//		out.println("Nachricht: " + usereingabe + "<br>");
//		out.println("Uhrzeit: " + ft.format(dNow) + "<br>"); // Datum ausgabe
//		
//		out.println("</body>");
//		out.println("</html>");
//	}
//	
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}

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

import bean.KontaktBean;

/**
 * Servlet implementation class ProduktformcServlet
 */
@WebServlet("/KontaktformularServlet")
public class KontaktformularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	private void persist(KontaktBean b) throws ServletException {
		String[] generatedKeys = new String[] {"id"};
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO  kontakt (vorname, nachname, email, usereingabe) VALUES (?, ?, ?, ?)", generatedKeys)) {
			pstmt.setString(1, b.getVorname());
			pstmt.setString(2, b.getNachname());
			pstmt.setString(3, b.getEmail());
			pstmt.setString(4, b.getUsereingabe());
			pstmt.executeUpdate();
			try(ResultSet rs = pstmt.getGeneratedKeys()){
				while (rs.next()) {
					b.setId(rs.getInt(1));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		KontaktBean kontakt = new KontaktBean();
		kontakt.setGeschlecht(request.getParameter("geschlecht"));
		kontakt.setVorname(request.getParameter("vorname"));
		kontakt.setNachname(request.getParameter("nachname"));
		kontakt.setEmail(request.getParameter("email"));
		kontakt.setUsereingabe(request.getParameter("usereingabe"));
		persist(kontakt);

		// Scope "Request"
		request.setAttribute("myKontakt", kontakt);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/kontaktformular.jsp");
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

}
