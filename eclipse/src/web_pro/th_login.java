package web_pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class th_login
 */
@WebServlet("/th_login")
public class th_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public th_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String openid = request.getParameter("openid");
		
		Connection  conn = pub_fun.getConnection();
    	String Sql_str = "select * from th_userinfo where openid=openid  ";
    	String Ostr="";
    	try {
			PreparedStatement pstat = conn.prepareStatement(Sql_str);
			ResultSet rs = (ResultSet) pstat.executeQuery();
			while(rs.next())  
	            {  
				Ostr=Ostr+"{\"phone\":\""+rs.getString("phone")+"\","; 
				Ostr=Ostr+"\"email\":\""+rs.getString("email")+"\"}"; 
				
						}  
			
	        pstat.close();
	        conn.close();

 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	System.out.println(Ostr);
    	
    	PrintWriter JsonOut = response.getWriter();
    	JsonOut.println(Ostr);
        JsonOut.flush();
        JsonOut.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
