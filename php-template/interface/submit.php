<?php 

$mysqli = $GLOBALS['mysqli'];

if(		isset($_POST['type']) && $_POST['type'] == "email"
	&& 	isset($_POST['email']) && strlen($_POST['email']) > 5)
{
	$email = htmlspecialchars($_POST['email'], ENT_QUOTES, "UTF-8");
	$active = 1;

	$query = sprintf("SELECT * FROM Newsletter WHERE Email LIKE '%s' LIMIT 0, 1", $email);

	$emails = $mysqli->query($query);

	if(isset($emails) && $emails->num_rows > 0) 
	{
		$result_newsletter = '<span class="error">Email already exists!</span>';
	}
	else if (isset($email)) 
	{
		if ($insertStmt = $mysqli->prepare("INSERT INTO Newsletter (Email, Active) VALUES (?, ?)")) 
		{
			$insertStmt->bind_param('si', $email, $active); 

			$insertStmt->execute();
			$result_newsletter = '<span class="success">Successful added '.$email.'!</span>';
		}
		else
		{
			$result_newsletter = '<span class="error">Failed to insert '.$email.'!</span>';
		}
	}
}
else
{
	$result_newsletter = '<span class="info">Get infos about unimportant stuff!</span>';
}
?>