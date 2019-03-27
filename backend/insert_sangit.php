<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password)
	or die("Could not connect: ".mysql_error());
	mysqli_select_db($con,$database)  
	or die("Error in selecting the database:".mysql_error());
	$venue=$_POST['venue'];
	$poc=$_POST['poc'];
	$description=$_POST['description'];
	$timing=$_POST['timing'];	
//$r=mysqli_query($con,"insert into tbl_sangit values('ddd','989898','dd')");	
	$r=mysqli_query($con,"insert into tbl_sangit values('$venue','$poc','$description','$timing')");	
	mysqli_close($con);
?>	  