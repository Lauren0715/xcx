package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sp_show_bean {
	
	String id="",sp_name="",sp_id="",sp_price="",sp_kuchun="",sp_info;
	
	public String get_id() {
		return id;   
	}
	public String get_sp_id() {
		return sp_id;   
	}
	public String get_sp_name() {
		return sp_name;   
	}
	public String get_sp_price() {
		return sp_price;   
	}
	public String get_sp_kuchun() {
		return sp_kuchun;   
	}
	public String get_sp_info() {
		return sp_info;   
	}
	
	//--------------------------------------------
	public void setsp_id(String id001) {
		this.id=id001;
		this.sp_name=sp_check(id001,"");
		
		
		//System.out.print(this.sp_id);
	}
	//----------------------------------------------------------------------
    public String sp_check(String spid,String spname){
    	Connection  conn = pub_fun.getConnection();
    	String Sql_str = "select * from sheet1 where sp_id= '  "+spid+"  ' ";
    	String Ostr="没找到";
    	boolean Oboolean=false;
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
				Ostr="找到";
				this.sp_name=rs.getString("sp_name");
				}  
	        pstat.close();
	        conn.close();

 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	System.out.println(Ostr);
		return Ostr;
	}  
	//--------------------------------------------
		public void setsp_mingcheng(String spname) {
			this.sp_name=spname;
			System.out.print(this.sp_name);
		}
	//--------------------------------------------
}
