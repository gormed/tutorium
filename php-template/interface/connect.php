
<?php

define("HOST", "localhost");
define("USER", "template_user");
define("PASSWORD", "12345");
define("DATABASE", "template_db");

$mysqli = new mysqli("p:".HOST, USER, PASSWORD, DATABASE);
$GLOBALS['mysqli'] = $mysqli;

/* check connection */
if ($mysqli->connect_errno) 
{
    echo "Connect failed:".$mysqli->connect_error;
    exit();
}
else
{
	echo "Successful connected to database!";
}

?>