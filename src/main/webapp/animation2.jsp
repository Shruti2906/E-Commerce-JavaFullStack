<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
@import url("https://fonts.googleapis.com/css?family=Luckiest+Guy");
/* BODY */

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
  width: 100%;
  height: 100px;
  margin: auto;
  display: block;
  text-align: center;
}

h1 span {
  top: 20px;
  display: inline-block;
  -webkit-animation: bounce 0.3s ease  alternate;
  font-size: 35px;
  color: #fff;
  text-shadow: 0 1px 0 #ccc, 0 2px 0 #ccc, 0 3px 0 #ccc, 0 4px 0 #ccc,
    0 5px 0 #ccc, 0 6px 0 transparent, 0 7px 0 transparent, 0 8px 0 transparent,
    0 9px 0 transparent, 0 10px 10px rgba(0, 0, 0, 0.4);
}




/* ANIMATION */
@-webkit-keyframes bounce {
  100% {
    top: -20px;
    text-shadow: 0 1px 0 #ccc, 0 2px 0 #ccc, 0 3px 0 #ccc, 0 4px 0 #ccc,
      0 5px 0 #ccc, 0 6px 0 #ccc, 0 7px 0 #ccc, 0 8px 0 #ccc, 0 9px 0 #ccc,
      0 50px 25px rgba(0, 0, 0, 0.2);
  }
}

</style>
</head>
<body>
<h1>
  <span>product added</span>
  
</h1>
</body>
</html>