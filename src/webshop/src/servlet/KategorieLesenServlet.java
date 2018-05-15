package servlet;

import java.util.ArrayList;
import java.util.List;
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


import bean.KategorieBean;
@WebServlet("/KategorieLesenServlet")
public class KategorieLesenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Lesen der Daten in einer DB
		// und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP

		request.setCharacterEncoding("UTF-8");
		String kategorieName = request.getParameter("kategorieName");

		// DB-Zugriff
		List<KategorieBean> kategorie = search(kategorieName);

		// Scope "Request"
		request.setAttribute("kategorieName", kategorieName);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("kategorie.jsp");
		dispatcher.forward(request, response);
	}

	private List<KategorieBean> search(String kategorieName) throws ServletException {
		// TODO Auto-generated method stub
		kategorieName = (kategorieName == null || kategorieName == "") ? "%" : "%" + kategorieName + "%";
		List<KategorieBean> kategorie = new ArrayList<KategorieBean>();

		// DB-Zugriff
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM kategorie ")) {

			pstmt.setString(1, kategorieName);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					KategorieBean k = new KategorieBean();
					k.setKategorieName(rs.getString("kategorieName"));
					kategorie.add(k);

				}

			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		return kategorie;
	}
}
