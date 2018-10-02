<?php 
define('UPLOAD_PATH', '/uploads_invitation/');
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "weddingdb";
	$con=new mysqli($host,$user,$password,$database);	
	if($con->connect_error)
	{
		die("connection failed". $con->connect_error);
	}
	$invitation_array=array();
	$sql="select pageno,invitation_path from tbl_invitation;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($pageno,$invitation_path);
	while($statement->fetch())
	{
	$absurl = 'http://' . gethostbyname(gethostname()) .':81'. '/wedding' . UPLOAD_PATH . $invitation_path;	


	$temp=['pageno'=>$pageno,'invitation_path'=>$absurl];
	array_push($invitation_array,$temp);
	}			
	echo json_encode($invitation_array);
?>	  