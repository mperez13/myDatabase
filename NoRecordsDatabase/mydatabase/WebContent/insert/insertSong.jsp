<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">  
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	<title>Add A Song</title>
</head>
<body>
	<main role="main">
	<div class="jumbotron">
	   <h1>Add A Song</h1>
  	</div>
	<div class="container">
	<form action="InsertSong" method="post">
		<div class="form-group">
			<label for="title">Song Title</label>
		    <input type="text" class="form-control" name="title"  placeholder="Enter Song Title"></input>
		</div>
		<div class="form-group">
			<label for="author">Song Author</label>
			<input type="text" class="form-control" name="author"  placeholder="Enter Song's Author"></input>
		</div>
		<div class="form-group">
			<label for="album_id">Album ID </label>
			<input type="text" class="form-control" name="album_id"  placeholder="Enter Album ID"></input>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	</main>
</body>
</html>