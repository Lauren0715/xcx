package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sp_edit {
	
	private int listid=0;
	private String spid="";
	private String spname="";
	private String spprice="";
	private String spkucun="";
	private String spinfo="";
	

	public String getspid() {
		return spid;
	}
	public void setspid(String spid) {
		this.spid = spid;
	}
	public String getspname() {
		return spname;
	}
	public void setspname(String spname) {
		this.spname = spname;
	}
	public String getspprice() {
		return spprice;
	}
	public void setspprice(String spprice) {
		this.spprice = spprice;
	}
	public String getspkucun() {
		return spkucun;
	}
	public void setspkucun(String spkucun) {
		this.spkucun = spkucun;
	}
	
	
	
	public String getId() {
		return spid;
	}
	public void setId(String Vspid) {
//	对接bean	<jsp:setProperty  name="XW_edit" property="id"   value="123456"/> 
		this.spid = Vspid;
		 System.out.println("this.sp_id ="+this.spid);
		 sp_get(this.spid);
	}

	
	
	
	//----------------------------------------------------------------------
    public void sp_get(String Vspid){
    	Connection  conn = pub_fun.getConnection();
    	String Sql_str = "select * from sp_data where sp_id="+Vspid+"   ";
    	boolean Oboolean=false;
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
				this.setspid(rs.getString("sp_id"));
				this.setspname(rs.getString("sp_name"));
				}  
	        pstat.close();
	        conn.close();

 
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public String getname() {
		return spname;
	}
	public void setname(String Vspname) {
		this.spname = Vspname;
	} 

}
