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
	$user_array=array();
	$sql="select uname,pwd,arrangertype from tbl_user;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($uname,$pwd,$arrangertype);
	while($statement->fetch())
	{
	//$absurl = 'http://' . gethostbyname(gethostname()) . '/wedding' . UPLOAD_PATH . $menu_img;	


	$temp=['uname'=>$uname,'pwd'=>$pwd,'arrangertype'=>$arrangertype];
	array_push($user_array,$temp);
	}			
	echo json_encode($user_array);
?>	  