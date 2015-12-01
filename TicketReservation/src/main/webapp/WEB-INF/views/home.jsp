<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
${msg}
<h1>LOGIN</h1>
	<form action="login" method="post">
	USERNAME<input type="text" name="userName"/><br>
	PASSWORD<input type="text" name="password"/><br>
	<input type="submit" value="login"/>
     
<a href="register">register</a>	 
</form>
</body>
</html>
