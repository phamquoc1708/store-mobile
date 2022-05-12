package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import context.DBContext;
import model.Orders;
import model.ProductOrders;

public class OrderDAO {
	Connection connection = null;
	PreparedStatement ps = null;
	PreparedStatement psDetail = null;
	public void insertProduct(Orders orders) {
		try {
			String query = "SET IDENTITY_INSERT Orders ON\r\n"
					+ "insert into Orders(user_mail, order_id, order_status, order_discount_code, order_address)\r\n"
					+ "values (?, ?, ?, ?, ?)";
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, orders.getUserMail());
			ps.setInt(2, orders.getOrderId());
			ps.setInt(3, 1);
			ps.setString(4, orders.getDiscount());
			ps.setString(5, orders.getAddress());
			ps.executeUpdate();
			ps.close();
			
			List<ProductOrders> lp = orders.getLp();
			
			for (ProductOrders p : lp) {
				String quertDetail = "insert into Orders_detail(order_id, product_id, amount_product, price_product) "
						+ "values (?, ?, ?, ?)";
				psDetail = connection.prepareStatement(quertDetail);
				psDetail.setInt(1, orders.getOrderId());
				psDetail.setInt(2, p.getProduct().getId());
				psDetail.setInt(3, p.getAmountProduct());
				float price = (float) (Math.round(p.getProduct().getPrice() * 100) / 100);
				psDetail.setFloat(4, price);
				psDetail.executeUpdate();
				psDetail.close();
			}
			connection.close();
			System.out.println("Success");
		} catch (Exception e) {
			
		}
	}
	
}
