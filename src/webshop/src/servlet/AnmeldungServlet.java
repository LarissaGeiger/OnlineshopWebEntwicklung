package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.KundeBean;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class anmeldungServlet
 */
@WebServlet("/AnmeldungServlet")
public class AnmeldungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnmeldungServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String passwort = request.getParameter("passwort");

		// https://www.studytonight.com/servlet/login-system-example-in-servlet.php
		if (checkUser(email, passwort) && passwort != "admin" && email != "admin@thi.de") {

			HttpSession session = request.getSession();
			KundeBean kunde = new KundeBean();
			kunde.setEmail(email);
			kunde.setPasswort(passwort);
			session.setAttribute("kunde", kunde);

			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.forward(request, response);

			
//		Adminerkennung? Festgelegter Kunde mit bestimmten Passwort und Email?			
			
//		} else if (checkUser(email, passwort) && passwort == "admin"
//				&& request.getParameter("email") == "admin@thi.de") {
//			RequestDispatcher rs = request.getRequestDispatcher("html/admin.html");
//			rs.forward(request, response);
//
		} else {
			out.println("Email oder Passwort falsch!");
			RequestDispatcher rs = request.getRequestDispatcher("html/anmeldung.html");
			rs.include(request, response);
		}

	}

	public boolean checkUser(String email, String passwort) throws ServletException {
		boolean st = false;
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from kunden where email=? and passwort=?")) {

			ps.setString(1, email);
			ps.setString(2, passwort);
			ResultSet rs = ps.executeQuery();
			st = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		return st;
	}

}

// package edu.thi.servlets;
//
// import java.io.IOException;
// import java.io.PrintWriter;
//
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;
////
/// **
// * Servlet implementation class SessionHandlingServlet
// */
// @WebServlet("/sessionhandlingservlet")
// public class SessionHandlingServlet extends HttpServlet {
// private static final long serialVersionUID = 1L;
//
// /**
// * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
// response)
// */
// protected void doGet(HttpServletRequest request, HttpServletResponse
// response) throws ServletException, IOException {
// // HTTP-Header setzen
// response.setStatus(HttpServletResponse.SC_OK); // nicht zwingend
// erforderlich; ist der default-Wert
// response.setContentType("text/html");
// response.setCharacterEncoding("UTF-8");
//
// final PrintWriter out = response.getWriter();
// String action = request.getParameter("action");
// String vorname = null;
// String nachname = null;
// HttpSession session = null;
//
// switch (action) {
// case "writeToSession":
// vorname = request.getParameter("vorname");
// nachname = request.getParameter("nachname");
// session = request.getSession();
// session.setAttribute("vorname", vorname);
// session.setAttribute("nachname", nachname);
//
// out.println("<!DOCTYPE html>");
// out.println("<html>");
// out.println("<body>");
// out.println("<h3>Schreiben von Daten in eine Sitzung</h3>");
// out.println("Sessiondaten wurden erfolgreich geschrieben!");
// out.println("<form method='post' action='sessionhandlingservlet'>");
// out.println("<div>");
// out.println("<button type='submit' name='action'
// value='readFromSession'>Daten aus Session lesen</button>");
// out.println("</div>");
// out.println("</form>");
// out.println("</body>");
// out.println("</html>");
// break;
//
// case "readFromSession":
// session = request.getSession();
// vorname = (String) session.getAttribute("vorname");
// nachname = (String) session.getAttribute("nachname");
// out.println("<!DOCTYPE html>");
// out.println("<html>");
// out.println("<body>");
// out.println("<h3>Lesen von Daten aus einer Sitzung</h3>");
// out.println("<b>Gelesene Daten:</b><br>");
// out.println("Vorname: " + vorname + "<br>");
// out.println("Nachname: " + nachname + "<br>");
// out.println("</body>");
// out.println("</html>");
// break;
//
// default:
// out.println("<!DOCTYPE html>");
// out.println("<html>");
// out.println("<body>");
// out.println("<h3>Unbekannte Aktion!</h3>");
// out.println("</body>");
// out.println("</html>");
// break;
// }
// }
//
// /**
// * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
// response)
// */
// protected void doPost(HttpServletRequest request, HttpServletResponse
// response) throws ServletException, IOException {
// // TODO Auto-generated method stub
// doGet(request, response);
// }
//
// }
