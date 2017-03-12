<?php

	$assg_id = $_POST['asid'];
	session_start();
	$_SESSION["assgid"] = $assg_id;
	echo $_SESSION["assgid"];

?>