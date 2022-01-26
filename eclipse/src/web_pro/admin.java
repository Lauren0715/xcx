package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class admin {
	String log="";
	String pwd="";
	String admin_name="";
	boolean admin_login(String Vlog,String Vpwd) {
		boolean loginok=false;
		Connection  conn = pub_fun.getConnection();
    	String Sql_str = "select * from admin where ad_log='"+Vlog+"' and ad_pwd='"+Vpwd+"' ";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
 				     loginok=true;
				}  
	        pstat.close();
	        conn.close();

 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	System.out.println(loginok);

		return loginok;
		
	}

}
