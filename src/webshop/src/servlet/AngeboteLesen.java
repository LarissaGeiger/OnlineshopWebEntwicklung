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

import bean.KategorieBean;
import bean.ProduktBean;

@WebServlet("/AngeboteLesen")
public class AngeboteLesen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// Boolean angebotProdukt = Boolean.valueOf((request.getParameter("angebot")));

		List<ProduktBean> angebot = new ArrayList<ProduktBean>();
		angebot = read();
		request.setAttribute("angebot", angebot);

		request.getRequestDispatcher("index.jsp").include(request, response);

	}

	private List<ProduktBean> read() throws ServletException {

		List<ProduktBean> angebot = new ArrayList<ProduktBean>();
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						//Abfrage ist falsch
						"SELECT bilder.id, fernseher.bildID, kameras.bildID, notebooks.bildID, smartphone.bildID"
								+ "FROM bilder, fernseher, kameras, notebooks, smartphone" + "WHERE bilder.id=? ")) {

			pstmt.setString(1, "");
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs == rs) {
					while (rs.next()) {
						ProduktBean p = new ProduktBean();
						p.setBildID(rs.getInt("bildID"));
						angebot.add(p);

					}

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return angebot;

	}

}
