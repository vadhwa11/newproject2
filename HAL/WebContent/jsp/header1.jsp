<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* Header.jsp  
* Purpose of the JSP -  This is for Header.
* @author  Mansi
* @author  Deepali
* Create Date: 21st Feb,2008 
* Revision Date:      
* Revision By: 
* @version 1.7
--%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
</head>
<body onUnload="window['window2'].close()">
<form name="header" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="81" valign="top"><img
			src="/hms/jsp/images/bafLogo.gif" alt="Logo HMS" width="81"
			height="88"></td>
		<td height="88" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
				<table width="80%" border="0" align="right" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="28"><IMG SRC="/hms/jsp/images/userBar_01.gif"
							WIDTH=28 HEIGHT=23 ALT=""></td>
						<td width="300" bgcolor="#91A8BC" class="bodytext"
							style="background: url(/hms/jsp/images/userBar_02.gif) #819BB2;">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="56%" class="bodytext">
								<%	
String userName ="";
if(session.getAttribute("userName")!=null){
userName = (String)session.getAttribute("userName");	
%> <%=userName%> | Dept: <%} %>
								</td>
								<td width="44%" class="bodytext"><a href="chafb.iaf.in"
									target="_blank">chafb.iaf.in</a></td>
							</tr>
						</table>
						</td>
						<td width="28" bgcolor="#91A8BC"><IMG
							SRC="/hms/jsp/images/userBar_01.gif" WIDTH=28 HEIGHT=23 ALT=""></td>
						<td valign="top"
							style="background: url(/hms/jsp/images/userBar_02.gif) #819BB2 no-repeat;">
						<table width="100%" border="0" align="right" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="196" height="23" class="bodytext"><script
									type="text/javascript">
/*
var currentDate = new Date()
var day = currentDate.getDate()
var month = currentDate.getMonth()
var year = currentDate.getFullYear()
document.write(day + "/" + month + "/" + year)	
*/
function getCalendarDate()
{
var months = new Array(13);
months[0]  = "January";
months[1]  = "February";
months[2]  = "March";
months[3]  = "April";
months[4]  = "May";
months[5]  = "June";
months[6]  = "July";
months[7]  = "August";
months[8]  = "September";
months[9]  = "October";
months[10] = "November";
months[11] = "December";
var now         = new Date();
var monthnumber = now.getMonth();
var monthname   = months[monthnumber];
var monthday    = now.getDate();
var year        = now.getYear();
if(year < 2000) { year = year + 1900; }
var dateString = monthname + ' ' + monthday + ', ' + year;
return dateString;
} // function getCalendarDate()								


var calendarDate = getCalendarDate();
document.write(calendarDate);	
</script> &nbsp; : <script type="text/javascript">
var currentTime = new Date()
var hours = currentTime.getHours()
var minutes = currentTime.getMinutes()

if (minutes < 10)
minutes = "0" + minutes

var suffix = "AM";
if (hours >= 12) {
suffix = "PM";
hours = hours - 12;
}
if (hours == 0) {
hours = 12;
}

document.write(hours + ":" + minutes + " " + suffix)
//-->
</script></td>
								<td width="177" align="left"><a href="#" class="bodytext">Contact</a>
								<span class="bodytext">|</span> <%
if(!userName.equals("")){
%> <input type="button" name="logout" value="Logout" class="logout"
									onClick="submitForm('header','/hms/hms/login?method=logout')" />
								<%} %>
								</td>
							</tr>
						</table>
						</td>
					</tr>

				</table>
				</td>
			</tr>
			<tr>
				<td height="63" valign="bottom"
					style="text-align: right; padding-right: 100px;"><img
					src="/hms/jsp/images/hmsLogo.gif" width="103" height="53"></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>