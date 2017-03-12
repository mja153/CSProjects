<?php
//containing directory for photos/images .. general variable initiation
	$dir = "./images/";
	$files = scandir($dir);
	$imageNames = array();
	$imageComments = array();	
	$q = $_GET["q"];
	$comment = "";
	$maxPhotoCount = 0;
	$x = 0;
//as files is an array of all files in the directory of photos (there may or may not already be txt files of comments inside), we check each to see if it is an image. 
//if it is an image, increase the max # of photos for reference in client, and save the names of the image files in a new array.
		for($i = 0; $i<sizeof($files); $i++){
			$length = strlen($files[$i]);
		
			if(strcmp(substr($files[$i],$length-3),"png") == 0 || strcmp(substr($files[$i],$length-3),"jpg") == 0){
				$maxPhotoCount++;
				$imageNames[$x] = $files[$i];
				$x++;
			}
		}
//if files (array) has less elements than x2 the imageNames array, essentially meaning text files existed, we create text files for the image comments 
		if(sizeof($files)<sizeof($imageNames)*2){
			for($i = 0; $i<sizeof($imageNames); $i++){
				$newFile = substr($imageNames[$i], 0, -3)."txt";
				$destination = "./images/".$newFile;
				fopen($destination, "a+");
			}
		}
//if the client request has q=1, we read the text file and store it as $comment and then empts the array into $sendingComments. we then return the image src, directory, photo count & image comments
	if($q == 1){
		$requestNum = 0;
		$txtfile = substr($imageNames[$requestNum], 0, -3)."txt";
		$comment = file("./images/".$txtfile);
		$sendingComments = "";
		for($i=0; $i<sizeof($comment); $i++){
			$sendingComments .= $comment[$i];
		}
		echo $imageNames[0] . " " . $dir . " " . $maxPhotoCount . " " . $sendingComments;
	}
//if the client request is q=2, we read the text file and store it as $comment and then empty the array into $sendingComments. we then return the image src & image comments
	else if ($q == 2){
		$p = $_GET["p"];
		$requestNum = $p;
		$txtfile = substr($imageNames[$requestNum], 0, -3)."txt";
		$comment = file("./images/".$txtfile);
		$sendingComments = "";
		for($i=0; $i<sizeof($comment); $i++){
				$sendingComments .= $comment[$i];

		}
		echo $imageNames[$requestNum] . " " . $sendingComments;
	}
//if the client request is q=3, we insert the user's comments into the text file, read the text file and store it as $comment and then empty the array into
//$sendingComments. we then return the image src & image comments
	else if ($q == 3){
		$p = $_GET["p"];
		$requestNum = $p;
		$c = $_GET["c"];
		$txtfile = substr($imageNames[$requestNum], 0, -3)."txt";
		file_put_contents("./images/".$txtfile, $c . "<br><br>", FILE_APPEND);
		$comment = file("./images/".$txtfile);
		$sendingComments = "";
		for($i=0; $i<sizeof($comment); $i++){
				$sendingComments .= $comment[$i];
		}
		echo $imageNames[$requestNum] . " " . $sendingComments;
	}
?>