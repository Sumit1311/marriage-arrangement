<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "weddingdb";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());
	$mid=$_POST['mid'];
	$menu_type=$_POST['menu_type'];
	$menu_time=$_POST['menu_time'];
	$menu_dt=$_POST['menu_dt'];
	
	//$r=mysqli_query($con,"update tbl_menu set menu_type='kkk',menu_time='oooo',menu_dt='eeee' where mid=1");	
	$r=mysqli_query($con,"update tbl_menu set menu_type='$menu_type',menu_time='$menu_time',menu_dt='$menu_dt' where mid=$mid");	
	
?>	  