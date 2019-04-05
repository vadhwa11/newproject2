<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>

<%
  if(session.getAttribute("userName") == null)
  {
	response.sendRedirect("/hms/hms/login?method=logout");
  }

  else
  {
	  session.setAttribute("userName", session.getAttribute("userName"));
  }

%>
<meta http-equiv="X-UA-Compatible" content="IE=8" >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<!-- 
Code for Logout after session Expired
Code By Mukesh Narayan Singh
Date 19 Aug 2010
 -->
<meta http-equiv="refresh" content="${pageContext.session.maxInactiveInterval};url=/hms/hms/login?method=logout" />
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="/hms/jsp/css/datePicker.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js?n=1"></script>
<%@page import="jkt.hms.masters.business.MasHospital"%>

<!--[if IE 8]>
        <link href="/hms/jsp/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!-- script for fixed header table starts -->
<!--[if IE 9]>
<link href="/hms/jsp/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->

<!--[if IE]>
<style type="text/css">
/* IE Specific Style addition to constrain table from automatically growing in height */
div.TableContainer {
 height: auto; 
 overflow-x:hidden;
 overflow-y:auto;
}
</style>
<![endif]-->

<script>
// Function to scroll to top before sorting to fix an IE bug
// Which repositions the header off the top of the screen
// if you try to sort while scrolled to bottom.
function GoTop() {
 document.getElementById('TableContainer').scrollTop = 0;
}

// For those browsers that fully support the CSS :hover pseudo class the "table.scrollTable tr:hover" definition above 
// will work fine, but Internet Explorer 6 only supports "hover" for "<a>" tag elements, so we need to use the following 
// JavaScript to mimic support (at least until IE7 comes out, which does support "hover" for all elements)

// Create a JavaScript function that dynamically assigns mouseover and mouseout events to all 
// rows in a table which is assigned the "scrollTable" class name,  in order to simulate a "hover" 
// effect on each of the tables rows
HoverRow = function() {

 // If an IE browser
 if (document.all) {
  var table_rows = 0;
	
  // Find the table that uses the "scrollTable" classname
  var allTableTags=document.getElementsByTagName("table"); 
  for (i=0; i<allTableTags.length; i++) { 
   // If this table uses the "scrollTable" class then get a reference to its body and first row
   if (allTableTags[i].className=="scrollTable") { 
    table_body = allTableTags[i].getElementsByTagName("tbody");
    table_rows = table_body[0].getElementsByTagName("tr");
    i = allTableTags.length + 1; // Force an exit from the loop - only interested in first table match
   } 
  } 

  // For each row add a onmouseover and onmouseout event that adds, then remove the "hoverMe" class
  // (but leaving untouched all other class assignments) to the row in order to simulate a "hover"
  // effect on the entire row
  for (var i=0; i<table_rows.length; i++) {
   // ignore rows with the title and total class assigned to them
   if (table_rows[i].className != "title" && table_rows[i].className != "total") {
    table_rows[i].onmouseover=function() {this.className += " hoverMe";}
    table_rows[i].onmouseout=function() {this.className=this.className.replace(new RegExp(" hoverMe\\b"), "");}
   }
  } // End of for loop
  
 } // End of "If an IE browser"

}
// If this browser suports attaching events (IE) then make the HoverRow function run on page load
// Hote: HoverRow has to be re-run each time the table gets sorted
if (window.attachEvent) window.attachEvent("onload", HoverRow);

function ajaxFunctionForShowCalculator() 
{
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
   window.open('/hms/hms/login?method=showCalculator','mywindow','target="_blank", width=275,height=200');;
   <%-- var url="/hms/hms/login?method=showCalculator";
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
    }
  } --%>
}

</script>

<!-- script for fixed header table ends -->
<script type="text/javascript">


function disableKey(event) {

  if (!event) event = window.event;

  if (!event) return;

  var keyCode = event.keyCode ? event.keyCode : event.charCode;

  //window.status = keyCode;

  // keyCode for F% on Opera is 57349 ?!  

  if (keyCode == 116) {

   window.status = "F5 key detected! Attempting to disabling default response.";

   window.setTimeout("window.status='';", 2000);

   // Standard DOM (Mozilla):

   if (event.preventDefault) event.preventDefault();

   //IE (exclude Opera with !event.preventDefault):

   if (document.all && window.event && !event.preventDefault) {

     event.cancelBubble = true;

     event.returnValue = false;

     event.keyCode = 0;

   }

   return false;

  }

  if (event.keyCode == 27) return false; 

}

 

document.onkeydown = disableKey; // register listener function  

</script>
<script language=JavaScript>


//Disable right mouse click Script
//By Maximus (maximus@nsimail.com) w/ mods by DynamicDrive
//For full source code, visit http://www.dynamicdrive.com

var message="Function Disabled!";

///////////////////////////////////
function clickIE4(){
if (event.button==2){
alert(message);
return false;
}
}

function clickNS4(e){
if (document.layers||document.getElementById&&!document.all){
if (e.which==2||e.which==3){
alert(message);
return false;
}
}
}

if (document.layers){
document.captureEvents(Event.MOUSEDOWN);
document.onmousedown=clickNS4;
}
else if (document.all&&!document.getElementById){
document.onmousedown=clickIE4;
}

//document.oncontextmenu=new Function("alert(message);return false")


</script>
</head>
<body>
<div id="body">
<form name="header" method="post"><!--header Starts-->
<div class="header">
<!-- <div class="logo-div">
<img width="500" height="74" alt="HAL Logo" border="0" class="---floatLeft" src="../jsp/images/logo-hal.jpg" />

</div> -->
<!--
<div style="color:#058CBC; font:bold 15px/30px arial;float:left;line-height:38px; padding-left:5px;text-decoration:underline;">XYZ Hospital</div>
--> <!---for header text--->
<div class="hdText">
<!-- <img src="/hms/jsp/images/careIsLogo.gif" class="floatRight" alt="careIs Logo" /> -->

<div class="dateTimeDiv">

<span>

<script type="text/javascript">

function getNoticeData(){
//alert("hi");
	var xmlHttp;
  	try {
    	// Firefox, Opera 8.0+, Safari
    	xmlHttp=new XMLHttpRequest();
  	}catch (e){
	    // Internet Explorer
    	try{
      	xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }

	xmlHttp.onreadystatechange=function()
    {
    	if(xmlHttp.readyState==4)
    	{
    	  
    		var notice =xmlHttp.responseXML.getElementsByTagName('notice')[0];
    		  var desc  = notice.getElementsByTagName("desc")[0];
    		
    		
    		//alert("notice value::::"+desc.childNodes[0].nodeValue);
    		if(desc.childNodes[0].nodeValue!='nodesc'){
    			document.getElementById('noticeLabel').value = desc.childNodes[0].nodeValue;
    		}else{
    			document.getElementById('noticeLabel').value = '';
    		}
    		//document.getElementById('noticeLabel').value = desc.childNodes[0].nodeValue; 
	 		//document.getElementById("noticeDiv").innerHTML = '<marquee>'+noticeData+'</marquee>' ;
	 		  
	 	}
    }
	//alert('hello');
   	 var url='/hms/hms/login?method=getNoticeData';
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
}


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

<%

String[] monthName = {"January", "February",
            "March", "April", "May", "June", "July",
	          "August", "September", "October", "November",
	          "December"};

Calendar now = Calendar.getInstance();

int currentDays=now.get(Calendar.DATE);
String currentMonth=monthName[now.get(Calendar.MONTH)];
int currentYear=now.get(Calendar.YEAR);
%>
var monthname   = '<%=currentMonth%>';
var monthday    = '<%=currentDays%>';
var year        = '<%=currentYear%>';
<%--
var now         = new Date();
var monthnumber = now.getMonth();
var monthname   = months[monthnumber];
var monthday    = now.getDate();
var year        = now.getYear(); --%>
if(year < 2000) { year = year + 1900; }
var dateString = monthname + ' ' + monthday + ', ' + year;
return dateString;
}						

var calendarDate = getCalendarDate();
document.write(calendarDate);	
</script> </span>
<span> <%
Calendar calendar = new GregorianCalendar();
String suffix;
int hour = calendar.get(Calendar.HOUR_OF_DAY);
int minute = calendar.get(Calendar.MINUTE);
if(calendar.get(Calendar.AM_PM) == 0)
	suffix = "AM";
else
	suffix = "PM";

String hr = "";
String mnt = "";
if(hour<10){
	hr="0"+hour;
}else{
	hr=""+hour;
}
if(minute<10){
	mnt="0"+minute;
}else{
	mnt=""+minute;
}
%> <script type="text/javascript">
<%-- var currentTime = new Date()
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
} --%>

document.write('<%=hr%>' + ":" + '<%=mnt%>' + " " + '<%=suffix%>')
//-->
</script> </span>
</div>
<div class="hdTextFix"><% String noticeData = "";
String userName ="";
if(session.getAttribute("notice")!=null){
	  noticeData = session.getAttribute("notice").toString(); 
}
if(session.getAttribute("empName")!=null){
userName = (String)session.getAttribute("empName");	
}
String deptName ="";

if(session.getAttribute("deptName")!=null){
	deptName = (String)session.getAttribute("deptName");	
%> <%=userName%> <br /> Dept : <span style="color:#fff; font-size:12px;"><%=deptName %></span> <%} %>

<%
   Cookie cookie = null;
   Cookie[] cookies = null;
   // Get an array of Cookies associated with this domain
   cookies = request.getCookies();
   if( cookies != null ){
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        // out.print("Name : " + cookie.getName( ) + ",  ");
       //  out.print("Value: " + cookie.getValue( )+" <br/>");
      }
  }
%>
</div>
<div class="homeLoginDiv">
<span> <%
if(!userName.equals("")){
%>  <a href="#" onclick="submitForm('header','/hms/hms/login?method=showHomeJsp')" class="home-icon"></a> <%} %> </span>
<!-- <a href="http://www.maintguru.iaf.in/forum" target="_blank">Forum</a> | -->
	<!-- <a	href="#" target="blank">Contact</a> -->
	<%
if(!userName.equals("")){
%> <a href="#" name="logout"
	onclick="submitForm('header','/hms/hms/login?method=logout')" class="logout-icon"></a>
<%} %>
</div>
</div>
<!---header text ends--->


<%if(session.getAttribute("hospitalName")!=null){ %>
 <div class="hName"><%=((String)session.getAttribute("hospitalName")) %>
</div>
<%}%> <!-- 
<input type="button" value="Calculator" name="Button" onclick="ajaxFunctionForShowCalculator();"/>
 -->
<div class="clear"></div>
<input type="hidden" id="notice" name="notice" value="" />
<!--  <div>
  <marquee direction="left">
<input type="text" readonly="readonly" id="noticeLabel" value="<%=noticeData %>"  /></marquee>

</div>-->
</div>
</div>

<!--header Ends-->
<div class="clear"></div>
<script type="text/javascript">
	window.setInterval('getNoticeData()',5000000);
</script></form>
