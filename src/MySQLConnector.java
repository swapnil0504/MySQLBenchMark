import java.sql.*;

class MySQLConenctor {
	
	public Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db", "user", "password");
		}catch(Exception e){
			System.out.println("ERROR while connecting MYSQL");
		}
		return con;
	}
	
}