<?php
class FileHandler
{
 
    private $con;
    public function __construct()
    {
 	define('DB_HOST', 'localhost');
	define('DB_USER', 'root');
	define('DB_PASS', '');
	define('DB_NAME', 'wedding');
	define('UPLOAD_PATH', '/uploads_invitation/'); 
	$this->con = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
	if (mysqli_connect_errno()) 
	{
            		echo 'Failed to connect ' . mysqli_connect_error();
           	 	return null;
        	}
    }
    public function saveFile($file, $extension,$pageno)
    {
        $name = round(microtime(true) * 1000) . '.' . $extension;
        $filedest = dirname(__FILE__) . UPLOAD_PATH . $name;
        move_uploaded_file($file, $filedest); 
        $stmt = $this->con->prepare("INSERT INTO tbl_invitation(pageno,imgpath) VALUES (?,?)");
        $stmt->bind_param("ss",$pageno,$name);
        if ($stmt->execute())
            return true;
        return false;
    }
 
 
}

