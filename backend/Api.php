<?php
 
require_once dirname(__FILE__) . '/FileHandler.php';
 
$response = array();
 
if (isset($_GET['apicall'])) {
    switch ($_GET['apicall']) {
        case 'upload':
 
            if (isset($_POST['pageno']) && strlen($_POST['pageno']) > 0 && $_FILES['image']['error'] ===
	 UPLOAD_ERR_OK) {
                $upload = new FileHandler();
 
                	$file = $_FILES['image']['tmp_name']; 
                	$pageno = $_POST['pageno'];
	                if ($upload->saveFile($file, getFileExtension($_FILES['image']['name']), $pageno)) 
	{
                    $response['error'] = false;
                    $response['message'] = 'File Uploaded Successfullly';
                }
 
            } else {
                $response['error'] = true;
                $response['message'] = 'Required parameters are not available';
            }
 
            break;
    }
}
 
echo json_encode($response);
 
function getFileExtension($file)
{
    $path_parts = pathinfo($file);
    return $path_parts['extension'];
}

