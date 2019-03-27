<?php 
define('UPLOAD_PATH', '/uploads_menu/');
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	$con=new mysqli($host,$user,$password,$database);	
	if($con->connect_error)
	{
		die("connection failed". $con->connect_error);
	}
	$menu_array=array();
	$sql="select m_id,menu_type,menu_time,menu_dt from tbl_menu;";
	$statement=$con->prepare($sql);
	$statement->execute();
	$statement->bind_result($m_id,$menu_type,$menu_time,$menu_dt);
	while($statement->fetch())
	{
	//$absurl = 'http://' . gethostbyname(gethostname()) .':81'. '/wedding' . UPLOAD_PATH . $menu_img;	


	$temp=['m_id'=>$m_id,'menu_type'=>$menu_type,'menu_time'=>$menu_time,'menu_dt'=>$menu_dt];
	array_push($menu_array,$temp);
	}			
	echo json_encode($menu_array);
?>	  