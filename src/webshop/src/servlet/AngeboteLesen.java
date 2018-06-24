package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.ProduktBean;

@WebServlet("/AngeboteLesen")
public class AngeboteLesen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		List<ProduktBean> angebot = new ArrayList<ProduktBean>();
		angebot = read();
		request.setAttribute("angebot", angebot);

		request.getRequestDispatcher("angebote.jsp").include(request, response);

	}

	private List<ProduktBean> read() throws ServletException {

		List<ProduktBean> angebot = new ArrayList<ProduktBean>();
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(

						"SELECT bildId, name, pageName, kategorieID FROM smartphones WHERE angebot = true UNION ALL (SELECT bildID, name, pageName, kategorieID FROM kameras WHERE angebot = true)"
								+ "UNION ALL (SELECT bildId, name, pageName, kategorieID FROM notebooks WHERE angebot = true) UNION ALL (SELECT bildId, name, pageName, kategorieID FROM fernseher WHERE angebot = true);")) {

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					ProduktBean s = new ProduktBean();
					s.setName(rs.getString("name"));
					s.setBildID(rs.getInt("bildID"));
					s.setPageName(rs.getString("pageName"));
					s.setKategorieID(rs.getInt("kategorieID"));
					angebot.add(s);

				}

			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return angebot;

	}

}
