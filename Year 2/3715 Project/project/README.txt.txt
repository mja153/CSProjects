Gradebook
CS3715 Project
Dale Palmer 201449659
Michael Anderson 201449410

This application is a web-based grade organizer designed to be used by an instructor.
It uses HTML-based code to show various statistics regarding a student's progress in a class.
All grades, student data, etc. are all stored within a MySQL database which is accessed through .php files included.

USAGE:
All files should be stored in an Apache-based server or an equivalent, and accessed by the respective commands. www.cs.mun.ca/~dap848 for example, could be a potential location for all files to be stored. Running the application is as simple as running the HTML file, "authenticate.html" via the browser/server communication.
Upon loading the app, the user is greeted with a Login screen. All data currently stored in the database is loaded immediately. The first class of the entered user is loaded, and all students and assignments are loaded into the selection boxes.
You can click on student names, or assignment names to show various statistics regarding each in the tables.
Various buttons to add, remove and modify data in the database are also included.
There is also a button that lets you view all marks for all students for the selected assignment.
To use the Remove Student/Assignment buttons, you must select a student or assignment and then click the respective button.
To use the Update Mark button, you must select an assignment AND a student, then click the Update Mark button to enter a mark.
To change to a different class, simply click the Class Selection box and select the class you wish to view.