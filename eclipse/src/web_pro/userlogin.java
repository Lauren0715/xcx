package web_pro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userlogin
 */
@WebServlet("/userlogin")
public class userlogin extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.getWriter().append("Served at: ").append(request.getContextPath());
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  //doGet(request, response);
  

  
  request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8");
  response.setContentType("text/html;charset=utf-8");
  String log = request.getParameter("log");
  String pwd = request.getParameter("pwd");
  
  if("tom".equals(log) && "123456".equals(pwd) ){

   response.sendRedirect("./admin/main.jsp");
   System.out.println("login good!");
  }else{
   response.getWriter().append("<script>alert('用户名和密码错误');window.location.href=\"./admin/login.html\";</script>");
//   response.sendRedirect("./admin/login.html");
   System.out.println("login bad!");
  }
  
 }

}