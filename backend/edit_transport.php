<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
		$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());

	$t_id=$_POST['t_id'];
	$route=$_POST['route'];
	$drivername=$_POST['drivername'];
	$driverno=$_POST['driverno'];
	$vehicleno=$_POST['vehicleno'];
	$dt=$_POST['dt'];
	
	$r=mysqli_query($con,"update tbl_transport set route='$route',drivername='$drivername',driverno='$driverno',vehicleno='$vehicleno',dt='$dt' where t_id=$t_id");

	?>	  