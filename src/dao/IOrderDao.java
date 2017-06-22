package dao;

import java.sql.SQLException;
import java.util.List;

import po.IOrder;
public interface IOrderDao {
	public abstract boolean addIOrder(IOrder iorder) throws ClassNotFoundException, SQLException;
	public abstract boolean deleteIOrder(IOrder iorder) throws ClassNotFoundException, SQLException;
	public abstract List<IOrder> queryIOrder(IOrder iorder) throws ClassNotFoundException, SQLException;
	public abstract List<IOrder> queryIOrderlist() throws ClassNotFoundException, SQLException;
	public abstract boolean updateIOrder(IOrder iorder) throws SQLException, ClassNotFoundException ;
	
}
