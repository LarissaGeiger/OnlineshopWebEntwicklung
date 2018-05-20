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
	 * @see HttpServlet#HttpServlet()
	 */
	public KundenSehenServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String nachname = request.getParameter("nachname");
		// Integer id = Integer.valueOf(request.getParameter("id"));
		List<KundeBean> kunden = read(nachname);
		// DB-Zugriff

		// Scope "Request"
		request.setAttribute("myKunde", kunden);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/kunden.jsp");
		dispatcher.forward(request, response);

	}

	private List<KundeBean> read(String nachname) throws ServletException {
		List<KundeBean> kunden = new ArrayList<KundeBean>();

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM customer WHERE nachname LIKE ?")) {

			pstmt.setString(1, nachname);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					KundeBean kunde = new KundeBean();

					Integer id = Integer.valueOf((rs.getInt("id")));
					kunde.setId(id);
					String vorname = rs.getString("vorname");
					kunde.setVorname(vorname);
					String n = rs.getString("nachname");
					kunde.setNachname(n);
					String email = rs.getString("email");
					kunde.setEmail(email);
					String telefonnummer = rs.getString("telefonnr");
					kunde.setTelefonnr(telefonnummer);
					String straﬂe = rs.getString("straﬂe");
					kunde.setStraﬂe(straﬂe);
					String gebdatum = rs.getString("gebdatum");
					kunde.setGebdatum(gebdatum);
					String password = rs.getString("passwort");
					kunde.setPasswort(password);
					Boolean admin = rs.getBoolean("admin");
					kunde.setAdmin(admin);
					String ort = rs.getString("ort");
					kunde.setOrt(ort);
					Integer plz = rs.getInt("plz");
					kunde.setPlz(plz);
					Integer hausnr = rs.getInt("hausnr");
					kunde.setHausnr(hausnr);
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
