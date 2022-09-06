package jdbc.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MSSQLConnection {
	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "MSSQLSERVER";
		String dbName = "TESTING";
		String dbUername = "sa";
		String dbPassword = "123";
		return getSQLServerConnection(hostName, sqlInstanceName, dbName, dbUername, dbPassword);
	}
	
	private static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String dbName, String dbUername, String dbPassword) {
		Connection connect = null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";instance=" + sqlInstanceName + ";databaseName=" + dbName;
			String jtdsConnectionUrl = "jdbc:jtds:sqlserver://localhost:1433/TESTING;instance=MSSQLSERVER";
			connect = DriverManager.getConnection(jtdsConnectionUrl, dbUername, dbPassword);
			System.out.println("Connect SQL to success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection connect = getSQLServerConnection();
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
