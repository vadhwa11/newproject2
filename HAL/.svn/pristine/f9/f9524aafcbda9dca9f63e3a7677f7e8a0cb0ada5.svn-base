
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="jkt.hms.masters.business.OpdVaccinationPlan"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.MasVaccineItem"%>
<%-- <%@page import="jkt.hms.masters.business.PhMemberSurvey"%> --%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.concurrent.TimeUnit" %>
<%@page import="jkt.hms.util.ImmunizationUtil"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>
 <script type="text/javascript" language="javascript"  src="/hms/jsp/js/jquery.min.js"></script>
 <script type="text/javascript" src="/hms/jsp/js/hms.js"></script>
 
<link href="/hms/jsp/css/datePicker.css" rel="stylesheet" type="text/css" />

	<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>';
	</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	int pHeaderId = 0;
	Box box = HMSUtil.getBox(request);
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	System.out.println("currentDate="+currentDate);
	List<MasVaccineItem> vaccineList = new ArrayList<MasVaccineItem>();
	List<OpdVaccinationPlan>vaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
	List<Integer> prescribedVaccinList = new ArrayList<Integer>();
	List<RouteOfAdministration> routeOfAdministrationList = null;  /* added by amit das on 19-10-2016 */
	// List<MasFrequency> frequencyList = null;  /* added by amit das on 19-10-2016 */
	/* if(map.get("immunizationList") != null){
		immunizationList = (List<PhMemberSurvey>)map.get("immunizationList");
	} */
	
	List<ImmunizationUtil> immunizationList=new ArrayList<ImmunizationUtil>();//added by govind 6-12-2016
	
	if(map.get("vaccineList") != null){
		vaccineList = (List<MasVaccineItem>)map.get("vaccineList");
	}
	if(map.get("vaccinationPlanList") != null){
		vaccinationPlanList = (List<OpdVaccinationPlan>)map.get("vaccinationPlanList");
	}
	List<Patient>patientList=new ArrayList<Patient>();
	if(map.get("patientList")!=null){
		patientList=(List<Patient>)map.get("patientList");
	}
	/* added by amit das on 19-10-2016 */
	if(map.get("routeOfAdministrationList")!=null){
		routeOfAdministrationList=(List<RouteOfAdministration>)map.get("routeOfAdministrationList");
	}
	
	if(map.get("immunizationList") != null){
		immunizationList = (List<ImmunizationUtil>)map.get("immunizationList");
	}
	/* added by amit das on 19-10-2016 */
	/* if(map.get("frequencyList")!=null){
		frequencyList=(List<MasFrequency>)map.get("frequencyList");
	} */
	
	/* Patient patient=new Patient();
	if(map.get("patient") != null){
		patient = (Patient)map.get("patient");
	} */
	
	if(map.get("pHeaderId")!=null){
		pHeaderId=(Integer)map.get("pHeaderId");
	}
	

	if(map.get("prescribedVaccinList")!=null){
		prescribedVaccinList=(List<Integer>)map.get("prescribedVaccinList");
	}
	
	
	String uhid="";
	String name="";
	int hinId=0;
	String service_no=null;
	String relation=null;
	Date dob=new Date();
	for(Patient patient:patientList){
	if(patient!=null){
		uhid=patient.getHinNo();
		hinId=patient.getId();
		service_no=patient.getServiceNo();
		if(patient.getRelation()!=null)
		relation=patient.getRelation().getNewRelationName();
		name=patient.getPFirstName();
		if(patient.getPMiddleName()!=null && !patient.getPMiddleName().equals(""))
			name=name+" "+patient.getPMiddleName();
		if(patient.getPMiddleName()!=null && !patient.getPMiddleName().equals(""))
			name=name+" "+patient.getPLastName();
		if(name.equals(""))
			name=patient.getFileName();
		if(patient.getDateOfBirth()!=null)
			dob=patient.getDateOfBirth();
	}
	}
	int visitId = box.getInt("visitId");
	int inpatientId=0;
	if(box.getInt("inpatientId")!=0){
		inpatientId=box.getInt("inpatientId");
	}

if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%} %>
<div class="titleBg">
<h2>Vaccine</h2>
</div>
<div class="clear"></div>
<form name="vaccineDetail" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<label class="auto">Employee No</label>
<input type="hidden" name="hinId" value="<%=hinId%>"/>
<input type="hidden" name="visitId" value="<%=visitId%>"/>
 <input type="text" tabindex="1" name="aadharNo" value="<%=service_no %>" maxlength="16" readonly="readonly" /> 
<label class="auto"> Name</label>
 <input type="text" id="pFirstNameId"  name="patientName" value="<%=name != null?name:"" %>" readonly="readonly"/>
 <label class="auto"> Relation</label>
 <input type="text" id="pFirstNameId"  name="patientName" value="<%=relation != null?relation:"" %>" readonly="readonly"/>
<label class="auto"> Date of Birth</label>
 <input type="text" id="dobId"  name="dob" value="<%=dob != null?HMSUtil.convertDateToStringWithoutTime(dob):"" %>" readonly="readonly" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<!-- <div class="tableForTab" style="width:auto; height:  425px; overflow: scroll;"> -->
<div class="cmntable">
<table>
	<tr>
	<th>Prescribe</th>
	<th>Order No.</th>
	<th>Name Of Vaccine</th>
	<th>Source</th>
	<!-- <th>Dose No.</th> -->
	<!-- <th>Duration</th>  -->
<!-- 	<th>Schedule Date</th> -->
<!-- 	<th>To Date</th> -->
   <!--  <th>Scheduled due date as per DOB</th> -->
   <!--  <th>To date as per DOB</th> -->
	<th>Vaccination  Date</th>
	<th>Doctor Remarks</th>
<!-- 	<th>Vaccination Date</th>
	<th>Status</th> -->
	</tr>
<%
int i= 1;
boolean match = false;
String vaccineDate=null;
String remarks = null;
String source = null;
if(vaccineList.size()>0 && vaccineList != null){
	for(MasVaccineItem masVaccine :vaccineList){
		match = false;
		vaccineDate=null;
		remarks = null;
		source = null;
		for(OpdVaccinationPlan vaccinationPlan : vaccinationPlanList){
			%>
			<%if(vaccinationPlan.getVaccin().getId()==masVaccine.getId()){
				match = true;
				vaccineDate = HMSUtil.convertDateToStringTypeDateOnly(vaccinationPlan.getVaccinDate());
				remarks = vaccinationPlan.getRemarks(); 
				source = vaccinationPlan.getVaccineSource();
				break;
			}
	     }
		
		if(match==true){
		%><tr><td><input type="checkbox" onclick="toogleVaccinDetails('<%=i%>',this,'${_csrf.parameterName}','${_csrf.token}')" checked="checked" id="vaccineItemPvmsNo<%=i %>" disabled="disabled" name="vaccineItemPvmsNo<%=i %>"  <%-- value="<%=opdVaccinMst.getMasStoreItem().getPvmsNo()%>" --%> />
		   </td>
				<%
			}else{
				%>
					<td><input type="checkbox" onclick="toogleVaccinDetails('<%=i%>',this,'${_csrf.parameterName}','${_csrf.token}')"   id="vaccineItemPvmsNo<%=i %>"  name="vaccineItemPvmsNo<%=i %>" <%--  value="<%=opdVaccinMst.getMasStoreItem().getPvmsNo()%>" --%> />
		<input type="hidden" id="checkItem<%=i%>" name="checkItem<%=i%>" value="N" /> </td>
			<%}%>
				<td><%=masVaccine.getOrderNo() != null ? masVaccine.getOrderNo():"" %></td>
		<td><%=masVaccine.getVaccineName() != null ? masVaccine.getVaccineName():"" %>
		<input type="hidden" name = "vaccineId<%=i %>"  value="<%=!match? masVaccine.getId():"" %>" />
		</td>
		<td><select name="vaccine_source<%=i%>" class="auto"><option>HAL</option><option <%=source!=null?source.equalsIgnoreCase("Outside")?"selected":"":""%>>Outside</option></select></td>
		<td>
		<%-- <input type="text" size="20"  name="completionDate<%=i %>" id="completionDateId<%=i %>" class="date" validate="completion Date,string,no" readonly="readonly" value="<%=vaccineDate!=null?vaccineDate:""%>"/>
 			<%if(!match){ %><img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.vaccineDetail.completionDate<%=i %>,event)" /><%} %> --%>
 			
 			<input  type="text" class="calDate"  id="completionDate<%=i %>" name="completionDate<%=i %>" placeholder="DD/MM/YYYY" validate="Vaccine Date,string,no" value="<%=vaccineDate!=null?vaccineDate:""%>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'completionDate<%=i %>');" maxlength="10" style="width: 120px"/>
 			
 			</td>
		<td><input type="text" name = "remarks<%=i %>"  value="<%=remarks!=null?remarks:""%>" <%=match?"readonly":"" %> size="50"/></td>
		
			</tr>
	<%i++;}
} %>
	<input type="hidden" id="totalVaccinNo" value="<%=i%>">	
</table>
</div>

 <input	type="hidden" name="count" id="count"	value="<%=i %>" />
 <input	type="hidden" name="pHeaderId" id="pHeaderId"	value="<%=pHeaderId%>" />
 <input	type="hidden" name="currentDate" id="currentDate"	value="<%=currentDate%>" />
 
<div class="clear"></div>

<%-- <input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('vaccineDetail','pubHealth?method=submitVaccineDetail&flag=opd&visitId=<%=visitId %>&inpatientId=<%=inpatientId %>','validateGridData');" /> --%>
<input name="button"  type="button"	value="Submit" class="button"	onClick="callOtherDiagnosis();" />
<script type="text/javascript">

function validateGridData() {
	var count = document.getElementById("count").value;
	var flag = false;
	for (var inc = 1; inc < count; inc++) {
		var completionDate = document.getElementById("completionDateId" + inc).value
		if (completionDate != "" ) {
			flag = true;
			break;
		}
	}
	if(!flag){
		alert("Please Select completion Date ");
		return false;

	}
	return true;
}


function toogleVaccinDetails(i,j,csrfTokenName,csrfTokenValue){
	if(j.checked){
	/* 	document.getElementById("vaccinDetails"+i).style.display = '';
		document.getElementById("dosage"+i).value = '1';
		displayAu(i,csrfTokenName,csrfTokenValue); */
		document.getElementById("checkItem"+i).value = 'Y';
		document.getElementById("completionDate"+i).value= document.getElementById("currentDate").value;
	}else{
	/* 	document.getElementById("vaccinDetails"+i).style.display = 'none'; */
		document.getElementById("checkItem"+i).value = 'N';
		document.getElementById("completionDate"+i).value="";
	} 
}


function checkCompilationDate(inc){ 
	var vDate=document.getElementById("vaccineDateId" + inc).value;
	var cDate=document.getElementById("completionDateId" + inc).value;
	var vToDate=document.getElementById("vaccineToDateId" + inc).value;
	var regExp = /(\d{1,2})\/(\d{1,2})\/(\d{2,4})/;
	//alert(parseInt(cDate.replace(regExp, "$3$2$1")));
	//alert(parseInt(vDate.replace(regExp, "$3$2$1")));
	//alert(parseInt(vToDate.replace(regExp, "$3$2$1")));
	if(parseInt(cDate.replace(regExp, "$3$2$1")) >= parseInt(vDate.replace(regExp, "$3$2$1")) && parseInt(cDate.replace(regExp, "$3$2$1"))<=parseInt(vToDate.replace(regExp, "$3$2$1"))){
		//alert("in if 1");
	return true;
	}else{
		//
		document.getElementById("completionDateId" + inc).value="";
		//alert("Vaccination date should be in between sceduled dates!!");
		return false;
	}
	
	
}


// added by amit das on 15-09-2016
window.onbeforeunload = closingCode;

//added by amit das on 15-09-2016
function closingCode(){
		var checkBoxName  = 'vaccineItemPvmsNo';
		var totalVaccinNo =	 document.getElemenyById('totalVaccinNo').value;
		var pvms = '';
		for(var i=0;i<totalVaccinNo;i++){
			if(document.getElemenyById('totalVaccinNo'+i).checked){
				pvms = pvms+document.getElemenyById('totalVaccinNo').value+',';
			}
		}
		
	 	var elementId = 'vaccinPvms';
	 	var elementValue = 	pvms;
		window.opener.setVaccinPvms(elementId,elementValue);
}


function displayAu(inc,csrfTokenName,csrfTokenValue) {
		var pvmsNo = document.getElementById('pvsmNo'+inc).value;
		var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];

					var au = item.getElementsByTagName("au")[0];
					var actualDispensingQty = item
							.getElementsByTagName("actualDispensingQty")[0];
					var stock = item.getElementsByTagName("stock")[0];

					/* if (document.getElementById('au' + inc)
							&& au.childNodes[0] != undefined) {
						document.getElementById('au' + inc).value = au.childNodes[0].nodeValue;
					} */
					
				/* 	if (document.getElementById('actualDispensingQty' + inc)) {
						if (actualDispensingQty.childNodes[0] != undefined) {
							document
									.getElementById('actualDispensingQty' + inc).value = actualDispensingQty.childNodes[0].nodeValue;
						} else {
							document
									.getElementById('actualDispensingQty' + inc).value = 0;

						}
					} */
					document.getElementById('unit'+inc).value = au.childNodes[0].nodeValue;
					
				}
			}
		}
		var url = "/hms/hms/opd?method=displayAU&pvmsNo=" + pvmsNo + "&"
				+ csrfTokenName + "=" + csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	
}

function callOtherDiagnosis(){
// 	/*var formName ="vaccineDetail";
// 	// var url = "/hms/hms/pubHealth?method=submitVaccineDetail";
<%-- 	 var data = "&flag=opd&visitId="+<%=visitId %>+"&inpatientId="+<%=inpatientId %>+"&"+getNameAndData(formName); --%>
// submitForm("vaccineDetail","pubHealth?method=submitVaccineDetail"+data);*/

var count=0;
var j=0;
if(document.getElementById("count"))
	count=document.getElementById("count").value;
	
	for(var i=1;i<=count;i++)
		{

		  if( document.getElementById("checkItem"+i)!=null && document.getElementById("checkItem"+i).value=="Y" )
			  {
			  j++;
			     if( document.getElementById("completionDateId"+i)!=null &&document.getElementById("completionDateId"+i).value=="")
			    	 {
			    	 alert("Please select vaccination date");
			    	 return false;
			    	 }
			  }
		}
	 if(j==0)
	  { alert("select atleast one row to submit");
   	   return false;}
	var formName ="vaccineDetail";
	 var url = "/hms/hms/opd?method=submitVaccineDetail";
	 var data = "&flag=opd&visitId="+<%=visitId %>+"&inpatientId="+<%=inpatientId %>+"&"+getNameAndData(formName);
	jQuery(function ($) {
		  
    	$.ajax({
			type:"POST",
			url: url,	
			data: data,	
			cache: false,
			success: function(msg)
			{									 
				
				alert("Records Saved Sucessfully");
				//window.opener.location = window.opener.location;
				window.close();
				
			},
			error: function(msg)
			{					
				
				alert("An error has occurred while contacting the server");
				}
		});
    });   
	//window.opener.location = window.opener.location;
	/* window.opener.document.getElementById("OtherDiagnosis").value="Vaccination";
	window.close(); */
}



</script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
</script>
</form>


