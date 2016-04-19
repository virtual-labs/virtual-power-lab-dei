<?php
session_start();
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html >
<title>Virtual Labs - DEI</title>
<link href="../Dreamweaver/style.css" rel="stylesheet" type="text/css" media="screen" />
<SCRIPT language="JavaScript">
function checkOut() 
{
	var semail=/^[0-9a-zA-Z_\.-]+\@[0-9a-zA-Z_\.-]+\.[0-9a-zA-Z_\.-]+$/;
	if(document.survey.name.value=="")
	   {
		alert("Enter your name");
		document.survey.name.focus();
		return false;
	    }
	else if(document.survey.name.value.length<'3')
	    {
		alert("Minimum name length must be 3");
		document.survey.name.value="";
		document.survey.name.focus();
		return false;
	    }		
    else if(document.survey.email.value=="")
	   {
		alert("Please enter your email");
		document.survey.email.focus();
		return false;
	   }
	else if(!semail.test(document.survey.email.value))
	   {
		alert("Please enter correct email");
		document.survey.email.value="";
		document.survey.email.focus();
		return false;
	   }	   
	else if(document.survey.address.value=="")
	    {
		alert("Please enter your Address");
		document.survey.address.focus();
		return false;
	    }
	else if(document.survey.address.value.length<'6')
	    {
		alert("Minimum address length must be 6");
		document.survey.address.value="";
		document.survey.address.focus();
		return false;
	    }		
	else if(document.survey.city.value=="")
		 {
		alert("Please enter your city name");
		document.survey.city.focus();
		return false;
	     }
	else if(document.survey.state.value=="")
		 {
		alert("Please enter your state name");
		document.survey.state.focus();
		return false;
	     }
	else if(document.survey.country.value=="")
		 {
		alert("Please enter your country name");
		document.survey.country.focus();
		return false;
	     }
	else if(document.survey.zip.value=="")
		 {
		alert("Please enter your Postal Code");
		document.survey.zip.focus();
		return false;
	     }
	else if(isNaN(document.survey.zip.value))
		 {
		alert("Postal Code must be in Number Format");
		document.survey.zip.focus();
		return false;
	     }
	else if(document.survey.zip.value.length<'6')
		 {
		alert("Minimum Postal Code length must be 6");
		document.survey.zip.focus();
		return false;
	     }
}		 
</SCRIPT>
</head>
<body>
<div id="wrapper">
<div id="header">
		<div id="logo">
				 <br> 
			 <div class="thimage" > <img src="REIbuilding.png" alt="" width="165" height="90" /><img src="../Dreamweaver/main.bmp" alt="" width="165" height="90" /><img src="../Dreamweaver/images69.jpg" alt="" width="220" height="90" /><br> 
	      </div>
		  <h1>Virtual Power Laboratory-D.E.I.</h1></div></div> <div id="menu">
		<ul>
			<li><a href="../Dreamweaver/index.html">Home</a></li>
			<li><a href="../Dreamweaver/list.html">Experiments</a></li>
			<li><a href="../Dreamweaver/equip.html">Basic Equipments</a></li>
			<li><a href="../Dreamweaver/measurement.html">Measurements</a></li>
			<li><a href="../Dreamweaver/char.html">Charactristics</a></li>
			<li><a href="../Dreamweaver/safety.html">LAB Safety</a></li>
                        <li><a href="../Dreamweaver/feedback.html">Feedback</a></li>			
                        <li><a href="../Dreamweaver/lab.html">DEI PowerLab</a></li>
						
		</ul>
	

</div>		  
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
	  <div id="content">
	    <div class="post">
	      <div class="post-bgtop">
	        <div class="post-bgbtm">
	         <h2 class="title">Feedback Form</h2>
              <div class="nob">
<FORM NAME="survey" METHOD="POST" onSubmit="return checkOut()">
<center><b style="font-size:18px; color:red; text-decoration:blink;">&nbsp;<span id="info"></span></b></center>
                <br>
                <B>Name:</B><img src="images/arsterix.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <INPUT Name="name" Size="30" Type="TEXT" MaxLength="30"><br>
                  <B>E-mail ID:</B><img src="images/arsterix.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <INPUT Type="TEXT" Name="email" Size="30" /><br>
                  <B> Address:</B><img src="images/arsterix.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <INPUT Type="TEXT" Name="address" Size="30" /><BR>
                  <B>City:</B><img src="images/arsterix.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <INPUT TYPE="TEXT" NAME="city" SIZE="30" /><br />
                  <b>State:</b><img src="images/arsterix.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <INPUT Type="Text" NAME="state" SIZE="30" /><br>
				<b>Country:</b><img src="images/arsterix.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <INPUT Type="Text" NAME="country" SIZE="30" /><br>
                  <b>Postal Code:</b><img src="images/arsterix.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <INPUT TYPE="Text" NAME="zip" SIZE="15" MaxLength="10"/><br />
<ol class="boldlist">
<li> How do you rate the online performance of the experiment?</li>
<ul><INPUT TYPE="radio" NAME="performance" VALUE="Excellent" Checked="1" />Excellent
<INPUT Type="radio" Name="performance" Value="V.Good" />V.Good
<INPUT TYPE="radio" NAME="performance" VALUE="Good" />Good
<INPUT Type="radio" Name="performance" Value="Average" />Average
<INPUT TYPE="radio" NAME="performance" VALUE="Poor" />Poor
<INPUT Type="radio" Name="performance" Value="Unsatisfactory" />Unsatisfactory</ul>

<li>To what degree was the actual lab environment simulated?</li>
<ul><INPUT TYPE="radio" NAME="degree" VALUE="Excellent" Checked="1" />Excellent
<INPUT Type="radio" Name="degree" Value="V.Good" />V.Good
<INPUT TYPE="radio" NAME="degree" VALUE="Good" />Good
<INPUT Type="radio" Name="degree" Value="Average" />Average
<INPUT TYPE="radio" NAME="degree" VALUE="Poor" />Poor
<INPUT Type="radio" Name="degree" Value="Unsatisfactory" />Unsatisfactory</ul>

<li>The measurement and analysis of data was found to be easy.</li>
<ul><INPUT TYPE="radio" NAME="measurement" VALUE="Excellent" Checked="1" />Excellent
<INPUT Type="radio" Name="measurement" Value="V.Good" />V.Good
<INPUT TYPE="radio" NAME="measurement" VALUE="Good" />Good
<INPUT Type="radio" Name="measurement" Value="Average" />Average
<INPUT TYPE="radio" NAME="measurement" VALUE="Poor" />Poor
<INPUT Type="radio" Name="measurement" Value="Unsatisfactory" />Unsatisfactory</ul>

<li>The manuals were found to be helpful.</li>
<ul><INPUT TYPE="radio" NAME="manuals" VALUE="Excellent" Checked="1" />Excellent
<INPUT Type="radio" Name="manuals" Value="V.Good" />V.Good
<INPUT TYPE="radio" NAME="manuals" VALUE="Good" />Good
<INPUT Type="radio" Name="manuals" Value="Average" />Average
<INPUT TYPE="radio" NAME="manuals" VALUE="Poor" />Poor
<INPUT Type="radio" Name="manuals" Value="Unsatisfactory" />Unsatisfactory</ul>

<li>The links provided were consistent with the objectives of the experiment?</li> 
<ul><INPUT TYPE="radio" NAME="links" VALUE="Excellent" Checked="1" />Excellent
<INPUT Type="radio" Name="links" Value="V.Good" />V.Good
<INPUT TYPE="radio" NAME="links" VALUE="Good" />Good
<INPUT Type="radio" Name="links" Value="Average" />Average
<INPUT TYPE="radio" NAME="links" VALUE="Poor" />Poor
<INPUT Type="radio" Name="links" Value="Unsatisfactory" />Unsatisfactory</ul>

<li>The results of experiment were easily interpretable.</li>
<ul><INPUT TYPE="radio" NAME="results" VALUE="Excellent" Checked="1" />Excellent
<INPUT Type="radio" Name="results" Value="V.Good" />V.Good
<INPUT TYPE="radio" NAME="results" VALUE="Good" />Good
<INPUT Type="radio" Name="results" Value="Average" />Average
<INPUT TYPE="radio" NAME="results" VALUE="Poor" />Poor
<INPUT Type="radio" Name="results" Value="Unsatisfactory" />Unsatisfactory</ul>

<li>A clear understanding of the experiment and related topics was ganied.</li>
<ul><INPUT TYPE="radio" NAME="topics" VALUE="Excellent" Checked="1" />Excellent
<INPUT Type="radio" Name="topics" Value="V.Good" />V.Good
<INPUT TYPE="radio" NAME="topics" VALUE="Good" />Good
<INPUT Type="radio" Name="topics" Value="Average" />Average
<INPUT TYPE="radio" NAME="topics" VALUE="Poor" />Poor
<INPUT Type="radio" Name="topics" Value="Unsatisfactory" />Unsatisfactory</ul>

<li>How helpful do you feel the system is?</b><BR/>
<TEXTAREA Name="system" Cols="65" Rows="2"></TEXTAREA>

<li>Did you experience any problem?</b><BR/>
<TEXTAREA Name="problem" Cols="65" Rows="2"></TEXTAREA>

<li>Is there anything you would like to tell us?</li>
<TEXTAREA Name="comments" Cols="65" Rows="2"></TEXTAREA>
</ol>
<label for="securitycode">Security Code<img src="images/arsterix.gif"></label>
<input id="securitycode" name="securitycode" type="text" size="11"/>&nbsp;&nbsp;&nbsp;
<img src="captcha.php" id="captcha_security" />&nbsp;&nbsp;&nbsp;
<a href="#" onclick="document.getElementById('captcha_security').src='captcha.php?'+Math.random();" id="change-captcha">
<img src="images/refresh_icon.jpg" height="25" width="25" title="Refresh"></a>
<center><INPUT Type="SUBMIT" Name="send" Value="Submit" />
<INPUT Type="RESET" Value="Start Over" /></center>
</FORM>
<?php		   
if (isset($_POST['send']))
{
if( $_SESSION['code'] == $_POST['securitycode'] ) 
{
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
}
else echo "<script language=\"javascript\">document.getElementById('info').innerHTML=\"Invalid Security Code\"</script>";
unset($_SESSION['code']);
}
?>
              </div>
            </div>
              </div>
              </div>
              </div>
	<!-- end #CONTENT -->
    <div id="sidebar">
<ul>
<h2>Virtual Power Lab </h2><BR><BR>
<img src="images/ba.JPG" width=210 height=190>
</ul></div>
		<!-- end #sidebar -->
             </div> 
           </div>
           </div>
</div>
</body>
</html>