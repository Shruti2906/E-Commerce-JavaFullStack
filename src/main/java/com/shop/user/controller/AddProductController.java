package com.shop.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
import com.shop.user.services.UserServices;
import com.shop.user.services.UserServicesImpl;



/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	List<Product> plst;
    public AddProductController() {
        super();
        System.out.println("constructor called..");
        plst = new LinkedList<Product>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("in addprodcontroller");
		HttpSession session= request.getSession(true);
		
		//got product id from jsp
		int id = Integer.parseInt(request.getParameter("add"));
		System.out.println("id: "+id);
		
		//get product from product id
		UserServicesImpl userImpl = new UserServicesImpl(); 
		List<Product> templst= userImpl.getProductById(id);
		Product p = templst.get(0);
		
		
		List<Register> currentUserlst = (List<Register>) session.getAttribute("CurrentUser");
		Register currentUser = currentUserlst.get(0);
		
		if(p.getProductQty() > 0) {
		
			plst.add(p);
			
			Cart cart = new Cart(p.getProductId(), p.getProductName(), p.getProductPrice(), currentUser.getUserName());
			List<Cart> clst = new ArrayList();
			clst.add(cart);
			int i = userImpl.addToCart(clst);
			
			if(i>0) {
				System.out.println("going to prod qty con");
				session.setAttribute("pAddStatus", "true");
				//session.setAttribute("cartProdLst", clst);
				session.setAttribute("prodLst", plst);
				response.sendRedirect("ProductQtyController");
				
			}
			else {
				session.setAttribute("pAddStatus", "false");
				plst.remove(p);
				session.setAttribute("cartProdLst", plst);
			}
		}
		else {
			session.setAttribute("pAddStatus", "false");
		}
		
		
		
		
		//for debugging
		System.out.println("plst"+plst);
		for(Product prod:plst) {
			System.out.println(prod.getProductId()+"\t"+prod.getProductName()+"\t"+prod.getProductPrice()+"\t"+prod.getProductQty());
		}
		
		//response.sendRedirect("User_DisplayAllProd.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
