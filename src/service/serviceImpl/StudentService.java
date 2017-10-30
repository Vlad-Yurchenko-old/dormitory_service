package service.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import dao.daoImpl.StudentDao;
import domain.entityImpl.Student;
import service.Service;

public class StudentService implements Service<Student>{

	private StudentDao studentDao;
	
	public StudentService() {
		studentDao = new StudentDao();
	}
	
	@Override
	public void create(Student entity) {
		try {
			studentDao.create(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Student read(int id) {
		try {
			return studentDao.read(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Student entity) {
		try {
			studentDao.update(entity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			studentDao.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> readAll() {
		try {
			return studentDao.readAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
