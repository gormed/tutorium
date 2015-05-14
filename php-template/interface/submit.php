<?php 

$mysqli = $GLOBALS['mysqli'];

if(		isset($_POST['type']) 
	&& 	isset($_POST['email']) && strlen($_POST['email']) > 5)
{
	if ($_POST['type'] == "subscribe_newsletter")
	{
		$active = 1;
	}
	else if ($_POST['type'] == "unsubscribe_newsletter")
	{
		$active = 0;
	}

	$email = htmlspecialchars($_POST['email'], ENT_QUOTES, "UTF-8");

	$query = sprintf("SELECT * FROM Newsletter WHERE Email LIKE '%s' LIMIT 0, 1", $email);

	$emails = $mysqli->query($query);

	if(isset($emails) && 
		(($emails->num_rows > 0 && $active == 1) 
			|| ($emails->num_rows < 1 && $active == 0)) ) 
	{
		$result_newsletter = '<span class="error">Email already exists!</span>';
	}
	else if (isset($email)) 
	{
		if ($insertStmt = $mysqli->prepare("INSERT INTO Newsletter (Email, Active) VALUES (?, ?)")) 
		{
			$insertStmt->bind_param('si', $email, $active); 

			$insertStmt->execute();
			if ($active)
			{
				$result_newsletter = '<span class="success">Thank you '.$email.' for subscribing!</span>';
			}
			else
			{
				$result_newsletter = '<span class="success">Unsubscribed '.$email.' from newsletter!</span>';
			}
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