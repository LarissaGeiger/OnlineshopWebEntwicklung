
package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import bean.BilderBean;
import bean.ProduktBean;

@WebServlet("/ProduktServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5
		* 5, location = "/tmp", fileSizeThreshold = 1024 * 1024)
public class ProduktServlet extends HttpServlet {
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

		String kategorieName = request.getParameter("kategorieName");

		ProduktBean produkt = new ProduktBean();
		produkt.setArtikelnr(Integer.valueOf(request.getParameter("artikelnr")));
		produkt.setAngebot(false);
		produkt.setFarbe(request.getParameter("farbe"));
		produkt.setMarke(request.getParameter("marke"));
		produkt.setName(request.getParameter("name"));
		produkt.setPreis(Double.valueOf(request.getParameter("preis")));
		produkt.setPageName(request.getParameter("pageName"));

		BilderBean bild = new BilderBean();
		bild.setBez(request.getParameter("pageName"));
		Part filepart = request.getPart("image");
		bild.setImageFileName(filepart.getSubmittedFileName());

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); InputStream in = filepart.getInputStream()) {
			int i = 0;
			while ((i = in.read()) != -1) {
				baos.write(i);
			}
			bild.setFile(baos.toByteArray());
			baos.flush();
		} catch (IOException ex) {
			throw new ServletException(ex.getMessage());
		}

		persist(bild);
		produkt.setBildID(bild.getId());

		read(produkt, kategorieName);

		
		if (produkt.getKategorieID() == 1) {
			produkt.setDisplaytech(request.getParameter("displaytech"));
			produkt.setBildschirmdiagonale(Double.valueOf(request.getParameter("bildschirmdia")));

			persistFernseher(produkt);
		}
		if (produkt.getKategorieID() == 4) {
			produkt.setModell(request.getParameter("modell"));
			produkt.setDisplaygröße(Double.valueOf(request.getParameter("displaygröße")));
			produkt.setSensorauflösung(Integer.valueOf(request.getParameter("sensorauflösung")));

			persistKameras(produkt);
		}
		if (produkt.getKategorieID() == 3) {
			produkt.setSpeicherplatz(Integer.valueOf(request.getParameter("speicherplatz")));
			produkt.setBetriebssystem(request.getParameter("betriebssystem"));
			produkt.setDisplaygröße(Double.valueOf(request.getParameter("displaygröße")));

			persistSmartphones(produkt);
		}
		if (produkt.getKategorieID() == 2) {
			produkt.setArbeitsspeicher(Integer.valueOf(request.getParameter("arbeitsspeicher")));
			produkt.setDisplaygröße(Double.valueOf(request.getParameter("displaygröße")));
			produkt.setBetriebssystem(request.getParameter("betriebssystem"));

			persistNotebooks(produkt);
		}
		request.setAttribute("produkt", produkt);

		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/admin/adminProdukte.html");

		// final RequestDispatcher dispatcher =
		// request.getRequestDispatcher("jsp/produkt.jsp");
		dispatcher.forward(request, response);
	}

	private void persist(BilderBean b) throws ServletException {

		String[] generatedKeys = new String[] { "id" };
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO bilder (bez, file, imageFileName) VALUES (?, ?, ?)", generatedKeys)) {
			pstmt.setString(1, b.getBez());
			pstmt.setBytes(2, b.getFile());
			pstmt.setString(3, b.getImageFileName());
			pstmt.executeUpdate();

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					b.setId(rs.getInt(1));
				}

			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

	}

	private void persistFernseher(ProduktBean produkt) throws ServletException {

		String[] generatedKeys = new String[] { "artikelnr" };
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO fernseher (artikelnr, angebot,  bildschirmdiagonale, displaytech, farbe, marke,  name, preis, bildID, kategorieID, pageName) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)",
						generatedKeys)) {

			pstmt.setInt(1, produkt.getArtikelnr());
			pstmt.setBoolean(2, produkt.isAngebot());
			pstmt.setDouble(3, produkt.getBildschirmdiagonale());
			pstmt.setString(4, produkt.getDisplaytech());
			pstmt.setString(5, produkt.getFarbe());
			pstmt.setString(6, produkt.getMarke());
			pstmt.setString(7, produkt.getName());
			pstmt.setDouble(8, produkt.getPreis());
			pstmt.setInt(9, produkt.getBildID());
			pstmt.setInt(10, produkt.getKategorieID());
			pstmt.setString(11, produkt.getPageName());
			pstmt.executeUpdate();

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					produkt.setArtikelnr(rs.getInt(1));
				}

			}

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

	}

	private void persistKameras(ProduktBean produkt) throws ServletException {

		String[] generatedKeys = new String[] { "artikelnr" };
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO kameras (artikelnr, angebot,  sensorauflösung, modell, farbe, marke,  name, preis, bildID, kategorieID, displaygröße, pageName) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
						generatedKeys)) {

			pstmt.setInt(1, produkt.getArtikelnr());
			pstmt.setBoolean(2, produkt.isAngebot());
			pstmt.setInt(3, produkt.getSensorauflösung());
			pstmt.setString(4, produkt.getModell());
			pstmt.setString(5, produkt.getFarbe());
			pstmt.setString(6, produkt.getMarke());
			pstmt.setString(7, produkt.getName());
			pstmt.setDouble(8, produkt.getPreis());
			pstmt.setInt(9, produkt.getBildID());
			pstmt.setInt(10, produkt.getKategorieID());
			pstmt.setDouble(11, produkt.getDisplaygröße());
			pstmt.setString(12, produkt.getPageName());

			pstmt.executeUpdate();

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					produkt.setArtikelnr(rs.getInt(1));
				}

			}

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

	}

	private void persistSmartphones(ProduktBean produkt) throws ServletException {

		String[] generatedKeys = new String[] { "artikelnr" };
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO smartphones (artikelnr, angebot,  speicherplatz, betriebssystem, farbe, marke,  name, preis, bildID, kategorieID, displaygröße, pageName) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
						generatedKeys)) {

			pstmt.setInt(1, produkt.getArtikelnr());
			pstmt.setBoolean(2, produkt.isAngebot());
			pstmt.setInt(3, produkt.getSpeicherplatz());
			pstmt.setString(4, produkt.getBetriebssystem());
			pstmt.setString(5, produkt.getFarbe());
			pstmt.setString(6, produkt.getMarke());
			pstmt.setString(7, produkt.getName());
			pstmt.setDouble(8, produkt.getPreis());
			pstmt.setInt(9, produkt.getBildID());
			pstmt.setInt(10, produkt.getKategorieID());
			pstmt.setDouble(11, produkt.getDisplaygröße());
			pstmt.setString(12, produkt.getPageName());
			pstmt.executeUpdate();

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					produkt.setArtikelnr(rs.getInt(1));
				}

			}

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

	}

	private void persistNotebooks(ProduktBean produkt) throws ServletException {

		String[] generatedKeys = new String[] { "artikelnr" };
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO notebooks (artikelnr, angebot,  arbeitsspeicher, betriebssystem, farbe, marke,  name, preis, bildID, kategorieID, displaygröße, pageName) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
						generatedKeys)) {

			pstmt.setInt(1, produkt.getArtikelnr());
			pstmt.setBoolean(2, produkt.isAngebot());
			pstmt.setInt(3, produkt.getArbeitsspeicher());
			pstmt.setString(4, produkt.getBetriebssystem());
			pstmt.setString(5, produkt.getFarbe());
			pstmt.setString(6, produkt.getMarke());
			pstmt.setString(7, produkt.getName());
			pstmt.setDouble(8, produkt.getPreis());
			pstmt.setInt(9, produkt.getBildID());
			pstmt.setInt(10, produkt.getKategorieID());
			pstmt.setDouble(11, produkt.getDisplaygröße());
			pstmt.setString(12, produkt.getPageName());
			
			pstmt.executeUpdate();

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					produkt.setArtikelnr(rs.getInt(1));
				}

			}

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

	}

	private void read(ProduktBean p, String name) throws ServletException {

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT id FROM kategorie WHERE name = '" + name + " '")) {

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {

					p.setKategorieID(rs.getInt("id"));
				}

			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
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
