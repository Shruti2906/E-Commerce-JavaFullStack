package com.shop.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.admin.model.Product;
import com.shop.admin.services.ProductServices;
import com.shop.admin.services.ProductServicesImpl;
import com.shop.user.services.UserServices;
import com.shop.user.services.UserServicesImpl;

/**
 * Servlet implementation class DisplayAllProdController
 */
@WebServlet("/DisplayAllProdController")
public class DisplayAllProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllProdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("display all prod controller");
		UserServices userImpl = new UserServicesImpl();
		//only those products will be displayed whose Qty is less greater than 0
		List<Product> lst = userImpl.displayAllAvailables();
		System.out.println("back in display con after user impl");
		HttpSession session = request.getSession();
		session.setAttribute("userProdlst", lst);
		session.setAttribute("pAddStatus", null);
		
		System.out.println("redireting to userdisplayall.jsp");
		response.sendRedirect("User_DisplayAllProd.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
