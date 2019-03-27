<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());
	$venue=$_POST['venue'];
	
	
	//$r=mysqli_query($con,"delete from tbl_sangit where venue='ddd'");	
	$r=mysqli_query($con,"delete from tbl_sangit where venue='$venue'");	
	
?>	  