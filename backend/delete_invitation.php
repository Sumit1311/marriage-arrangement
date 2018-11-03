<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());

	$pageno=$_POST['pageno'];
	
		
	$r=mysqli_query($con,"delete from tbl_invitation where pageno LIKE '%$pageno%'");	
	
?>	  