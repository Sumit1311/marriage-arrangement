<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());
	$uname=$_POST['uname'];	
	$r=mysqli_query($con,"delete from tbl_user where uname='$uname'");	
	
?>	  