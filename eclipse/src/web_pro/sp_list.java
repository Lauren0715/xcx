package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sp_list {
	
	//----------------------------------------------------------------------
    public String sp_list_all(int PN){
        int pageSize=5;   
	    int beginnum=0;
        beginnum=(PN-1)*pageSize;
    	Connection  conn = pub_fun.getConnection();
    	String Sql_str = "select * from sp_data order by sp_id  limit "+beginnum+","+pageSize;
    	String Ostr="";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            { 
				        Ostr=Ostr+"<td>"+rs.getString("id")+"</td>";  
		                Ostr=Ostr+"<td>"+rs.getString("sp_name")+"</td>"; 
		                Ostr=Ostr+"<td>"+rs.getString("sp_id")+"</td>";
		                Ostr=Ostr+"<td>"+rs.getString("sp_price")+"</td>";  
		                Ostr=Ostr+"<td>"+rs.getString("sp_kuchun")+"</td>"; 
		                Ostr=Ostr+"<td>"+rs.getString("sp_info")+"</td>";  
		                Ostr=Ostr+"<td><a href='./HT_sp_show.jsp?spid="+rs.getString("sp_id")+"' class='tablelink'>详情</a> ";
		                Ostr=Ostr+"<a href='./sp_edit.jsp?spid="+rs.getString("sp_id")+"'  class='tablelink'>修改</a>";
		                Ostr=Ostr+"<a href='../sp_delok?spid="+rs.getString("sp_id")+"' class='tablelink'> 删除</a></td></tr>";
						}  
	        pstat.close();
	        conn.close();

 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	//System.out.println(Ostr);
		return Ostr;
	}  
  //----------------------------------------------------------------------
    public String  sp_listallpage(int PN){
        int pageSize=5;  
        int pageNow=1;   
	    int pageCount=0; 
        int Pprev=0;
        int Pnext=0;
        int rowCount=0;
        pageNow=PN;
    	Connection  conn = pub_fun.getConnection();
    	String Sql_str ="select  count(*) from sp_data ",Ostr="";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
	         rs.last(); //跳到最后一条数据 
	         rowCount=rs.getInt(1);	
	         if(rowCount%pageSize==0)   //计算总页面数  
	         {  
	         	  pageCount=rowCount/pageSize;  
	         } else {  
	         	  pageCount=rowCount/pageSize+1;    
	         } 
	         Pprev=pageNow-1;
	         Pnext=pageNow+1;
	         if(Pprev<1)
	         {
	             Pprev=1;
	         }
	         if(Pnext>pageCount)
	         {
	        	 Pnext=pageCount;
	         }

             pstat.close();
	         conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	//System.out.println(Ostr);
    	Ostr="<a href='HT_sp_list.jsp?PN="+Pprev+"'>上一页</a>";
    	Ostr+="&nbsp;&nbsp;&nbsp;&nbsp;<a href='HT_sp_list.jsp?PN="+Pnext+"'>下一页</a>";
		return Ostr;
	}  
    //----------------------------------------------------------------------
    public boolean sp_check(String spid,String spmingcheng){
    	Connection  conn = pub_fun.getConnection();
    	String Sql_str = "select * from sp_data ";
    	String Ostr="";
    	boolean Oboolean=false;
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
 				     Oboolean=true;
				}  
	        pstat.close();
	        conn.close();

 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	System.out.println(Oboolean);
		return Oboolean;
	}  
  //  ----------------------------------------------------------------------	
    
}
