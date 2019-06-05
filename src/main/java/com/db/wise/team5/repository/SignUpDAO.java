package com.db.wise.team5.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Repository;

import com.db.wise.team5.model.User;

@Repository
public class SignUpDAO {

	public boolean createUserInDatabase(User user) {
		if (!userExists(user)) {
			return createUser(user);
		}
		return false;
	}

	private boolean createUser(User user) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("INSERT INTO account (password, email,created_on) VALUES (" +user.getPassword() +","+user.getEmail()+", new Date())");
			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (ClassNotFoundException | SQLException e) {

		} finally {
			try {
				statement.close();
				connection.close();

			} catch (SQLException e) {
				System.out.println("Exception while closing the connection in wiseWuestioRepository java file");
			}
		}
		return false;
	}

	private boolean userExists(User user) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("select * from account a where a.email = ?");
			statement.setString(1, user.getEmail());
			ResultSet result = statement.executeQuery();
			return result.next();
		} catch (ClassNotFoundException | SQLException e) {

		} finally {
			try {
				statement.close();
				connection.close();

			} catch (SQLException e) {
				System.out.println("Exception while closing the connection in wiseWuestioRepository java file");
			}
		}
		return false;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("org.postgresql.Driver");
		String hostName = "team5db1.postgres.database.azure.com";
		String dbName = "postgres";
		String user = "team5@team5db1";
		String password = "CaryHack!";
		Connection connection = null;

		try {
			String url = String.format("jdbc:postgresql://%s/%s", hostName, dbName);
			// set up the connection properties
			Properties properties = new Properties();
			properties.setProperty("user", user);
			properties.setProperty("password", password);
			properties.setProperty("ssl", "false");

			// get connection
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			throw new SQLException("Failed to create connection to database.", e);
		}

		if (connection != null) {
			return connection;
		} else {
			throw new SQLException("Unable to coonect to AZURE DATABASE from Wise APP!");
		}

	}

}
