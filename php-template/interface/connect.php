
<?php

define("HOST", "localhost");
define("USER", "");
define("PASSWORD", "");
define("DATABASE", "");

$mysqli = new mysqli(HOST, USER, PASSWORD, DATABASE);
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