<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * login.jsp  
 * Purpose of the JSP -  This is for login.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 31st Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.11
--%>
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<%--<%@ include file="header.jsp"%>--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasCommand"%>
<%@page import="java.net.URL"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<!--[if lt IE 9]>
        <link href="/hms/jsp/css/ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
function getHD(){
var password = document.getElementById('password').value;
var loginName = document.getElementById('loginName').value;
if(loginName!='' && password!=''){
submitProtoAjaxWithDivName('loginForm','/hms/hms/login?method=getHospitalName&loginName='+loginName+'&password='+password,'defaultList');
}
}
</script>
<script>
function checkGroup(){
var group = document.getElementById('empGroup').value;
if(group == ""){
var password = document.getElementById('password').value;
var loginName = document.getElementById('loginName').value;
}
}
</script>
<style type="text/css">
/*body {background:none;}*/
html { height: auto;}
#main { overflow: hidden;}
</style>

<div class="headerTopSolid">
<div class="mainHeader">
<!-- <div class="logo-div"><img src="../jsp/images/logo-hal.jpg" alt="" /></div> -->
<div class="dateTtime-wrapper">
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
</script> </span>
</div>
<div class="clear"></div>
</div>
</div>

<div id="main-login-wrapper">
<div class="main-login-form">
<div class="welText-wrapper">WELCOME TO MEDICAL &amp; HEALTH UNIT</div>
<form action="" method="post" name="forgetPassword">
<div id="loginForm-Wrapper" style="height:150px">
<div class="loginheader">
<div class="loginText-left">Forget Password</div>
<div class="loginText-mandatory">*fields are mandatory</div>
</div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<label>Employee No. <span>*</span></label>
<input type="text" validate="Employee No,string,yes" value="" name="empNo" tabindex="1" id="empNo" class="usernameIn" style="margin:2px 5px 0px 0px;">
<input type="button" onclick="doResetPassword();" value="Reset Request" name="Login2" tabindex="1" class="button">
<input type="button" onclick="backToLogin('forgetPassword','/hms/hms/login?method=logout');" value="Back to Login" name="back" tabindex="1" class="button">

</div>
</form>
<div class="clear"></div>
</div>



<div class="clear"></div>

<%@ include file="footer.jsp"%>

<script language="javascript">

function backToLogin(formName,action)
{
	obj = eval('document.'+formName)
	obj.method="POST";
	obj.action = action;
	obj.submit();
}


function doResetPassword(val,a,inc)
{
	var empNo = document.getElementById('empNo').value;		   
	    console.log(empNo);
	  
	  if(empNo !="")
	  {
		 
			  ajaxFunctionForResetPassword('forgetPassword','user?method=doResetPassword&empNo=' +  empNo);
				//ajaxFunctionForAutoCompleteForPurchase('purchaseGrid','stores?method=fillItemsCommon&pvmsNo=' +  pvms , inc);
			   	
			}
	  else{
			    return false;
			}
	 
			  	  
	    
}

function ajaxFunctionForResetPassword(formName,action) {
	
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
    var url=action
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
    	  

  	     var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	 
		
		
      	for (loop = 0; loop < items.childNodes.length; loop++) 
      	{
      
	   	    var item = items.childNodes[loop];
	   	    
	        var Msg  = item.getElementsByTagName("Msg")[0];
	       
	        alert(Msg.childNodes[0].nodeValue);
	        
        				
        	
      }
    }
  }
}


</script>
