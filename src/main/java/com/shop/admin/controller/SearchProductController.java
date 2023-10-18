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

/**
 * Servlet implementation class SearchProductController
 */
@WebServlet("/SearchProductController")
public class SearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in searchcom");
		
		String prodId = request.getParameter("productId");
		int productId = Integer.parseInt(prodId);
		
		ProductServices prodImpl = new ProductServicesImpl();
		List<Product> lst = prodImpl.retreiveProduct(productId);
		HttpSession session = request.getSession();
		if(lst != null) {
			session.setAttribute("SearchProdStatus", "true");
			session.setAttribute("SearchProdlst", lst);
		}
		else{
			session.setAttribute("SearchProdStatus", "false");
			
		}
		
		response.sendRedirect("SearchProduct.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
