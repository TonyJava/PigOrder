package daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import jdbc.jdbc;
import po.User;

public class UserDaoImpl implements UserDao {
	private User u;
//增加用户
	@Override
	public boolean adduser(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
			Connection conn=null;
			jdbc jd=new jdbc();
			conn=jd.getConnection();
			String sql="insert into user (uname,upassword,idno,realname) values(?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,user.getUname());
			stmt.setString(2,user.getUpassword());
			stmt.setString(3,user.getIdno());
			stmt.setString(4,user.getRealname());
			stmt.executeUpdate();
			ResultSet rs=null;
			jd.free(conn,stmt,rs);
			
		return true;
	}

//用户注册	
	public boolean register(String name,String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
			Connection conn=null;
			jdbc jd=new jdbc();
			conn=jd.getConnection();
			String sql="insert into user (uname,upassword) values(?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,name);
			stmt.setString(2,password);
			stmt.executeUpdate();
			ResultSet rs=null;
			jd.free(conn,stmt,rs);
			
		return true;
	}
	
//删除用户
	@Override
	public boolean deleteuser(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		String sql="delete from user where uid=?";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1,user.getUid());
		stmt.executeUpdate();
		ResultSet rs=null;
		jd.free(conn,stmt,rs);
		return false;
	}
//查询单个用户(检测登录）
	@Override
	public ArrayList<User> queryuesr(User user) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		 u=null;
		String sql="select * from user where uname=?";
		PreparedStatement pstm=null;
    	pstm=conn.prepareStatement(sql);
    	pstm.setString(1,user.getUname());
    	ResultSet rs=pstm.executeQuery();
    	 ArrayList<User> list=new ArrayList<User>();
    	while(rs.next()){
    		int uid=rs.getInt(1);
    		String uname=rs.getString(2);
    		String upassword=rs.getString(3);
    		String idno=rs.getString(4);
    		String realname=rs.getString(5);
    		int isadmin=rs.getInt(6);
    		u=new User(uid, uname, upassword, idno, realname, isadmin);
    		list.add(u);
    	}
    	jd.free(conn,pstm,rs);
		return list;
	}

	//查询全部用户(管理员)
		public ArrayList<User> findall() throws SQLException, ClassNotFoundException{
			Connection conn=null;
			jdbc jd=new jdbc();
			conn=jd.getConnection();
			User bo=null;
			String sql="select * from user";
			PreparedStatement stmt=conn.prepareStatement(sql);
		    ResultSet rs=stmt.executeQuery();
		    ArrayList<User> list=new ArrayList<User>();
		    while(rs.next()){
		    	int s1=rs.getInt("uid");
		    	String s2=rs.getString("uname");
		    	String s3=rs.getString("upassword");
		    	String s4=rs.getString("idno");
		    	String s5=rs.getString("realname");
		    	int s6=rs.getInt("isadmin");
		    	bo=new User(s1,s2,s3,s4,s5,s6);
		    	list.add(bo);
		    }
		    jd.free(conn,stmt,rs);
			return list;
		}
//更新用户
	@Override
	public boolean updateuser(User user) throws SQLException, ClassNotFoundException {
		Connection conn=null;
		jdbc jd=new jdbc();
		conn=jd.getConnection();
		String sql="update user set uname=?,upassword=?,idno=?,realname=? where uid=? ";
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setString(1,user.getUname());
		stmt.setString(2,user.getUpassword());
		stmt.setString(3,user.getIdno());
		stmt.setString(4,user.getRealname());
		stmt.setInt(5,user.getUid());
		stmt.executeUpdate();
		ResultSet rs=null;
		jd.free(conn,stmt,rs);
		return true;
	}
	
	

	 //�����ҳ��ҳ��
	 public int getPageCount ()throws Exception{
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 jdbc jd=new jdbc();
		 int recordCount=0,t1=0,t2=0,pagesize=5;
		 try{
			 conn=jd.getConnection();
			 String sql="select count(*) from User;";
			 ps=conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			 rs.next();
			 recordCount=rs.getInt(1);
			 t1=recordCount%pagesize;
			 t2=recordCount/pagesize;
		 }finally{
			 jd.free(conn,ps,rs);
		 }
		 return t1==0?t2:t2+1;
	 }
	 
	 //��ѯָ��ҳ����
	 
	 public List<User>listUser(int pageNo)throws Exception{
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 jdbc jd=new jdbc();
		 int pageSize=5;
		 int startRecno=(pageNo-1)*pageSize;
		 ArrayList<User>userList=new ArrayList<User>();
		 try{
			 conn=jd.getConnection();
			 String sql="select * from User  order by Userid limit ?,?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, startRecno);
			 ps.setInt(2, pageSize);
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				 User user=new User();
//				 user.setUserid(rs.getString(1));
//				 user.setUsername(rs.getString(2));
//				 user.setAuthor(rs.getString(3));
//				 user.setPress(rs.getString(4));
//				 user.setPrice(rs.getDouble(5));
//				 user.setMemo(rs.getString(6));
				 userList.add(user);			
			 }
		 }
		 finally{
			 jd.free(conn, ps, rs);
		 }
		 
		return userList; 
	 }
	 
	//�����ѯ�����ҳ
	 public int getCount (String select,String search)throws Exception{
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 jdbc jd=new jdbc();
		 int recordCount=0,t1=0,t2=0,pagesize=5;
		 try{
			 conn=jd.getConnection();
			 String sql="select count(*) from User where "+ select+" like '%"+search+"%'";
			 ps=conn.prepareStatement(sql);
			 rs=ps.executeQuery();
			 rs.next();
			 recordCount=rs.getInt(1);
			 t1=recordCount%pagesize;
			 t2=recordCount/pagesize;
		 }finally{
			 jd.free(conn,ps,rs);
		 }
		 return t1==0?t2:t2+1;
	 }
	 public List<User>findbypage(String s,String search,int pageNo)throws Exception{
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 jdbc jd=new jdbc();
		 int pageSize=5;
		 int startRecno=(pageNo-1)*pageSize;
		 ArrayList<User>userList=new ArrayList<User>();
		 try{
			 conn=jd.getConnection();
			 String sql="select * from user where "+ s+ " like '%"+search+"%' order by "+s+" limit ?,?";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, startRecno);
			 ps.setInt(2, pageSize);
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				 User user=new User();
//				 user.setUserid(rs.getString(1));
//				 user.setUsername(rs.getString(2));
//				 user.setAuthor(rs.getString(3));
//				 user.setPress(rs.getString(4));
//				 user.setPrice(rs.getDouble(5));
//				 user.setMemo(rs.getString(6));
				 userList.add(user);			
			 }
		 }
		 finally{
			 jd.free(conn, ps, rs);
		 }
		 
		return userList; 
	 }
	 


}
