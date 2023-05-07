package com.project.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Model.DAOService;
import com.project.Model.DAOServiceImpl;


@WebServlet("/savereg")
public class saveregistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public saveregistrationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newregistration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("email")!=null) {
			session.setMaxInactiveInterval(10);
		
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	
	DAOService service = new DAOServiceImpl();
	service.ConnectDB();
	service.saveregistration(name,city,email,mobile);
	
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newregistration.jsp");
	rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}catch (Exception e) {
		request.setAttribute("error", "session timeout login again....");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}

}
