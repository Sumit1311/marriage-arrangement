<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());
	
	$vidhiname=$_POST['vidhiname'];
	$venue=$_POST['venue'];
	$description=$_POST['description'];
	$poc=$_POST['poc'];

	$r=mysqli_query($con,"update tbl_other set venue='$venue',poc='$poc',description='$description' where vidhiname='$vidhiname'");	
	
?>	  