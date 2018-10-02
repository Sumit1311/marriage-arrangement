<?php 
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "weddingdb";
	
	$con=mysql_connect($host,$user,$password) 
	or die("Could not connect: ".mysql_error());
	mysql_select_db($database) 
	or die("Error in selecting the database:".mysql_error());
	$venue=$_POST['venue'];
	$poc=$_POST['poc'];
	$description=$_POST['description'];
	
	$r=mysql_query("insert into tbl_sangit values('$venue','$poc','$description')",$con);	
	mysql_close($con);
?>	  