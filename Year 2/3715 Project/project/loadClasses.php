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
	
	session_start();
	if (isset($_SESSION["username"]))
		$username = $_SESSION["username"];
	echo "<optgroup label=\"Classes for " . $username . "\">";
	$get_classes = "SELECT class_id FROM class_taught WHERE username='" . $username . "'";
	$classes = $conn->query($get_classes);
	while ($row = $classes->fetch_assoc()) {
		$get_classNames = "SELECT class_name FROM class WHERE class_id =" . $row['class_id'];
		$classNames = $conn->query($get_classNames);
		$name = $classNames->fetch_assoc();
		echo "<option value=" . $row["class_id"]. ">" . $name["class_name"] . "</option>";
	}
	echo "</optgroup>";
	
/*	if ($classes->num_rows > 0) {
		while($row = $classes->fetch_assoc()) {
			echo "<option value=" . $row["class_id"]. ">" . $row["class_name"]. "</option>";
		}
	} 
	else {
		echo "0 results";
	}*/

?>
