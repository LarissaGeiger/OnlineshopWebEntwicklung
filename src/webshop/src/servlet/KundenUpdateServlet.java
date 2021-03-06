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

import bean.KundeBean;

/**
 * Servlet implementation class kundeUpdateServlet
 */
@WebServlet("/KundenUpdateServlet")
public class KundenUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		KundeBean kunde = new KundeBean();
		kunde.setId(Integer.valueOf(request.getParameter("id")));

		if (check(kunde.getId())) {

			kunde.setHausnr(Integer.valueOf(request.getParameter("hausnummer")));
			kunde.setOrt(request.getParameter("ort"));
			kunde.setPlz(Integer.valueOf(request.getParameter("postleitzahl")));
			kunde.setStra�e(request.getParameter("stra�e"));
			kunde.setTelefonnr(request.getParameter("telefonnummer"));

			persist(kunde);

			request.setAttribute("myKunde", kunde);

			final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/updateAdmin.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("myKunde", kunde.getId());
			final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/fehlerAdmin.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void persist(KundeBean k) throws ServletException {
		// DB-Zugriff
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("UPDATE customer "
						+ "SET  stra�e = ?, hausnr = ?, plz = ?, ort = ?, telefonnr = ? WHERE id = ?")) {

			pstmt.setString(1, k.getStra�e());
			pstmt.setInt(2, k.getHausnr());
			pstmt.setInt(3, k.getPlz());
			pstmt.setString(4, k.getOrt());
			pstmt.setString(5, k.getTelefonnr());
			pstmt.setInt(6, k.getId());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
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

	private boolean check(Integer id) throws ServletException {

		KundeBean k = new KundeBean();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT id FROM customer WHERE id = ?")) {
			pstmt.setInt(1, id);

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					k.setId(Integer.valueOf(rs.getInt("id")));

				}
			}

		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		if (k.getId() == id) {
			return true;
		} else {
			return false;
		}
	}

}
