package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;


/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		try {
			request.getSession(true).invalidate();
			
			String regexMail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			
			Account acc = new Account();
			acc.setUsr(user);
			acc.setPwd(password);
			
			HttpSession session = request.getSession();
			
			if (!password.matches(regex) || !user.matches(regexMail)) {
				session.setAttribute("error", "Invalid syntax");
				response.sendRedirect("login.jsp");
			}
			
			String uid = getServletContext().getInitParameter("username");
			String pwd = getServletContext().getInitParameter("password");

			if (user != null && password.equals(pwd) && user.equalsIgnoreCase(uid)) {
				session.setAttribute("user", user);
			
				
				response.sendRedirect("admin/index.jsp");
			} else {
				session.setAttribute("error", "Wrong username or password");
				response.sendRedirect("login.jsp");
			}

		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}

}
