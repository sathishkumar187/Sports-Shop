package com.sportsshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.sportsshop.model.Product;

public class SportsShopDaoImp implements SportsShopDao {
	private static final String INSERT_PRODUCT = "insert into products (brand, name, price, size, manufacturedate, isdeleted) values (?, ?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_PRODUCT = "select * from products where isdeleted = ?";
	private static final String DELETE_PRODUCT = "update products set isdeleted = ? where brand = ? and name = ? and size = ?";
	private static final String UPDATE_PRODUCT = "update products set price = ? where brand = ? and name = ? and size = ? and isdeleted = ?";

	private static final DBConnection CONNECTION = new DBConnection();

	/**
	 * To add the product in database.
	 */
	public void addProduct(Product product) {

		try (final Connection connection = CONNECTION.getConnection();
				final PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);) {
			preparedStatement.setString(1, product.getBrand());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setString(4, String.valueOf(product.getSize()));
			preparedStatement.setDate(5, product.getManufactureDate());
			preparedStatement.setBoolean(6, false);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Couldn't Add The Product... \n    Please Try Again");
		}
	}

	/**
	 * To update the product price.
	 */
	public void updateProductPrice(Product product) {

		try (final Connection connection = CONNECTION.getConnection();
				final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);) {
			preparedStatement.setDouble(1, product.getPrice());
			preparedStatement.setString(2, product.getBrand());
			preparedStatement.setString(3, product.getName());
			preparedStatement.setString(4, String.valueOf(product.getSize()));
			preparedStatement.setBoolean(5, false);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Couldn't Update The Product... \n    Please Try Again");
		}
	}

	/**
	 * To remove the product from database.
	 */
	public void removeProduct(Product product) {

		try (final Connection connection = CONNECTION.getConnection();
				final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);) {
			preparedStatement.setBoolean(1, true);
			preparedStatement.setString(2, product.getBrand());
			preparedStatement.setString(3, product.getName());
			preparedStatement.setString(4, String.valueOf(product.getSize()));

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Couldn't Remove The Product... \n    Please Try Again");
		}
	}

	/**
	 * To retrieve all the products from database.
	 * 
	 * @return all products by list.
	 */
	public List<Product> selectAllProducts() {
		final List<Product> products = new ArrayList<>();

		try (final Connection connection = CONNECTION.getConnection();
				final PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
			preparedStatement.setBoolean(1, false);
			final ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				final Product product = new Product(rs.getString("name"), rs.getString("brand"), rs.getDouble("price"),
						rs.getString("size").charAt(0), rs.getDate("manufacturedate"));
				products.add(product);
			}
		} catch (SQLException e) {
			System.out.println("Couldn't Select The Products... \n    Please Try Again");
		}
		return products;
	}
}
