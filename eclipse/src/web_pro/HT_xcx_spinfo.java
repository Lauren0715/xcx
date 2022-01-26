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
 * Servlet implementation class HT_xcx_spinfo
 */
@WebServlet("/HT_xcx_spinfo")
public class HT_xcx_spinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HT_xcx_spinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String message=request.getParameter("spid");
        System.out.println(message);
		shangpin A_shangpin = new shangpin();
		String json1 = "";
		json1=A_shangpin.xcx_spinfo(Integer.parseInt(message));
    	//System.out.println(Ostr);
		//return Ostr;
		
		
		
		PrintWriter JsonOut = response.getWriter();
		
		
		System.out.println(json1);
		JsonOut.println(json1);
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
