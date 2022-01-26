package web_pro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sysinfo
 */
@WebServlet("/sysinfo")
public class sysinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sysinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String phone = request.getParameter("phone");
		String pixel = request.getParameter("pixel");
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		String language = request.getParameter("language");
		String version = request.getParameter("version");
		String sys = request.getParameter("sys");
		String platform = request.getParameter("platform");
		
		
		System.out.print(phone);
		System.out.print(pixel);
		System.out.print(width);
		System.out.print(height);
		System.out.print(language);
		System.out.print(version);
		
		
		
		Connection  conn = pub_fun.getConnection();
		PreparedStatement stmt = null;
		String sql="insert  into sysinfo(phone,pixel,width,height,language,version,sys,platform)";
        sql+=" values(?,?,?,?,?,?,?,?)";
        try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,phone);
	        stmt.setString(2,pixel);
	        stmt.setString(3,width);
	        stmt.setString(4,height);
	        stmt.setString(5,language);
	        stmt.setString(6,version);
	        stmt.setString(7,sys);
	        stmt.setString(8,platform);
	        stmt.executeUpdate();
	        System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
