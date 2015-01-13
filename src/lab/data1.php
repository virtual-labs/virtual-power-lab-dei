<?php
$con = mysql_connect("www.vpl-Dayalbagh.in","dkchaturvedi","vpl@dei");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }

// Create database

// Create table
mysql_select_db("virtual", $con);
$sql = "CREATE TABLE IF NOT EXISTS `members` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `studentname` varchar(60) NOT NULL,
  `rollno` int(11) NOT NULL,
  `class` text NOT NULL,
  `email` text NOT NULL,
  `login` text NOT NULL,
  `passwd` text NOT NULL,
  `verification` text NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16;";

$sql1="INSERT INTO `members` (`student_id`, `studentname`, `rollno`, `class`, `email`, `login`, `passwd`, `verification`) VALUES
(4, 'staff', 0, 'staff', 'staff@dei.ac.in', 'staff', 'staff', 'verified');";

// Execute query
mysql_query($sql,$con);
mysql_query($sql1,$con);
mysql_close($con);
?>
