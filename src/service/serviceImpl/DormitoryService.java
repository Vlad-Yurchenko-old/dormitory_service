package service.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import dao.daoImpl.DormitoryDao;
import domain.entityImpl.Dormitory;
import service.Service;

public class DormitoryService implements Service<Dormitory>{

	private DormitoryDao dDao;
	
	public DormitoryService() {
		dDao = new DormitoryDao();
	}
	
	@Override
	public void create(Dormitory entity) {
		try {
			dDao.create(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Dormitory read(int id) {
		try {
			return dDao.read(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Dormitory entity) {
		try {
			dDao.update(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			dDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Dormitory> readAll() {
		try {
			return dDao.readAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
