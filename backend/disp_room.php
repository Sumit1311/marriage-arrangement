<?php 
//define('UPLOAD_PATH', '/uploads_menu/');
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	$con=new mysqli($host,$user,$password,$database);	
	if($con->connect_error)
	{
		die("connection failed". $con->connect_error);
	}
	$room_array=array();
	$sql="select roomno,guest_nm,guest_mob from tbl_room;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($roomno,$guest_nm,$guest_mob);
	while($statement->fetch())
	{
	//$absurl = 'http://' . gethostbyname(gethostname()) .':81'. '/wedding' . UPLOAD_PATH . $menu_img;	


	$temp=['roomno'=>$roomno,'guest_nm'=>$guest_nm,'guest_mob'=>$guest_mob];
	array_push($room_array,$temp);
	}			
	echo json_encode($room_array);
?>	  