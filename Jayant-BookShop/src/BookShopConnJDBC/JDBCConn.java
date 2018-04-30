package BookShopConnJDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class JDBCConn {
	final String JDBCUserName = "root";
	final String JDBCPassWord = "123456";
	final String ConnectUrlStr = "jdbc:mysql://127.0.0.1:3306/yourbookshop";
	private Connection conn = null;
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public JDBCConn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			try{
				conn=(Connection)DriverManager.getConnection(ConnectUrlStr,JDBCUserName,JDBCPassWord);
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			if(conn==null){
				
			}
			else{
				
			}
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
}
