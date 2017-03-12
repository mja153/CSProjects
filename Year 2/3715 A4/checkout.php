<?php
ini_set('session.gc_maxlifetime', 300);
session_set_cookie_params(300);
//read in session variables created in bookstore.php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<title>Checking out...</title>
<h1 style="text-align:center;">Checking Out</h1>
</head>
<body>
<table border align=center width="410"> 
<tr>
	<td width="40%" style="text-align:center;">
		<b>Item</b>
	</td>
	<td width="25%" style="text-align:center;">
		<b>Quantity</b>
	</td>
	<td width="15%" style="text-align:center;">
		<b>Unit Price</b>
	</td>
	<td width="20%" style="text-align:center;">
		<b>Unit Total</b>
	</td>
</tr>
<?php
		//assuming the appCount variable has been created, print its value in this column
if(isset($_SESSION['appCount'])){
echo "<tr>";
echo	"<td width=\"40\">";
echo "Web Applications";
echo	"</td>";
echo	"<td width=\"25%\">";
		echo $appCount = $_SESSION["appCount"];
echo	"</td>";
echo	"<td width=\"15%\">";
echo "$95";
echo	"</td>";
echo	"<td width=\"25%\">";
		//calculate the total price of the unit
		echo "$". ($appCount*95);
echo	"</td>";
echo "</tr>";
}
	//assuming the jsCount variable has been created, print its value in this column
if(isset($_SESSION['jsCount'])){
echo "<tr>";
echo	"<td width=\"40\">";
echo "JavaScript";
echo	"</td>";
echo	"<td width=\"25%\">";
		echo $jsCount = $_SESSION["jsCount"];
echo	"</td>";
echo	"<td width=\"15%\">";
echo "$135";
echo	"</td>";
echo	"<td width=\"25%\">";
		//calculate the total price of the unit
		echo "$". ($jsCount*135);
echo	"</td>";
echo "</tr>";
}
?>
</table>
</body>
</html>