<?php 
define('UPLOAD_PATH', '/uploads_transport/');
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "weddingdb";
	$con=new mysqli($host,$user,$password,$database);	
	if($con->connect_error)
	{
		die("connection failed". $con->connect_error);
	}
	$transport_array=array();
	$sql="select driver_nm,driver_mob,vehicle_no,vehicle_imgpath,vehicle_path from tbl_transport;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($driver_nm,$driver_mob,$vehicle_no,$vehicle_imgpath,$vehicle_path);
	while($statement->fetch())
	{
	$absurl = 'http://' . gethostbyname(gethostname()) .':81'. '/wedding' . UPLOAD_PATH . $vehicle_imgpath;	


	$temp=['driver_nm'=>$driver_nm,'driver_mob'=>$driver_mob,'vehicle_no'=>$vehicle_no,'vehicle_imgpath'=>$absurl,'vehicle_path'=>$vehicle_path];
	array_push($transport_array,$temp);
	}			
	echo json_encode($transport_array);
?>	  