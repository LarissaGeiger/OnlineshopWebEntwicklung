
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

	private void persist(KontaktBean kontaktformular) throws ServletException {
		String[] generatedKeys = new String[] { "id" };
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO  kontakt (vorname, nachname, email, usereingabe, geschlecht) VALUES (?,?, ?, ?, ?)",
						generatedKeys)) {
			pstmt.setString(1, kontaktformular.getVorname());
			pstmt.setString(2, kontaktformular.getNachname());
			pstmt.setString(3, kontaktformular.getEmail());
			pstmt.setString(4, kontaktformular.getUsereingabe());
			pstmt.setString(5, kontaktformular.getGeschlecht());
			pstmt.executeUpdate();
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					kontaktformular.setId(rs.getInt(1));
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


		request.setAttribute("myKontakt", kontakt);

		// richtige Seite fehlt noch 
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
