<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="java.util.List" %>
 <%@ page import="com.shop.user.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!List<Cart> lst = null; %>
	<%
		if(!session.isNew()){
			lst = (List<Cart>)session.getAttribute("cartProdLst");
			if(lst != null){%>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Id</th><th scope="col">Name</th><th scope="col">Price</th>
				    </tr>
				  </thead>
				  <tbody>
				<% for(Cart prod:lst){	%>
				
					<tr>
				    <th scope="row"><%=prod.getProductId() %></th>
				    <td><%=prod.getProductName() %></td>
				    <td><%=prod.getProductPrice() %></td>
				    
				    </tr>
				 
				<%} %>
				 </tbody>
				</table>
					<form action="BillServlet">
						<button type="submit">Get Bill</button>
					</form>
			<%}
			else{
				
					out.print("Cart is empty");
			}
		}	
	%>
	

</body>
</html>