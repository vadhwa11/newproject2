<%@page import="java.util.*"%>   
<%@page import="jkt.hms.pacs.controller.PacsPatientHistory"%> 
<%@page import="jkt.hms.pacs.controller.PacsReport"%>  
<%@page import="jkt.hms.masters.business.PacsTemplate"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script> 
<script type="text/javascript" src="/hms/jsp/js/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-settings.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>


<%--For AutoComplete Through Ajax--%> 
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
<head>
<title>Patient Report</title>
</head>

<script type="text/javascript"> 

WYSIWYG.attach('abc', full); // full featured setup
 
</script>


<%
	/* check Pacs Rights */
	String pacsRights="y";
	if(session.getAttribute("PacsRights") != null){
		 pacsRights = (String)session.getAttribute("PacsRights"); 
	}
	/*End of check Pacs Rights */
	
	Map map = new HashMap();
	Map mapdata = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	} 
	
	List<PacsReport> editrepotList=new ArrayList<PacsReport>();
	List<PacsTemplate> templateList = new ArrayList<PacsTemplate>();
	List<PacsReport> patientPacsReportList=new ArrayList<PacsReport>();
	List<PacsPatientHistory> patientsHistoryList=new ArrayList<PacsPatientHistory>();
	String patientsId=""; 
	String patientsName="";
	String patientsSex="";
	String message="";
	String patientsType="";
	String patientsReg="";
	String patientsDate="";

	if(map.get("editrepotList")!=null){
		editrepotList=(List<PacsReport>) map.get("editrepotList"); 
	} 
	
	if (map.get("templateList") != null) {
		templateList = (List<PacsTemplate>)map.get("templateList");
	} 
		
	if (map.get("patientsHistoryList") != null) {
		patientsHistoryList = (List<PacsPatientHistory>)map.get("patientsHistoryList");
	} 
	
	if (map.get("patientPacsReportList") != null) {
		patientPacsReportList = (List<PacsReport>)map.get("patientPacsReportList");
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
<h2>Patient Report</h2>
</div>
 
 	<!-- FOR PATIENT DETAILS -->
	<table class="divmain"  style="width: 1004px;">
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
	
	<!-- for patient history -->
	<div class="clear"></div> 
	<%if(patientsHistoryList.size()!=0) {%>
		<%if(patientsHistoryList.size()==1) {%>
			<div class="divmain">
				<div class="divtitle"><h4>Patient History Details</h4></div>
				<table style="width: 1000px;"  class="small">
					<%for(int i=0;i<=patientsHistoryList.size()-1;i++){%> 
					<tr>
						<td align="right" class="historytd">Created By : <b>Dr.&nbsp;<%=patientsHistoryList.get(i).getEmployeeName()%>&nbsp;&nbsp;</b>Created On :&nbsp;<b><%=patientsHistoryList.get(i).getLastchangetime()%></b></td> 
					</tr>
					<tr>
						<td align="right" class="historytd">
							<div class="divhistory"><%=patientsHistoryList.get(i).getDescription()%></div>
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
		<%}else{ %>
			<div class="divmain">
				<div class="divtitle" onclick="openHistory()"><h4 id="h4content" name="h4content">+ Patient History Details</h4></div>
				<table id="histable" name="histable" style="width: 1000px;display: none;"  class="small">
					<%for(int i=0;i<=patientsHistoryList.size()-1;i++){%> 
					<tr>
						<td align="right" class="historytd">Created By : <b>Dr.&nbsp;<%=patientsHistoryList.get(i).getEmployeeName()%>&nbsp;&nbsp;</b>Created On :&nbsp;<b><%=patientsHistoryList.get(i).getLastchangetime()%></b></td> 
					</tr>
					<tr>
						<td align="right" class="historytd">
							<div class="divhistory"><%=patientsHistoryList.get(i).getDescription()%></div>
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
	<%} }%>
	
	<!-- CHECK PATIENT RIGHTS -->
	<%if(pacsRights.equalsIgnoreCase("y")){ %> 
		<!-- FOR PATIENT REPORTS -->
		<div class="clear"></div>  
		<div class="divmain"> 
			<table style="width: 1000px;"  class="small">
				<tr>
					<td class="thstyle">Doctor Name</td>
					<td class="thstyle">Report Time</td>
					<td class="thstyle">Status</td> 
					<td class="thstyle">Referral File</td>
					<td class="thstyle">Edit</td>
					<td class="thstyle">Print</td>
					<td class="thstyle">Delete</td>
				</tr>
				<%if(patientPacsReportList.size()!=0){ %>
				<%for(int i=0;i<=patientPacsReportList.size()-1;i++){%> 
				<tr id="<%=patientPacsReportList.get(i).getReportId()%>" style="background: lightgoldenrodyellow;">
					<td align="right" class="tdstyle"><b>Dr.&nbsp;<%=patientPacsReportList.get(i).getEmployeeName()%></b></td>  
					<td align="right" class="tdstyle"><b><%=patientPacsReportList.get(i).getLastchangetime()%></b></td>  
					<td align="right" class="tdstyle"><b><%=patientPacsReportList.get(i).getReportStatus()%></b></td> 
					<td align="right" class="tdstyle"><%if(patientPacsReportList.get(i).getFileStatus().equalsIgnoreCase("Y")){ %><a href="/hms/hms/pacs?method=downloadReportFile&reportId=<%=patientPacsReportList.get(i).getReportId()%>&patientName=<%=patientsName%>"><b>Download Referral File</b></a><%} %></td> 
					<td align="right" class="tdstyle"><a href="#" onclick="editReport('<%=patientPacsReportList.get(i).getReportId()%>','<%=patientPacsReportList.get(i).getPatientId()%>')"><b><%=patientPacsReportList.get(i).getReportno() %></b></a></td>
					<td align="right" class="tdstyle"><a href="#" onclick="printReport('<%=patientPacsReportList.get(i).getReportId()%>','<%=patientPacsReportList.get(i).getPatientId()%>')"><b>Print</b></a></td>
					<td align="right" class="tdstyle"><a href="#" onclick="deleteReport('<%=patientPacsReportList.get(i).getReportId()%>','<%=patientPacsReportList.get(i).getPatientId()%>')"><b>Delete</b></a></td> 
				</tr>
				<%} %> 
				<%}else{ %>
				<tr>
					<td colspan="7" class="tdstyle" style="text-align: left;padding-left: 10px;color: red;">Report not created...</td> 
				</tr>
				<%} %>
			</table>
		</div> 
		 
		 <!-- FOR CREATE REPORT FORM--> 
		<div class="clear"></div>
		<div class="divmain">
			<div class="divtitle" onclick="openHistory()"><h4>Create Patient Report</h4></div>
				<form name="patientReports" method="post" enctype="multipart/form-data" action="" style="width: 1000px;"> 
					<h4><span><%=message%></span></h4>
					<div class="clear"></div>
					  
					 <!-- Block for Search templates -->
					<div> 
						<label style="text-align: left;padding-left: 10px;width: 140px;">Search Template Name : </label>
				 		  <input tabindex="1" type="text" value="" id="TemplateName" size="65" name="TemplateName"  style="width: 350px;height: 22px;"/>
				 		  <div id="ac2update1" style="display: none;width: 400px;" class="autocomplete" ></div>
						  <script type="text/javascript" language="javascript" charset="utf-8"> 
								  new Ajax.Autocompleter('TemplateName','ac2update1','pacs?method=getTemplatesForAutoComplete',{minChars:3,parameters:'requiredField=TemplateName'});
					      </script>	 
					       <input type="button" tabindex="1" onclick="submitProtoAjaxForTemplate()" class="button" value="Search" name="search" style="margin: 4px 11px;"> 
				    </div>
				    
	   				<div class="clear"></div>  
	   				<div>  
						  <label style="text-align: left;padding-left: 10px;width: 140px;">Attach Referral File : </label> 
						  <input type="file" id="hisfile" name="hisfile" class="browse"  style="width: 290px;"/>
						  <label style="text-align: left;padding-left: 10px;width: 90px;"><span>*</span>Report Staus : </label> 
			         	  <select id="reportStatus" name="reportStatus" >
						  		<option value="0">UNREPORTED</option>  
				               	<option value="1">DRAFTED</option> 
				               	<option value="2">REVIEWED</option> 
				           </select>
				           <input type="button" name="Save"  value="Save"  class="button" onclick="validateReportforms();"  style="margin: 4px 11px;"> 
				 	</div>
	     			<div class="clear"></div> 
					<!--Rich text editor-->
					<div id="rtf" style="width: 998px;"> 
						<%if(editrepotList.size()!=0){%>
							 <textarea value="" id="abc" name="abc" class="tableTextareaEditor"><%=editrepotList.get(0).getDescription() %></textarea>
						<%}else{  %>
							<%if(templateList.size()!=0){ %>
					 	  	<textarea value="" id="abc" name="abc" class="tableTextareaEditor"><%=templateList.get(0).getDescription() %></textarea>
					 	  	<%}else{ %>
					 	  	<textarea value="" id="abc" name="abc" class="tableTextareaEditor"></textarea>
					 	 <%} }%> 
					</div>
					
				   
					<div class="clear"></div>   
				 	 
				 	<input type="button" class="button"  value="Save" onclick="validateReportforms();" />
				 	<input type="reset" class="button" value="Reset"/>  
				</form>
		</div>
	<%} else{%>
		<div class="clear"></div> 
		<div class="divmain"> 
			<table style="width: 1000px;"  class="small">
				<tr>
					<td class="thstyle">Doctor Name</td>
					<td class="thstyle">Report Time</td>
					<td class="thstyle">Status</td> 
					<td class="thstyle">Referral File</td>
					<td class="thstyle">Print</td>
				</tr>
				<%if(patientPacsReportList.size()!=0){ %>
				<%for(int i=0;i<=patientPacsReportList.size()-1;i++){%> 
				<tr>
					<td align="right" class="tdstyle"><b>Dr.&nbsp;<%=patientPacsReportList.get(i).getEmployeeName()%></b></td>  
					<td align="right" class="tdstyle"><b><%=patientPacsReportList.get(i).getLastchangetime()%></b></td>  
					<td align="right" class="tdstyle"><b><%=patientPacsReportList.get(i).getReportStatus()%></b></td>   
					<td align="right" class="tdstyle"><%if(patientPacsReportList.get(i).getFileStatus().equalsIgnoreCase("Y")){ %><a href="/hms/hms/pacs?method=downloadReportFile&reportId=<%=patientPacsReportList.get(i).getReportId()%>&patientName=<%=patientsName%>"><b>Download Referral File</b></a><%} %></td> 
					<td align="right" class="tdstyle"><a href="#" onclick="printReport('<%=patientPacsReportList.get(i).getReportId()%>','<%=patientPacsReportList.get(i).getPatientId()%>')"><b>Print</b></a></td> 
				</tr>
				<%} %> 
				<%}else{ %>
				<tr>
					<td colspan="6" class="tdstyle" style="text-align: left;padding-left: 10px;color: red;">Report not created...</td> 
				</tr>
				<%} %>
			</table>
		</div>
		<div class="clear"></div> 
		<h4><span>You do not have permission to create history</span></h4>
	<%} %>
	<div class="clear"></div> 
	<!-- END OF CREATE REPORT FORM AND CHECK USER RIGHST-->
	
	
	
<script type="text/javascript">
 
function validateReportforms()
{
	window.onbeforeunload = null;
	 if (confirm("Are You Sure To Save Report?") == true) {
			WYSIWYG.updateTextArea("abc"); 
			var reportStatus=document.getElementById("reportStatus").value; 
			var patientId=<%=patientsId%>;  
			var formName="patientReports";
			var action="pacs?method=submitPatientReport&reportStatus="+reportStatus+"&patientId="+patientId+"&patientReg="+<%=patientsReg%>;
			errorMsg="";
			ob1 = true;
			ob2 = true;
			ob3 = true;
			obj = eval('document.'+formName); 
			obj.action = action;
			obj.submit(); 
			location.replace(); 
	  }else {
	        return false;
	  }
	
}

function openHistory()
{ 
	var visible=document.getElementById("histable").style.display;
	if(visible=="none"){ 
		document.getElementById("histable").style.display="block"; 
		document.getElementById("h4content").innerHTML="- Patient History Details";
	}else if(visible=="block"){
		document.getElementById("histable").style.display="none"; 
		document.getElementById("h4content").innerHTML="+ Patient History Details";
	}
}

function submitProtoAjaxForTemplate(){	
	window.onbeforeunload = null;
	var formName="patientReports"
	var tempname= document.getElementById("TemplateName").value;
	if(tempname=="" || tempname==" "){
		alert("Please enter template name!!");
		document.getElementById("TemplateName").focus();
	}else{
		var action="pacs?method=getTemplateForRepors&tempname="+tempname+"&patientId="+<%=patientsId%>;
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)
		obj.action = action;
		obj.submit(); 
		location.replace();        
	}
 }
 
 function deleteReport(reportId,patientId)
 {	  
	 window.onbeforeunload = null;	
	 if (confirm("Are You Sure To Delete Report?") == true) {
		 var formName="patientReports" 
				var action="pacs?method=deleteReport&reportId="+reportId+"&patientId="+patientId;
				errorMsg = "";
				ob1 = true;
				ob2 = true;
				ob3 = true;
				obj = eval('document.'+formName)
				obj.action = action;
				obj.submit(); 
				location.replace();     
	  }else {
	        return false;
	  } 
 }
 
 function editReport(reportId,patientId)
 { 
	window.onbeforeunload = null;
	var formName="patientReports" 
	var action="pacs?method=editReport&reportId="+reportId+"&patientId="+patientId;
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	obj.action = action;
	obj.submit(); 
	location.replace();   
 }
 
 function printReport(reportId,patientId)
 {  
		var url="/hms/hms/pacs?method=printReport&reportId="+reportId+"&patientId="+patientId;
	    window.open(url,'PrintReport','height=850,width=1024,status=1,scrollbars=yes,toolbar=yes'); 
}
 
 <%if(editrepotList.size()!=0){%> 	
 	document.getElementById(<%=editrepotList.get(0).getReportId()%>).style.backgroundColor='#ffd0c6';
	<%if(editrepotList.get(0).getReportStatus().equals("0")){%>
		document.getElementById("reportStatus").value = "0";
	<%}else if(editrepotList.get(0).getReportStatus().equals("1")){%>	
		document.getElementById("reportStatus").value = "1";
	<%}else if(editrepotList.get(0).getReportStatus().equals("2")){%>
		document.getElementById("reportStatus").value = "2";
	<%}%>
<%}%>
</script>

<style>
.historytd{
	width:988px;
	background:lightgray;
	border:none;
	font: 12px Tahoma;
	padding-left: 10px;
	text-align: left;}
	
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
.divmain{
	width: 1000px;
	border: 2px solid #424242;
	border-radius:4px;
	height: auto;
}
 
.iframeText{
	height: 450px;
}	
.tdstyle{ 
border: 1px solid gray;
text-transform: uppercase;
 font: bold 12px tahoma;
}
.thstyle{
background: gray;
border: 1px solid white;
text-transform: uppercase;
 font: bold 12px tahoma;
 color: white;
 height: 26px;
}

a{
cursor: pointer;
}
a:hover{
color:red;
}
.divhistory{
border: 1px solid gray;
border-radius: 2px;
width: 976px;
background: lightgoldenrodyellow;
font: 14px Tahoma;
padding: 3px;
word-wrap: break-word;
}
</style>

<script type="text/javascript">
   window.onbeforeunload = function() {
    return false;
}; 
</script>
 