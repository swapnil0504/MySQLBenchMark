import java.sql.*;

class MySQLConenctor {
	
	public Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(
					"jdbc:mysql://192.168.41.18:3306/test", "root", "P@ssw0rd");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR while connecting MYSQL"+e.getMessage());
		}
		return con;
	}
	
}