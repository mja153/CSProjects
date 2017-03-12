<?php
	
	$username = "cs3715_mja153";
	$password = "orangegreen0";
	$hostname = "mysql.cs.mun.ca";
	$database = "cs3715_mja153";
	
	//creates a connection to the database
	$conn = new mysqli($hostname, $username, $password, $database) 
		or die("Unable to connect to MySQL");
		
	$un = $_POST['user'];
	$pwd = $_POST['pwd'];
	
	$getPwdQuery = "SELECT password FROM users WHERE username='" . $un . "'";
	$pwdQuery = $conn->query($getPwdQuery);
	$row = $pwdQuery->fetch_assoc();
	$pwdDatabase = $row['password'];

	if ($pwd == $pwdDatabase && $un != "" && $pwd != ""){
		session_start();
		$_SESSION["username"] = $un;
		echo "";
	}

	else {
		echo "bad login info";
	}

?>