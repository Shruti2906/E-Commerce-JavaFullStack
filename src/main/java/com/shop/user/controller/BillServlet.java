package com.shop.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.user.model.Cart;
import com.shop.user.services.UserServicesImpl;
import com.shop.user.model.Bill;
import com.shop.admin.model.Product;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Bill servlet called..");

		HttpSession session = request.getSession(true);
		List<Cart> lst = (List<Cart>)session.getAttribute("cartProdLst");
		
		UserServicesImpl userImpl = new UserServicesImpl();
		
		float total = 0; 
		float cgst, sgst, finalTotal;
		
		for(Cart p:lst) {
			int qty = userImpl.getPurchaseQty(p.getProductId(), p.getUserName());
			total += (p.getProductPrice()*qty);
			
		}
		cgst = total*0.05f;
		sgst = total*0.04f;
		finalTotal = total+cgst+sgst;
		Bill bobj = new Bill(total, cgst, sgst, finalTotal);
		session.setAttribute("bill", bobj);
		System.out.println("bill "+bobj.getFinalTotal());
		response.sendRedirect("Bill.jsp");
	//	pw.print("total Payment Amount : "+total);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
