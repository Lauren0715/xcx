package web_pro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gpsjava {
	private String dongjin="";
	private String beiwei="";
	private String time="";
	private String distance="";
	
	public String getDongjin() {
		return dongjin;
	}
	public void setDongjin(String dongjin) {
		this.dongjin = dongjin;
	}
	public String getBeiwei() {
		return beiwei;
	}
	public void setBeiwei(String beiwei) {
		this.beiwei = beiwei;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	
	void gps(String Vjd,String Vwd) {
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="insert  into gps(jingdu,weidu)";
        sql+=" values(?,?)";
        try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Vjd);
	        stmt.setString(2,Vwd);
	        //stmt.setString(3,Vjl);
	        stmt.executeUpdate();
	        System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
        //response.getWriter().append("<script>alert('新闻增加已完成');window.location.href=\"./admin/HT_xw_list.jsp\";</script>");
       }
       
	
	
	}

