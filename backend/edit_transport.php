<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "weddingdb";
	
	$con=mysql_connect($host,$user,$password) 
	or die("Could not connect: ".mysql_error());
	mysql_select_db($database) 
	or die("Error in selecting the database:".mysql_error());
	$route=$_POST['route'];
	$drivername=$_POST['drivername'];
	$driverno=$_POST['driverno'];
	$vehicleno=$_POST['vehicleno'];
	$transdate=$_POST['transdate'];
	
	$r=mysqli_query($con,"update tbl_transport set drivername='$drivername',driverno='$driverno',vehicleno='$vehicleno',transdate='$transdate' where route='$route'");
	?>	  