<%@page import="java.util.*"%>   
<%@page import="jkt.hms.pacs.controller.PacsPatientHistory"%> 
 
 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 
<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
<head>
<title>Patient History</title>
</head>
<% 

	/* check Pacs Rights */
	String pacsRights="y";
	if(session.getAttribute("PacsRights") != null){
		 pacsRights = (String)session.getAttribute("PacsRights"); 
	}
	/*End of check Pacs Rights */

	Map map = new HashMap(); 
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	} 
	
	List<PacsPatientHistory> patientsHistoryList=new ArrayList<PacsPatientHistory>();
	String patientsId=""; 
	String patientsName="";
	String patientsSex="";
	String message="";
	String patientsType="";
	String patientsReg="";
	String patientsDate="";

	if (map.get("patientsHistoryList") != null) {
		patientsHistoryList = (List<PacsPatientHistory>)map.get("patientsHistoryList");
	} 
	  
	if (map.get("message") != null) {
		message = (String)map.get("message");
	} 
	if (map.get("patientsId") != null) {
		patientsId = (String)map.get("patientsId");
	} 
	if (map.get("patientsName") != null) {
		patientsName = (String)map.get("patientsName");
	} 
	if (map.get("patientsSex") != null) {
		patientsSex = (String)map.get("patientsSex"); 
	} 
	if (map.get("patientsReg") != null) {
		patientsReg = (String)map.get("patientsReg");
	} 
	if (map.get("patientsType") != null) {
		patientsType = (String)map.get("patientsType");
	} 
	if (map.get("patientsDate") != null) {
		patientsDate = (String)map.get("patientsDate");
	} 
	 
 %> 
  
<div class="titleBg" style="margin: 0px 0px 5px 0px;">
<h2>Patient History</h2>
</div>

<div class="divmain"> 
	<table style="width: 480px;"  class="small">
		<tr>
			<td align="right" class="historytd">Name : <b><%=patientsName %> &nbsp;&nbsp;</b>Reg.No :&nbsp;<b><%=patientsReg%></b>&nbsp;&nbsp;Gender : <b><%=patientsSex %></b></td> 
		</tr>
		<tr>
			<td align="right" class="historytd">Investigation Name : <b><%=patientsType %></b></td> 
		</tr>
		<tr>
			<td align="right" class="historytd">Study Date : <b><%=patientsDate %></b></td> 
		</tr> 
	</table>
</div>

<div class="clear"></div> 
	<%if(patientsHistoryList.size()!=0) {%>
	<div class="divmain">
		<table style="width: 480px;"  class="small">
			<%for(int i=0;i<=patientsHistoryList.size()-1;i++){%> 
			<tr>
				<td align="right" class="historytd">Created By : <b>Dr.&nbsp;<%=patientsHistoryList.get(i).getEmployeeName()%>&nbsp;&nbsp;</b>Created On :&nbsp;<b><%=patientsHistoryList.get(i).getLastchangetime()%></b></td> 
			</tr>
			<tr>
				<td align="right" class="historytd">
					<div  class="divhistory"><%=patientsHistoryList.get(i).getDescription()%></div>
				</td> 
			</tr>
			<%if(patientsHistoryList.get(i).getFileStatus().equalsIgnoreCase("Y")){ %>
			<tr>
				<td align="right" class="historytd"><a href="/hms/hms/pacs?method=downloadHistoryFile&historyId=<%=patientsHistoryList.get(i).getHistoryid()%>&patientName=<%=patientsName%>"><b>Download Referral File</b></a></td> 
			</tr> 
			<%} %>
			 <tr>
				<td align="right" class="historytd">&nbsp;</td> 
			</tr>
			<%} %> 
		</table>
	</div>
	<%} %>
	
	 <!-- FOR CREATE REPORT FORM AND CHECK USER RIGHST-->
	<%if(pacsRights.equalsIgnoreCase("y")){ %> 
	<div class="clear"></div>
	<div class="divmain">
		<div class="divtitle" onclick="openHistory()"><h4>Create Patient History</h4></div>
		<form name="patientHistory" method="post" enctype="multipart/form-data" action="" style="width: 475px;"> 
			<h4><span><%=message%></span></h4>
			<div class="clear"></div> 
		  	<!-- Block for form deetails -->
			<div class="clear"></div>  
			  
				  <div class="clear"></div>  
				  <textarea  maxlength="600" rows="10" cols="100" id="history" name="history" style="width: 460px; height: 79px;"></textarea>
				  <div class="clear"></div> 
				  <label style="text-align: left;padding-left: 10px;width: 120px;">Upload Referral File : </label> 
				  <input type="file" id="hisfile" name="hisfile" class="browse"  style="width: 290px;"/>
		 	 
		 	 
		 	<div class="clear"></div>  
		 	<input type="button" class="button"  value="Save" onclick="validateHistoryform();" />
		 	<input type="reset" class="button" value="Reset"/>  
		</form>
	</div>
	<%} else{%>
	<div class="clear"></div> 
	<h4><span>You do not have permission to create history</span></h4>
	<%} %>
	<div class="clear"></div> 
	<!-- END OFCREATE REPORT FORM AND CHECK USER RIGHST-->
	<div class="clear"></div> 

<script type="text/javascript">
function validateHistoryform()
{
	var history=document.getElementById("history").value;
	var patientId=<%=patientsId%>;
	submitForm("patientHistory","pacs?method=submitPatientHistory&history="+history+"&patientId="+patientId);
	window.close();
}
</script>

<style>
.historytd{
	background:lightgray;
	border:none;
	font: 12px Tahoma;
	padding-left: 10px;
	text-align: left;
}

.divmain{
	width: 480px;
	border: 2px solid #424242;
	border-radius:4px;
	height: auto;
}	

.divtitle{
background: gray none repeat scroll 0 0;
    height: 22px;
    margin: 0 auto;
    padding: 6px 0 0;
}	

h4 {
    clear: both;
    color: white;
    font: bold 14px/15px tahoma;
    margin: 0;
    padding: 0 0 0 10px;
    text-decoration: none;
    text-transform: uppercase;
}
.divhistory{
border: 1px solid gray;
border-radius: 2px;
width: 450px;
background: lightgoldenrodyellow;
font: 14px Tahoma;
padding: 3px;
word-wrap: break-word;
}
</style>
 