<?php 
//define('UPLOAD_PATH', '/uploads_invitation/');
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	$con=new mysqli($host,$user,$password,$database);	
	if($con->connect_error)
	{
		die("connection failed". $con->connect_error);
	}
	$contact_array=array();
	$sql="select cname,cno from tbl_contact;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($cname,$cno);
	while($statement->fetch())
	{
	//$absurl = 'http://' . gethostbyname(gethostname()) .':81'. '/wedding' . UPLOAD_PATH . $imgpath;	


	$temp=['cname'=>$cname,'cno'=>$cno];
	array_push($contact_array,$temp);
	}			
	echo json_encode($contact_array);
?>	  