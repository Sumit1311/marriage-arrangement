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
	$transport_array=array();
	$sql="select t_id,route,drivername,driverno,vehicleno,dt from tbl_transport;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($t_id,$route,$drivername,$driverno,$vehicleno,$dt);
	while($statement->fetch())
	{
	//$absurl = 'http://' . gethostbyname(gethostname()) .':81'. '/wedding' . UPLOAD_PATH . $vehicle_imgpath;	


	$temp=['t_id'=>$t_id,'route'=>$route,'drivername'=>$drivername,'driverno'=>$driverno,'vehicleno'=>$vehicleno,'dt'=>$dt];
	array_push($transport_array,$temp);
	}			
	echo json_encode($transport_array);
?>	  