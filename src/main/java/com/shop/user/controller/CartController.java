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
import com.shop.superAdmin.model.Register;
import com.shop.user.model.Cart;
import com.shop.user.services.UserServicesImpl;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("cart controller..");
		HttpSession session = request.getSession(true);
		//List<Cart>clst =(List<Cart>) 
	
		List<Register> currentUserlst = (List<Register>) session.getAttribute("CurrentUser");
		Register currentUser = currentUserlst.get(0);
		
		UserServicesImpl userImpl = new UserServicesImpl(); 
		List<Cart> cartlst= userImpl.getCart(currentUser.getUserName());
		
		session.setAttribute("cartProdLst", cartlst);
		System.out.println("got carts");
		response.sendRedirect("Cart.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
