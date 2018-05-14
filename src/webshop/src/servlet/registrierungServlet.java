
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

import bean.kundeBean;

/**
 * Servlet implementation class ProduktformcServlet
 */
@WebServlet("/registrierungServlet")
public class registrierungServlet extends HttpServlet {
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
												// erg‰nzen (zu finden im WEB-INF-Ordner des Projektes):
												// <parameter-encoding default-charset="UTF-8" />
		kundeBean kunde = new kundeBean();
		kunde.setFirstname(request.getParameter("firstname"));
		kunde.setLastname(request.getParameter("lastname"));
		kunde.setEmail(request.getParameter("email"));
		kunde.setPassword(request.getParameter("password"));
		kunde.setTelefonnr(request.getParameter("telefonnr"));
		kunde.setStraﬂe(request.getParameter("straﬂe"));
		kunde.setGebdate(request.getParameter("gebdate"));

		persist(kunde);

		// Scope "Request"
		request.setAttribute("myKunde", kunde);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/registrierung.jsp");
		dispatcher.forward(request, response);
	}

	private void persist(kundeBean kunde) throws ServletException {
		// String [] neuerKunde = new String[] {"id",
		// "firstname","lastname","email","telefonnummer", "Straﬂe"};
		String[] generatedKeys = new String[] {"id"};
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO customer (firstname,lastname,email,telefonnr, straﬂe,gebdate,password) VALUES (?,?,?,?,?,?,?)", generatedKeys)) {
			pstmt.setString(1, kunde.getFirstname());
			pstmt.setString(2, kunde.getLastname());
			pstmt.setString(3, kunde.getEmail());
			pstmt.setString(4, kunde.getTelefonnr());
			pstmt.setString(5, kunde.getStraﬂe());
			pstmt.setString(6, kunde.getGebdate());
			pstmt.setString(7, kunde.getPassword());
			pstmt.executeUpdate();

		

		
		try (ResultSet rs = pstmt.getGeneratedKeys()) {
			while (rs.next()) {
				kunde.setId(rs.getInt(1));
			}
			
		}
		
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
