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

import bean.KontaktBean;

/**
 * Servlet implementation class AngeboteSehenServlet
 */
@WebServlet("/KontaktSehenServlet")
public class KontaktSehenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KontaktSehenServlet() {
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
		request.setCharacterEncoding("UTF-8");
		Integer id = Integer.valueOf(request.getParameter("id"));
		KontaktBean kontakte = read(id);

		request.setAttribute("kontakte", kontakte);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/kontaktSehen.jsp");
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

	private KontaktBean read(Integer id) throws ServletException {
		KontaktBean k = new KontaktBean();
		k.setId(id);

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM kontakt WHERE id =?")) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {
					k.setVorname(rs.getString("vorname"));
					k.setNachname(rs.getString("nachname"));
					k.setEmail(rs.getString("email"));
					k.setUsereingabe(rs.getString("usereingabe"));
					k.setGeschlecht(rs.getString("geschlecht"));
				}

			}

		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return k;
	}

}
