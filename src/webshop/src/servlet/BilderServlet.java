
package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
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

@WebServlet("/BilderServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5
		* 5, location = "/tmp", fileSizeThreshold = 1024 * 1024)
public class BilderServlet extends HttpServlet {
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
		BilderBean bild = new BilderBean();
		bild.setBez(request.getParameter("bez"));
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
		// Scope "Request"
		request.setAttribute("myBild", bild);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/bilder.jsp");
		dispatcher.forward(request, response);
	}

	private void persist(BilderBean b) throws ServletException {
		// String [] neuerKunde = new String[] {"id",
		// "firstname","lastname","email","telefonnummer", "Straﬂe"};
		String[] generatedKeys = new String[] { "id" };
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO bilder (bez, file, imageFileName) VALUES (?, ?, ?)", generatedKeys)) {
			pstmt.setString(1, b.getBez());
			pstmt.setBytes(2, b.getFile());
			pstmt.setString(3, b.getImageFileName());
			pstmt.executeUpdate();

		} catch (

		Exception ex) {
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
