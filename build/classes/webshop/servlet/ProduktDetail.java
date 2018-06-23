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

import bean.ProduktBean;

@WebServlet("/ProduktDetail")
public class ProduktDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setCharacterEncoding("UTF-8"); // In diesem Format erwartet das
		// Servlet jetzt die Formulardaten
		// Scope "Session"
		HttpSession session = request.getSession();
		session.setAttribute("pageName", request.getParameter("page"));

		// DB-Zugriff
		ProduktBean produkt = new ProduktBean();
		System.out.println(request.getParameter("page"));


		produkt = read(session, request);
		session.setAttribute("produktDetail", produkt);

		request.getRequestDispatcher("jsp/produktDetail.jsp").include(request, response);

	}

	private ProduktBean read(HttpSession session, HttpServletRequest request) throws ServletException {
		ProduktBean produkt = new ProduktBean();
		try (Connection con = ds.getConnection();

				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM "+request.getParameter("titel").toString().toLowerCase()+" WHERE pageName= '"+ session.getAttribute("pageName")+"'")) {

			//pstmt.setString(1, session.getAttribute("titel").toString().toLowerCase());
			//pstmt.setString(2, (String) session.getAttribute("pageName"));
			try (ResultSet rs = pstmt.executeQuery()) {

				if (rs != null && rs.next()) {
					// ProduktBean b = new ProduktBean();
					if (session.getAttribute("titel").equals("Fernseher")) {
						produkt.setArtikelnr(rs.getInt("artikelnr"));
						produkt.setName(rs.getString("name"));
						produkt.setPreis(rs.getDouble("preis"));
						produkt.setMarke(rs.getString("marke"));
						produkt.setFarbe(rs.getString("farbe"));
						produkt.setBildschirmdiagonale(rs.getDouble("bildschirmdiagonale"));
						produkt.setDisplaytech(rs.getString("displaytech"));
						produkt.setBildID(rs.getInt("bildID"));
						produkt.setPageName(rs.getString("pageName"));

					} else if (session.getAttribute("titel").equals("Kameras")) {
						produkt.setArtikelnr(rs.getInt("artikelnr"));
						produkt.setName(rs.getString("name"));
						produkt.setPreis(rs.getDouble("preis"));
						produkt.setMarke(rs.getString("marke"));
						produkt.setFarbe(rs.getString("farbe"));
						produkt.setSensorauflösung(rs.getInt("sensorauflösung"));
						produkt.setModell(rs.getString("modell"));
						produkt.setBildID(rs.getInt("bildID"));
						produkt.setPageName(rs.getString("pageName"));

					} else if (session.getAttribute("titel").equals("Smartphones")) {
						produkt.setArtikelnr(rs.getInt("artikelnr"));
						produkt.setName(rs.getString("name"));
						produkt.setPreis(rs.getDouble("preis"));
						produkt.setMarke(rs.getString("marke"));
						produkt.setFarbe(rs.getString("farbe"));
						produkt.setDisplaygröße(rs.getDouble("displaygröße"));
						produkt.setBetriebssystem(rs.getString("betriebssystem"));
						produkt.setSpeicherplatz(rs.getInt("speicherplatz"));
						produkt.setBildID(rs.getInt("bildID"));
						produkt.setPageName(rs.getString("pageName"));

					} else if (session.getAttribute("titel").equals("Notebooks")) {
						produkt.setArtikelnr(rs.getInt("artikelnr"));
						produkt.setName(rs.getString("name"));
						produkt.setPreis(rs.getDouble("preis"));
						produkt.setMarke(rs.getString("marke"));
						produkt.setFarbe(rs.getString("farbe"));
						produkt.setBetriebssystem(rs.getString("betriebssystem"));
						produkt.setDisplaygröße(rs.getDouble("displaygröße"));
						produkt.setArbeitsspeicher(rs.getInt("arbeitsspeicher"));
						produkt.setBildID(rs.getInt("bildID"));
						produkt.setPageName(rs.getString("pageName"));
					}

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
