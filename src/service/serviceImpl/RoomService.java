package service.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import dao.daoImpl.RoomDao;
import domain.entityImpl.Room;
import service.Service;

public class RoomService implements Service<Room> {

	private RoomDao roomDao;

	public RoomService() {
		roomDao = new RoomDao();
	}

	@Override
	public void create(Room entity) {
		try {
			roomDao.create(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Room read(int id) {
		try {
			return roomDao.read(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Room entity) {
		try {
			roomDao.update(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			roomDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Room> readAll() {
		try {
			return roomDao.readAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
