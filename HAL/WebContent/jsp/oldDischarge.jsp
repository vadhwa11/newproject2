<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * attach_admission.jsp  
 * Purpose of the JSP -  Back data diagnosis entry in DISCHARGE.
 * @author  Vivek
 * Create Date: 31st July,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.13  
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.MasCareType"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasDischargeStatus"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script>
<%
    String right = "n";
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
	List<MasDisposedTo> disposedToList = new ArrayList<MasDisposedTo>();
	List<MasCareType> careTypeList = new ArrayList<MasCareType>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasDischargeStatus> dischargeStatusList = new ArrayList<MasDischargeStatus>();
	List<UserEmpGroup> userRights = new ArrayList<UserEmpGroup>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	if(request.getAttribute("map") != null){
		detailsMap = (Map<String, Object>)request.getAttribute("map");
	}
	if(detailsMap.get("employeeList") != null){
		employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
	}
	if(detailsMap.get("disposedToList") != null){
		disposedToList = (List<MasDisposedTo>)detailsMap.get("disposedToList");
	}
	if(detailsMap.get("disposalList") != null){
		disposalList = (List<MasDisposal>)detailsMap.get("disposalList");
	}
	if(detailsMap.get("careTypeList") != null){
		careTypeList = (List<MasCareType>)detailsMap.get("careTypeList");
	}
	if(detailsMap.get("dischargeStatusList") != null){
		dischargeStatusList = (List<MasDischargeStatus>)detailsMap.get("dischargeStatusList");
	}
	if(detailsMap.get("userRights") != null){
		userRights = (List<UserEmpGroup>) detailsMap.get("userRights"); 
	}
	if(userRights.size() > 0){
		System.out.println("User Rights"+userRights.size());
		right = "y";
	}
	
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
function openPopupWindow()
{
 var url="/hms/hms/adt?method=showICDSearchJsp";
 newwindow=window.open(url,'_blank','name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}
function openSearchPopup()
{
 var url="/hms/hms/adt?method=showSearchPopup";
 newwindow=window.open(url,'_blank','name',"left=100,top=100,height=500,width=950,status=1,scrollbars=1,resizable=0");
}

function jsSetIcdData(icd_no)
{
document.getElementById("icdCode").value=icd_no;
document.getElementById("icdCode").focus();
}
function setServiceNo(serviceNo)
{
document.getElementById("serviceNoId").value=serviceNo;
document.getElementById("serviceNoId").focus();
}

</script>

<div id="contentHolder">
<form name="updateDischarge" method="post">
<h6 align="left" class="style1">Update Discharge</h6>

<input id="dischargeAddId" align="right" type="button" name="Submit"
	value="Cancel Discharge" class="buttonbig"
	onClick="checkForCancelDischarge();" />
<div class="Clear"></div>

<div class="blockTitle">Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Service No :</label> <input
	type="text" class="textbox_size20" name="" value=""
	onblur="getDischargeDetails(this.value);" id="serviceNoId" /> <IMG
	SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer;" onClick="javascript:openSearchPopup();">
<label class="medium">Ad No :</label> <select name="<%=INPATIENT_ID %>"
	id="adNoId"
	onchange="if(getAdNo()){getDetailsOfDischarge(this.value);}"
	id="adNoId">
	<option value="0">Select</option>
</select> <label class="bodytextB">Service Name :</label> <input id="sName"
	class="textbox_size20" readonly="readonly" />
<div class="Clear"></div>

<label class="bodytextB">Patient Name :</label> <input id="pName"
	class="textbox_size20" readonly="readonly" /> <label class="bodytextB">DOA
:</label> <input id="doa" class="textbox_size20" readonly="readonly"> <label
	class="bodytextB">Relation :</label> <input id="relation"
	class="textbox_size20" readonly="readonly">
<div class="Clear"></div>

<label class="bodytextB">Age :</label> <input id="age"
	class="textbox_size20" readonly="readonly"> <label
	class="bodytextB">Sex :</label> <input id="sex" class="textbox_size20"
	readonly="readonly"> <input id="hinId" class="textbox_size20"
	name="hinId" type="hidden">
<div class="Clear"></div>


</div>

<br />

<div class="blockTitle">Discharge Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">

<div id="testDiv"><label class="bodytextB"><span>*</span>Doctor:</label>

<select name="<%=DOCTOR_NAME %>" validate="Doctor,String,yes"
	class="select_adt" id="doctor">
	<option value="0">Select</option>
	<%
							for(MasEmployee masEmployee : employeeList){
								if(masEmployee.getEmpCategory() != null){
									if(masEmployee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
										String doctorMiddleName = "";
										String doctorLastName = "";
										//if(patient.getPMiddleName() != null){
										//	doctorMiddleName = masEmployee.getMiddleName();
										//}
										//if(patient.getPLastName() != null){
										//	doctorLastName = masEmployee.getLastName();
										//}
										
									
										
						%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName() %>
	<%=doctorMiddleName %> <%=doctorLastName %></option>
	<% 			}
								}
							}
						%>
</select> <label class="bodytextB"><span>*</span>Disposal:</label> <select
	name="<%=DISPOSAL_ID %>" validate="Disposal,String,yes"
	class="select_adt" id="disposal">
	<option value="0">Select</option>
	<%
							for(MasDisposal masDisposal : disposalList){
						%>
	<option value="<%=masDisposal.getId() %>"><%=masDisposal.getDisposalName() %></option>
	<%} %>
</select>

<div class="Clear"></div>

<label class="bodytextB"><span>*</span>Disposed To:</label> <select
	name="<%=DISPOSED_TO_ID %>" validate="Disposed To,String,yes"
	class="large" onchange="getOtherHospitalTextBox(this.value);"
	id="disposalTo">
	<option value="0">Select</option>
	<%
								for(MasDisposedTo masDisposedTo : disposedToList){
									System.out.println("masDisposedTo.getId()   "+masDisposedTo.getId());
							%>
	<option value="<%=masDisposedTo.getId()%>"><%=masDisposedTo.getDisposedToName() %></option>
	<%} %>
</select>
<div id="otherHospitalId" style="display: none;"><input
	type="text" name="<%=OTHER_HOSPITAL_NAME%>" id="" maxlength="30"
	validate="Other Hospital Name,String,no"></div>
<div class="Clear"></div>

<label class="bodytextB">Care Type:</label> <select
	name="<%=CARE_TYPE_ID %>" validate="Care Type,String,no"
	class="select_adt" id="careType">
	<option value="0">Select</option>
	<%
							for(MasCareType masCareType : careTypeList){
						%>
	<option value="<%=masCareType.getId() %>"><%=masCareType.getCareTypeName() %></option>
	<%} %>
</select> <label class="bodytextB">Injury Rpt Init On:</label> <input type="text"
	id="injuryRptInitOn" name="<%=INJURY_REPORT_INITIATED_ON %>" value=""
	class="calDate" readonly="readonly"
	validate="Injury Report Initiated On,date,no" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.updateDischarge.<%=INJURY_REPORT_INITIATED_ON%>,event)" />

<label class="bodytextB">Injury Rpt Init at</label> <input type="text"
	name="injury_report_init_at" class="textbox_date"
	validate="Injury Report Initiated At,string,no" MAXLENGTH="50"
	id="injuryRptInitat" />
<div class="Clear"></div>

<label class="bodytextB">Board Held On:</label> <input type="text"
	id="boardHeldOn" name="<%=BOARD_HELD_ON %>" value="" class="calDate"
	readonly="readonly" validate="Board Held On,date,no" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.updateDischarge.<%=BOARD_HELD_ON%>,event)" />

<label class="bodytextB">Follow Up Date:</label> <input type="text"
	id="followUpDate" name="<%=FOLLOW_UP %>" value="" class="calDate"
	readonly="readonly" validate="Follow Up Date,date,no" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.updateDischarge.<%=FOLLOW_UP%>,event)" />


<label class="bodytextB">Dischrg In Medical Ctgry:</label> <input
	type="text" name="<%=DISCHARGE_IN_MEDICAL_CATEGORY %>"
	id="dischrgInMedicalCtgry" class="textbox_date"
	validate="Discharge In Medical Category,String,no" MAXLENGTH="30" />
<div class="Clear"></div>

<label class="bodytextB"><span>*</span>Discharge Status:</label> <select
	name="<%=DISCHARGE_STATUS_ID %>" validate="Discharge Status,String,yes"
	onchange="checkDischargeStatus(this.value);" class="select_adt"
	id="dischargeStatus">
	<option value="0">Select</option>
	<%
							for(MasDischargeStatus masDischargeStatus : dischargeStatusList){
						%>
	<option value="<%=masDischargeStatus.getId() %>"><%=masDischargeStatus.getDischargeStatusName() %></option>
	<%} %>
</select> <label class="bodytextB">Care Summary:</label> <textarea
	name="<%=CARE_SUMMARY %>" id="careSummary"
	validate="Care Summary,string,no" cols="25" rows="1" class="txtarea" /></textarea>

<label class="bodytextB">Instructions To Patient:</label> <textarea
	name="<%=INSTRUCTIONS %>" id="instructionsToPatient"
	validate="Instructions To Patient,string,no" cols="25" rows="2"
	class="select_adt" /></textarea>

<div class="Clear"></div>


<label class="bodytextB">Document Initiated </label> <textarea
	name="document_initiated" validate="Document Initiated,string,no"
	cols="25" rows="2" class="select_adt" id="documentInitiated" /></textarea> <label
	class="bodytextB">Date of Discharge:</label> <input type="text"
	class="calDate" name="<%=DISCHARGE_DATE%>" value="" id="dDate"
	readonly="readonly" validate="Date of Discharge,date,yes" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.updateDischarge.<%=DISCHARGE_DATE%>,event)" />

<label class="bodytextB">Time of Discharge:</label> <input type="text"
	class="textbox_size20" name="<%=DISCHARGE_TIME%>" value="" id="dTime"
	onblur="checkTime('updateDischarge','<%=DISCHARGE_TIME%>')"
	validate="Time of Discharge,String,yes" />
<div class="Clear"></div>

<label class="bodytextB">Delete Diagnosis:</label> <input
	type="checkbox" name="<%=DELETE_DIAGNOSIS %>" value="" class="radio">

<label class="bodytextB">Working Diagnosis:</label> <input type="text"
	maxlength="150" align="right" name="workingDiagnosis"
	id="workingDiagnosis" class="large2" />
<div class="Clear"></div>

<label class="bodytextB">Diagnosis :</label>
<div id="diagnosisId"></div>
<div class="Clear"></div>

</div>
</div>
<br />

<div class="blockTitle">Diagnosis</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="small">Z03</label> <input
	type="checkbox" class="radio" name="<%=Z03 %>" value="z03"> <label
	class="small">Z09</label> <input type="checkbox" class="radio"
	name="<%=Z09%>" value="z09" id="Z09"> <input type="button"
	class="delbutton" value=" "
	onclick="removeRowForUpdateDischarge(this,'tblSample');" align="right" />
<input type="button" class="addbutton" value=" " onclick="addRow();"
	align="right" />
<div class="Clear"></div>

<label>Icd Code :</label> <IMG SRC="/hms/jsp/images/s_search.gif"
	WIDTH="26" HEIGHT="26" style="cursor: pointer;"
	onClick="javascript:openPopupWindow();"
	title="Click here to Search ICD Codes"> <input name="" value=""
	class="textbox_date" type="text" id="icdCode" onblur="getIcd();" /> <input
	name="" value="" class="textbox_date" id="temp" type="hidden" />
<div class="Clear"></div>

<div class="tableHholderCmn">
<table width="100%" colspan="7" id="tblSample" cellpadding="0"
	cellspacing="0">
	<tbody>
		<tr>
			<td width="2%"><input type="hidden" class="radio"
				name="checkbox" id="checkbox" value="" />&nbsp;</td>
			<td width="1%">Icd Name 1:</td>
			<td width="10%"><input type="text" align="right" name="icd"
				id="icd" size="95" />
			<div id="ac2update"
				style="height: 150px; overflow: scroll; display: none; border: 1px solid #000"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('icd','ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'});
			</script></td>
		</tr>
	</tbody>
</table>

</div>
</div>
<input type="hidden" name="<%=CHANGED_DATE %>" id="currentDate" value="<%=currentDate%>" />
<input type="hidden" name="admissionNo" value="" id="admissionNo" /> 
<input type="hidden" name="deptId" value="0" id="deptId" /> 
<input type="hidden" name="hdb" value="1" id="hdb" /> 
<input type="hidden" name="rights" id="rights" value="<%=right%>">
<input type="hidden" name="dId" value="0" id="dId" /> <br />
<input id="dischargeAddId" type="button" name="Submit" value="Save"
	class="button"
	onClick="if(validateUpdateDischarge()&& validateDischargeDate()){submitForm('updateDischarge','/hms/hms/adt?method=updateDischarge');}" />
<input id="dischargeAddId" type="button" name="Submit" value="Reset"
	class="button"
	onClick="submitForm('updateDischarge','/hms/hms/adt?method=oldDischargeEntry');" />
</form>
<div class="Clear"></div>

</div>

<script type="text/javascript">


function getIcd(){

 //=========To get Icd String with icd code==========================
var icdCode =document.getElementById("icdCode").value
 if(icdCode !="")
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
 
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	         icdString  = item.getElementsByTagName("icdString")[0];
	         	
	        if(icdString.childNodes[0].nodeValue){
	        	document.getElementById("temp").value =icdString.childNodes[0].nodeValue
	        }
	       }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
  
  }
  //==================End of Icd String block======================
}
function addRow(){
var icdString =document.getElementById("temp").value;

if(document.getElementById("Z09").checked == true && icdString !="NO" && icdString !=""){
	icdString =icdString +"{OLD}"
}

if(icdString !="NO"){
if(document.getElementById("icd").value==""){
	document.getElementById("icd").value =icdString
	document.getElementById("temp").value =""
	document.getElementById("icdCode").value =""
	return false;
	}
}else{
alert("ICD Code does not exists...!")
  		document.getElementById("icdCode").value =""
  		document.getElementById("temp").value =""
  		return true
}

	if(icdString != "NO"){
  var tbl = document.getElementById('tblSample');
  var lastRow = tbl.rows.length;
  // if there's no header row in the table, then iteration = lastRow + 1
  var iteration = lastRow+1;
  var row = tbl.insertRow(lastRow);
  var hdb = document.getElementById('hdb');
  hdb.value=iteration
 
  var cellRight2 = row.insertCell(0);
  var e2 = document.createElement('input');
  e2.type = 'checkbox';
  cellRight2.appendChild(e2);
  
  var cellRight0 = row.insertCell(1);
  var e0 = document.createElement('label');
  e0.type = '';
  e0.innerHTML = 'Icd Name '+iteration+':';
  e0.className = ''
  cellRight0.appendChild(e0);
  
   var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.name = 'icd' + iteration;
	  sel.id = 'icd' + iteration;
	  sel.type = 'text';
	  sel.value =icdString;
	  sel.size = '95'
	  cellRightSel.appendChild(sel);
	  new Ajax.Autocompleter('icd'+iteration,'ac2update','ipd?method=getICDList',{parameters:'requiredField=icd'+iteration});
  cellRightSel.appendChild(sel);
  document.getElementById("icdCode").value =""
  document.getElementById("temp").value =""
  
  
  
  }else{
  		alert("ICD Code does not exists...!")
  		document.getElementById("icdCode").value =""
  		document.getElementById("temp").value =""
  		return true
  }
    
}
function check(){
alert("@#@!#@")
}
function removeRowForUpdateDischarge(argIndex,idName){
	
	         var table=document.getElementById(idName);
	         var tblRows  = table.getElementsByTagName("tr");
	         var check=0;
	         
	         for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              check=check+1;
	                   }
	               }
	        }
			
	        for(i=tblRows.length-1;i>0;i--)
	        {         
	         var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
	         
	               for(j=0;j<tblCtrl.length;j++)
	               {
	                  if(tblCtrl[j].type == 'checkbox')
	                   {    
	                    if(tblCtrl [j].checked)
	                              document.getElementById(idName).deleteRow(i);
	                   }
	               }
	        }
     }
function getOtherHospitalTextBox(disposalId){

if(disposalId == 12){
	document.getElementById('otherHospitalId').style.display = 'inline';
}else{
	document.getElementById('otherHospitalId').style.display = 'none';
return true;
}
}
function getAdNo(){
var obj = document.getElementById("adNoId");
var val = obj.value;
for(i=0;i<obj.length;i++)
{
	if(obj.options[i].value == val)
	{
		admissionNo = obj.options[i].text
		break;
	}
}
document.getElementById("admissionNo").value =admissionNo
return true
}

function validateUpdateDischarge(){
var errMsg ="";
if(document.getElementById("serviceNoId").value ==""){
	errMsg ="Please fill Service No ...!\n"
}
if(document.getElementById("adNoId").value =="0"){
	errMsg =errMsg+"Please select Ad No ...!\n"
}
if(errMsg ==""){
	return true
}else{

alert(errMsg)
return false
}
}

function validateDischargeDate()
{
    var disDate = document.getElementById('dDate')
    var curDate = document.getElementById('currentDate')
    var disDate1   = new Date(disDate.value.substring(6),(disDate.value.substring(3,5) - 1) ,disDate.value.substring(0,2));
	var currdate = new Date(curDate.value.substring(6),(curDate.value.substring(3,5) - 1) ,curDate.value.substring(0,2));
	currdate.setDate(currdate.getDate() - 2);
	
	var right   = document.getElementById('rights').value;
	if(right == 'n'){
		if(disDate1.value != "" && currdate.value != ""){
			  if(disDate1 < currdate){
			       alert("Discharge date should not be less than 2 day before today's date !");
			       document.getElementById('dDate').value ="";
			       return false;
			  }
			  else{
			 		return true;
			  }
		}else{
			 return false;
		}
	}
	else{
		return true;
	}	
		
}

function checkForCancelDischarge()
{
if(document.getElementById("adNoId").value ==0){
	alert("Select Ad No ...!")
	return false;
}else{
	submitForm('updateDischarge','/hms/hms/adt?method=cancelDischarge&inpatientId='+document.getElementById("adNoId").value);
}

}
</script>
