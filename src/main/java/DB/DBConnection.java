package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection CreatConnection() throws SQLException 
	{
		Connection conn = null;
//		String url ="jdbc:mysql://localhost:3306/examplebai23";
		String username="root";
		String password="30032001";
		
		try {
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Create connection
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/signup", username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}