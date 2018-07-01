package servlet;

import java.util.ArrayList;

import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.KategorieBean;

@WebServlet("/KategorieLesen")
public class KategorieLesen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		List<KategorieBean> kategorie = new ArrayList<KategorieBean>();
		kategorie = read();

		// Scope "Request"

		request.setAttribute("kategorie", kategorie);

		request.getRequestDispatcher("kategorie.jsp").include(request, response);
	}

	private List<KategorieBean> read() throws ServletException {

		List<KategorieBean> kategorie = new ArrayList<KategorieBean>();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM kategorie ")) {

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					KategorieBean k = new KategorieBean();
					k.setName(rs.getString("name"));
					k.setBildID(rs.getInt("bildID"));
					kategorie.add(k);

				}

			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		return kategorie;
	}

}