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

@WebServlet("/KontaktformularLoeschenServlet")
public class KontaktformularLoeschenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer id = Integer.valueOf(request.getParameter("id"));

		if (check(id)) {
			delete(id);

			request.setAttribute("kontakt", id);

			final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/loeschenAdmin.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("kontakt", id);
			final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/fehlerAdmin.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void delete(Integer id) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM kontakt WHERE id = ?")) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private boolean check(Integer id) throws ServletException {

		KontaktBean k = new KontaktBean();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT id FROM kontakt WHERE id = ?")) {
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
