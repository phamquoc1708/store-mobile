package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import model.Product;

@WebServlet(urlPatterns = {"/search"})
public class searchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public searchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String txtSearch = request.getParameter("txtSearch");
		DAO dao = new DAO();
		List<Product> list = dao.searchProduct(txtSearch);
		List<Product> listTop = dao.getTopProduct();
		
		if (list.isEmpty()) {
			request.setAttribute("listEmpty", "Sorry, we couldn't find any matches");
		} else {
			request.setAttribute("listP", list);
		}
		request.setAttribute("txtSearch", txtSearch);
		request.setAttribute("listTopProduct", listTop);			
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
