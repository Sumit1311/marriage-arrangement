<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) 
	or die("Error in selecting the database:".mysql_error());
	$route=$_POST['route'];
	$drivername=$_POST['drivername'];
	$driverno=$_POST['driverno'];
	$vehicleno=$_POST['vehicleno'];
	$dt=$_POST['dt'];

$r=mysqli_query($con,"insert into tbl_transport values(1,'$route','$drivername','$driverno','$vehicleno','$dt')");
	//$r=mysqli_query($con,"insert into tbl_transport values('kk','dd','dd','dd','dd')");
	
	
	
?>	  