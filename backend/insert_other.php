<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) 
	or die("Error in selecting the database:".mysqli_error());
	$venue=$_POST['venue'];
	$poc=$_POST['poc'];
	$description=$_POST['description'];
	$vidhiname=$_POST['vidhiname'];
	
$r=mysqli_query($con,"insert into tbl_other values('$venue','$poc','$description','$vidhiname')");
	//$r=mysqli_query($con,"insert into tbl_transpor values('kk','dd','dd','dd','dd')");
?>	  