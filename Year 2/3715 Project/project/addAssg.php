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

	$value = $_POST['val'];
	$weight = $_POST['weight'];
	$asname = $_POST['asname'];
	$class_id = $_POST['classid'];
		
	$sql = "INSERT INTO assignments VALUES (null," . $value . "," . $weight . ",'" . $asname . "'," . $class_id . ", null)";
	$conn->query($sql);
	
?>