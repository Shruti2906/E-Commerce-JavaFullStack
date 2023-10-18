package com.shop.superAdmin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.superAdmin.model.Register;
import com.shop.superAdmin.services.RegisterServices;
import com.shop.superAdmin.services.RegisterServicesImpl;


/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in reg controller");
		Register reg = new Register();
	//	reg.setName(request.getParameter("firstName"));
		
		reg.setFirstName(request.getParameter("firstName"));
		reg.setLastName(request.getParameter("lastName"));
		reg.setEmail(request.getParameter("email"));
		reg.setGender(request.getParameter("gender"));
		reg.setUserName(request.getParameter("userName"));
		reg.setPassword(request.getParameter("password"));
		reg.setRegisterType(request.getParameter("registerType"));
		
		
		System.out.println(reg.getFirstName()+"\t"+reg.getLastName()+"\t"+reg.getEmail()+"\t"+reg.getGender()+"\t"+reg.getUserName()+"\t"+reg.getPassword()+"\t"+reg.getRegisterType());
		
		List<Register> lst = new ArrayList();
		lst.add(reg);
		
		RegisterServices regDao = new RegisterServicesImpl();
		int i = regDao.create(lst);
		
		if(i>0) {
//			//HttpSession session = request.getSession();
//			//session.setAttribute("CurrUser", lst);
			System.out.println("register successfull");
			if(reg.getRegisterType().equalsIgnoreCase("user")){
				response.sendRedirect("Login.jsp");
			}
			else {
				response.sendRedirect("Login.jsp");
			}
		}
		else {
			response.sendRedirect("ErrorPage.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
