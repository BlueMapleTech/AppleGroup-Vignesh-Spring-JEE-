<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>MOVIE</h1>
	<form action="movies" method="post">
	MOVIENAME<input type="text" name="movie_name"/><br>
	ReleseDate<input type="text" name="release_date"/><br>
	NO.of.SHOW<input type="text" name="no_of_shows"/>
	         <input type="hidden" id="movie_id" name="movie_id" value=${userId}>
	<input type="submit" value="submit"/>
     </form>
</body>
</html>