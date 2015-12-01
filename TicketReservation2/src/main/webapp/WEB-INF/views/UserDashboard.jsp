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
${msg}
<div class="container-fluid">
		<h1>Admin Dashboard</h1>

		
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

							<c:forEach var="model" items="${List.data}">


								<tr>
									<c:forEach items="${model.movies}" var="admin">
										<tr>
											<td><c:out value="${admin.movie_name}" /></td>
											<td><c:out value="${admin.release_date}" /></td>
											<td><a href="edit?id=${admin.movie_id}">Edit</a></td>
										</tr>
									</c:forEach>
							</c:forEach>
						</tbody>
					</table>
				</div>
</div>
</div>
</div>

</body>
</html>