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


@WebServlet("/verify")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username = request.getParameter("email");	
	String password = request.getParameter("password");
	
	DAOService service = new DAOServiceImpl();
	service.ConnectDB();
	boolean status = service.VerifyCredentials(username, password);
	
	if (status==true) {
		HttpSession session = request.getSession(true);
		session.setAttribute("email", username);
		session.setMaxInactiveInterval(10);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newregistration.jsp");
		rd.forward(request, response);
	}
	else {
		
		request.setAttribute("error", "invalid username/password");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	}

}
