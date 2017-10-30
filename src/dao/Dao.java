package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import domain.Entity;

public interface Dao <T extends Entity> {

	void create(T entity) throws SQLException;
	
	T read (int id) throws SQLException;
	
	void update(T entity) throws SQLException;
	
	void delete(int id) throws SQLException;
	
	ArrayList<T> readAll() throws SQLException;
	
}
