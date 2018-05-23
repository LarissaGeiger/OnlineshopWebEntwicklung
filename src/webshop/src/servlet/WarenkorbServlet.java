package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class warenkorbServlet
 */
@WebServlet("/warenkorbservlet")
public class WarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarenkorbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_OK);	// nicht zwingend erforderlich; ist der default-Wert
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		// Alternative: GlassFish dazu bewegen, die Formulardaten gleich
		// als UTF-8 zu interpretieren. Dazu muss GlassFish auf UTF-8 umge-
		// stellt werden. Eine neue Zeile in die Datei glassfish-web.xml
		// erg�nzen (zu finden im WEB-INF-Ordner des Projektes):
		// <parameter-encoding default-charset="UTF-8" />
		
		final PrintWriter out = response.getWriter();
		

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
//		
		out.println("</body>");
		out.println("</html>");
		
	}

}
