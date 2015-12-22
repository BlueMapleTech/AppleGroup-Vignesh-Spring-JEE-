<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>REGISTRATION</h1>
	<form action="registration" method="post">
	UserName<input type="text" name="userName"/><br>
	Password<input type="password" name="password"/><br>
	FirstName<input type="text" name="firstName"/><br>
	LastName<input type="text" name="lastName"/><br>
	Email<input type="text" name="email"/><br>
	Address<input type="text" name="address"/><br>
	        <input type="hidden" id="user_role" name="user_role" value=1>
	<input type="submit" value="Register"/>
     </form>
</body>
</html>