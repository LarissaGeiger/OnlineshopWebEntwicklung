package servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import bean.BilderBean;
import bean.KategorieBean;

@WebServlet("/KategorieServlet")
public class KategorieServlet extends HttpServlet {
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
		KategorieBean kategorie = new KategorieBean();
		kategorie.setName(request.getParameter("name"));
		
		persist(kategorie);
		createTable(kategorie.getName());

		// Scope "Request"
		request.setAttribute("kategorie", kategorie);

		// Weiterleiten an JSP //html/admin/neueKategorieBilder.html
		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/kategorie.jsp");
		dispatcher.forward(request, response);

	}

	private void persist(KategorieBean kategorie) throws ServletException {
		String[] generatedKeys = new String[] { "id" };
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO kategorie (name) VALUES (?)", generatedKeys)) {
			pstmt.setString(1, kategorie.getName());
			pstmt.executeUpdate();
			
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					kategorie.setId(rs.getInt(1));
				}

			}
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

	}

	private void createTable(String name) throws ServletException {
// richtigen Spalten mit Merkmalen
		try (Connection con = ds.getConnection(); final Statement stmt = con.createStatement()) {
			stmt.executeUpdate("CREATE TABLE " + name + " (artikelnr int(7), kategorieID int(11), bildID int(11),  PRIMARY KEY (artikelnr))");

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
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

}
