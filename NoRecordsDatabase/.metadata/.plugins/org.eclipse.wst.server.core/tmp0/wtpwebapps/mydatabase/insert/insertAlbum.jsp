<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">  
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	<title>Add An Album</title>
</head>
<body>
	<main role="main">
	<div class="jumbotron">
	   <h1>Add an Album</h1>
  	</div>
	<div class="container">
	<form action="InsertAlbum" method="post">
		<div class="form-group">
			<label for="album_id">Album ID</label>
		    <input type="text" class="form-control" name="album_id"  placeholder="Enter Album ID"></input>
		</div>
		<div class="form-group">
			<label for="title">Title</label>
			<input type="text" class="form-control" name="title"  placeholder="Enter Album Title"></input>
		</div>
		<div class="form-group">
			<label for="copyright_dt">Copyright Date (YYYY-MM-DD)</label>
			<input type="text" class="form-control" name="copyright_dt"  placeholder="Enter Copyright Date"></input>
		</div>
		<div class="form-group">
			<label for="format">Album's Format (CD,DVD)</label>
			<input type="text" class="form-control" name="format"  placeholder="Enter Album's Format"></input>
		</div>
		<div class="form-group">
			<label for="m_ssn">Musician's Social Security Number</label>
			<input type="text" class="form-control" name="m_ssn"  placeholder="Enter Musician's Social Security Number"></input>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	</main>
</body>
</html>