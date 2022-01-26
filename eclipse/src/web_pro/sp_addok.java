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
 * Servlet implementation class sp_addok
 */
@WebServlet("/sp_addok")
public class sp_addok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sp_addok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("sp_id");
		String name = request.getParameter("sp_name");
		String price = request.getParameter("sp_price");
		String kucun = request.getParameter("sp_kucun");
		String info = request.getParameter("sp_info");
		System.out.println("name ="+name);
		
		SP A_SP = new SP();
		A_SP.sp_addok(id,name,price,kucun,info);
		
//		Connection  conn = pub_fun.getConnection();
//		PreparedStatement stmt = null;
//		String sql="insert  into sp_data(sp_id,sp_name,sp_price,sp_kucun,sp_info)";
//        sql+=" values(?,?)";
//        try {
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1,id);
//	        stmt.setString(2,name);
//	        stmt.setString(3,price);
//	        stmt.setString(4,kucun);
//	        stmt.setString(5,info);
//	        
//	        stmt.executeUpdate();
//	        System.out.println("success");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
        response.getWriter().append("<script>alert('商品增加已完成');window.location.href=\"./admin/HT_sp_list.jsp\";</script>");
		
		
		

        
	}

}
