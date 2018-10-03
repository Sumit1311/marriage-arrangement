<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) 
	or die("Error in selecting the database:".mysql_error());
	$partname=$_POST['partname'];
	$partno=$_POST['partno'];
	$parttype=$_POST['parttype'];
	
	$r=mysqli_query($con,"insert into tbl_participants values('$partname','$partno','$parttype')");	
	
?>	  