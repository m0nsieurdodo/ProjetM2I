
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	
	private static String URL = "jdbc:mysql://localhost:3306/GIP?useSSL=false&serverTimezone=UTC";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	
	
	private static Connection connection;
	public static Connection getConnection() throws SQLException {
		if(connection ==null || connection.isClosed()) {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		//System.out.println("connecté à la base de données !");
		return connection;
	}
}
