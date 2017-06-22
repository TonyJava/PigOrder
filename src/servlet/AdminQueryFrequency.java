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

import daoimpl.FrequencyDaoImpl;
import daoimpl.UserDaoImpl;
import po.Frequency;
import po.User;

public class AdminQueryFrequency extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AdminQueryFrequency() {
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
		FrequencyDaoImpl fd=new FrequencyDaoImpl();
		String name=request.getParameter("fname");
		Frequency f=new Frequency();
		f.setFname(name);
		List<Frequency>list=new ArrayList<Frequency>();
		try {
				list=fd.queryfrequency(f);
				System.out.println(f.getFname());
				System.out.println(list.size());
			if(list.size()==0){
				out.print("<script>alert('暂无相关车次信息');location.href='AdminQueryFrequencyAll';</script>");
			}else{
				request.setAttribute("frequencylist",list);
				request.getRequestDispatcher("../adminCar.jsp").forward(request,response); 
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
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
