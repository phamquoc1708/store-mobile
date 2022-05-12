package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import model.Orders;
import model.Product;
import model.ProductOrders;

@WebServlet("/AddToCart")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String idProduct;
		DAO dao = new DAO();
		float total;
		try {
			if (request.getParameter("id") != null) {
				idProduct = request.getParameter("id");
				Product product = dao.getProductByID(idProduct);
				if (product != null) {
					HttpSession session = request.getSession();
					if (session.getAttribute("order") == null) {
						Orders order = new Orders();
						List<ProductOrders> listProduct = new ArrayList<>();
						ProductOrders productOrder = new ProductOrders();
						productOrder.setAmountProduct(1);
						productOrder.setProduct(product);
						productOrder.setPrice(product.getPrice());
						
						listProduct.add(productOrder);
						order.setLp(listProduct);
						total = order.totalPrice();
						session.setAttribute("total", total);
						session.setAttribute("order", order);
					} else {
						Orders order = (Orders) session.getAttribute("order");
						List<ProductOrders> listProduct = order.getLp();
						boolean check = false;
						for (ProductOrders p : listProduct) {
							if (p.getProduct().getId() == product.getId()) {
								p.setAmountProduct(p.getAmountProduct() + 1);
								check = true;
							}
						}
						
						if (!check) {
							ProductOrders productO = new ProductOrders();
							productO.setAmountProduct(1);
							productO.setProduct(product);
							productO.setPrice(product.getPrice());
							listProduct.add(productO);
							order.setLp(listProduct);
						}
						total = order.totalPrice();
						session.setAttribute("total", total);
						session.setAttribute("order", order);
					}
				}
			}
			
			response.sendRedirect(request.getContextPath() + "/home");
		} catch(Exception e) {
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
