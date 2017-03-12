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

	$fName = $_POST['fname'];
	$lName = $_POST['lname'];
	$class_id = $_POST['classid'];
	
	$sql = "INSERT INTO person VALUES (null,'" . $fName . "','" . $lName . "')";
	$conn->query($sql);
	$sql = "INSERT INTO student VALUES ((SELECT stud_id FROM person WHERE (fName = '" . $fName . "' AND lName = '" . $lName . "'))," . $class_id . ")";
	$conn->query($sql);	
		
?>
