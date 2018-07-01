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
import bean.ProduktBean;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class anmeldungServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

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
		String email = request.getParameter("email");
		String passwort = request.getParameter("passwort");

		if (checkUser(email, passwort) && passwort != "admin" && email != "admin@thi.de") {

			HttpSession session = request.getSession();
			KundeBean kunde = new KundeBean();
			kunde.setEmail(email);
			kunde.setPasswort(passwort);
			session.setAttribute("myKunde", kunde);

			final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/anmeldung.jsp");
			dispatcher.forward(request, response);

		} else if (passwort.equals("admin") && email.equals("admin@thi.de")) {
			RequestDispatcher rs = request.getRequestDispatcher("jsp/anmeldung.jsp");
			rs.forward(request, response);

		} else {
			RequestDispatcher rs = request.getRequestDispatcher("jsp/fehlerLogin.jsp");
			rs.include(request, response);
		}

	}

	public boolean checkUser(String email, String passwort) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM customer WHERE email = ? AND passwort = ?")) {

			pstmt.setString(1, email);
			pstmt.setString(2, passwort);

			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			}

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

	}

}
