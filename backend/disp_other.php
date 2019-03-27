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
	$other_array=array();
	$sql="select venue,poc,description,vidhiname from tbl_other;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($venue,$poc,$description,$vidhiname);
	while($statement->fetch())
	{
	//$absurl = 'http://' . gethostbyname(gethostname()) .':81'. '/wedding' . UPLOAD_PATH . $menu_img;	


	$temp=['venue'=>$venue,'poc'=>$poc,'description'=>$description,'vidhiname'=>$vidhiname];
	array_push($other_array,$temp);
	}			
	echo json_encode($other_array);
?>	  