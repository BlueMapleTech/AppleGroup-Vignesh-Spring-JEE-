<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LIst oF Movie</h1>
<a href="adminhome">HOME</a>
<table border="1" width="100%">
		<table border="1" width="100%">
					<thead>
						<tr>
							<th>Name</th>
							<th>Release Date</th>
							<th>edit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="Admin" items="${MovieList}">
							<tr>
								<td><c:out value="${Admin.movie_name}" /></td>
								<td><c:out value="${Admin.release_date}" /></td>
								<td><a href="edit?id=${Admin.movie_id}">Edit</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>