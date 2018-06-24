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

		request.setCharacterEncoding("UTF-8");

		// Scope "Session"
		HttpSession session = request.getSession();
		session.setAttribute("titel", request.getParameter("titel"));

		System.out.println("jsp/" + session.getAttribute("titel") + ".jsp");
		request.getRequestURL();
		System.out.println(request.getRequestURL());

		request.getRequestDispatcher("jsp/" + session.getAttribute("titel") + ".jsp").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
