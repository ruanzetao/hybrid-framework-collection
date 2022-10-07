package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLUtils {

	public static Connection getMySQLConnection() {
		String hostName = "localhost";
		String dbName = "automationtest";
		String username = "root";
		String password = "";
		return getMySQLConnection(hostName, dbName, username, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String username, String password) {
		Connection connection = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			connection = DriverManager.getConnection(connectionUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
