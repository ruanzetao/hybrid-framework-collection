package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJTDSConnUtils {

	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "MSSQLSERVER";
		String dbName = "automationtest";
		String userName = "sa";
		String password = "Admin@123";
		return getSQLServerConnection(hostName, sqlInstanceName, dbName, userName, password);
	}

	public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String dbName, String username, String password) {
		Connection connection = null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String connectionUrl = "jdbc:sqlserver://" + hostName + ":1433/" + dbName + ";instance=" + sqlInstanceName;
			connection = DriverManager.getConnection(connectionUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
