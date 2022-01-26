package web_pro;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class xcx_login
 */
@WebServlet("/xcx_login")
public class xcx_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xcx_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num=0;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String log = request.getParameter("log");
		String pwd = request.getParameter("pwd");
		
		System.out.print(log);
		System.out.print(pwd);
		
		admin user =new admin();
		user.admin_login(log, pwd);
//		int json1 ;
//		json1=user.xcx_log(log,pwd);
    	
		Writer JsonOut = response.getWriter();
		
		if (user.admin_login(log, pwd)) {
			JsonOut.write("{\"name\":\""+log+"\", \"code\":1}");
			   System.out.println("{\"name\":\""+log+"\", \"code\":1}");
			  } else {
				  JsonOut.write("{\"name\":\""+log+"\", \"code\":0}");
			   System.out.println("{\"name\":\""+log+"\", \"code\":0}");
			  }
		
		System.out.println(JsonOut);
//		JsonOut.println(JsonOut);
        JsonOut.flush();
        JsonOut.close();
		
		
//		System.out.println("xcx good get  "+log+"_____"+pwd);
//		Writer out = response.getWriter();
//		out.write("{\"IdNumber\":\"43100000000004\", \"Name\":\"牛ss七\", \"code\":\"200\"}");
//        out.flush();
		
    	 
    	
    	
    	

		//return loginok;
		
		
        
//		System.out.println("XCX on work");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
