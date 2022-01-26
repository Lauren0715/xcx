package web_pro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class xcx_fyinfo
 */
@WebServlet("/xcx_fyinfo")
public class xcx_fyinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FYMC = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xcx_fyinfo() {
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
		
		String FYMC=request.getParameter("FYMC");
		
		fangyuan A_fangyuan=new fangyuan();
		A_fangyuan.xcx_FYinfo(FYMC);
		PrintWriter  JsonOut=response.getWriter();
		JsonOut.println(A_fangyuan.xcx_FYinfo(FYMC));
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
