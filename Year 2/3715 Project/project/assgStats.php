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
	$asId = $_POST['asid'];
	$stId = $_POST['stid'];
	$get_assgStats = "SELECT value,weight,name,comments from assignments WHERE assg_id = " . $asId;
	$assgStats = $conn->query($get_assgStats);
	$get_assgScore = "SELECT score from mark WHERE assn_id = " . $asId . " AND stud_id = " . $stId;
	$row = $conn->query($get_assgScore)->fetch_assoc();
	$assgScore = $row["score"];
	if ($assgScore == null)
		$assgScore = 0;
	
	if ($assgStats->num_rows > 0) {
		while ($row = $assgStats->fetch_assoc()) {
			echo "<div class=\"two\" style=\"font-size:120%;\"><b>Name: </b>" . $row["name"] . "</div><br>";
			echo "<div class=\"two\" style=\"font-size:120%;\"><b>Achieved Score: </b>" . $assgScore . "/" . $row["value"]. "</div><br>";
			echo "<div class=\"two\" style=\"font-size:120%;\"><b>Achieved Score (%): </b>". $assgScore / $row["value"] * 100 . "%</div><br>";
			echo "<div class=\"two\" style=\"font-size:120%;\"><b>Weight: </b>" . $row["weight"]. "</div><br>";
		}
	}
	else {
		echo "0 results";
	}
	
	

?>