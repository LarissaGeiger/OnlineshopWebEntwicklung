// Hakan Demen 

package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import bean.ArtikelBean;
import bean.ProduktBean;
import bean.WarenkorbBean;

/**
 * Servlet implementation class Warenkorbservlet
 */
@WebServlet("/Warenkorbservlet")
public class Warenkorbservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();

		WarenkorbBean warenkorb = (WarenkorbBean) session.getAttribute("warenkorb");
		ProduktBean produkt = new ProduktBean(request.getParameter("name"),
				Double.parseDouble(request.getParameter("preis")));
		produkt.setPageName(request.getParameter("page"));

		// warenkorb = new WarenkorbBean();
		if (warenkorb == null) {
			warenkorb = new WarenkorbBean();

			session.setAttribute("warenkorb", warenkorb);
		}
		session.setAttribute("warenkorb", warenkorb);

		ArrayList<ArtikelBean> wkb = warenkorb.getWarenkorb();
		boolean newArtikel = true;

		for (ArtikelBean i : wkb) {
			if (i.getProdukt().getPageName().equals(produkt.getPageName())) {

				newArtikel = false;
				i.setAnzahl(i.getAnzahl() + 1);

			}
		}

		if (newArtikel) {
			ProduktBean neuesProdukt = read(request);
			ArtikelBean neuerArtikel = new ArtikelBean(neuesProdukt);
			neuerArtikel.setAnzahl(1);
			System.out.println(neuerArtikel.getAnzahl());
			System.out.println(neuesProdukt.getName());
			System.out.println(neuesProdukt.getPreis());
			wkb.add(neuerArtikel);

		}
		request.setAttribute("summe", warenkorb.getGesamtpreis());
		request.getRequestDispatcher("jsp/warenkorb.jsp").include(request, response);

	}

	private ProduktBean read(HttpServletRequest request) throws ServletException {
		bean.ProduktBean b = new bean.ProduktBean();
		try (Connection con = ds.getConnection();

				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM " + request.getParameter("titel").toString().toLowerCase()
								+ " WHERE pageName= '" + request.getParameter("page") + "'")) {

			// pstmt.setString(1, session.getAttribute("titel").toString().toLowerCase());
			// pstmt.setString(2, (String) session.getAttribute("pageName"));
			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs.next()) {
					// ProduktBean b = new ProduktBean();
					b.setArtikelnr(rs.getInt("artikelnr"));
					b.setName(rs.getString("name"));
					b.setPreis(rs.getDouble("preis"));
					b.setBildID(rs.getInt("bildID"));
					b.setPageName(rs.getString("pageName"));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		return b;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
