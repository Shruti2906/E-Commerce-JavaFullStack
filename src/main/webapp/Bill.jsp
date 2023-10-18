<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.shop.user.model.Bill" %>
     <%@ page import="com.shop.user.model.Cart" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!List<Cart> lst = null;
		Bill bobj = null;
	%>
	
	<%List<Cart> lst = (List<Cart>) session.getAttribute("cartProdLst"); 
		for(Cart p:lst){
			
		%>
			<table>
				<tr>
					<td><%=p.getProductId() %></td>
					<td><%=p.getProductName() %></td>
					<td><%=p.getProductPrice() %></td>
					
				</tr>
			</table>	
			
		<%
		}
	%>
	<h1>Bill Details</h1>
	
	<%
		bobj = (Bill) session.getAttribute("bill");
	%>
	<table border="solid" style="font-size: 30px;">
		<tr>
			<th>Total</th>
			<th>CGST</th>
			<th>SGST</th>
			<th>FinalTotal</th>
		</tr>
		<tr>
			<td><%=bobj.getTotal() %></td>
			<td><%=bobj.getCgst() %></td>
			<td><%=bobj.getSgst() %></td>
			<td><%=bobj.getFinalTotal() %></td>
		</tr>
	</table><br>
		<form action="WorkInProgress.jsp" style="font-size: 30px;">
						<button type="submit">Proceed to Pay</button>
					</form>

</body>
</html>