<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">  
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	<title>Add A Musician</title>
</head>
<body>
	<main role="main">
	<div class="jumbotron">
	   <h1>Add a New Musician</h1>
  	</div>
	<div class="container">
	<form action="InsertMusician" method="post">
		<div class="form-group">
			<label for="ssn">Social Security Number</label>
		    <input type="text" class="form-control" name="ssn"  placeholder="Enter Social Security Number"></input>
		</div>
		<div class="form-group">
			<label for="name">Name</label>
			<input type="text" class="form-control" name="name"  placeholder="Enter Full Name"></input>
		</div>
		<div class="form-group">
			<label for="phoNo">Phone Number</label>
			<input type="text" aria-describedby="phoneNumHelp" class="form-control" name="phone_no"  placeholder="Enter in this format: 123-456-7890"></input>
			<small id="phoneNumHelp" class="form-text text-muted">Phone Number must already be in the system. If it is not, please go to Addresses and add it first.</small>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	</main>
</body>
</html>