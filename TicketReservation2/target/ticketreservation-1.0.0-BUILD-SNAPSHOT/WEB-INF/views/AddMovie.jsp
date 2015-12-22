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
	ReleseDate<input type="Date" name="release_date" placeholder="yyyy-mm-dd"/><br>
	NO.of.SHOW<input type="text" name="no_of_shows"/><br>
	    
	         <input type="hidden" id="movie_id" name="movie_id" value=${userId}>
	        <h2>TIMINGS</h2>
	         <input type="checkbox" name="count" value="1">7:00 AM - 10:00 AM<BR>
	         <input type="checkbox" name="count" value="2">10:00 AM - 1:00 PM<BR>
             <input type="checkbox" name="count" value="3">2:00 PM - 5:00 PM<BR>
             <input type="checkbox" name="count" value="4">6:30 PM - 9:30 PM<BR>
             
             <h3>TICKET RATE</h3>
    FirstClass <input type="text"  name="ticket_rate">
    SecondClass<input type="text" name="ticket_rate1">
	         <input type="submit" value="submit"/>
     </form>
</body>
</html>