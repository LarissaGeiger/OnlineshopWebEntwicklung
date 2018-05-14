package servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.kategorieBean;

public class kategorieServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;


	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten und Generierung eines Beans
		// zur Weitergabe
		// der Formulardaten an eine JSP

		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten
												// Alternative: GlassFish dazu bewegen, die Formulardaten gleich
												// als UTF-8 zu interpretieren. Dazu muss GlassFish auf UTF-8 umge-
												// stellt werden. Eine neue Zeile in die Datei glassfish-web.xml
												// ergänzen (zu finden im WEB-INF-Ordner des Projektes):
												// <parameter-encoding default-charset="UTF-8" />
		
		kategorieBean kategorie = new kategorieBean();
		kategorie.setKategorieName(request.getParameter("kategorieName"));
		
		
	
		persist(kategorie);
		
		// Scope "Request"
		request.setAttribute("kategorie", kategorie);
		
		// Weiterleiten an JSP
				final RequestDispatcher dispatcher = request.getRequestDispatcher("html/registrierung.jsp");
				dispatcher.forward(request, response);

}

	private void persist(kategorieBean kategorie) throws ServletException {
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO kategorie (kategorieName) VALUES (?)")) 
		{
							pstmt.setString(1, kategorie.getKategorieName());
							pstmt.executeUpdate();

						}
		catch (Exception e) {
			throw new ServletException(e.getMessage());
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
