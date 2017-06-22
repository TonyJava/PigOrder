package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.PriceFactory;
import dao.Price;
import daoimpl.FrequencyDaoImpl;
import daoimpl.IOrderDaoImpl;
import daoimpl.UserDaoImpl;
import po.Frequency;
import po.User;

public class UserOrder extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public UserOrder() {
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

		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out = response.getWriter();
		int uid=Integer.parseInt(request.getParameter("uid"));
		int fid=Integer.parseInt(request.getParameter("fid"));
		FrequencyDaoImpl fd=new FrequencyDaoImpl();
		Frequency f=new Frequency();
		f.setFid(fid);
		try {
			f=fd.queryfrequencybyid(f).get(0);
			String finaladdress=f.getFaddress();
			double price=PriceFactory.getPrice(f);
			int state=1;
			IOrderDaoImpl iod=new IOrderDaoImpl();
			iod.addIOrder(uid, finaladdress, fid, price, state);
			out.print("<script>alert('订票成功');location.href='FindAllFrequency'</script>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
