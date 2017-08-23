package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static String url ="jdbc:mysql://localhost/example";
	private static String user = "root";
	private static String pass ="papiyon2491";

	public static Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, pass);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
