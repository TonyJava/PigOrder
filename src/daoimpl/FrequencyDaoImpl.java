package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.FrequencyDao;
import jdbc.jdbc;
import po.Frequency;
import po.Frequency;

public class FrequencyDaoImpl implements FrequencyDao {
	public Frequency fre;
	@Override
	public boolean addFrequency(Frequency frequency) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
					Connection conn=null;
					jdbc jd=new jdbc();
					conn=jd.getConnection();
					String sql="insert into frequency (fname,faddress,starttime,kilometers,type,level) values(?,?,?,?,?,?)";
					PreparedStatement stmt=conn.prepareStatement(sql);
					stmt.setString(1,frequency.getFname());
					stmt.setString(2,frequency.getFaddress());
					stmt.setString(3,frequency.getStarttime());
					stmt.setDouble(4,frequency.getKilometers());
					stmt.setString(5,frequency.getType());
					stmt.setInt(6,frequency.getLevel());
					stmt.executeUpdate();
					ResultSet rs=null;
					jd.free(conn,stmt,rs);
				return true;
	}

	@Override
	public boolean deleteFrequency(Frequency frequency) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		String sql="delete from frequency where fid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1,frequency.getFid());
		stmt.executeUpdate();
		ResultSet rs=null;
		jd.free(conn,stmt,rs);
		return true;
	}

	@Override
	public List<Frequency> queryfrequency(Frequency frequency) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		Frequency bo=null;
		String sql="select * from frequency where fname=?";
		PreparedStatement pstm=null;
    	pstm=conn.prepareStatement(sql);
    	pstm.setString(1,frequency.getFname());
    	ResultSet rs=pstm.executeQuery();
    	 ArrayList<Frequency> list=new ArrayList<Frequency>();
    	while(rs.next()){
    
    		int s1=rs.getInt("fid");
	    	String s2=rs.getString("fname");
	    	String s3=rs.getString("faddress");
	    	String s4=rs.getString("starttime");
	    	Double s5=rs.getDouble("kilometers");
	    	String s6=rs.getString("type");
	    	int s7=rs.getInt("level");
	    	bo=new Frequency(s1,s2,s3,s4,s5,s6,s7);
	    	list.add(bo);
    	}
    	jd.free(conn,pstm,rs);
		return list;
	}

	public List<Frequency> queryfrequencybyid(Frequency frequency) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		Frequency bo=null;
		String sql="select * from frequency where fid=?";
		PreparedStatement pstm=null;
    	pstm=conn.prepareStatement(sql);
    	pstm.setInt(1,frequency.getFid());
    	ResultSet rs=pstm.executeQuery();
    	 ArrayList<Frequency> list=new ArrayList<Frequency>();
    	while(rs.next()){
    		int s1=rs.getInt("fid");
	    	String s2=rs.getString("fname");
	    	String s3=rs.getString("faddress");
	    	String s4=rs.getString("starttime");
	    	Double s5=rs.getDouble("kilometers");
	    	String s6=rs.getString("type");
	    	int s7=rs.getInt("level");
	    	bo=new Frequency(s1,s2,s3,s4,s5,s6,s7);
	    	list.add(bo);
    	}
    	jd.free(conn,pstm,rs);
		return list;
	}
	public List<Frequency> queryfrequencybyfinaladdress(String critera) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		Frequency bo=null;
		String sql="select * from frequency where faddress=?";
		PreparedStatement pstm=null;
    	pstm=conn.prepareStatement(sql);
    	pstm.setString(1,critera);
    	ResultSet rs=pstm.executeQuery();
    	 ArrayList<Frequency> list=new ArrayList<Frequency>();
    	while(rs.next()){
    		int s1=rs.getInt("fid");
	    	String s2=rs.getString("fname");
	    	String s3=rs.getString("faddress");
	    	String s4=rs.getString("starttime");
	    	Double s5=rs.getDouble("kilometers");
	    	String s6=rs.getString("type");
	    	int s7=rs.getInt("level");
	    	bo=new Frequency(s1,s2,s3,s4,s5,s6,s7);
	    	list.add(bo);
    	}
    	jd.free(conn,pstm,rs);
		return list;
	}
	public List<Frequency> queryfrequencybyfname(String critera) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		Frequency bo=null;
		String sql="select * from frequency where fname=?";
		PreparedStatement pstm=null;
    	pstm=conn.prepareStatement(sql);
    	pstm.setString(1,critera);
    	ResultSet rs=pstm.executeQuery();
    	 ArrayList<Frequency> list=new ArrayList<Frequency>();
    	while(rs.next()){
    		int s1=rs.getInt("fid");
	    	String s2=rs.getString("fname");
	    	String s3=rs.getString("faddress");
	    	String s4=rs.getString("starttime");
	    	Double s5=rs.getDouble("kilometers");
	    	String s6=rs.getString("type");
	    	int s7=rs.getInt("level");
	    	bo=new Frequency(s1,s2,s3,s4,s5,s6,s7);
	    	list.add(bo);
    	}
    	jd.free(conn,pstm,rs);
		return list;
	}
	public List<Frequency> queryfrequencybytype(String critera) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		Frequency bo=null;
		String sql="select * from frequency where type=?";
		PreparedStatement pstm=null;
    	pstm=conn.prepareStatement(sql);
    	pstm.setString(1,critera);
    	ResultSet rs=pstm.executeQuery();
    	 ArrayList<Frequency> list=new ArrayList<Frequency>();
    	while(rs.next()){
    		int s1=rs.getInt("fid");
	    	String s2=rs.getString("fname");
	    	String s3=rs.getString("faddress");
	    	String s4=rs.getString("starttime");
	    	Double s5=rs.getDouble("kilometers");
	    	String s6=rs.getString("type");
	    	int s7=rs.getInt("level");
	    	bo=new Frequency(s1,s2,s3,s4,s5,s6,s7);
	    	list.add(bo);
    	}
    	jd.free(conn,pstm,rs);
		return list;
	}
	@Override
	public List<Frequency> queryfrequencylist() throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		Frequency bo=null;
		String sql="select * from frequency";
		PreparedStatement stmt=conn.prepareStatement(sql);
	    ResultSet rs=stmt.executeQuery();
	    ArrayList<Frequency> list=new ArrayList<Frequency>();
	    while(rs.next()){
	    	int s1=rs.getInt("fid");
	    	String s2=rs.getString("fname");
	    	String s3=rs.getString("faddress");
	    	String s4=rs.getString("starttime");
	    	Double s5=rs.getDouble("kilometers");
	    	String s6=rs.getString("type");
	    	int s7=rs.getInt("level");
	    	bo=new Frequency(s1,s2,s3,s4,s5,s6,s7);
	    	list.add(bo);
	    }
	    jd.free(conn,stmt,rs);
		return list;
	}

	@Override
	public boolean updateFrequency(Frequency frequency) throws SQLException, ClassNotFoundException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		String sql="update frequency set fname=?,faddress=?,starttime=?,kilometers=?,type=?,level=? where fid=? ";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1,frequency.getFname());
		stmt.setString(2,frequency.getFaddress());
		stmt.setString(3,frequency.getStarttime());
		stmt.setDouble(4,frequency.getKilometers());
		stmt.setString(5,frequency.getType());
		stmt.setInt(6,frequency.getLevel());
		stmt.setInt(7,frequency.getFid());
		stmt.executeUpdate();
		ResultSet rs=null;
		jd.free(conn,stmt,rs);
		return true;
	}

}
