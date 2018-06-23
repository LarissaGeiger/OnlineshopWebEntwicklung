package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.eclipse.persistence.internal.jpa.rs.metadata.model.SessionBeanCall;

import bean.KategorieBean;
import bean.ProduktBean;

@WebServlet("/Titel")
public class Titel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das Servlet jetzt die Formulardaten

		// Scope "Session"
		HttpSession session = request.getSession();
		session.setAttribute("titel", request.getParameter("titel"));

		// DB-Zugriff
		/*List<ProduktBean> produkt = new ArrayList<ProduktBean>();
		produkt = read(session);
		session.setAttribute("produkt", produkt);
*/
		System.out.println("jsp/" + session.getAttribute("titel") + ".jsp");
		request.getRequestURL();
		System.out.println(request.getRequestURL());


		request.getRequestDispatcher("jsp/" + session.getAttribute("titel") + ".jsp").include(request, response);

	}

	private List<ProduktBean> read(HttpSession session) throws ServletException {
		System.out.println(session.getAttribute("titel").toString().toLowerCase());
		List<ProduktBean> produkt = new ArrayList<ProduktBean>();

		try (Connection con = ds.getConnection();

				PreparedStatement pstmt = con.prepareStatement(
						"SELECT bildID, name FROM " + session.getAttribute("titel").toString().toLowerCase())) {
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					ProduktBean b = new ProduktBean();
					// if (session.getAttribute("titel").equals("Fernseher")) {
					// b.setArtikelnr(rs.getInt("artikelnr"));
					b.setName(rs.getString("name"));
					// b.setPreis(rs.getDouble("preis"));
					// b.setMarke(rs.getString("marke"));
					// b.setFarbe(rs.getString("farbe"));
					// b.setBildschirmdiagonale(rs.getDouble("bildschirmdiagonale"));
					// b.setDisplaytech(rs.getString("displaytech"));
					b.setBildID(rs.getInt("bildID"));
					produkt.add(b);
					break;
					// } else if (session.getAttribute("titel").equals("Kameras")) {
					// b.setArtikelnr(rs.getInt("artikelnr"));
					// b.setName(rs.getString("name"));
					// b.setPreis(rs.getDouble("preis"));
					// b.setMarke(rs.getString("marke"));
					// b.setFarbe(rs.getString("farbe"));
					// b.setSensorauflösung(rs.getInt("sensorauflösung"));
					// b.setModell(rs.getString("modell"));
					// } else {


					// }

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
