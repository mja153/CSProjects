		function returnToMain(){
				location.href = "main.html"	
		}		
				
		function loadGrades(){
				var path = "setSessionAssn.php/"
				var xhttp = new XMLHttpRequest();
				xhttp.open("POST", path, true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {						
						location.href = "AllGrades.html";
					}
				};
				var assgLists = document.getElementById("assgList")
				var id = assgLists.options[assgLists.selectedIndex].value
				document.write(id)
				var sendstuff = "asid=" + id;
				xhttp.send(sendstuff);
		}		
		
		function	enumList(){
			var path = "enumList.php/"	//php file that handles database operations
			//use AJAX to supply the php file
			var xhttp = new XMLHttpRequest();
			xhttp.open("GET", path, true);
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					document.getElementById("dataTable").innerHTML = xhttp.responseText;
					}
			};
			xhttp.send();
		}			
		
		function logout(){	
				var path = "logout.php/"
				var xhttp = new XMLHttpRequest();
				xhttp.open("GET", path, true);
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {						
						location.href = "authenticate.html";
					}
				};
				xhttp.send()
		}		
				
		function loadAssgData(){
				var path = "loadAssgs.php/"	//php file that handles database operations
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
				xhttp.open("POST", path, true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						document.getElementById("assgList").innerHTML = xhttp.responseText;
					}
				};
				var classes = document.getElementById('classes')
				var sendstuff = "i="+classes.options[classes.selectedIndex].value;
				
				xhttp.send(sendstuff);
			}
			
			function loadStudData(){
				var path = "loadStudents.php/"	//php file that handles database operations
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
				xhttp.open("POST", path, true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						document.getElementById("studList").innerHTML = xhttp.responseText;
					}
				};
				var classes = document.getElementById('classes')
				var sendstuff = "i="+classes.options[classes.selectedIndex].value;
				xhttp.send(sendstuff);
			}
		
			function loadData() {
				var path = "loadClasses.php/"	//php file that handles database operations
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						document.getElementById("classes").innerHTML = xhttp.responseText;
						loadAssgData();
						loadStudData();
					}
				};
				xhttp.open("POST", path, true);
				xhttp.send();
			}
			
			function addStud() {
				var fName, lName
				var name = prompt("Please enter the name (each name is at most 15 characters): first last")
				fName = name.substring(0,name.indexOf(" "))
				lName = name.substring(name.indexOf(" ")+1)
				if (fName.length <= 15 && lName.length <= 15 && (fName != "" || lName != "")){
					alert(fName + " " + lName + " will be added to the database.")
					var classes = document.getElementById("classes")
					var id = classes.options[classes.selectedIndex].value
					//AJAX loading php
					var path = "addStudent.php/"
					//use AJAX to supply the php file
					var xhttp = new XMLHttpRequest();
					xhttp.open("POST", path, true);
					xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
					xhttp.onreadystatechange = function() {
						if (xhttp.readyState == 4 && xhttp.status == 200) {
							loadAssgData();
							loadStudData();
						}
					};
					var sendstuff = "fname=" + fName + "&lname=" + lName + "&classid=" + id
					xhttp.send(sendstuff);
					}
				else
					alert("Entry made, " + fName + " " + lName + " is not a valid entry.")
			}
			
			
			function remStud(){
				var studList = document.getElementById('studList')
				var id = studList.options[studList.selectedIndex].value
				var c = confirm("You are trying to delete student with ID: " + id + ", are you sure you wish to continue?") //returns a boolean
				var path = "remStudent.php/"
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
					if(c){
						xhttp.open("POST", path, true);
						xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
						xhttp.onreadystatechange = function() {
							if (xhttp.readyState == 4 && xhttp.status == 200) {
							loadAssgData();
							loadStudData();
						}
						};
						var sendstuff = "stid=" + id
						xhttp.send(sendstuff);
					}
			}
			
			function addAssg(){
				var name, val
				var readin = prompt("Please enter the assignment information as: name,value,weight")
				name = readin.substring(0,readin.indexOf(","))
				readin = readin.substring(readin.indexOf(",")+1)
				val = readin.substring(0,readin.indexOf(","))
				readin = readin.substring(readin.indexOf(",")+1)	//now has the weight
				if(name.length <=30){
				alert("Assignment, " + name + ", will be added with a value of " + val + ", and weight of " + readin + ".")
				}
				
				else{
					alert("Assignment is not valid.")
					return;
				}
				var path = "addAssg.php/"
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
				xhttp.open("POST", path, true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						loadAssgData();
						loadStudData();
					}
				};
				var classes = document.getElementById("classes")
				var id = classes.options[classes.selectedIndex].value
				var sendstuff = "val=" + val + "&weight=" + readin + "&asname=" + name + "&classid=" + id
				xhttp.send(sendstuff);
			}
			
			function remAssg(){			
				var assgList = document.getElementById('assgList')
				var id = assgList.options[assgList.selectedIndex].value
				var c = confirm("You are trying to delete the selected assignment. Do you wish to continue?")
				var path = "remAssg.php/"
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
				if(c){
					xhttp.open("POST", path, true);
					xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
					xhttp.onreadystatechange = function() {
						if (xhttp.readyState == 4 && xhttp.status == 200) {
							loadAssgData();
							loadStudData();
						}
					};
					var sendstuff = "assgid=" + id;
					xhttp.send(sendstuff);
				}
			}
			
			function addGrade(){
				var score = prompt("Please enter the achieved score:")
				var assgList = document.getElementById('assgList')
				var assgid = assgList.options[assgList.selectedIndex].value
				var studList = document.getElementById('studList')
				var studid = studList.options[studList.selectedIndex].value
				var path = "addGrade.php/"
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
				xhttp.open("POST", path, true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
					statsCallback(xhttp.responseText);
				}
				};
				var sendstuff = "assgid=" + assgid + "&studid=" + studid + "&score=" + score;
				xhttp.send(sendstuff);
			}
			
			function remGrade(){
				var c = confirm("You are trying to remove the score for the selected assignment. Do you wish to continue?")
				var assgList = document.getElementById('assgList')
				var assgid = assgList.options[assgList.selectedIndex].value
				var studList = document.getElementById('studList')
				var studid = studList.options[studList.selectedIndex].value
				var path = "remGrade.php/"
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
				if(c){
					xhttp.open("POST", path, true);
					xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
					xhttp.onreadystatechange = function() {
						if (xhttp.readyState == 4 && xhttp.status == 200) {
							assgStats();
						}
					};
					var sendstuff = "assgid=" + assgid + "&studid=" + studid;
					xhttp.send(sendstuff);
				}
			}
			
			function statsCallback(xhttp){
				assgStats();
				studStats();
			}
			
			function assgStats(){
				var path = "assgStats.php/"	//php file that handles database operations
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
				xhttp.open("POST", path, true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						document.getElementById("assgStats").innerHTML = xhttp.responseText;
					}
				};
				var assgList = document.getElementById('assgList')
				var studList = document.getElementById('studList')
				var sendstuff = "asid="+assgList.options[assgList.selectedIndex].value+"&stid="+studList.options[studList.selectedIndex].value;
				xhttp.send(sendstuff);
			}
			
			function studStats(){
				var path = "studStats.php/"
				//use AJAX to supply the php file
				var xhttp = new XMLHttpRequest();
				xhttp.open("POST", path, true);
				xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						document.getElementById("studentStats").innerHTML = xhttp.responseText;
					}
				};
				var studList = document.getElementById('studList')
				var classes = document.getElementById('classes')
				var sendstuff = "stid="+studList.options[studList.selectedIndex].value+"&name="+studList.options[studList.selectedIndex].text+"&class="+classes.options[classes.selectedIndex].value;
				xhttp.send(sendstuff);
			}