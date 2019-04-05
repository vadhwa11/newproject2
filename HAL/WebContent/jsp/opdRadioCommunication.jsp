<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>   
<%@page import="jkt.hms.pacs.controller.PacsPatientHistory"%> 
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%> 
<%@page import="jkt.hms.masters.business.RadiologyCommunication"%> 
 
 
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
	  System.out.println("message "+map.get("message") );
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
	List<MasEmployeeDepartment> empDepartmentList = new ArrayList<MasEmployeeDepartment>();
	if (map.get("empDepartmentList") != null) {
		empDepartmentList = (List<MasEmployeeDepartment>)map.get("empDepartmentList");
	} 
	List<RadiologyCommunication> rcList = new ArrayList<RadiologyCommunication>();
	if (map.get("rcList") != null) {
		rcList = (List<RadiologyCommunication>)map.get("rcList");
	} 
 %> 
  
<div class="titleBg" style="margin: 0px 0px 5px 0px;">
<h2>Patient History</h2>
</div>

<div class="divmain"> 
	<table style="width: 480px;"  class="small">
		<tr>
			<td align="right" class="historytd">Name : <b><%=patientsName %> &nbsp;&nbsp;</b>Reg No. :&nbsp;<b><%=patientsReg%></b>&nbsp;&nbsp;Gender : <b><%=patientsSex %></b></td> 
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
<div class="titleBg">
		<h2>Previous Message</h2>
	</div>
	<%if(rcList.size()!=0) {
	int i=0;
	%>
	<div class="divmain">
		<table style="width: 480px;"  class="small">
		<tr><th>S.No</th><th>Created on</th><th> Message</th><th>Radiology Response</th></tr>
			<%  for(RadiologyCommunication rc:rcList){%> 
			          <tr><td><%=++i%></td><td> <%=rc.getOpdRemarksDate()!=null?HMSUtil.convertDateTypeToStringWithoutTime(rc.getOpdRemarksDate()):""%> (<%=rc.getOpdRemarksTime()%>)</td><td><%=rc.getOpdDoctorRemarks()%></td><td><%=rc.getRadioDoctorRemarks()!=null?rc.getRadioDoctorRemarks():"-"%></td></tr>
			<%} %> 
		</table>
	</div>
	<%}else { %>
	     No record found.
	<%} %>
	
	 <!-- FOR CREATE REPORT FORM AND CHECK USER RIGHST-->
	 
<div class="clear"></div> 
	 <div class="titleBg">
		<h2>Create a new Message</h2>
	</div>
<h6><span style="color: green;"><%=message%></span></h6>
	<form name="patientHistory" method="post"> 

 <label>Doctor <span>*</span></label>
 <select name="radioDocId" validate="Doctor, int, yes" id="radioDocId"><option value="0">Select</option>
 <%
 
 for(MasEmployeeDepartment med: empDepartmentList){
 %>
         <option value="<%=med.getEmployee().getId()%>"> <%=med.getEmployee().getFirstName()!=null?med.getEmployee().getFirstName():"" %><%=med.getEmployee().getMiddleName()!=null?" "+med.getEmployee().getMiddleName():"" %><%=med.getEmployee().getLastName()!=null?" "+med.getEmployee().getLastName():"" %></option>
 <%} %>
</select>
	<div class="clear"></div><br/>
	
	<div class="divmain">
		<div class="divtitle" onclick="openHistory()"><h4>Enter your remarks for Radiology Department</h4></div>
			<div class="clear"></div> 
		  	<!-- Block for form deetails -->
			<div class="clear"></div>  
			  
				  <div class="clear"></div>  
				  <textarea  maxlength="200" rows="10" cols="100" id="opdRemarks" name="opdRemarks" style="width: 460px; height: 79px;" validate="Remarks, string yes"></textarea>
				  <div class="clear"></div> 
			<!-- 	  <label style="text-align: left;padding-left: 10px;width: 120px;">Upload Referral File : </label> 
				  <input type="file" id="hisfile" name="hisfile" class="browse"  style="width: 290px;"/> -->
		 	 
		 	 
		 	<div class="clear"></div>  
		 	<input type="button" class="button"  value="Submit" onclick="validateHistoryform();"/>
		 	<input type="reset" class="button" value="Reset"/>  
		
	</div>

</form>
	<div class="clear"></div> 
	<!-- END OFCREATE REPORT FORM AND CHECK USER RIGHST-->
	<div class="clear"></div> 

<script type="text/javascript">
function validateHistoryform()
{
	var opdRemarks=document.getElementById("opdRemarks").value;
	var radioDoctor=document.getElementById("radioDocId").value;
	if(radioDoctor==0)
		{
		alert("Please select Radiology Doctor");
		return false;
		}
	else if(opdRemarks=="")
		{
		alert("Please Enter remarks");
		return false;
		}
	var patientId=<%=patientsId%>;
	//submitForm("patientHistory","opd?method=sendMessageToRadiology&opdRemarks="+opdRemarks+"&patientId="+patientId);
	submitForm("patientHistory","opd?method=sendMessageToRadiology&patientId="+patientId);
	//window.close();
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
 