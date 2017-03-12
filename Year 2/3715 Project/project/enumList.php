<?php

	$username = "cs3715_mja153";
	$password = "orangegreen0";
	$hostname = "mysql.cs.mun.ca";
	$database = "cs3715_mja153";
	
	//creates a connection to the database
	$conn = new mysqli($hostname, $username, $password, $database) 
		or die("Unable to connect to MySQL");

	echo "<tr><td class=one width=25>ID</td><td class=one width=250>Student Name</td><td class=one width=100>Assignment</td><td class=one width=25>Grade</td></tr>";
	session_start();	
	if (isset($_SESSION["assgid"]))
		$assg_id = $_SESSION["assgid"];	
	
	$getAssgNames = "SELECT name,value FROM assignments WHERE assg_id = " . $assg_id;
	$assgNames = $conn->query($getAssgNames);
	$assgName = $assgNames->fetch_assoc();
	
	$getStudentIDs = "SELECT stud_id,score FROM mark WHERE assn_id = " . $assg_id;
	$stids = $conn->query($getStudentIDs);
	while ($row = $stids->fetch_assoc()){
		$getStudentNames = "SELECT CONCAT(fName, \" \", lName) AS fullName FROM person WHERE stud_ID = " . $row['stud_id'];
		$stnames = $conn->query($getStudentNames);
		$namerow = $stnames->fetch_assoc();
		echo "<tr><td class=one>" . $row['stud_id'] . "</td><td class=one>" . $namerow['fullName'] . "</td><td class=one>" . $assgName['name'] .  "</td><td class=one>" . round($row['score']/$assgName['value']*100,2) . "%</td></tr>";
	}
	

?>