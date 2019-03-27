<?php
class Dbconnect
{
    private $con;
 
    public function connect()
    {
//        require_once dirname(__FILE__) . '/constants.php';
define('DB_HOST', 'localhost');
define('DB_USER', 'root');
define('DB_PASS', '');
define('DB_NAME', 'wedding');
 
define('UPLOAD_PATH', '/uploads_invitation/');

 
        $this->con = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
 
        if (mysqli_connect_errno()) {
            echo 'Failed to connect ' . mysqli_connect_error();
            return null;
        }
 
        return $this->con;
    }
}

