package dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.Dao;
import dao.mysql.Connector;
import domain.entityImpl.Student;

public class StudentDao implements Dao<Student> {

	@Override
	public void create(Student entity) throws SQLException {
		String sql = "INSERT INTO student (`name`,`sur_name`,`last_name`,`course`,`room_id`,`gender`) VALUES (?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getSurName());
			statement.setString(3, entity.getLastName());
			statement.setInt(4, entity.getCourse());
			statement.setInt(5, entity.getRoomID());
			statement.setString(6, entity.getGender());
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
	public Student read(int id) throws SQLException {
		String sql = "SELECT * FROM student WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			Student examScope = new Student();
			if (resultSet.next()) {
				examScope.setId(id);
				examScope.setName(resultSet.getString("name"));
				examScope.setSurName(resultSet.getString("sur_name"));
				examScope.setLastName(resultSet.getString("last_name"));
				examScope.setCourse(resultSet.getInt("course"));
				examScope.setRoomID(resultSet.getInt("room_id"));
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
	public void update(Student entity) throws SQLException {
		String sql = "UPDATE `student` SET `name` = ? , SET `sur_name` = ? , SET `last_name` = ? , SET `course` = ? , SET `room_id` = ? , SET `gender` = ? WHERE `id` = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = Connector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getSurName());
			statement.setString(3, entity.getLastName());
			statement.setInt(4, entity.getCourse());
			statement.setInt(5, entity.getRoomID());
			statement.setString(6, entity.getGender());
			statement.setInt(7, entity.getId());
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
		String sql = "DELETE FROM `student` WHERE `id` = ?";
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
	public ArrayList<Student> readAll() throws SQLException {
		String sql = "SELECT * FROM exam_scope";
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			c = Connector.getConnection();
			s = c.createStatement();
			r = s.executeQuery(sql);
			ArrayList<Student> examScopes = new ArrayList<>();
			while (r.next()) {
				Student examScope = new Student();
				examScope.setId(r.getInt("id"));
				examScope.setName(r.getString("name"));
				examScope.setSurName(r.getString("sur_name"));
				examScope.setLastName(r.getString("last_name"));
				examScope.setCourse(r.getInt("course"));
				examScope.setRoomID(r.getInt("room_id"));
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
