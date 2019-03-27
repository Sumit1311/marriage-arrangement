<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());

	$t_id=$_POST['t_id'];
	
	//$r=mysqli_query($con,"update tbl_menu set menu_type='kkk',menu_time='oooo',menu_dt='eeee' where mid=1");	
	$r=mysqli_query($con,"delete from tbl_transport where t_id=$t_id");	
	
?>	  