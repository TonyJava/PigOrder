package dao;

import java.sql.SQLException;
import java.util.List;

import po.Frequency;

public interface FrequencyDao {
	public abstract boolean addFrequency(Frequency frequency) throws ClassNotFoundException, SQLException;
	public abstract boolean deleteFrequency(Frequency frequency) throws ClassNotFoundException, SQLException;
	public abstract List<Frequency> queryfrequency(Frequency frequency) throws ClassNotFoundException, SQLException;
	public abstract List<Frequency> queryfrequencylist() throws ClassNotFoundException, SQLException;
	public abstract boolean updateFrequency(Frequency frequency) throws SQLException, ClassNotFoundException ;
}
