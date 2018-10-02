<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "weddingdb";
	
	$con=mysql_connect($host,$user,$password) 
	or die("Could not connect: ".mysql_error());
	mysql_select_db($database) 
	or die("Error in selecting the database:".mysql_error());
	$vidhiname=$_POST['vidhiname'];
	$venue=$_POST['venue'];
	$des=$_POST['des'];
	
	$r=mysqli_query($con,"update tbl_other set venue='$venue',des='$des' where vidhiname='$vidhiname'");
	?>	  