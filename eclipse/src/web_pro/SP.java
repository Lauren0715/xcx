package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SP {
	
	void sp_addok(String Vid,String Vname,String Vprice,String Vkucun,String Vinfo )
	{
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="insert into sp_data(sp_name,sp_id,sp_price,sp_kucun,sp_info)";
        sql+=" values(?,?,?,?,?)";
        try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vname);
	        stmt.setString(2,Vid);
	        stmt.setString(3,Vprice);
	        stmt.setString(4,Vkucun);
	        stmt.setString(5,Vinfo);
	        stmt.executeUpdate();
	        System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	void sp_delok(String Vsp_id)
	{
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="delete from sp_data where sp_id = ?";
		
        try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,Integer.parseInt(Vsp_id));
	        stmt.executeUpdate();
	        System.out.println("delete success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

}
