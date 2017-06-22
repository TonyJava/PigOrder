package dao;
import java.sql.SQLException;
import java.util.ArrayList;

import po.User;
public interface UserDao {
	public abstract boolean adduser(User user) throws ClassNotFoundException, SQLException;
	public abstract boolean deleteuser(User user) throws ClassNotFoundException, SQLException;
	public abstract ArrayList<User> queryuesr(User user) throws ClassNotFoundException, SQLException;
	public abstract boolean updateuser(User user) throws SQLException, ClassNotFoundException ;
}
