<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());
	$mid=$_POST['mid'];
	
	//$r=mysqli_query($con,"delete from tbl_menu where m_id=2");	
	$r=mysqli_query($con,"delete from tbl_menu where m_id='$mid'");	
	
?>	  