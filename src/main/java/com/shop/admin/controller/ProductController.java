package com.shop.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		double productPrice = Double.parseDouble(request.getParameter("productPrice"));
		int ProductQty = Integer.parseInt(request.getParameter("ProductQty"));
		
		Product prod = new Product();
		prod.setProductId(productId);
		prod.setProductName(productName);
		prod.setProductPrice(productPrice);
		prod.setProductQty(ProductQty);
				
		List<Product> lst = new ArrayList();
		lst.add(prod);
		
		ProductServices prodImpl = new ProductServicesImpl();
		String str = prodImpl.create(lst);
		
		//if(str.equals("ORA-00001: unique constraint (SYSTEM.PRODUCT_PROD_ID_PK) violated")) {
			//str = "Product Id must be Unique";
		//}
		System.out.println("str: "+str);
		
		HttpSession session = request.getSession();
		
		if(str.equals("valid")) {
			session.setAttribute("successMsg", str);
			session.setAttribute("errMsg", null);
		}
		else {
			session.setAttribute("successMsg", null);
			session.setAttribute("errMsg", str);
		}
		
		response.sendRedirect("ProductView.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
