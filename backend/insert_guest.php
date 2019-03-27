<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) 
	or die("Error in selecting the database:".mysql_error());
	$cname=$_POST['cname'];
	$cno=$_POST['cno'];
	$type_of_guest=$_POST['type_of_guest'];
	$guestaddr=$_POST['guestaddr'];
	$guestcat=$_POST['guestcat'];
	
	$r=mysqli_query($con,"insert into tbl_contact values('$cname','$cno','$type_of_guest','$guestaddr','$guestcat')");	
	
?>	  