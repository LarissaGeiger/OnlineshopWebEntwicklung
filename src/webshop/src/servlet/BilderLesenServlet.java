package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.BilderBean;

/**
 * Servlet implementation class Demo08aServlet
 */
@WebServlet("/BilderLesenServlet")
public class BilderLesenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");	
		// Auskommentierter Code für ID-Suche statt Bez
//		Integer id = Integer.valueOf(request.getParameter("id"));
//	
//		String filename = request.getParameter("filename");
		String filename = request.getParameter("bez");
		// DB-Zugriff
		try (Connection con = ds.getConnection();
//			 PreparedStatement pstmt = con.prepareStatement("SELECT bez,file FROM bilder WHERE imageFileName = ?") ) {
//			pstmt.setString(1, filename);
				 PreparedStatement pstmt = con.prepareStatement("SELECT file FROM bilder WHERE bez = ?") ) {
			pstmt.setString(1, filename);
			try (ResultSet rs = pstmt.executeQuery()) {
			
				if (rs != null && rs.next()) {
//					String bez = rs.getString("bez");
					Blob file = rs.getBlob("file");
					response.reset();
					long length = file.length();
					response.setContentType("application/octet-stream");
					response.setHeader("Content-Length",String.valueOf(length));
					
//					response.setHeader("Content-Disposition", "attachment; filename=\"" + bez + "\"");
					response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
					try (InputStream in = file.getBinaryStream()) {
						final int bufferSize = 256;
						byte[] buffer = new byte[bufferSize];
						
						ServletOutputStream out = response.getOutputStream();
						while ((length = in.read(buffer)) != -1) {
							out.write(buffer,0,(int) length);
						}
						out.flush();
					}
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
