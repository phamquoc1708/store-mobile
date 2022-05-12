package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import model.Orders;


@WebServlet("/PayController")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			HttpSession session = request.getSession();
			
			Orders orders = (Orders) session.getAttribute("order");
			
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String discount = request.getParameter("code");
			String phone = request.getParameter("phone");
			int status = 1;
			orders.setOrderId(orders.getOrderId() + 1);
			orders.setAddress(address);
			orders.setDiscount(discount);
			orders.setPhoneNumber(phone);
			orders.setStatus(status);
			orders.setUserMail(name);
			
			OrderDAO o = new OrderDAO();
			o.insertProduct(orders);
		} catch (Exception e) {
			
		}
		response.sendRedirect(request.getContextPath() + "/home");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
