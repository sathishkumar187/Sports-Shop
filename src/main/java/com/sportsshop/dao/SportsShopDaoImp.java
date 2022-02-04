package com.sportsshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.sportsshop.customexceptions.CustomException.UnableToAccessException;
import com.sportsshop.model.Product;

public class SportsShopDaoImp implements SportsShopDao {
    private static final String INSERT_PRODUCT = "insert into products (brand, name, price, size, manufacturedate, isdeleted) values (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_PRODUCT = "select brand, name, price, size, manufacturedate from products where isdeleted = ?";
    private static final String DELETE_PRODUCT = "update products set isdeleted = ? where brand = ? and name = ? and size = ?";
    private static final String UPDATE_PRODUCT = "update products set price = ? where brand = ? and name = ? and size = ? and isdeleted = ?";

    /**
     * To add the product in database.
     */
    public boolean addProduct(final Product product) {

        try (final Connection connection = DBConnection.getConnection(); final PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);) {
            preparedStatement.setString(1, product.getBrand());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, String.valueOf(product.getSize()));
            preparedStatement.setDate(5, product.getManufactureDate());
            preparedStatement.setBoolean(6, true);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new UnableToAccessException("Couldn't Add The Product... \n    Please Try Again");
        }
    }

    /**
     * To update the product price.
     */
    public boolean updateProductPrice(final Product product) {

        try (final Connection connection = DBConnection.getConnection(); 
                final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);) {
            preparedStatement.setDouble(1, product.getPrice());
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setString(3, product.getName());
            preparedStatement.setString(4, String.valueOf(product.getSize()));
            preparedStatement.setBoolean(5, true);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new UnableToAccessException("Couldn't Update The Product... \n    Please Try Again");
        }
    }

    /**
     * To remove the product from database.
     */
    public boolean removeProduct(final Product product) {

        try (final Connection connection = DBConnection.getConnection(); 
                final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);) {
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setString(3, product.getName());
            preparedStatement.setString(4, String.valueOf(product.getSize()));

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new UnableToAccessException("Couldn't Remove The Product... \n    Please Try Again");
        }
    }

    /**
     * To retrieve all the products from database.
     * 
     * @return all products by list.
     */
    public List<Product> selectAllProducts() {
    	ResultSet resultSet = null;
        try (final Connection connection = DBConnection.getConnection(); final PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            final List<Product> products = new ArrayList<Product>();
            
            preparedStatement.setBoolean(1, true);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                final Product product = new Product(resultSet.getString("name"), resultSet.getString("brand"), 
                		resultSet.getDouble("price"), resultSet.getString("size").charAt(0), resultSet.getDate("manufacturedate"));
                products.add(product);
            }
            return products;
        } catch (SQLException exception) {
            throw new UnableToAccessException("Couldn't Select The Products... \n    Please Try Again");
        } finally {
        	
            try {
				resultSet.close();
			} catch (SQLException exception) {
				throw new UnableToAccessException("Couldn't Select The Products... \n    Please Try Again");
			}
        }
    }
}
