<?php 
//define('UPLOAD_PATH', '/uploads_transport/');
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	$con=new mysqli($host,$user,$password,$database);	
	if($con->connect_error)
	{
		die("connection failed". $con->connect_error);
	}
	$sangit_array=array();
	$sql="select venue,poc,description,timing from tbl_sangit;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($venue,$poc,$description,$timing);
	while($statement->fetch())
	{
	//$absurl = 'http://' . gethostbyname(gethostname()) .':81'. '/wedding' . UPLOAD_PATH . $vehicle_imgpath;	


	$temp=['venue'=>$venue,'poc'=>$poc,'description'=>$description,'timing'=>$timing];
	array_push($sangit_array,$temp);
	}			
	echo json_encode($sangit_array);
?>	  