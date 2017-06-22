package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoimpl.FrequencyDaoImpl;
import daoimpl.UserDaoImpl;
import po.Frequency;
import po.User;

public class AdminUpdateFrequency extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AdminUpdateFrequency() {
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
		int fid=Integer.parseInt(request.getParameter("fid"));
		String fname=request.getParameter("fname");
		String faddress=request.getParameter("faddress");
		String starttime=request.getParameter("starttime");
		Double kilometers=Double.parseDouble(request.getParameter("kilometers"));
		String type=request.getParameter("type");
		int level=Integer.parseInt(request.getParameter("level"));
			FrequencyDaoImpl fd=new FrequencyDaoImpl();
			Frequency f=new Frequency();
			f.setFname(fname);
			f.setFaddress(faddress);
			f.setStarttime(starttime);
			f.setKilometers(kilometers);
			f.setType(type);
			f.setLevel(level);
			f.setFid(fid);
		try {
			fd.updateFrequency(f);
			out.print("<script>alert('修改成功');location.href='AdminQueryFrequencyAll';</script>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
