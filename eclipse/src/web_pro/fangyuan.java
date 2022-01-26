package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fangyuan {
	private String FYID="";
	private String FYTP="";
	private String FYDZ="";
	private String FYMC="";
	private String FYJG="";
	private String FYPF="";
	public String getFYID() {
		return FYID;
	}
	public void setFYID(String fYID) {
		FYID = fYID;
	}
	public String getFYTP() {
		return FYTP;
	}
	public void setFYTP(String fYTP) {
		FYTP = fYTP;
	}
	public String getFYDZ() {
		return FYDZ;
	}
	public void setFYDZ(String fYDZ) {
		FYDZ = fYDZ;
	}
	public String getFYMC() {
		return FYMC;
	}
	public void setFYMC(String fYMC) {
		FYMC = fYMC;
	}
	public String getFYJG() {
		return FYJG;
	}
	public void setFYJG(String fYJG) {
		FYJG = fYJG;
	}
	public String getFYPF() {
		return FYPF;
	}
	public void setFYPF(String fYPF) {
		FYPF = fYPF;
	}

public String xcx_FYlist() {
     	
//		json01=json01+"{\"SPID\":\"43101\", \"SPMC\":\"商品01\", \"SPJG\":\"32\", \"SPKC\":\"43\"}";
//		return json01;
		
		Connection  conn = pub_fun.getConnection();
		
    	String Sql_str = "select * from fy_data order by fyid desc";
    	String json01="[";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();	
			while(rs.next())  
	            {  
			
 
				json01=json01+"{\"FYID\":\""+rs.getString("fyid")+"\",";  
				json01=json01+"\"FYTP\":\""+rs.getString("fytp")+"\","; 
				json01=json01+"\"FYDZ\":\""+rs.getString("fydz")+"\","; 
				json01=json01+"\"FYMC\":\""+rs.getString("fymc")+"\","; 
				json01=json01+"\"FYJG\":\""+rs.getString("fyjg")+"\",";  
				json01=json01+"\"room\":\""+rs.getString("room")+"\","; 
				json01=json01+"\"common\":\""+rs.getString("common")+"\","; 
				json01=json01+"\"bb1\":\""+rs.getString("bb1")+"\","; 
				json01=json01+"\"bb2\":\""+rs.getString("bb2")+"\","; 
				json01=json01+"\"discount\":\""+rs.getString("discount")+"\","; 
				json01=json01+"\"FYPF\":\""+rs.getString("fypf")+"\"},";  
//				json01=json01+"<td><a href='./HT_sp_show.jsp?spid="+rs.getString("sp_id")+"' class='tablelink'>详情</a> ";
//				json01=json01+"<a href='./sp_edit.jsp?spid="+rs.getString("sp_id")+"'  class='tablelink'>修改</a>";
//				json01=json01+"<a href='../sp_delok?spid="+rs.getString("sp_id")+"' class='tablelink'> 删除</a></td></tr>";
						}  
			json01=json01+"]";
			json01=json01.replace("},]", "}]");
	        pstat.close();
	        conn.close();

 System.out.println(json01);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     
		return json01;
	}  

public String xcx_FYinfo(String FYMC) {
	
	String json01="";
	
	 Connection  conn = pub_fun.getConnection();
	 	String Sql_str = "select * from fy_data where fymc=? ";
	 	String Ostr="{";
	 	try {
				PreparedStatement pstat = conn.prepareStatement(Sql_str);
				pstat.setNString(1, FYMC);
				ResultSet rs = (ResultSet) pstat.executeQuery();
		while(rs.next())  
            {  
			json01=json01+"{\"FYMC\":\""+rs.getString("fymc")+"\",";  
			json01=json01+"\"FYPF\":\""+rs.getString("fypf")+"\","; 
			json01=json01+"\"FYDZ\":\""+rs.getString("fydz")+"\","; 
			json01=json01+"\"bb1\":\""+rs.getString("bb1")+"\","; 
			json01=json01+"\"bb2\":\""+rs.getString("bb2")+"\",";  
			json01=json01+"\"room\":\""+rs.getString("room")+"\","; 
			json01=json01+"\"common\":\""+rs.getString("common")+"\","; 
			json01=json01+"\"bed\":\""+rs.getString("bed")+"\","; 
			json01=json01+"\"toilet\":\""+rs.getString("toilet")+"\","; 
			json01=json01+"\"FJSL\":\""+rs.getString("fjsl")+"\","; 
			json01=json01+"\"FKSL\":\""+rs.getString("fksl")+"\","; 
			json01=json01+"\"FYJS\":\""+rs.getString("fyjs")+"\","; 
			json01=json01+"\"FKTP\":\""+rs.getString("fktp")+"\","; 
			json01=json01+"\"FKMC\":\""+rs.getString("fkmc")+"\","; 
			json01=json01+"\"FKPJ\":\""+rs.getString("fkpj")+"\","; 
			json01=json01+"\"year\":\""+rs.getString("year")+"\","; 
			json01=json01+"\"month\":\""+rs.getString("month")+"\","; 
			json01=json01+"\"longitude\":\""+rs.getString("longitude")+"\","; 
			json01=json01+"\"latitude\":\""+rs.getString("latitude")+"\","; 
			json01=json01+"\"mrt1\":\""+rs.getString("mrt1")+"\","; 
			json01=json01+"\"place1\":\""+rs.getString("place1")+"\","; 
			json01=json01+"\"station1\":\""+rs.getString("station1")+"\","; 
			json01=json01+"\"mrt2\":\""+rs.getString("mrt2")+"\","; 
			json01=json01+"\"place2\":\""+rs.getString("place2")+"\","; 
			json01=json01+"\"station2\":\""+rs.getString("station2")+"\",";
			json01=json01+"\"m1\":\""+rs.getString("m1")+"\",";
			json01=json01+"\"p1\":\""+rs.getString("p1")+"\",";
			json01=json01+"\"s1\":\""+rs.getString("s1")+"\",";
			json01=json01+"\"m2\":\""+rs.getString("m2")+"\",";
			json01=json01+"\"p2\":\""+rs.getString("p2")+"\",";
			json01=json01+"\"s2\":\""+rs.getString("s2")+"\",";
			json01=json01+"\"weizhi\":\""+rs.getString("weizhi")+"\",";
			json01=json01+"\"FYTP\":\""+rs.getString("fytp")+"\"}"; 
			
			
			}  
	
	     pstat.close();
	        conn.close();
//	        System.out.println(Ostr);


        
        
	}catch (SQLException e) {
		e.printStackTrace();
	}
//	System.out.println(json01);
	return json01;
}


}
