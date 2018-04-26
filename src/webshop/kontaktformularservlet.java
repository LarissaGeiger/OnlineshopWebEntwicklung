package onlineshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class kontaktformularservlet
 */
@WebServlet("/kontaktformularservlet")
public class kontaktformularservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Datum aus dem Internet
	public kontaktformularservlet() {
		super();
	}
	// Datum aus dem Internet
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP-Header setzen
		response.setStatus(HttpServletResponse.SC_OK);	// nicht zwingend erforderlich; ist der default-Wert
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		// Alternative: GlassFish dazu bewegen, die Formulardaten gleich
		// als UTF-8 zu interpretieren. Dazu muss GlassFish auf UTF-8 umge-
		// stellt werden. Eine neue Zeile in die Datei glassfish-web.xml
		// ergänzen (zu finden im WEB-INF-Ordner des Projektes):
		// <parameter-encoding default-charset="UTF-8" />
		
		final PrintWriter out = response.getWriter();
		
		// Datum aus dem Internet
		Date dNow = new Date( );
		SimpleDateFormat ft = 
				new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss E  ");
		// Datum aus dem Internet 
		
		
		String geschlecht = request.getParameter("geschlecht");
		String email = request.getParameter("email");
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String usereingabe = request.getParameter("usereingabe");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Empfangene Formulardaten</h3>");
		out.println("Geschlecht: " + geschlecht + "<br>");
		out.println("E-Mail: " + email + "<br>");
		out.println("Vorname: " + vorname + "<br>");
		out.println("Nachname: " + nachname + "<br>");
		out.println("Nachricht: " + usereingabe + "<br>");
		out.println("Uhrzeit: " + ft.format(dNow) + "<br>"); // Datum ausgabe
		
		out.println("</body>");
		out.println("</html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
