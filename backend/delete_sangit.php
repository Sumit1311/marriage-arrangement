<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "weddingdb";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) or die("Error in selecting the database:".mysql_error());
	$venue=$_POST['venue'];
	
	
	//$r=mysqli_query($con,"update tbl_menu set menu_type='kkk',menu_time='oooo',menu_dt='eeee' where mid=1");	
	$r=mysqli_query($con,"delete from tbl_sangit where venue='$venue'");	
	
?>	  