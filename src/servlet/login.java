package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoimpl.UserDaoImpl;
import net.sf.json.JSONObject;
import po.User;

public class login extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public login() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");	
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		 String name=request.getParameter("username2");
		 String password=request.getParameter("password2");
		 System.out.println(name+password);
		 UserDaoImpl ud=new UserDaoImpl();
			 	User user=new User();
				user.setUname(name);
				List list=new ArrayList<User>();
				try {
					list=ud.queryuesr(user);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			if(list.size()==0){
				out.print("<script>alert('用户名或密码错误');location.href='../register.jsp'</script>");
			}else{
				user=(User) list.get(0);
				if(user.getUpassword().equals(password)){
					HttpSession session=request.getSession();  
					session.setAttribute("username", name);
					session.setAttribute("uid", user.getUid());
					if(user.getAdmin()==0){
						request.getRequestDispatcher("FindAllFrequency").forward(request,response);  
					}
					else{
						request.getRequestDispatcher("AdminFindAll").forward(request,response);  
					}
						
				}	
			else{
				out.print("<script>alert('用户名或密码错误');location.href='../register.jsp'</script>");
			}
		}
		
		 
		
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
