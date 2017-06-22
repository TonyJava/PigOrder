package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IOrderDao;
import jdbc.jdbc;
import po.Frequency;
import po.IOrder;

public class IOrderDaoImpl implements IOrderDao {

	
	public boolean addIOrder(int s1,String s2,int s3,double s4,int s5) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		String sql="insert into torder (userid,finaladdress,frequencyid,price,state) values(?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1,s1);
		stmt.setString(2, s2);
		stmt.setInt(3,s3);
		stmt.setDouble(4, s4);
		stmt.setInt(5,s5);
		stmt.executeUpdate();
		ResultSet rs=null;
		jd.free(conn,stmt,rs);
	return true;
	}

	@Override
	public boolean deleteIOrder(IOrder frequency) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		String sql="update torder set state=0 where oid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1,frequency.getOid());
		stmt.executeUpdate();
		ResultSet rs=null;
		jd.free(conn,stmt,rs);
		return true;
	}

	@Override
	public List<IOrder> queryIOrder(IOrder iorder) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		IOrder bo=null;
		String sql="select * from torder where userid=? and state=1";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, iorder.getUserid());
	    ResultSet rs=stmt.executeQuery();
	    ArrayList<IOrder> list=new ArrayList<IOrder>();
	    while(rs.next()){
	    	int s1=rs.getInt("oid");
	    	int s2=rs.getInt("userid");
	    	String s3=rs.getString("finaladdress");
	    	int s4=rs.getInt("frequencyid");
	    	Double s5=rs.getDouble("price");
	    	int s6=rs.getInt("state");
	    	
	    	bo=new IOrder(s1,s2,s3,s4,s5,s6);
	    	list.add(bo);
	    }
	    jd.free(conn,stmt,rs);
		return list;
	}

	@Override
	public List<IOrder> queryIOrderlist() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean addIOrder(IOrder frequency) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateIOrder(IOrder frequency) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
