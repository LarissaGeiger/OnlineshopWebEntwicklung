
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

import bean.KundeBean;

@WebServlet("/RegistrierungServlet")
public class RegistrierungServlet extends HttpServlet {
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
		KundeBean kunde = new KundeBean();
		kunde.setVorname(request.getParameter("vorname"));
		kunde.setNachname(request.getParameter("nachname"));
		kunde.setEmail(request.getParameter("email"));
		kunde.setPasswort(request.getParameter("passwort"));
		 kunde.setTelefonnr(request.getParameter("telefonnummer"));
		kunde.setStraﬂe(request.getParameter("straﬂe"));
		kunde.setGebdatum(request.getParameter("geburtsdatum"));
		kunde.setHausnr(Integer.valueOf(request.getParameter("hausnummer")));
		kunde.setPlz(Integer.valueOf(request.getParameter("postleitzahl")));
		kunde.setOrt(request.getParameter("ort"));
		persist(kunde);

		request.setAttribute("myKunde", kunde);

		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/registrierung.jsp");
		dispatcher.forward(request, response);
	}

	private void persist(KundeBean kunde) throws ServletException {

		String[] generatedKeys = new String[] { "id" };
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO customer (vorname,nachname,email, straﬂe, gebdatum,passwort, ort, admin, hausnr, plz, telefonnr) "
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)",
						generatedKeys)) {

			pstmt.setString(1, kunde.getVorname());
			pstmt.setString(2, kunde.getNachname());
			pstmt.setString(3, kunde.getEmail());

			pstmt.setString(4, kunde.getStraﬂe());
			pstmt.setString(5, kunde.getGebdatum());
			pstmt.setString(6, kunde.getPasswort());

			pstmt.setString(7, kunde.getOrt());
			pstmt.setBoolean(8, false);
			pstmt.setInt(9, kunde.getHausnr());
			pstmt.setInt(10, kunde.getPlz());
			pstmt.setString(11, kunde.getTelefonnr());
			pstmt.executeUpdate();

			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					kunde.setId(rs.getInt(1));
				}

			}

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
