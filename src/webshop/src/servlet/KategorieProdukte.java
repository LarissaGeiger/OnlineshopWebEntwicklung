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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import bean.ProduktBean;

@WebServlet("/KategorieProdukte")
public class KategorieProdukte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// Scope "Session"
		HttpSession session = request.getSession();

		// DB-Zugriff
		List<ProduktBean> produkt = new ArrayList<ProduktBean>();
		produkt = read(session);

		session.setAttribute("titel", request.getParameter("titel"));
		session.setAttribute("produkt", produkt);

		request.getRequestDispatcher("jsp/bilderTest.jsp").include(request, response);

	}

	private List<ProduktBean> read(HttpSession session) throws ServletException {
		System.out.println(session.getAttribute("titel").toString().toLowerCase());
		List<ProduktBean> produkt = new ArrayList<ProduktBean>();

		try (Connection con = ds.getConnection();

				PreparedStatement pstmt = con.prepareStatement("SELECT bildID, name, pageName FROM "
						+ session.getAttribute("titel").toString().toLowerCase())) {
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					ProduktBean b = new ProduktBean();

					b.setName(rs.getString("name"));
					b.setBildID(rs.getInt("bildID"));
					b.setPageName(rs.getString("pageName"));
					produkt.add(b);

				}

			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		return produkt;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
