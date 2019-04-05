<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.HroEntry"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.PendingHroProposal"%>
<%@page import="jkt.hms.masters.business.ProposalForHroEntry"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Hospital Management System</title>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<style>
#contentHolder1 {width:100%; margin:0px auto; }
#contentHolder1 .blockFrame1 {width:100%; margin:0px auto;}
#contentHolder1 .blockFrame1 label {
	width:170px;
	float:left;
	text-align:left;
	height:auto;
	line-height:normal;
	padding-right:5px;
	padding-left:50px;
	font-weight:bold;
}


#contentHolder1 .blockFrame1 label.value{
	color:#000000;
	width:180px;
	float:left;
	font-size:11px;
	text-align:left;
	height:auto;
	font-weight:normal;
}
#contentHolder1 .divisionR {height:1px;clear:both; border-top:1px solid #000; margin-top:2px;}
#contentHolder1 .Clear {
	clear:both;
    height:1px;
    overflow:hidden;
}

#html,body {

	overflow:visible;
	text-align:left;

}

</style>

</head>

<body>
<%

	List<HroEntry> hroEntryList = new ArrayList<HroEntry>();
	HroEntry hroEntry = new HroEntry();
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	if (map.get("hroEntry") != null) {
		
		hroEntry = (HroEntry)map.get("hroEntry");
		System.out.println("in not null");
		
	}
	
	%>
<div id="contentHolder1">

<table style="width:680px;" >
<tr><td>
<label style="font:bold 13px arial color:#000;font-weight:bold;text-decoration:underline;
			float: right;text-align:center;font-size:12px;width:100%;margin-top: 3px;">RESTRICTED</label>
<div class="Clear"></div>
<div class="Clear"></div>
<table  width="100%"  >
<tr>
<td rowspan="2">
<table border="1" width="130" height="150" style="padding-right:0px;">
		<tr>
			<td style="font-size:10px;">Adjutant</td>
			<td style="font-size:10px;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
		</tr>
		<tr>
			<td style="font-size:10px;">Cmds Adm & Cdr Tps</td>
			<td style="font-size:10px;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
		</tr>
		<tr>
			<td style="font-size:10px;">Dy Comdt</td>
			<td style="font-size:10px;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
		</tr>
		<tr>
			<td style="font-size:10px;">Commandant</td>
			<td style="font-size:10px;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
		</tr>
	</table>
</td>
<td align="left">
	<label style="font-size:11px; color:#000;font-family:arial;	padding-left:330px;font-weight:bold;
			width:70px;padding-right:0px;margin-right: 0px;margin-top: 0px;margin-bottom: 0px;">COPY NO :-.................</label>
	<div class="Clear"></div>
	<label style="font-size:11px; color:#000;font-family:arial;	padding-left:330px;font-weight:bold;
			width:70px;padding-right:0px;margin-right: 0px;margin-top: 0px;margin-bottom: 0px;">SERIAL NO :-<%=hroEntry.getSerialNo() %></label>
	<div class="Clear"></div>
	<label style="font-size:11px; color:#000;font-family:arial;	padding-left:330px;font-weight:bold;
			width:70px;padding-right:0px;margin-right: 0px;margin-top: 0px;margin-bottom: 0px;">DATE :-<%=HMSUtil.convertDateToStringWithoutTime(hroEntry.getHroDate()) %></label>

</td>
</tr>
<tr>
<td>
<label style="font:bold 13px arial color:#000;font-weight:bold;text-decoration:underline;
			float:left;text-align:center;font-size:12px;width:320;margin-top: 0px;">HOSPITAL ROUTINE ORDERS</label>
<div class="Clear"></div>
<label style="font:bold 13px arial color:#000;font-weight:bold;text-decoration:underline;
			float: left;text-align:center;font-size:12px;width:320;margin-top: 0px;">BY</label>
			<div class="Clear"></div>
<%
String name="";
if(!hroEntry.getNameOfCommandant().getFirstName().equals(""))
{
	name=name +hroEntry.getNameOfCommandant().getFirstName()+" ";
}
if(!hroEntry.getNameOfCommandant().getMiddleName().equals(""))
{
	name=name +hroEntry.getNameOfCommandant().getMiddleName()+" ";
}
if(!hroEntry.getNameOfCommandant().getLastName().equals(""))
{
	name=name +hroEntry.getNameOfCommandant().getLastName()+" ";
}
%>
			
<label style="font:bold 13px arial color:#000;font-weight:bold;text-decoration:underline;
			float: left;text-align:center;font-size:12px;width:320;margin-top: 0px;"><%=name.toUpperCase() %></label>

<div class="Clear"></div>
<label style="font:bold 13px arial color:#000;font-weight:bold;text-decoration:underline;
			float: left;text-align:center;font-size:12px;width:320;margin-top: 0px;"><%=hroEntry.getDesignation().toUpperCase() %></label>

<div class="Clear"></div>
<label style="font:bold 13px arial color:#000;font-weight:bold;text-decoration:underline;
			float: left;text-align:center;font-size:12px;width:320;margin-top: 0px;">COMMAND HOSPITAL AIR FORCE BANGALORE</label>

</td>
</tr>
</table>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="divisionR"></div>
<div class="divisionR"></div>
<div class="Clear"></div>
<label class="value" ><%=hroEntry.getTextContent()%></label>
<div class="Clear"></div>
<%
name="";
if(!hroEntry.getNameOfAdjudant().getFirstName().equals(""))
{
	name=name +hroEntry.getNameOfAdjudant().getFirstName()+" ";
}
if(!hroEntry.getNameOfAdjudant().getMiddleName().equals(""))
{
	name=name +hroEntry.getNameOfAdjudant().getMiddleName()+" ";
}
if(!hroEntry.getNameOfAdjudant().getLastName().equals(""))
{
	name=name +hroEntry.getNameOfAdjudant().getLastName()+" ";
}
String rankName ="";
if(hroEntry.getNameOfAdjudant().getRank()!=null){
	rankName=hroEntry.getNameOfAdjudant().getRank().getRankName();
}
%>
<label class="value" style="font-size:10px;width:120px;margin-left: 0px;padding-left: 500px;padding-top:20px;text-align:center;">(<%=name%>)
 </label>
<div class="Clear"></div>
<label class="value" style="font-size:10px;width:120px;margin-left: 0px;padding-left: 500px;padding-top:0px;text-align:center;"><%=rankName %>
 </label>
 <div class="Clear"></div>
<label class="value" style="font-size:10px; width:120px;margin-left: 0px;padding-left: 500px;padding-top:0px;text-align:center;">Adjudant
 </label>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<label style="font-size:11px; color:#000;font-family:arial;	padding-left:500px;font-weight:bold;
		width:70px;padding-right:0px;margin-right: 0px;margin-top: 0px;margin-bottom: 0px;text-align:center;">Time of issue.................hrs</label>
<div class="Clear"></div>
<label style="font:bold 12px arial color:#000;font-weight:bold;text-decoration:underline;
			float: right;text-align:center;font-size:12px;width:100%;margin-top: 50px;">RESTRICTED</label>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>



			<label style="font:bold 13px arial color:#000;font-weight:bold;
					float: right;text-align:center;font-size: 11px;width:680;height: 0px;
					margin-top: 0px;">---------- End Of The Report ----------</label>

<div style='page-break-after:always;'></div>  
</td></tr>
</table>
</div>
</body></html>