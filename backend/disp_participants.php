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
	$participants_array=array();
	$sql="select p_id,pname,pmob,pper from tbl_participants;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($p_id,$pname,$pmob,$pper);
	while($statement->fetch())
	{
	
	$temp=['p_id'=>$p_id,'pname'=>$pname,'pmob'=>$pmob,'pper'=>$pper];
	array_push($participants_array,$temp);
	}			
	echo json_encode($participants_array);
?>	  