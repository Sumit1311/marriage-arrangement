<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	
	$con=mysqli_connect($host,$user,$password);
	mysqli_select_db($con,$database) 
	or die("Error in selecting the database:".mysqli_error());
	$uname=$_POST['uname'];
	$pwd=$_POST['pwd'];
	$arrangertype=$_POST['arrangertype'];
	
	
$r=mysqli_query($con,"insert into tbl_user values('$uname','$pwd','$arrangertype')");
	//$r=mysqli_query($con,"insert into tbl_transpor values('kk','dd','dd','dd','dd')");
?>	  