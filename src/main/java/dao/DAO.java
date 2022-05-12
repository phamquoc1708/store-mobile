package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class DAO {
	
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		String query = "select * from Products";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
				
		} catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public List<Product> getTopProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select top 3 * from Products order by product_id";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public Product getProductByID(String id) {
		String query = "select * from Products where product_id = ?";
		
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						);
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public List<Product> searchProduct(String txt) {
		List<Product> list = new ArrayList<>();
		String query = "select * from Products where product_name like ?";
		try {
			connection = new DBContext().getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, "%" + txt + "%");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
			
		} catch (Exception e) {
			
		}
		
		return list;
	}
	
}
