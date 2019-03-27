<?php 
	define('UPLOAD_PATH', '/uploads_invitation/');
	 $host = "localhost";
	 $user = "root";
 	 $password = "";
 	 $database = "wedding";
	$con=new mysqli($host,$user,$password,$database);	
	if(isset($_POST['insert']))
	{
		$file=addslashes(file_get_contents($_FILES['image']['tmp_name']));
		$q="insert into t3 values('$file')";
		if(mysqli_query($con,$q))
		{
			echo "Inserted";
		}	
	}
?>
	<html
	<form method="post" enctype="multipart/form-data">
		<input type="file" name="image" id="image"/>
		<input type="submit" name="insert" id="insert" value="Insert"/>
	</form>
	</html>

	<script>
	$(document).ready(function(){
		$('#insert').click(function(){
	var image_name=$('#image').val();
	if(image_name=='')
	{
		alert("Select Image");
		return false;
	}		
	else
	{
		var extension=$('#image').val().split('.').pop().toLowerCase();
		if(jQuery.inArray(extension,['gif','png','jpg','jpeg'])==-1)
		{
			alert ('Inavalid image');
			$('#image').val('');
			return false;
		}
	}
		});
	});
	</script>
<?php	$sql="select * from t3;";
	$res=mysqli_query($con,$sql);
	while($row=mysqli_fetch_array($res))
	{
		 echo '<img src="data:image/jpeg;base64,'.base64_encode($row['name']).'"/>';
	}

?>	  