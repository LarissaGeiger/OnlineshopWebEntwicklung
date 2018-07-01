package servlet;

import java.io.IOException;
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
import javax.sql.DataSource;

import bean.KundeBean;

/**
 * Servlet implementation class kundenReadServlet
 */
@WebServlet("/KundenSehenServlet")
public class KundenSehenServlet extends HttpServlet {
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

		String nachname = request.getParameter("nachname");

		List<KundeBean> kunden = read(nachname);

		request.setAttribute("myKunde", kunden);

		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/kunden.jsp");
		dispatcher.forward(request, response);

	}

	private List<KundeBean> read(String nachname) throws ServletException {
		List<KundeBean> kunden = new ArrayList<KundeBean>();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM customer WHERE nachname = ?")) {

			pstmt.setString(1, nachname);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					KundeBean kunde = new KundeBean();
					kunde.setId(Integer.valueOf((rs.getInt("id"))));
					kunde.setVorname(rs.getString("vorname"));
					kunde.setNachname(rs.getString("nachname"));
					kunde.setEmail(rs.getString("email"));
					kunde.setTelefonnr(rs.getString("telefonnr"));
					kunde.setStraﬂe(rs.getString("straﬂe"));
					kunde.setGebdatum(rs.getString("gebdatum"));
					kunde.setPasswort(rs.getString("passwort"));
					kunde.setAdmin(Boolean.valueOf(rs.getBoolean("admin")));
					kunde.setOrt(rs.getString("ort"));
					kunde.setPlz(Integer.valueOf(rs.getInt("plz")));
					kunde.setHausnr(Integer.valueOf(rs.getInt("hausnr")));
					kunden.add(kunde);
				}

			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return kunden;
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
