<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "weddingdb";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) 
	or die("Error in selecting the database:".mysql_error());
	$menu_type=$_POST['menu_type'];
	$menu_time=$_POST['menu_time'];
	$menu_dt=$_POST['menu_dt'];
$r=mysqli_query($con,"insert into tbl_menu values(1,'$menu_type','$menu_time','$menu_dt')");	
	


?>	  