package utils;

import java.sql.*;

public class DBUtils {

	private static Connection connection;
	private static Statement statement;

	public static void DatabaseConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/?user=root";
			String username = "root";
			String password = "Bikram@1234";

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("DataBase Connection Sucessfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String executeQuery(String query) {
		StringBuilder result = new StringBuilder();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Get column count dynamically
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					result.append(metaData.getColumnName(i)).append(": ").append(rs.getString(i)).append(" | ");
				}
				result.append("\n");
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public static void closeConnection() {
		try {
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
			System.out.println("Database Connection Closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
