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

import daoimpl.IOrderDaoImpl;
import daoimpl.UserDaoImpl;
import po.IOrder;
import po.User;

public class QueryOrder extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public QueryOrder() {
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

		response.setContentType("text/html;charset=utf-8");	
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserDaoImpl ud=new UserDaoImpl();
		int userid=Integer.parseInt(request.getParameter("userid"));
		System.out.println(userid);
		IOrder iod=new IOrder();
		iod.setUserid(userid);
		IOrderDaoImpl iodp=new IOrderDaoImpl();
		List<IOrder>orderlist=new ArrayList<IOrder>();
		try {
			orderlist=iodp.queryIOrder(iod);
			if(orderlist.size()==0){
				out.print("<script>alert('当前没有订票');location.href='../user.jsp';</script>");
			}else{
				request.setAttribute("orderlist",orderlist);
				request.getRequestDispatcher("../order.jsp").forward(request,response); 
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.close();
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
		doGet(request,response);
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
