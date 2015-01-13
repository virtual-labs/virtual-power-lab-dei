<?php
$con = mysql_connect("www.vpl-Dayalbagh.in","dkchaturvedi","vpl@dei");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }

// Create database

// Create table
mysql_select_db("virtual", $con);
$sql = "CREATE TABLE IF NOT EXISTS `member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `branch` text NOT NULL,
  `sem` text NOT NULL,
  `institute` text NOT NULL,
  `place` text NOT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21;";

// Execute query
mysql_query($sql,$con);

mysql_close($con);
?>
