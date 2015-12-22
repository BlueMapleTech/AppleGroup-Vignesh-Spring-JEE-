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
<div class="container-fluid">
		<h1>User DashBoard</h1>

		
			<div class="row">
				<!--  movies table -->
				<div class="col-md-6" style="background-color:lavender;">
					<h1>MOVIES</h1><br>
					<table border="4" width="100%">
						<thead>
							<tr>
								<th>Name</th>
								<th>Release Date</th>
								<th>BookShow</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="currentMovies" items="${currentMovies}">

<tr>
								
											<td><c:out value="${currentMovies.movie_name}" /></td>
											<td><c:out value="${currentMovies.release_date}" /></td>
											
										<td>	<form action = "Book" method="get">
									<input type="hidden"  name="user_id" value=${user_id} /> 
									<input type="hidden"  name="movie_id" value=<c:out value="${currentMovies.movie_id}"  /> /> 
									<input type="submit" value="book"></td>
											
										    </form></tr>
										   <%--  <td><a href="Book?id=${currentMovies.movie_id}">Book</a></td> --%>
									</c:forEach>
							
						</tbody>
					</table>
				</div>
</div>
</div>


</body>
</html>