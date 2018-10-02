<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "weddingdb";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());
	$venue=$_POST['venue'];
	$poc=$_POST['poc'];
	$description=$_POST['description'];
	
	$r=mysqli_query($con,"insert into tbl_sangit values('$venue','$poc','$description')");	
	mysqli_close($con);
?>	  