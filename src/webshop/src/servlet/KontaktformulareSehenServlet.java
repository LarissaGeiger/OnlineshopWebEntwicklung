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

import bean.KategorieBean;
import bean.KontaktBean;

/**
 * Servlet implementation class AngeboteSehenServlet
 */
@WebServlet("/KontaktformulareSehenServlet")
public class KontaktformulareSehenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KontaktformulareSehenServlet() {
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

		List<KontaktBean> kontakte = new ArrayList<KontaktBean>();
		kontakte = read();
		request.setAttribute("kontakte", kontakte);


		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/kontaktformulareSehen.jsp");
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

	private List<KontaktBean> read() throws ServletException {
		List<KontaktBean> kontakte = new ArrayList<KontaktBean>();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM kontakt")) {

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					KontaktBean k = new KontaktBean();
					k.setId(rs.getInt("id"));
					k.setVorname(rs.getString("vorname"));
					k.setNachname(rs.getString("nachname"));
					k.setEmail(rs.getString("email"));
					k.setUsereingabe(rs.getString("usereingabe"));
					k.setGeschlecht(rs.getString("geschlecht"));
					kontakte.add(k);

				}

			}

		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return kontakte;
	}

}
