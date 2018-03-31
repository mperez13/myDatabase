<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Performance</title>
</head>
<body>
<div class="container">
        <div class="jumbotron">
          <h1>Performances</h1>
        </div>
	<form action="select/SelectPerformance" method="post">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Song ID</th>
					<th scope="col">Musician SSN</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${perf}" var="it">
					<tr>
						<th scope="row">${it.id}</th>
						<td>${it.song_id}</td>
						<td>${it.m_ssn}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
	<a href="index.jsp">back to home</a>
</body>
</html>
