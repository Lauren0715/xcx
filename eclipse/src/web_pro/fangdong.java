package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fangdong {

	private String FDMC="";
	private String FDDZ="";
	private String FDPF="";
	private String FDPL="";
	private String FDTP="";
	private String photo="";
	private String name="";
	private String score="";
	private String common="";
	private String bb1="";
	private String bb2="";
	private String price="";
	private String discount="";
	

	public String getFDMC() {
		return FDMC;
	}
	public void setFDMC(String fDMC) {
		FDMC = fDMC;
	}
	public String getFDDZ() {
		return FDDZ;
	}
	public void setFDDZ(String fDDZ) {
		FDDZ = fDDZ;
	}
	public String getFDPF() {
		return FDPF;
	}
	public void setFDPF(String fDPF) {
		FDPF = fDPF;
	}
	public String getFDPL() {
	return FDPL;
}
public void setFDPL(String fDPL) {
	FDPL = fDPL;
}
public String getFDTP() {
	return FDTP;
}
public void setFDTP(String fDTP) {
	FDTP = fDTP;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
public String getCommon() {
	return common;
}
public void setCommon(String common) {
	this.common = common;
}
public String getBb1() {
	return bb1;
}
public void setBb1(String bb1) {
	this.bb1 = bb1;
}
public String getBb2() {
	return bb2;
}
public void setBb2(String bb2) {
	this.bb2 = bb2;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getDiscount() {
	return discount;
}
public void setDiscount(String discount) {
	this.discount = discount;
}
public String xcx_FDlist() {
     	
//		json01=json01+"{\"SPID\":\"43101\", \"SPMC\":\"商品01\", \"SPJG\":\"32\", \"SPKC\":\"43\"}";
//		return json01;
		
		Connection  conn = pub_fun.getConnection();
		
    	String Sql_str = "select * from fd_data order by fdid desc";
    	String json01="[";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();	
			while(rs.next())  
	            {  
			
 
				json01=json01+"{\"FDMC\":\""+rs.getString("fdmc")+"\",";  
				json01=json01+"\"FDDZ\":\""+rs.getString("fddz")+"\","; 
				json01=json01+"\"FDPF\":\""+rs.getString("fdpf")+"\","; 
				json01=json01+"\"FDTP\":\""+rs.getString("fdtp")+"\","; 
				json01=json01+"\"FDPL\":\""+rs.getString("fdpl")+"\"},";  
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

public String xcx_FDinfo(String FDMC) {
	
	String json01="";
	
	Connection  conn = pub_fun.getConnection();
	String Sql_str = "select * from fd_data where fdmc='"+FDMC+"'";
	boolean oboolean = false;
	try {
		PreparedStatement pstat = conn.prepareStatement(Sql_str);
		ResultSet rs = (ResultSet) pstat.executeQuery();
		while(rs.next())  
            {  
			json01=json01+"{\"FDMC\":\""+rs.getString("fdmc")+"\",";  
			json01=json01+"\"FDDZ\":\""+rs.getString("fddz")+"\","; 
			json01=json01+"\"FDTP\":\""+rs.getString("fdtp")+"\","; 
			json01=json01+"\"FDPF\":\""+rs.getString("fdpf")+"\",";  
			json01=json01+"\"FDSJ\":\""+rs.getString("fdsj")+"\",";  
			json01=json01+"\"FDHFL\":\""+rs.getString("fdhfl")+"\","; 
			json01=json01+"\"FDPJ\":\""+rs.getString("fdpj")+"\",";  
			json01=json01+"\"FYSL\":\""+rs.getString("fysl")+"\",";  
			json01=json01+"\"FYMC\":\""+rs.getString("fymc")+"\",";  
			json01=json01+"\"FDPL\":\""+rs.getString("fdpl")+"\"}"; 
			}  
		
        pstat.close();
        conn.close();
        
        
        
	}catch (SQLException e) {
		e.printStackTrace();
	}System.out.println(json01);
	return json01;
}

public String xcx_FDFYlist(String Vname) {
 
	
	Connection  conn = pub_fun.getConnection();
	
	String Sql_str = "select * from fy_data where fdmc='"+Vname+"'";
	String json01="[";
	try {
		PreparedStatement pstat = conn.prepareStatement(Sql_str);
		ResultSet rs = (ResultSet) pstat.executeQuery();	
		while(rs.next())  
            {  
		

			json01=json01+"{\"FYMC\":\""+rs.getString("fymc")+"\","; 
			json01=json01+"\"FYTP\":\""+rs.getString("fytp")+"\","; 
			json01=json01+"\"room\":\""+rs.getString("room")+"\","; 
			json01=json01+"\"FYDZ\":\""+rs.getString("fydz")+"\","; 
			json01=json01+"\"FYPF\":\""+rs.getString("fypf")+"\",";
			json01=json01+"\"bb1\":\""+rs.getString("bb1")+"\","; 
			json01=json01+"\"bb2\":\""+rs.getString("bb2")+"\",";
			json01=json01+"\"FYJG\":\""+rs.getString("fyjg")+"\","; 
			json01=json01+"\"discount\":\""+rs.getString("discount")+"\","; 
			json01=json01+"\"common\":\""+rs.getString("common")+"\"},"; 
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

public String xcx_FKlist(String Fname) {
 
	
	Connection  conn = pub_fun.getConnection();
	
	String Sql_str = "select * from fk_data where fdmc='"+Fname+"'";
	String json01="[";
	try {
		PreparedStatement pstat = conn.prepareStatement(Sql_str);
		ResultSet rs = (ResultSet) pstat.executeQuery();	
		while(rs.next())  
            {  
			json01=json01+"{\"FYMC\":\""+rs.getString("fymc")+"\","; 
         	json01=json01+"\"FKTP\":\""+rs.getString("fktp")+"\","; 
			json01=json01+"\"FKMC\":\""+rs.getString("fkmc")+"\","; 
			json01=json01+"\"FKPJ\":\""+rs.getString("fkpj")+"\","; 
			json01=json01+"\"year\":\""+rs.getString("year")+"\",";
			json01=json01+"\"month\":\""+rs.getString("month")+"\"},";  

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


public String xcx_PJlist(String FKMC) {
	
	String json01="";
	
	 Connection  conn = pub_fun.getConnection();
	 	String Sql_str = "select * from fk_data where fymc=? ";
	 	String Ostr="{";
	 	try {
				PreparedStatement pstat = conn.prepareStatement(Sql_str);
				pstat.setNString(1, FKMC);
				ResultSet rs = (ResultSet) pstat.executeQuery();
		while(rs.next())  
            {  
			json01=json01+"{\"FKMC\":\""+rs.getString("fkmc")+"\","; 
			json01=json01+"\"FKTP\":\""+rs.getString("fktp")+"\","; 
			json01=json01+"\"FKPJ\":\""+rs.getString("fkpj")+"\","; 
			json01=json01+"\"year\":\""+rs.getString("year")+"\",";
			json01=json01+"\"month\":\""+rs.getString("month")+"\"},"; 
			
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


public String xcx_FFlist() {
 	
//	json01=json01+"{\"SPID\":\"43101\", \"SPMC\":\"商品01\", \"SPJG\":\"32\", \"SPKC\":\"43\"}";
//	return json01;
	
	Connection  conn = pub_fun.getConnection();
	
	String Sql_str = "select * from fk_data order by fkid desc";
	String json01="[";
	try {
		PreparedStatement pstat = conn.prepareStatement(Sql_str);
		ResultSet rs = (ResultSet) pstat.executeQuery();	
		while(rs.next())  
            {  
		

			json01=json01+"{\"FKMC\":\""+rs.getString("fkmc")+"\","; 
			json01=json01+"\"FKTP\":\""+rs.getString("fktp")+"\","; 
			json01=json01+"\"FKPJ\":\""+rs.getString("fkpj")+"\","; 
			json01=json01+"\"year\":\""+rs.getString("year")+"\",";
			json01=json01+"\"month\":\""+rs.getString("month")+"\"},"; 
//			json01=json01+"<td><a href='./HT_sp_show.jsp?spid="+rs.getString("sp_id")+"' class='tablelink'>详情</a> ";
//			json01=json01+"<a href='./sp_edit.jsp?spid="+rs.getString("sp_id")+"'  class='tablelink'>修改</a>";
//			json01=json01+"<a href='../sp_delok?spid="+rs.getString("sp_id")+"' class='tablelink'> 删除</a></td></tr>";
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



public String xcx_FDjs(String FYMC) {
	
	String json01="";
	
	 Connection  conn = pub_fun.getConnection();
	 	String Sql_str = "select * from fd_data where fymc=? ";
	 	String Ostr="{";
	try {
		PreparedStatement pstat = conn.prepareStatement(Sql_str);
		ResultSet rs = (ResultSet) pstat.executeQuery();
		while(rs.next())  
            {  
			json01=json01+"{\"FDMC\":\""+rs.getString("fdmc")+"\",";  
			json01=json01+"\"FDDZ\":\""+rs.getString("fddz")+"\","; 
			json01=json01+"\"FDTP\":\""+rs.getString("fdtp")+"\","; 
			json01=json01+"\"FDPF\":\""+rs.getString("fdpf")+"\",";  
			json01=json01+"\"FDSJ\":\""+rs.getString("fdsj")+"\",";  
			json01=json01+"\"FDHFL\":\""+rs.getString("fdhfl")+"\","; 
			json01=json01+"\"FDPJ\":\""+rs.getString("fdpj")+"\",";  
			json01=json01+"\"FYSL\":\""+rs.getString("fysl")+"\",";  
			json01=json01+"\"FYMC\":\""+rs.getString("fymc")+"\",";  
			json01=json01+"\"FDPL\":\""+rs.getString("fdpl")+"\"}"; 
			}  
		
        pstat.close();
        conn.close();
        
        
        
	}catch (SQLException e) {
		e.printStackTrace();
	}System.out.println(json01);
	return json01;
}

}


