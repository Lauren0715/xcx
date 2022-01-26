package web_pro;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class shangpin {
	private String spid="";
	private String spname="";
	private String spinfo="";
	private int spjiage=0;
	
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getSpinfo() {
		return spinfo;
	}
	public void setSpinfo(String spinfo) {
		this.spinfo = spinfo;
	}
	public int getSpjiage() {
		return spjiage;
	}
	public void setSpjiage(int spjiage) {
		this.spjiage = spjiage;
	}
	
	public String xcx_splist() {
		Connection  conn = pub_fun.getConnection();
    	String Sql_str = "select * from xcx_sp_data order by spid ";
    	String Ostr="[";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
				Ostr=Ostr+"{\"spid\":\""+rs.getString("spid")+"\","; 
				Ostr=Ostr+"\"spname\":\""+rs.getString("spname")+"\","; 
				Ostr=Ostr+"\"spinfo\":\""+rs.getString("spinfo")+"\","; 
				Ostr=Ostr+"\"spjiage\":\""+rs.getString("spjiage")+"\","; 
				Ostr=Ostr+"\"spjpg\":\""+rs.getString("spjpg")+"\"},";
                
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
		
	
	
	public String xcx_spinfo(int Vmessage) {
		Connection  conn = pub_fun.getConnection();
    	String Sql_str = "select * from xcx_sp_data where spid="+Vmessage+" ";
    	String Ostr="";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
				Ostr=Ostr+"{\"spid\":\""+rs.getString("spid")+"\","; 
				Ostr=Ostr+"\"spname\":\""+rs.getString("spname")+"\","; 
				Ostr=Ostr+"\"spinfo\":\""+rs.getString("spinfo")+"\","; 
				Ostr=Ostr+"\"spjiage\":\""+rs.getString("spjiage")+"\","; 
				Ostr=Ostr+"\"spjpg\":\""+rs.getString("spjpg")+"\"}";
                
						}  
	        pstat.close();
	        conn.close();

 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	System.out.println(Ostr);
		return Ostr;
	}
	
	

}
