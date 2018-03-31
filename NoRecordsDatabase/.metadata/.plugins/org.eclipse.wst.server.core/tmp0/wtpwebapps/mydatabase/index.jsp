<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">  
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	<title>Home</title>
</head>
<body>
<div class="container">
        <div class="jumbotron">
          <h1>NoName Records</h1>
        </div>
	 <div class="container">
        <div class="row">
        <div class="col-md-4">
            <h2>Musicians</h2>
            <p><a class="btn btn-secondary" href="SelectMusician" role="button">View/Delete Musicians &raquo;</a></p>
            <p><a class="btn btn-secondary" href="InsertMusician" role="button">Add a Musician &raquo;</a></p>
          </div>
        <div class="col-md-4">
            <h2>Songs</h2>
            <p><a class="btn btn-secondary" href="SelectSong" role="button">View/Delete Songs &raquo;</a></p>
            <p><a class="btn btn-secondary" href="InsertSong" role="button">Add a new Song &raquo;</a></p>
          </div>
          <div class="col-md-4">
            <h2>Albums</h2>
            <p><a class="btn btn-secondary" href="SelectAlbum" role="button">View/Delete an Album &raquo;</a></p>
            <p><a class="btn btn-secondary" href="InsertAlbum" role="button">Insert Album &raquo;</a></p>
          </div>
          <div class="col-md-4">
          	<h2>Instrument Players</h2>
            <p><a class="btn btn-secondary" href="SelectInstrumentPlayer" role="button">View Instrument Player &raquo;</a></p>
          </div>
          <div class="col-md-4">
          <h2>Instruments</h2>
            <p><a class="btn btn-secondary" href="SelectInstrument" role="button">View Instruments &raquo;</a></p>
          </div>
          
          <div class="col-md-4">
            <h2>Performances</h2>
            <p> </p>
            <p><a class="btn btn-secondary" href="SelectPerformance" role="button">View Performances &raquo;</a></p>
          </div>
          <div class="col-md-4">
            <h2>Addresses</h2>
            <p><a class="btn btn-secondary" href="SelectPlace" role="button">View Addresses &raquo;</a></p>
          </div>
          
        <hr>
        </div>
      </div> <!-- /container -->
 </div>
</body>
</html>