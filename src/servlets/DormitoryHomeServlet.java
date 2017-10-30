package servlets;

import static util.Constants.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.mysql.Connector;
import domain.entityImpl.Dormitory;
import service.serviceFactory.ServiceFactory;

/**
 * Servlet implementation class HomeServlet
 */
//@WebServlet("/HomeServlet")
public class DormitoryHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Connector.init(DRIVER, URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DormitoryHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		for(Dormitory dormitory: ServiceFactory.getDormitoryService().readAll()){
			System.out.println(dormitory.getAddress());
		}
		
		//String param = request.getParameter("id");
		getServletContext().getRequestDispatcher("/pages/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
