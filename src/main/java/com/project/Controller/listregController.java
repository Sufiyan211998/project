package com.project.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Model.DAOService;
import com.project.Model.DAOServiceImpl;


@WebServlet("/listleads")
public class listregController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public listregController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("email")!=null) {
			session.setMaxInactiveInterval(10);
		DAOService service = new DAOServiceImpl();
		service.ConnectDB();
		ResultSet registrations =service.listAll();
		request.setAttribute("registrations", registrations);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/listleads.jsp");
		rd.forward(request, response);
	}
else {
	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
	}catch (Exception e) {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
