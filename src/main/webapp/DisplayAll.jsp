<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.shop.admin.model.*"%>
     <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Display all products</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style>
body {
  margin: 0;
  padding: 0;
  
  background: linear-gradient(to top right, #7c89d5, #f599a5);
  height: 100vh;
}
</style>
</head>
<body>
<!-- <h1>hello</h1> -->
<!-- <button type="button" class="btn btn-primary btn-lg btn-block">Block level button</button><br>-->
		
		<div class="col-sm-8" style="padding-top:2%; padding-left:40%; padding:right:10%;">
    		<h2 class="d-inline-block text-white text-center">All Product List</h2>
			<a href="AdminDashboard.jsp"><button type="button" class="btn btn-light float-right">Home</button></a>
    	</div>
    	<br>
		
	<%!List<Product> lst = null;
			
	%>
	
	<%
		if(!session.isNew()){
			lst = (List<Product>)session.getAttribute("prodlst");
			if(lst != null){
				
		%>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Id</th><th scope="col">Name</th><th scope="col">Price</th><th scope="col">Quantity</th>
				    </tr>
				  </thead>
				  <tbody>
				<% for(Product prod:lst){	%>
				
					<tr>
				    <th scope="row"><%=prod.getProductId() %></th>
				    <td><%=prod.getProductName() %></td>
				    <td><%=prod.getProductPrice() %></td>
				    <td><%=prod.getProductQty() %></td>
				    </tr>
				
					
				<% } %>
				 </tbody>
				</table>
		<%	}
			else{
		%>
				<h2 style="color:red">No Record Found.!</h2>
		<%		
			}
		session.invalidate();
		}
		%>
	
</body>
</html>

<!--  table
<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th><th scope="col">Name</th><th scope="col">Price</th><th scope="col">Quantity</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
 -->


