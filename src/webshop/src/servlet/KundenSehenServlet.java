package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.KundeBean;

/**
 * Servlet implementation class kundenReadServlet
 */
@WebServlet("/KundenSehenServlet")
public class KundenSehenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KundenSehenServlet() {
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
		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten

		Integer id = Integer.valueOf(request.getParameter("id"));

		// DB-Zugriff
		KundeBean k = read(id);
		// Scope "Request"
		request.setAttribute("myKunde", k);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/kunden.jsp");
		dispatcher.forward(request, response);

	}

	private KundeBean read(Integer id) throws ServletException {
		KundeBean kunde = new KundeBean();
		kunde.setId(id);
		
		// DB-Zugriff
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM customer WHERE id=?")) {

			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {
									
					kunde.setVorname(rs.getString("vorname"));
					kunde.setNachname(rs.getString("nachname"));
					kunde.setEmail(rs.getString("email"));
					kunde.setGebdatum(rs.getString("gebdatum"));
					kunde.setTelefonnr(rs.getString("telefonnr"));
					kunde.setStraﬂe(rs.getString("straﬂe"));
					
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return kunde;
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
