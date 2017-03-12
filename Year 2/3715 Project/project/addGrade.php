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

	$stud_id = $_POST['studid'];
	$assg_id = $_POST['assgid'];
	$score = $_POST['score'];
	
	$sql = "INSERT INTO mark VALUES (" . $assg_id . "," . $stud_id . "," . $score . ")";
	$conn->query($sql);
	
?>
