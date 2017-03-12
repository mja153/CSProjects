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
	if (isset($_POST['i']))
		$i = $_POST['i'];
	$get_students = "SELECT CONCAT(fName, \" \", lName) AS fullName,stud_id from person WHERE (SELECT student_id FROM student WHERE class_id = " . $i . " AND student_id = stud_id)";
	$students = $conn->query($get_students);
	
	if ($students->num_rows > 0) {
		while ($row = $students->fetch_assoc()) {
			echo "<option value=" . $row["stud_id"] . ">" . $row["fullName"]. "</option>";
		}
	}
	else {
		echo "0 results";
	}
	
?>
