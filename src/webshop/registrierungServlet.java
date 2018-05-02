//package onlineshop;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class SessionHandlingServlet
// */
//@WebServlet("/registrierungServlet")
//public class registrierungServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		log("init() in FirstServlet reached");
//	}
//
//	
//	
//	
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
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
//		// erg�nzen (zu finden im WEB-INF-Ordner des Projektes):
//		// <parameter-encoding default-charset="UTF-8" />
//		
//		final PrintWriter out = response.getWriter();
//		String vorname = request.getParameter("vorname");
//		String nachname = request.getParameter("nachname");
//		String geburtsdatum = request.getParameter("geburtstag");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<h3>Empfangene Formulardaten</h3>");
//		out.println("Vorname: " + vorname + "<br>");
//		out.println("Nachname: " + nachname + "<br>");
//		out.println("Geburtsdatum: " + geburtsdatum + "<br>");
//		out.println("E-Mail: " + email + "<br>");
//		out.println("Password: " + password + "<br>");
//
//		out.println("</body>");
//		out.println("</html>");
//	}
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
//

package onlineshop;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlineshop.kundeBean;

/**
 * Servlet implementation class ProduktformcServlet
 */
@WebServlet("/registrierungServlet")
public class registrierungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="jdbc/MyTHIPool")
	 	
	
	
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
												// erg�nzen (zu finden im WEB-INF-Ordner des Projektes):
												// <parameter-encoding default-charset="UTF-8" />
		kundeBean kunde = new kundeBean();
		kunde.setVorname(request.getParameter("vorname"));
		kunde.setNachname(request.getParameter("nachname"));
		kunde.setEmail(request.getParameter("email"));
		kunde.setPasswort(request.getParameter("passwort"));
		kunde.setGeburtsdatum(request.getParameter("geburtsdatum"));

		// Scope "Request"
		request.setAttribute("myKunde", kunde);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/registrierung.jsp");
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