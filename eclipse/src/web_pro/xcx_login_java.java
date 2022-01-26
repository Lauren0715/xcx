package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xcx_login_java {
 
	public int xcx_log(String Vlog,String Vpwd)
 {
	 int code=0;
		Connection  conn = pub_fun.getConnection();
 	String Sql_str = "select * from xcx_yh_info where yh_id='"+Vlog+"' and yh_pwd='"+Vpwd+"' ";
 	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
				     code=200;
				}  
	        pstat.close();
	        conn.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 	return code;
 }
 

}
