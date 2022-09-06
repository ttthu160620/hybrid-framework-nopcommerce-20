package jdbc.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
	public static Connection getMySQLConnection() {
		String hostName = "localhost";
		String dbName = "TESTING";
		String dbUername = "rooter";
		String dbPassword = "123456";
		return getMySQLConnection(hostName, dbName, dbUername, dbPassword);
	}
	
	private static Connection getMySQLConnection(String hostName, String dbName, String dbUername, String dbPassword) {
		Connection connect = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			connect = DriverManager.getConnection(connectionURL, dbUername, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection connect = getMySQLConnection();
		Statement statement = connect.createStatement();
		String sql = "select * from Employee where DEPT_ID = 3";
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			int employeeID = rs.getInt(1);
			String empFirstName = rs.getString("FIRST_NAME");
			
			System.out.println(employeeID);
			System.out.println(empFirstName);
		}
		connect.close();
	}
}
