package service.serviceFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import domain.Entity;
import domain.entityImpl.Dormitory;
import domain.entityImpl.Room;
import domain.entityImpl.Student;
import service.Service;
import service.serviceImpl.DormitoryService;
import service.serviceImpl.RoomService;
import service.serviceImpl.StudentService;

public class ServiceFactory {

	@SuppressWarnings("rawtypes")
	private static final Map<Class<? extends Entity>, Service> SERVICES = new ConcurrentHashMap<Class<? extends Entity>, Service>();

	static {
		SERVICES.put(Dormitory.class, new DormitoryService());
		SERVICES.put(Room.class, new RoomService());
		SERVICES.put(Student.class, new StudentService());
	}

	public static DormitoryService getDormitoryService() {
		return (DormitoryService) SERVICES.get(Dormitory.class);
	}

	public static RoomService getRoomService() {
		return (RoomService) SERVICES.get(Room.class);
	}

	public static StudentService getStudentService() {
		return (StudentService) SERVICES.get(Student.class);
	}

}
