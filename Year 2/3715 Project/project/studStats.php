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

	$stId = $_POST['stid'];
	$name = $_POST['name'];
	$class_id = $_POST['class'];
	
	$addedWeight = 0;
	$addedMarks = 0;
	
	//get a list of assignments for class
	$listAssgsSQL = "SELECT assg_id,weight,value from assignments WHERE class_id = " . $class_id;
	$listAssgs = $conn->query($listAssgsSQL);
	
	if ($listAssgs->num_rows > 0) {
		while ($row = $listAssgs->fetch_assoc()) {
			$SQL = "SELECT score FROM mark WHERE assn_id = " . $row["assg_id"] . " AND stud_id = " . $stId;
			$scores= $conn->query($SQL);
			$curValue = $row['value'];
			$curWeight= $row['weight'];
			$addedWeight+=$curWeight;
			if ($scores->num_rows > 0) {
				$oRow = $scores->fetch_assoc();
				$curScore = $oRow['score'];
				$addedMarks += ($curScore / $curValue) * $curWeight;
			}
		}
	}
	
	echo "<div class=\"two\"><h2>" . $name . "</h2></div>";
	echo "<div class=\"two\"><b>Student Number: </b>" . $stId . "</div>";
	if ($addedWeight == 0)
		echo "<div class=\"two\"><b>Overall Class Mark (%): </b>Undefined. No Assignments Found.";
	else{
		if ($addedWeight > 100)
			echo "<div class=\"two\"><b>Overall Class Mark (%): </b> Weights of Grades Exceeds 100%</div>";
		else
			echo "<div class=\"two\"><b>Overall Class Mark (%): </b>" . round($addedMarks / $addedWeight * 100, 2) . "%</div>"; //fix percentage rounding

	}
?>

