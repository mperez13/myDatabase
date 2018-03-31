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
   	<title>Album</title>
</head>
<body>
<div class="container">
        <div class="jumbotron">
          <h1>Albums</h1>
        </div>
	<form action="select/SelectMusician" method="get">
		<table class="table">
			<thead class="thead-light">
			<tr>
				<th>ID</th>
				<th>Album ID</th>
				<th>Title</th>
				<th>Copyright Date</th>
				<th>Format</th>
				<th>Producer (m_ssn)</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${alb}" var="it">
			<tr>
				<td>${it.id}</td>
				<td>${it.album_id}</td>
				<td>${it.title}</td>
				<td>${it.copyright_dt}</td>
				<td>${it.format}</td>
				<td>${it.m_ssn}</td>
				<td>
					<a href="TotalSongsInAlbum?aid=${it.album_id}" class="btn btn-warning btn-xs">
							Get Song Total
					</a>
				</td>
				<td class="text-center">
					<a href="DeleteAlbum?id=${it.id}" class="btn btn-danger btn-xs">
						<span class="glyphicon glyphicon-trash"></span>
					</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<p><h3>There are currently ${cs} song(s) in that album.</h3></p>
		<p><h3>${de}</h3></p>
	</form>
</div>
	<a href="index.jsp">back to home</a>
	
</body>
</html>
