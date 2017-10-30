package dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.Dao;
import dao.mysql.Connector;
import domain.entityImpl.Room;

public class RoomDao implements Dao<Room> {

	@Override
	public void create(Room entity) throws SQLException {
		String sql = "INSERT INTO room (`number`,`dormitory_id`,`count_free`,`gender`) VALUES (?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setInt(1, entity.getNumber());
			statement.setInt(2, entity.getDormitoryID());
			statement.setInt(3, entity.getCountFree());
			statement.setString(4, entity.getGender());
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
	public Room read(int id) throws SQLException {
		String sql = "SELECT * FROM room WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			Room examScope = new Room();
			if (resultSet.next()) {
				examScope.setId(id);
				examScope.setNumber(resultSet.getInt("number"));
				examScope.setDormitoryID(resultSet.getInt("dormitory_id"));
				examScope.setCountFree(resultSet.getInt("count_free"));
				examScope.setGender(resultSet.getString("gender"));
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
	public void update(Room entity) throws SQLException {
		String sql = "UPDATE `room` SET `number` = ? , SET `dormitory_id` = ? , SET `count_free` = ? , SET `gender` = ? WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, entity.getNumber());
			statement.setInt(2, entity.getDormitoryID());
			statement.setInt(3, entity.getCountFree());
			statement.setString(4, entity.getGender());
			statement.setInt(5, entity.getId());
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
		String sql = "DELETE FROM `room` WHERE `id` = ?";
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
	public ArrayList<Room> readAll() throws SQLException {
		String sql = "SELECT * FROM exam_scope";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = Connector.getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			ArrayList<Room> examScopes = new ArrayList<>();
			while (r.next()) {
				Room examScope = new Room();
				examScope.setId(r.getInt("id"));
				examScope.setNumber(r.getInt("number"));
				examScope.setDormitoryID(r.getInt("dormitory_id"));
				examScope.setCountFree(r.getInt("count_free"));
				examScope.setGender(r.getString("gender"));
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
