<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	$con=mysqli_connect($host,$user,$password);

	//$con=mysql_connect($host,$user,$password) 
//	or die("Could not connect: ".mysql_error());
	mysqli_select_db($con,$database) 
	or die("Error in selecting the database:".mysql_error());
	$roomno=$_POST['roomno'];
	$guest_nm=$_POST['guest_nm'];
	$guest_mob=$_POST['guest_mob'];
	
	$r=mysqli_query($con,"insert into tbl_room values('$roomno','$guest_nm','$guest_mob')");	
	//mysql_close($con);
?>	  