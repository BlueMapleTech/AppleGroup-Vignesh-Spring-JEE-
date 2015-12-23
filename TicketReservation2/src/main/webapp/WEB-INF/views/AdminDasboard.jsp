<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body class="collapsing_header">

	<h1>BOOK UR SHOW</h1>
	<a href="home">HOME</a>||
	<a href="MovieRegister">ADD MOVIE</a>||

	<a href="addingTime">ADD TIME</a>||

	<a href="tickettype">ADD TICKET</a>||

	<!-- <a href="registrationstatus">REGISTRATION STATUS</a>|| -->


	<div class="container-fluid">
		<h1>Admin Dashboard</h1>

		
			<div class="row">
				<!--  movies table -->
				<div class="col-md-6">
					<!-- style="background-color:lavender;" -->
					<h3>LIST OF MOVIES</h3>
					<table border="4" width="100%">
						<thead>
							<tr>
								<th>Name</th>
								<th>Release Date</th>
								<th>edit</th>
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


				<div class="row">
					<!--  time table -->
					<div class="col-md-6">
						<h3>LIST OF TIMINGS</h3>
						<table border="4" width="100%">
							<thead>
								<tr>
									<th>Timings</th>
									<th>Edit</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="mymodel" items="${List.data}">

									<c:forEach var="Time" items="${mymodel.times}">
										<tr>
											<td><c:out value="${Time.timings}" /></td>
											<td><a href="edit2?id=${Time.timings_id}">Edit</a></td>
										</tr>
									</c:forEach>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			
		</div>
		<!--  TicketType table -->
		
			<div class="row">
				<!--  time table -->
				<div class="col-md-6">
					<h3>TicketTypesAndCount</h3>
					<table border="4" width="100%">
						<thead>
							<tr>
								<th>TicketType</th>
								<th>Count</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="mymodel" items="${List.data}">
								<c:forEach var="Ticket" items="${mymodel.tickets}">
									<tr>

										<td><c:out value="${Ticket.ticket_type}" /></td>
										<td><c:out value="${Ticket.ticket_type_count}" /></td>
										<td><a href="edit3?id=${Ticket.ticket_type_id}">Edit</a></td>
									</tr>
								</c:forEach>
							</c:forEach>

						</tbody>
					</table>
				</div>
			
			<div class="row">
				<!--  time table -->
				<div class="col-md-6">
					<h3>ReservationStatus</h3>
					<table border="4" width="100%">
						<thead>
							<tr>
								<th>ReservationId</th>
								<th>Status</th>
								<!-- <th>Edit</th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="mymodel" items="${List.data}">
								<c:forEach var="Status" items="${mymodel.status}">
									<tr>

										<td><c:out value="${Status.reservation_status_id}" /></td>
										<td><c:out value="${Status.reservation_status}" /></td>
										<%-- <td><a href="edit3?id=${Ticket.reservation_status_id}">Edit</a></td> --%>
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