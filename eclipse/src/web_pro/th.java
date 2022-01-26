package web_pro;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class th {
	public int editphone(String Vnum,String Vopenid) {
		
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="update th_userinfo set phone=? where openid=?";
        try {
        	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vnum);
	        stmt.setString(2,Vopenid);
	        stmt.executeUpdate();
	        System.out.println(Vnum);
	        System.out.println("Update success");
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
        return 200;
	}
 public int editemail(String Vnum,String Vopenid) {
		
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="update th_userinfo set email=? where openid=?";
        try {
        	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vnum);
	        stmt.setString(2,Vopenid);
	        stmt.executeUpdate();
	        System.out.println(Vnum);
	        System.out.println("Update success");
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
        return 200;
	}
 
 public String list_dingdan(String openid){
	 Connection  conn = pub_fun.getConnection();
 	String Sql_str = "select * from th_dingdan where openid=?";
 	String Ostr="[";
 	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			pstat.setNString(1, openid);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
				
				Ostr=Ostr+"{\"location\":\""+rs.getString("location")+"\","; 
				Ostr=Ostr+"\"time\":\""+rs.getString("time")+"\","; 
				Ostr=Ostr+"\"people\":\""+rs.getString("people")+"\","; 
				Ostr=Ostr+"\"situation\":\""+rs.getString("situation")+"\",";
				Ostr=Ostr+"\"tupian\":\""+rs.getString("tupian")+"\","; 
				Ostr=Ostr+"\"price\":\""+rs.getString("price")+"\"},";
             
						}  
			Ostr=Ostr+"]";
			Ostr=Ostr.replace("},]", "}]");
	        pstat.close();
	        conn.close();


     } catch (SQLException e) {
         e.printStackTrace();
     }
 	System.out.println(Ostr);
 	return Ostr;
	}  

 public String unpay_dingdan(String openid){
	 Connection  conn = pub_fun.getConnection();
 	String Sql_str = "select * from th_dingdan where openid=? and situation=?";
 	String Ostr="[";
 	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			pstat.setNString(1, openid);
			pstat.setNString(2, "待支付订单");
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next()) 
	            {  
				Ostr=Ostr+"{\"id\":\""+rs.getString("id")+"\","; 
				Ostr=Ostr+"\"location\":\""+rs.getString("location")+"\","; 
				Ostr=Ostr+"\"time\":\""+rs.getString("time")+"\","; 
				Ostr=Ostr+"\"people\":\""+rs.getString("people")+"\","; 
				Ostr=Ostr+"\"situation\":\""+rs.getString("situation")+"\",";
				Ostr=Ostr+"\"tupian\":\""+rs.getString("tupian")+"\","; 
				Ostr=Ostr+"\"price\":\""+rs.getString("price")+"\"},";
				
						}  
			Ostr=Ostr+"]";
			Ostr=Ostr.replace("},]", "}]");
	        pstat.close();
	        conn.close();


     } catch (SQLException e) {
         e.printStackTrace();
     }
 	System.out.println(Ostr);
 	return Ostr;
	}  

 public String youxiao_dingdan(String openid){
	 Connection  conn = pub_fun.getConnection();
 	String Sql_str = "select * from th_dingdan where openid=? and situation=?";
 	String Ostr="[";
 	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			pstat.setNString(1, openid);
			pstat.setNString(2, "订单已完成");
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next()) 
	            {  
				
				Ostr=Ostr+"{\"location\":\""+rs.getString("location")+"\","; 
				Ostr=Ostr+"\"time\":\""+rs.getString("time")+"\","; 
				Ostr=Ostr+"\"people\":\""+rs.getString("people")+"\","; 
				Ostr=Ostr+"\"situation\":\""+rs.getString("situation")+"\",";
				Ostr=Ostr+"\"tupian\":\""+rs.getString("tupian")+"\","; 
				Ostr=Ostr+"\"price\":\""+rs.getString("price")+"\"},";
				
						}  
			Ostr=Ostr+"]";
			Ostr=Ostr.replace("},]", "}]");
	        pstat.close();
	        conn.close();


     } catch (SQLException e) {
         e.printStackTrace();
     }
 	System.out.println(Ostr);
 	return Ostr;
	}  
 

 void fk_gnfk(String Vdetail,String Vphone) {
	Connection  conn = pub_fun.getConnection();
	PreparedStatement stmt = null;
	String sql="insert  into fk_gnyc(detail,phone)";
 sql+=" values(?,?)";
 try {
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,Vdetail);
     stmt.setString(2,Vphone);
     stmt.executeUpdate();
     System.out.println("success");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
 //response.getWriter().append("<script>alert('新闻增加已完成');window.location.href=\"./admin/HT_xw_list.jsp\";</script>");
}
 
 void fk_zfwt(String Vdetail,String Vphone) {
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="insert  into fk_zfwt(detail,phone)";
	 sql+=" values(?,?)";
	 try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vdetail);
	     stmt.setString(2,Vphone);
	     stmt.executeUpdate();
	     System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
 void fk_wgjb(String Vdetail,String Vphone) {
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="insert  into fk_wgjb(detail,phone)";
	 sql+=" values(?,?)";
	 try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vdetail);
	     stmt.setString(2,Vphone);
	     stmt.executeUpdate();
	     System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
	}
 void fk_cpjy(String Vdetail,String Vphone) {
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="insert  into fk_cpjy(detail,phone)";
	 sql+=" values(?,?)";
	 try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vdetail);
	     stmt.setString(2,Vphone);
	     stmt.executeUpdate();
	     System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
	}
 public String findhouse(String address){
	 Connection  conn = pub_fun.getConnection();
 	String Sql_str = "select * from th_dingdan where openid=? and situation=?";
 	String Ostr="[";
 	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			pstat.setNString(1, address);
			pstat.setNString(2, "待支付订单");
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next()) 
	            {  

				Ostr=Ostr+"{\"address\":\""+rs.getString("address")+"\","; 
				Ostr=Ostr+"\"location\":\""+rs.getString("location")+"\","; 
				Ostr=Ostr+"\"time\":\""+rs.getString("time")+"\","; 
				Ostr=Ostr+"\"people\":\""+rs.getString("people")+"\","; 
				Ostr=Ostr+"\"situation\":\""+rs.getString("situation")+"\",";
				Ostr=Ostr+"\"tupian\":\""+rs.getString("tupian")+"\","; 
				Ostr=Ostr+"\"price\":\""+rs.getString("price")+"\"},";
				
						}  
			Ostr=Ostr+"]";
			Ostr=Ostr.replace("},]", "}]");
	        pstat.close();
	        conn.close();


     } catch (SQLException e) {
         e.printStackTrace();
     }
 	System.out.println(Ostr);
 	return Ostr;
	}  
 
 public String zhifu(String id){
	 Connection  conn = pub_fun.getConnection();
 	String Sql_str = "select * from th_dingdan where id=? ";
 	String Ostr="{";
 	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			pstat.setNString(1, id);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next()) 
	            {  
				Ostr=Ostr+"\"address\":\""+rs.getString("address")+"\","; 
				Ostr=Ostr+"\"location\":\""+rs.getString("location")+"\","; 
				Ostr=Ostr+"\"time\":\""+rs.getString("time")+"\","; 
				Ostr=Ostr+"\"people\":\""+rs.getString("people")+"\","; 
				Ostr=Ostr+"\"tupian\":\""+rs.getString("tupian")+"\","; 
				Ostr=Ostr+"\"price\":\""+rs.getString("price")+"\"}";
						}  
			
	        pstat.close();
	        conn.close();
	        System.out.println(Ostr);


     } catch (SQLException e) {
         e.printStackTrace();
     }
 	System.out.println(Ostr);
 	return Ostr;
	}  

 
 void th_xinxi(String Vname,String Vnum,String Vid) {
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="update  th_dingdan set booker=?,num=? where id=?";
	 
	 try {
		 stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vname);
	        stmt.setString(2,Vnum);
	        stmt.setString(3,Vid);
	        stmt.executeUpdate();
	       
	        System.out.println("Update success");
		 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
	}
 
 public String zhifu2(String id){
	 Connection  conn = pub_fun.getConnection();
 	String Sql_str = "select * from th_dingdan where id=? ";
 	String Ostr="{";
 	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			pstat.setNString(1, id);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next()) 
	            {  
				Ostr=Ostr+"\"address\":\""+rs.getString("address")+"\","; 
				Ostr=Ostr+"\"location\":\""+rs.getString("location")+"\","; 
				Ostr=Ostr+"\"time\":\""+rs.getString("time")+"\","; 
				Ostr=Ostr+"\"people\":\""+rs.getString("people")+"\","; 
				Ostr=Ostr+"\"tupian\":\""+rs.getString("tupian")+"\","; 
				Ostr=Ostr+"\"booker\":\""+rs.getString("booker")+"\","; 
				Ostr=Ostr+"\"num\":\""+rs.getString("num")+"\","; 
				Ostr=Ostr+"\"price\":\""+rs.getString("price")+"\"}";
						}  
			
	        pstat.close();
	        conn.close();
	        System.out.println(Ostr);


     } catch (SQLException e) {
         e.printStackTrace();
     }
 	System.out.println(Ostr);
 	return Ostr;
	}  


}
