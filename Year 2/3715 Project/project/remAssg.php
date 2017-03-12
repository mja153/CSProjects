<?php

	//Credentials for the MySQL database will go in these variables
	//A MySQL Database has been supplied with the submission

	$username = "cs3715_mja153";
	$password = "orangegreen0";
	$hostname = "mysql.cs.mun.ca";
	$database = "cs3715_mja153";

	//creates a connection to the database
	$conn = new mysqli($hostname, $username, $password, $database) 
		or die("Unable to connect to MySQL");

	$assg_id = $_POST['assgid'];
		
	$sql = "DELETE FROM mark WHERE assn_id = " . $assg_id;
	$conn->query($sql);
	$sql = "DELETE FROM assignments WHERE assg_id = " . $assg_id;
	$conn->query($sql);	
		
?>
