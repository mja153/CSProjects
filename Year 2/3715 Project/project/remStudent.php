<?php

	$username = "cs3715_mja153";
	$password = "orangegreen0";
	$hostname = "mysql.cs.mun.ca";
	$database = "cs3715_mja153";

	//creates a connection to the database
	$conn = new mysqli($hostname, $username, $password, $database) 
		or die("Unable to connect to MySQL");

	$stud_id = $_POST['stid'];
	
	$sql = "DELETE FROM mark WHERE stud_id = " . $stud_id;
	$conn->query($sql);
	$sql = "DELETE FROM student WHERE student_id = " . $stud_id;
	$conn->query($sql);	
	$sql = "DELETE FROM person WHERE stud_id = " . $stud_id;
		
?>
