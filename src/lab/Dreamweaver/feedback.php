<html>
<body>

<?php		   

//Sending an automatic email

$to="powerlabdei@gmail.com";
$subject="Feedback for Virtual Power Lab";
$headers = 'MIME-Version: 1.0' . "\r\n";
$headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";
$headers .= 'From: ' . "\r\n";
$message="Name=".$_POST["name"]."<br>Email ID=".$_POST["email"]."<br>Address=".$_POST["address"]."<br>City=".$_POST["city"]."<br>State=".$_POST["state"]."<br>Country=".$_POST["country"]."<br>Pin Code=".$_POST["zip"]."<br><br>Performance=".$_POST["performance"]."<br>Degree=".$_POST["degree"]."<br>Measurement=".$_POST["measurement"]."<br>Manuals=".$_POST["manuals"]."<br>Links=".$_POST["links"]."<br>Results=".$_POST["results"]."<br>Topics=".$_POST["topics"]."<br>System=".$_POST["system"]."<br>Problem=".$_POST["problem"]."<br>Comments=".$_POST["comments"];
@mail($to,$subject,$message,$headers);
@mail($_POST["email"],"Welcome","Thankyou for sending feedback. You can give your valuable suggestions.",$headers);
echo ("<SCRIPT LANGUAGE='JavaScript'>alert('Thankyou, your feedback has been submitted');</SCRIPT>");

?>
</body>
</html>