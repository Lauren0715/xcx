package web_pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class pub_fun {
	//public String pub01="hello world jsp";
	//public String pub01="<a   >  go to step2 </a>";
	
	
	//---------------------------------------------------------------------		
		public static Connection getConnection(){
			String driver="com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/Z_web";
			//String  url = "jdbc:mysql://localhost:13306/xy_system";  //服务器
			Connection con = null;
			 try {
		        Class.forName(driver);
		        try {
		        	//con = DriverManager.getConnection(url,"root","root");
		        	con = DriverManager.getConnection(url,"root","OTgood30");
		        } catch (SQLException e) {
			         e.printStackTrace();
			    }
			  } catch (ClassNotFoundException e) {
			    e.printStackTrace();
			  }
		     return con;
		};

	//---------------------------------------------------------------------	
}
