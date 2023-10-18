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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style>
@import url("https://fonts.googleapis.com/css?family=Luckiest+Guy");
/* BODY */

body {
  margin: 0;
  padding: 0;
  
  /*background: linear-gradient(to top right, #7c89d5, #f599a5);
  /*height: 100vh;*/
}

::selection {
  background: transparent;
}
/* CLOUDS */

/* JUMP */
h1 {
  cursor: default;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 70%;
  height: 60px;
  margin: auto;
  display: block;
  text-align: center;
}

h1 span {
  top: 10px;
  display: inline-block;
  -webkit-animation: bounce 0.3s ease  alternate;
  font-size: 26px;
  
  color: green;
  text-shadow: 0 1px 0 #ccc, 0 2px 0 #ccc, 0 3px 0 #ccc, 0 4px 0 #ccc,
    0 5px 0 #ccc, 0 6px 0 transparent, 0 7px 0 transparent, 0 7px 0 transparent,
    0 9px 0 transparent, 0 12px 12px rgba(0, 0, 0, 0.4);
}


/* ANIMATION */
@-webkit-keyframes bounce {
  80% {
    top: -20px;
    text-shadow: 0 1px 0 #ccc, 0 2px 0 #ccc, 0 3px 0 #ccc, 0 4px 0 #ccc,
      0 5px 0 #ccc, 0 6px 0 #ccc, 0 7px 0 #ccc, 0 8px 0 #ccc, 0 9px 0 #ccc,
      0 50px 25px rgba(0, 0, 0, 0.2);
  }
}



</style>
</head>
<body>
<!-- <h1>hello</h1> -->
<!-- <button type="button" class="btn btn-primary btn-lg btn-block">Block level button</button><br>-->
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Products Available in Bazaar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="Trial UserDashboard.jsp">DashBoard <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="CartController"><i class="fa fa-shopping-cart"></i>&nbsp View Cart</a>
      </li>
      <!-- <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li> -->
    </ul>
    <form class="form-inline my-2 my-lg-0" action="#search.jsp">
      <input class="form-control mr-sm-2" type="search" placeholder="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
		
		
	<!--  	<div class="col-sm-8" style="padding-top:2%; padding-left:24%; padding:right:0%;">
    		<h2 class="d-inline-block text-white text-center">All Product available in the Bazaar &nbsp&nbsp</h2>
			<a href="UserDashboard.jsp"><button type="button" class="btn btn-light float-right">Home</button></a>
    	</div>
    	<br>
-->		
	<%!List<Product> lst = null;
			
	%>
	
	<%
		if(!session.isNew()){
			lst = (List<Product>)session.getAttribute("userProdlst");
			String str = null; 
			str = (String)session.getAttribute("pAddStatus");
			
			if(lst != null){
				if(str != null){
					if(str.equalsIgnoreCase("true")){
				%>
					<h1><span>added to cart.!</span></h1>
					<!--  <p class="animated bounce slideInLeft infinite"><h1 style="color: green; text-align: center;">Product Added..!!</h1></p>-->
				<%
					}
					else{
						%>
						<h1><span style="color:red;">Unable to add at the moment.!</span></h1>
						<!--  <p class="animated bounce slideInLeft infinite"><h1 style="color: green; text-align: center;">Product Added..!!</h1></p>-->
					<%
					}
				}
		%>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">Id</th><th scope="col">Name</th><th scope="col">Price</th><th scope="col">Quantity</th> <th scope="col"><a href="CartController"></a></th>
				    </tr>
				  </thead>
				  <tbody>
				<% for(Product prod:lst){	%>
				<form action="AddProductController">
				
					<tr>
				    <th scope="row"><%=prod.getProductId() %></th>
				    <td><%=prod.getProductName() %></td>
				    <td><%=prod.getProductPrice() %></td>
				    <td><%=prod.getProductQty() %></td>
				    
				    <%!int id = 0; %>
				    <td><button type="submit" name="add" class="btn btn-primary btn-md" value="<%=prod.getProductId() %>">Add to Cart</button></td>
				    
				    <!-- <td><h1><span>added to cart</span></h1></td> -->
				    </tr>
				</form>
					
				<% } %>
				 </tbody>
				</table>
		<% session.setAttribute("pAddStatus", null);
		//session.invalidate();	
		}
			else{
		%>
				<h2 style="color:red">No Record Found.!</h2>
		<%		
			}
			str=null;
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


