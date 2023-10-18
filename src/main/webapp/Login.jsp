<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

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
  height: 380px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
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

	<body>
    <div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                      
                        <form id="login-form" class="form" action="LoginController" method="post">
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="username" id="username" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control" required="required">
                            </div>
                            <div class="form-group">
                                <label for="remember-me" class="text-info"><span>New User?</span></label><br>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                            
                            <div style="color:red">
                            <%
                            	if(!session.isNew()){
                            		String LoginSatus = null;
	                            	 LoginSatus = (String)session.getAttribute("LoginSatus");
	                            	if(LoginSatus != null){
	                            		if(LoginSatus.equalsIgnoreCase("false")){
	                            		%>
	                            		<h2>&nbspinvalid credentials.!</h2>
	                            		<%
	                            			session.invalidate();
	                            		}
	                            	}
                            	}
        	                    %>
                             
                            <div id="register-link" class="text-right">
                                <a href="Registration.html" class="text-info"><h5>Register here</h5></a>
                            </div>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>