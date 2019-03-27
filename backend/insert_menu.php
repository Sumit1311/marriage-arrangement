<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password)
	or die("Could not connect: ".mysql_error());
	mysqli_select_db($con,$database)  
	or die("Error in selecting the database:".mysql_error());
	$menu_type=$_POST['menu_type'];
	$menu_time=$_POST['menu_time'];
	$menu_dt=$_POST['menu_dt'];
	//$r=mysqli_query($con,"insert into tbl_menu values('ddd','dd','ddd')");	
	$r=mysqli_query($con,"insert into tbl_menu(menu_type,menu_time,menu_dt) values('$menu_type','$menu_time','$menu_dt')");	
	//mysqli_close($con);
?>	  