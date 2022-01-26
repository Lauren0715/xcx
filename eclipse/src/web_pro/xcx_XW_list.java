package web_pro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class xcx_XW_list
 */
@WebServlet("/xcx_XW_list")
public class xcx_XW_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xcx_XW_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String json01="";
	    response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter JsonOut = response.getWriter();
    //-------------------------------------------------------
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		   String VPN=request.getParameter("PN");
		   if(VPN==null || VPN.equals("")){
			   VPN="1";
			}else{
				VPN=VPN.trim();
			}
	        json01=json01+"[{\"SPID\":\"43101\", \"SPMC\":\"商品01"+VPN+"\", \"SPJG\":\"$48\", \"SPKC\":\"600\", \"SPPIC\":\"001.jpg\" },";
	        json01=json01+"{\"SPID\":\"43102\", \"SPMC\":\"商品02"+VPN+"\", \"SPJG\":\"$65\", \"SPKC\":\"76\", \"SPPIC\":\"002.jpg\" },";
	        json01=json01+"{ \"SPID\":\"43103\", \"SPMC\":\"商品03"+VPN+"\", \"SPJG\":\"$285\", \"SPKC\":\"95\", \"SPPIC\":\"003.jpg\" },";
	        json01=json01+"{\"SPID\":\"43104\", \"SPMC\":\"商品04"+VPN+"\", \"SPJG\":\"$1985\", \"SPKC\":\"32\", \"SPPIC\":\"004.jpg\" },";
	        json01=json01+"{\"SPID\":\"43105\", \"SPMC\":\"商品05"+VPN+"\", \"SPJG\":\"$258\", \"SPKC\":\"74\", \"SPPIC\":\"002.jpg\" },";
	        json01=json01+"{\"SPID\":\"43106\", \"SPMC\":\"商品06"+VPN+"\", \"SPJG\":\"$52\", \"SPKC\":\"68\", \"SPPIC\":\"003.jpg\" },";
	        json01=json01+"{\"SPID\":\"43107\", \"SPMC\":\"商品07"+VPN+"\", \"SPJG\":\"$45\", \"SPKC\":\"21\", \"SPPIC\":\"004.jpg\" },";
	        json01=json01+"{\"SPID\":\"43108\", \"SPMC\":\"商品08"+VPN+"\", \"SPJG\":\"$125\", \"SPKC\":\"87\", \"SPPIC\":\"001.jpg\" }]";
            System.out.println(json01);
	        JsonOut.println(json01);
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
