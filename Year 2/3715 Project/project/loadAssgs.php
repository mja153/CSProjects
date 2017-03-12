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

	//index of class
	$i = $_POST['i'];
	$get_assgs = "SELECT name,assg_id from assignments WHERE class_id = " . $i;
	$assgs = $conn->query($get_assgs);


	if ($assgs->num_rows > 0) {
		while ($row = $assgs->fetch_assoc()) {
			echo "<option value=" . $row["assg_id"] . ">" . $row["name"]. "</option>";
		}
	}
	else {
		echo "<b>No assignments loaded</b>";
	}
	
?>
