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
	$participants_array=array();
	$sql="select partname,partno,parttype from tbl_participants;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($partname,$partno,$parttype);
	while($statement->fetch())
	{
	
	$temp=['partname'=>$partname,'partno'=>$partno,'parttype'=>$parttype];
	array_push($participants_array,$temp);
	}			
	echo json_encode($participants_array);
?>	  