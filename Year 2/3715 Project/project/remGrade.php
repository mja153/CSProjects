<?php

	$username = "cs3715_mja153";
	$password = "orangegreen0";
	$hostname = "mysql.cs.mun.ca";
	$database = "cs3715_mja153";

	//creates a connection to the database
	$conn = new mysqli($hostname, $username, $password, $database) 
		or die("Unable to connect to MySQL");

	$stud_id = $_POST['studid'];
	$assg_id = $_POST['assgid'];
	
	$sql = "DELETE FROM mark WHERE assn_id=" . $assg_id . " AND stud_id= " . $stud_id;
	$conn->query($sql);
	
?>
