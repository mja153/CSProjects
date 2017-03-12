<?php
//set session lifetime
ini_set('session.gc_maxlifetime', 300);
session_set_cookie_params(300);
//start session
session_start();
?>
<!DOCTYPE html>
<html>
<style>
	.center{
		text-align: center;
	}
	</style>
<head>
	<title>Very Large Shopping Site</title>
<h1 style="text-align:center;">A Small Shopping Site</h1>
</head>
<body>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
<table align=center width="350"> 
	<tr>
		<td>
		<b>Web Applications</b><br>This book provides an in-depth examination of the basic concepts and general principles associated with Web application development. The price is $95.
		</td>
		<td>
		<p> </p>
		</td>
		<td>
		<select name="AppSelect">
		  <option value="1">1</option>
		  <option value="2">2</option>
		  <option value="3">3</option>
		  <option value="4">4</option>
		  <option value="5">5</option>
		</select>
		</td>
		<td>
		<input type="submit" name="appSubmit" value="Add to Cart">
		</td>
	</tr>
</form>
<tr><td></td><td></td><td></td></tr>
<tr><td></td><td></td><td></td></tr>
<tr><td></td><td></td><td></td></tr>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
<tr>
		<td>
		<b>JavaScript</b><br>This is both an example-driven programmer's guide and a keep-on-your-desk reference with new chapters that explain everything you need to know to get the most out of JavaScript. The price is $130.
		</td>
		<td>
		<p> </p>
		</td>
		<td>
		<select name="jsSelect">
		  <option value="1">1</option>
		  <option value="2">2</option>
		  <option value="3">3</option>
		  <option value="4">4</option>
		  <option value="5">5</option>
		</select>
		</td>
		<td>
		<input type="submit" name="jsSubmit" value="Add to Cart">
		</td>
	</tr>
	</form>
	<tr>
	<td colspan=3>
	<form method="post" action="checkout.php">
	<br><br><br><br>
	<div class="center">
	<input type="submit" name="checkout" value="Check Out">
	</div>
	<br><br><br>
	</form>
</table>
<?php
	//if the WebApp AddToCart button was pressed, set variable appQuantity to the value of the select dropdown
	if(isset($_POST['appSubmit'])){
		$appQuantity = (isset($_POST["AppSelect"]) ? $_POST["AppSelect"]: null);
	//if appCount session variable had already been created, i.e this isn't your first time buying the book, increment the session variable based on select dropdown
		if(isset($_SESSION['appCount'])){
			for($i=0; $i<$appQuantity; $i++){
				$_SESSION["appCount"]++;
			}
	//store session variable in simple appCount variable
			$appCount = $_SESSION['appCount'];
		}
	//if this is your first time  buying the book, ie there are no session variables created yet, create it & set both of the appCount variables to the value of the dropdown
		else{
			$_SESSION['appCount'] = $appQuantity;
			$appCount = $_SESSION['appCount'];
		}	
	//confirm order.
	echo "<p style=\"text-align:center;\" >". $appQuantity . " Web Applications books successfully placed in your cart. You now have: " . $_SESSION['appCount'] . " copies.<br></p>";
	}
	//if the JavaScript AddToCart button was pressed, set variable jsQuantity to the value of the corresponding select dropdown
	if(isset($_POST['jsSubmit'])){
		$jsQuantity = (isset($_POST["jsSelect"]) ? $_POST["jsSelect"]: null);
	//if jsCount session variable had already been created, i.e this isn't your first time buying the book, increment the session variable based on select dropdown
		if(isset($_SESSION['jsCount'])){
			for($i=0; $i<$jsQuantity; $i++){
				$_SESSION["jsCount"]++;
			}
	//store session variable in simple jsCount variable
			$jsCount = $_SESSION['jsCount'];
		}
	//if this is your first time  buying the book, ie there are no session variables created yet, create it & set both of the jsCount variables to the value of the dropdown
		else{
			$_SESSION['jsCount'] = $jsQuantity;
			$jsCount = $_SESSION['jsCount'];
		}
	//confirm order
	echo "<p style=\"text-align:center;\" >". $jsQuantity . " JavaScript books successfully placed in your cart. You now have: " . $_SESSION['jsCount'] . " copies.<br></p>";
	}
?>	
</body>
</html>