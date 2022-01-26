package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XW {

	
	
	   
	    void XW_addok(String Vtopic,String Vkeyword) {
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="insert  into XW_data(XW_topic,XW_keyword)";
        sql+=" values(?,?)";
        try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vtopic);
	        stmt.setString(2,Vkeyword);
	        stmt.executeUpdate();
	        System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
        //response.getWriter().append("<script>alert('新闻增加已完成');window.location.href=\"./admin/HT_xw_list.jsp\";</script>");
       }
	    
	    
	    void XW_delok(String Vid) {
	    	Connection  conn = pub_fun.getConnection();
			PreparedStatement stmt = null;
			String sql="delete from XW_data where XW_id = ?";
			
	        try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1,Integer.parseInt(Vid));
		        stmt.executeUpdate();
		        System.out.println("delete success");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	    }
	    public void XW_editok(String Vtopic,String Vkeyword,String Vid)
	    {
	    Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="update XW_data set XW_topic=?,XW_keyword=? where XW_id=?";
        try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vtopic);
	        stmt.setString(2,Vkeyword);
	        stmt.setInt(3,Integer.parseInt(Vid));
	        stmt.executeUpdate();
	        System.out.println(" Update success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }	
	    }
	    
	    public String XW_list() {
	    	Connection  conn = pub_fun.getConnection();
	    	String Sql_str = "select * from XW_data order by XW_id  desc ";
	    	String Ostr="";
	    	try {
				PreparedStatement pstat = conn.prepareStatement(Sql_str);
				ResultSet rs = (ResultSet) pstat.executeQuery();
				while(rs.next())  
		            {  
							Ostr=Ostr+"<tr><td>"+rs.getString("XW_id")+"</td>"; 
			                Ostr=Ostr+"<td>"+rs.getString("XW_topic")+"</td>";   
			                Ostr=Ostr+"<td>"+rs.getString("XW_keyword")+"</td>";  
			                Ostr=Ostr+"<td><a href='./HT_xw_show.jsp?XWid="+rs.getString("XW_id")+"' class='tablelink'>详情</a> ";
			                Ostr=Ostr+"<a href='./XW_edit.jsp?XWid="+rs.getString("XW_id")+"'  class='tablelink'>修改</a>";
			                Ostr=Ostr+"<a href='../XW_delok?XWid="+rs.getString("XW_id")+"' class='tablelink'> 删除</a></td></tr>";

							}  
		        pstat.close();
		        conn.close();

	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	//System.out.println(Ostr);
			return Ostr;
	    }
	    
	    
}
