package webshop;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionHandlingServlet
 */
@WebServlet("/registrierungServlet")
public class registrierungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		log("init() in FirstServlet reached");
	}

	@Override
	public void destroy() {
		super.destroy();
		log("destroy() in FirstServlet reached");
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String geburtsdatum = request.getParameter("geburtstag");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Empfangene Formulardaten</h3>");
		out.println("Vorname: " + vorname + "<br>");
		out.println("Nachname: " + nachname + "<br>");
		out.println("Geburtsdatum: " + geburtsdatum + "<br>");
		out.println("E-Mail: " + email + "<br>");
		out.println("Password: " + password + "<br>");

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
