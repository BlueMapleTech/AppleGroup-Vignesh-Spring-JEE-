<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addticket" method="post">
	TicketType<input type="text" name="ticket_type"/><br>
	TicketTypeCount<input type="text" name="ticket_type_count"/><br>
	         <input type="hidden" id="ticket_type_id" name="ticket_type_id" value=${ticket_type_id}>
	<input type="submit" value="submit"/>
     </form>
</body>
</html>