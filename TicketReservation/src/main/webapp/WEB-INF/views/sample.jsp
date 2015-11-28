<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
  
</head>



<body class="collapsing_header">
	<header>
		<div class="container">
			<div class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<a class="navbar-brand" href="index.html"> 
						 <span class="logo_title"><strong>BOOK UR SHOW</strong></span>
						</a>
							<p style="text-align:right">
						<a href="video.html"> <span>Sign in &nbsp; &nbsp; &nbsp;</span>
					<a href="sign.html"><span>Sign up</span></a></a></p>
				</div>

			</div>
			
				
			</div>
		
	</header>



<!-- yfghjkl

 --><div class="container-fluid">
                               <h1>Admin Dashboard</h1>
  

<div class="row">
   <!--  movies table -->
  <div class="col-md-6">movies<br>
  <table border="1" width="100%" height="30">
		
		<tr>
			
			<th>Name</th>
			<th>release</th>
			<th>edit</th>
			<th>rating</th>
			</tr>
			<c:forEach var="User" items="${UserList}">
			<tr>
				<td><c:out value="${User.id}"/></td>
				<td><c:out value="${User.name}" /></td>
				<td><c:out value="${User.password}" /></td>
				<td><c:out value="${User.email}" /></td>
	      </c:forEach>
			</table></div>
			
			<!--  timing table -->
  <div class="col-md-6">timing<br>
  <table border="1" width="100%" height="30">
		
		<tr>
			
			<th>timing</th>
			<th>edit</th>
			<th>active</th>
			</tr>
			<c:forEach var="User" items="${UserList}">
			<tr>
				<td><c:out value="${User.id}"/></td>
				<td><c:out value="${User.name}" /></td>
				<td><c:out value="${User.password}" /></td>
				<td><c:out value="${User.email}" /></td>
	      </c:forEach>
			</table></div>
			
			
			
			<!--  registration table -->
  <div class="col-md-6">registrationstatus<br>
  <table border="1" width="100%" height="30">
		
		<tr>
			
			<th>Name</th>
			<th>release</th>
			<th>edit</th>
			<th>rating</th>
			</tr>
			<c:forEach var="User" items="${UserList}">
			<tr>
				<td><c:out value="${User.id}"/></td>
				<td><c:out value="${User.name}" /></td>
				<td><c:out value="${User.password}" /></td>
				<td><c:out value="${User.email}" /></td>
	      </c:forEach>
			</table></div>
			<!--  ticket type table -->
  <div class="col-md-6">ticket type<br>
  <table border="1" width="100%" height="30">
		
		<tr>
			
			<th>timing</th>
			<th>edit</th>
			<th>active</th>
			</tr>
			<c:forEach var="User" items="${UserList}">
			<tr>
				<td><c:out value="${User.id}"/></td>
				<td><c:out value="${User.name}" /></td>
				<td><c:out value="${User.password}" /></td>
				<td><c:out value="${User.email}" /></td>
	      </c:forEach>
			</table></div>
</div>
  </div>


</body>
</html>
