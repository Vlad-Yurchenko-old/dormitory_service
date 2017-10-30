package dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dao.Dao;
import dao.mysql.Connector;
import domain.entityImpl.Dormitory;

public class DormitoryDao implements Dao<Dormitory> {

	@Override
	public void create(Dormitory entity) throws SQLException {
		String sql = "INSERT INTO dormitory (`address`) VALUES (?)";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, entity.getAddress());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
		} finally {
			try {
				resultSet.close();
			} catch (NullPointerException | SQLException e) {
			}
			try {
				statement.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	@Override
	public Dormitory read(int id) throws SQLException {
		String sql = "SELECT * FROM dormitory WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			Dormitory examScope = new Dormitory();
			if (resultSet.next()) {
				examScope.setId(id);
				examScope.setAddress(resultSet.getString("address"));
			}
			return examScope;
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (NullPointerException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Dormitory entity) throws SQLException {
		String sql = "UPDATE `dormitory` SET `address` = ? WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getAddress());
			statement.setInt(2, entity.getId());
			statement.executeUpdate();
		} finally {
			try {
				statement.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM `dormitory` WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} finally {
			try {
				statement.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

	@Override
	public ArrayList<Dormitory> readAll() throws SQLException {
		String sql = "SELECT * FROM dormitory";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = Connector.getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			ArrayList<Dormitory> examScopes = new ArrayList<>();
			while (r.next()) {
				Dormitory examScope = new Dormitory();
				examScope.setId(r.getInt("id"));
				examScope.setAddress(r.getString("address"));
				examScopes.add(examScope);
			}
			return examScopes;
		} finally {
			try {
				r.close();
				s.close();
				c.close();
			} catch (NullPointerException | SQLException e) {
			}
		}
	}

}
