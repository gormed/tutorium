<?php

include_once './interface/submit.php';

?>

<center>
	<h3>Subscribe to newsletter</h3>
	<hr width="33%">
	<form>
			<input type="email" name="email" id="email" maxlength="256" placeholder="your@email.net" required>
			<button type="button" onclick="return Subscribe(form);">Subscribe</button>
	</form>
	<?php 
	if (isset($result_newsletter))
	{
		echo $result_newsletter;
	}
	?>
</center>

<script type="text/javascript">
	
function Subscribe(form) 
{
	var email_str = form.email.value;

	if (	email_str.length > 5
		&& 	email_str.indexOf("@") != -1 
		&& 	email_str.indexOf(".") != -1 
		&& 	email_str.indexOf("@") < email_str.lastIndexOf("."))
	{
		var type = document.createElement("input");
		form.appendChild(type);
		type.name = "type";
		type.type = "hidden";
		type.value = "email";

		form.setAttribute('method', "post");
		form.setAttribute('action', "./");
		form.setAttribute('role', "form");
		form.submit();
		return true;
	}
	return false;
}

</script>