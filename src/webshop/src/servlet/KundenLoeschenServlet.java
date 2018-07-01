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
 * Servlet implementation class kundeDeleteServlet
 */
@WebServlet("/KundenLoeschenServlet")
public class KundenLoeschenServlet extends HttpServlet {
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
		Integer id = Integer.valueOf(request.getParameter("id"));

		if (check(id)) {

			delete(id);

			request.setAttribute("myKunde", id);

			final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/loeschenAdmin.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("myKunde", id);

			final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/fehlerAdmin.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void delete(Integer id) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM customer WHERE id = ?")) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
