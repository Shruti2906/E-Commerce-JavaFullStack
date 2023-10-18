package com.shop.admin.controller;

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
 * Servlet implementation class ProductQtyController
 */
@WebServlet("/ProductQtyController")
public class ProductQtyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductQtyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Product Qty Controller..");
		HttpSession session = request.getSession(true);
		List<Product> plst = (List<Product>) session.getAttribute("prodLst");
		
		ProductServices prodImpl = new ProductServicesImpl();
		boolean b = prodImpl.decreaseQty(plst);
		if(b) {
			System.out.println("back in p qty con");
			UserServices userImpl = new UserServicesImpl();
			List<Product> lst = userImpl.displayAllAvailables();
			
			session.setAttribute("userProdlst", lst);
			response.sendRedirect("User_DisplayAllProd.jsp");
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
