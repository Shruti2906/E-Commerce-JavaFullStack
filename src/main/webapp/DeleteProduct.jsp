<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.shop.admin.model.*"%>
    <%@page import="java.util.List"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Product</title>

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
#login .container #login-row #login-column #login-box {
  margin-top: 120px;
  max-width: 600px;
  height: 300px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
  margin-top:10%;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}
</style>
</head>

<body>

<div id="login">
        <h3 class="text-center text-white pt-5"></h3>
        <div class="container">	
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                      
                      
                        <form id="login-form" class="form" action="DeleteProductController" method="post">
                            <h3 class="text-center text-info">Delete Product</h3><br>
                            <div class="form-group">
                                <label for="username" class="text-info">Enter Product Id:</label><br>
                                <input type="text" name="productId" id="username" class="form-control" required>
                            </div><br>
                            <div class="form-group row">
                                <input type="submit" name="submit" class="btn btn-info btn-md col" value="submit" style="margin-left: 3%;">
                                <a href="AdminDashboard.jsp" class="text-info text-right col"><input type="" name="home" class="btn btn-info btn-md col" value="Home"></a>
                            </div>
                            <div>
                            	<%!String msg = null;%>

								<%
								if(!session.isNew()){
									msg = (String)session.getAttribute("statusMsg");
									if(msg != null){
								
										if(msg.equals("query ok")){
											%><h3 style="color:green">Product Deleted.!</h3><%
										}
										else{
											%><h3 style="color:red">Unable to Delete Product.!</h3><%
										}
										
									}
									else{
										 %><h3 style="color:red">Unable to Delete Product.!</h3><%
									}
									session.invalidate();
								}
								%>
                            </div>
                        </form>
                        
                        
                    </div>
                </div>
            </div>
        </div>
    </div>


</body>
</html>